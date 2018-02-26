package Controlador;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextArea;

import Modelo.Calendarizador;
import Modelo.Proceso;

public class Controller {

	private static Controller controller;

	private Controller() {
	}

	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
			return controller;
		}
		return controller;
	}

	public void GenerarResultados(JTextArea textArea, JTable table, int algoritmo) {
		ArrayList<Proceso> procesos = new ArrayList<>();

		//ERROR de casteo aqui!!! Por arreglar!*********
		for (int row = 0; row < table.getRowCount(); row++) {
			for (int col = 0; col < table.getColumnCount(); col++) {
				procesos.add(new Proceso((Integer) table.getValueAt(row, col), (Integer) table.getValueAt(row, col),
						(Integer) table.getValueAt(row, col), (Integer) table.getValueAt(row, col)));
			}
		}

		Calendarizador calen = Calendarizador.getInstance();
		ArrayList<Proceso> procesos2 = new ArrayList<>();

		switch (algoritmo) {
		case 0:
			procesos2 = calen.FIFO(procesos);
			break;
		case 1:
			procesos2 = calen.SJF(procesos);
			break;
		case 2:
			procesos2 = calen.SRTF(procesos);
			break;
		case 3:
			procesos2 = calen.Prioridad(procesos);
			break;
		}

		textArea.append("Arreglo resultante de algoritmo\n\n");
		for (Proceso p : procesos2) {
			textArea.append(p.toString() + "\n");
		}
	}

}
