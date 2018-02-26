package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import Controlador.Controller;

public class Calendarizador {
	
	private Controller controller;

	private static Calendarizador calendarizador;

	private Vector<Proceso> colaTrabajo;
	private ArrayList<Proceso> procesosFinalizados;

	private int totalTime = 0;
	private int arrivalTime = 0;

	private Calendarizador() {
		colaTrabajo = new Vector<>();
		procesosFinalizados = new ArrayList<>();
	}

	public static Calendarizador getInstance() {
		if (calendarizador == null) {
			calendarizador = new Calendarizador();
			return calendarizador;
		}
		return calendarizador;
	}

	public ArrayList<Proceso> FIFO(ArrayList<Proceso> procesos) {
		inicializarAlgoritmo(procesos);

		for (int i = arrivalTime; i < totalTime + arrivalTime; i++) {
			actualizarColaTrabajo();

			// Aqui se añaden nuevos procesos a la cola de trabajo segun su tiempo de
			// llegada
			for (Proceso p : procesos) {
				if (p.getLlegada() == i) {
					colaTrabajo.add(p);
				}
			}

			// Se sacan los procesos que han agotado su tiempo de rafaga
			removeFinishedProcess();
		}
		// ultima llamada fuera del ciclo para asegurarnos de remover el ultimo proceso
		removeCurrentProcess();
		return procesosFinalizados;
	}

	public ArrayList<Proceso> SJF(ArrayList<Proceso> procesos) {
		inicializarAlgoritmo(procesos);

		for (int i = arrivalTime; i < totalTime + arrivalTime; i++) {
			actualizarColaTrabajo();

			// Aqui se añaden nuevos procesos a la cola de trabajo segun su tiempo de
			// llegada
			for (Proceso p : procesos) {
				if (p.getLlegada() == i) {
					p.setOrderBy(1);
					colaTrabajo.add(p);
				}
			}

			// Se sacan los procesos que han agotado su tiempo de rafaga
			removeFinishedProcess();
		}
		// ultima llamada fuera del ciclo para asegurarnos de remover el ultimo proceso
		removeCurrentProcess();
		return procesosFinalizados;
	}

	public ArrayList<Proceso> SRTF(ArrayList<Proceso> procesos) {
		inicializarAlgoritmo(procesos);

		for (int i = arrivalTime; i < totalTime + arrivalTime; i++) {
			actualizarColaTrabajo();

			// Aqui se añaden nuevos procesos a la cola de trabajo segun su tiempo de
			// llegada
			for (Proceso p : procesos) {
				if (p.getLlegada() == i) {
					p.setOrderBy(1);
					if (!colaTrabajo.isEmpty()) {
						if (colaTrabajo.elementAt(0).getRafaga() > p.getRafaga()) {
							colaTrabajo.elementAt(0).setEstado(false);
							procesosFinalizados.add(colaTrabajo.elementAt(0));
							colaTrabajo.add(0, p);
						} else {
							colaTrabajo.add(p);
						}
					} else {
						colaTrabajo.add(p);
					}
				}
			}

			// Se sacan los procesos que han agotado su tiempo de rafaga
			removeFinishedProcess();
		}
		// ultima llamada fuera del ciclo para asegurarnos de remover el ultimo proceso
		removeCurrentProcess();
		return procesosFinalizados;
	}

	// En construccion...
	public ArrayList<Proceso> RoundRobin(ArrayList<Proceso> procesos, int quantum) {
		// inicializarAlgoritmo(procesos);

		// Se añaden todos los procesos a la cola de trabajo
		for (Proceso p : procesos) {
			colaTrabajo.add(p);
		}

		// Se procede a trabajar con los procesos
		while (!colaTrabajo.isEmpty()) {
			System.out.println("entre al while, quedan procesos " + colaTrabajo.size());
			for (Proceso p : colaTrabajo) {
				System.out.println("entre al primer for");

				for (int j = 0; j < quantum; j++) {
					p.setEstado(true);
					System.out.println("entre al segundo for");
					actualizarColaTrabajo();
					// Se sacan los procesos que han agotado su tiempo de rafaga
					if (p.getRafaga() == 0) {
						System.out.println("fuera un proceso");
						procesosFinalizados.add(p);
						colaTrabajo.remove(p);
						//continue;
					}
					p.setEstado(false);
				}
				System.out.println("sali del segundo for");

			}
			System.out.println("sali del primer for");
		}
		// ultima llamada fuera del ciclo para asegurarnos de remover el ultimo proceso
		// removeCurrentProcess();
		return procesosFinalizados;
	}

	public ArrayList<Proceso> Prioridad(ArrayList<Proceso> procesos) {
		inicializarAlgoritmo(procesos);

		for (int i = arrivalTime; i < totalTime + arrivalTime; i++) {
			actualizarColaTrabajo();

			// Aqui se añaden nuevos procesos a la cola de trabajo segun su tiempo de
			// llegada
			for (Proceso p : procesos) {
				if (p.getLlegada() == i) {
					p.setOrderBy(2);
					colaTrabajo.add(p);
				}
			}

			// Se sacan los procesos que han agotado su tiempo de rafaga
			removeFinishedProcess();
		}
		// ultima llamada fuera del ciclo para asegurarnos de remover el ultimo proceso
		removeCurrentProcess();
		return procesosFinalizados;
	}

	private void inicializarAlgoritmo(ArrayList<Proceso> procesos) {
		Collections.sort(procesos);

		// Calculamos el tiempo total
		totalTime = 0;
		for (Proceso p : procesos) {
			totalTime += p.getRafaga();
		}

		arrivalTime = procesos.get(0).getLlegada();
	}

	private void actualizarColaTrabajo() {
		for (Proceso p : colaTrabajo) {
			p.Update();
		}
	}

	private void removeCurrentProcess() {
		procesosFinalizados.add(colaTrabajo.elementAt(0));
		colaTrabajo.removeElementAt(0);
	}

	private void removeFinishedProcess() {
		if (colaTrabajo.elementAt(0).getRafaga() == 0) {
			removeCurrentProcess();
			Collections.sort(colaTrabajo);
		}
		colaTrabajo.elementAt(0).setEstado(true);
	}
}
