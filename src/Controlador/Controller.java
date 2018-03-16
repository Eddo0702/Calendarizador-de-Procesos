package Controlador;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextArea;

import Modelo.Calendarizador;
import Modelo.Proceso;

public class Controller {

	private static Controller controller;

	private Calendarizador calendarizador;
	private ArrayList<Proceso> procesosIN;

	private Controller() {
		calendarizador = Calendarizador.getInstance();
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
	}

	public void GenerarResultados(JTextArea textArea, JTable table, int algoritmo) {
		procesosIN = new ArrayList<>();

		// Obtenemos la informacion contenida en la tabla
		for (int row = 0; row < table.getRowCount(); row++) {
			/*
			 * System.out.println(table.getValueAt(row, 0) + " " + table.getValueAt(row, 1)
			 * + " " + table.getValueAt(row, 2) + " " + table.getValueAt(row, 3) + " " +
			 * table.getValueAt(row, 4));
			 */
			procesosIN.add(new Proceso(castToNumber(table.getValueAt(row, 0)), castToNumber(table.getValueAt(row, 1)),
					castToNumber(table.getValueAt(row, 2)), castToNumber(table.getValueAt(row, 3))));
		}

		switch (algoritmo) {
		case 0:
			calendarizador.FIFO(procesosIN);
			break;
		case 1:
			calendarizador.SJF(procesosIN);
			break;
		case 2:
			calendarizador.SRTF(procesosIN);
			break;
		case 3:
			calendarizador.Prioridad(procesosIN);
			break;
		}

		calendarizador.imprimirResultados(textArea);

		procesosIN.clear();
	}

}
