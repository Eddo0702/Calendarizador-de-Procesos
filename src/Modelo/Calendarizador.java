package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class Calendarizador {

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

	private void setTotalTime(ArrayList<Proceso> procesos) {
		totalTime = 0;
		for (Proceso p : procesos) {
			totalTime += p.getRafaga();
		}
	}

	private void inicializarAlgoritmo(ArrayList<Proceso> procesos) {
		Collections.sort(procesos);
		setTotalTime(procesos);
		arrivalTime = procesos.get(0).getLlegada();
	}

	private void removeCurrentProcess() {
		procesosFinalizados.add(colaTrabajo.elementAt(0));
		colaTrabajo.removeElementAt(0);
	}

	public ArrayList<Proceso> FIFO(ArrayList<Proceso> procesos) {
		inicializarAlgoritmo(procesos);

		for (int i = arrivalTime; i < totalTime + arrivalTime; i++) {
			for (Proceso p : colaTrabajo) {
				p.Update();
			}

			// Aqui se añaden nuevos procesos a la cola de trabajo segun su tiempo de
			// llegada
			for (Proceso p : procesos) {
				if (p.getLlegada() == i) {
					colaTrabajo.add(p);
				}
			}

			// Se sacan los procesos que han agotado su tiempo de rafaga
			if (colaTrabajo.elementAt(0).getRafaga() == 0) {
				removeCurrentProcess();
			}
			colaTrabajo.elementAt(0).setEstado(true);
		}
		// ultima llamada fuera del ciclo para asegurarnos de remover el ultimo proceso
		removeCurrentProcess();
		return procesosFinalizados;
	}

	public ArrayList<Proceso> SJF(ArrayList<Proceso> procesos) {
		inicializarAlgoritmo(procesos);

		for (int i = arrivalTime; i < totalTime + arrivalTime; i++) {
			for (Proceso p : colaTrabajo) {
				p.Update();
			}

			// Aqui se añaden nuevos procesos a la cola de trabajo segun su tiempo de
			// llegada
			for (Proceso p : procesos) {
				if (p.getLlegada() == i) {
					p.setOrderBy(1);
					colaTrabajo.add(p);
				}
			}

			// Se sacan los procesos que han agotado su tiempo de rafaga
			if (colaTrabajo.elementAt(0).getRafaga() == 0) {
				removeCurrentProcess();
				Collections.sort(colaTrabajo);
			}
			colaTrabajo.elementAt(0).setEstado(true);
		}
		// ultima llamada fuera del ciclo para asegurarnos de remover el ultimo proceso
		removeCurrentProcess();
		return procesosFinalizados;
	}

	public ArrayList<Proceso> SRTF(ArrayList<Proceso> procesos) {
		inicializarAlgoritmo(procesos);

		for (int i = arrivalTime; i < totalTime + arrivalTime; i++) {
			for (Proceso p : colaTrabajo) {
				p.Update();
			}

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
			if (colaTrabajo.elementAt(0).getRafaga() == 0) {
				removeCurrentProcess();
				Collections.sort(colaTrabajo);
			}
			colaTrabajo.elementAt(0).setEstado(true);
		}
		// ultima llamada fuera del ciclo para asegurarnos de remover el ultimo proceso
		removeCurrentProcess();
		return procesosFinalizados;
	}

	public ArrayList<Proceso> Prioridad(ArrayList<Proceso> procesos) {
		inicializarAlgoritmo(procesos);

		for (int i = arrivalTime; i < totalTime + arrivalTime; i++) {
			for (Proceso p : colaTrabajo) {
				p.Update();
			}

			// Aqui se añaden nuevos procesos a la cola de trabajo segun su tiempo de
			// llegada
			for (Proceso p : procesos) {
				if (p.getLlegada() == i) {
					p.setOrderBy(2);
					colaTrabajo.add(p);
					// Collections.sort(colaTrabajo);
				}
			}

			// Se sacan los procesos que han agotado su tiempo de rafaga
			if (colaTrabajo.elementAt(0).getRafaga() == 0) {
				removeCurrentProcess();
				Collections.sort(colaTrabajo);
			}
			colaTrabajo.elementAt(0).setEstado(true);
		}
		// ultima llamada fuera del ciclo para asegurarnos de remover el ultimo proceso
		removeCurrentProcess();
		return procesosFinalizados;
	}
}
