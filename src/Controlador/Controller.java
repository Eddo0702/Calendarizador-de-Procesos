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

	private int castToNumber(Object object) {
		return Integer.parseInt(object.toString());
		//return (int) object;
	}

	public void GenerarResultados(JTextArea textArea, JTable table, int algoritmo) {
		ArrayList<Proceso> procesos = new ArrayList<>();

		// ERROR de casteo aqui!!! Por arreglar!*********
		for (int row = 0; row < table.getRowCount(); row++) {
			System.out.println(table.getValueAt(row, 0) + " " + table.getValueAt(row, 1) + " "
					+ table.getValueAt(row, 2) + " " + table.getValueAt(row, 3) + " " + table.getValueAt(row, 4));
			//
			procesos.add(new Proceso(castToNumber(table.getValueAt(row, 0)), castToNumber(table.getValueAt(row, 1)),
					castToNumber(table.getValueAt(row, 2)), castToNumber(table.getValueAt(row, 3))));
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
		default:
			System.out.println("Llamada a default");
		}

		textArea.append("Arreglo resultante de algoritmo\n\n");
		for (Proceso p : procesos2) {
			System.out.println(p.toString() + "\n");
			textArea.append(p.toString() + "\n");
		}
	}

}
