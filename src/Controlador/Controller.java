package Controlador;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextArea;

import Modelo.Calendarizador;
import Modelo.Proceso;

public class Controller {

	private static Controller controller;
	
	private ArrayList<Proceso> procesosIN;
	private ArrayList<Proceso> procesosOUT;

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
		textArea.setText("");
		procesosIN = new ArrayList<>();

		// ERROR de casteo aqui!!! Por arreglar!*********
		for (int row = 0; row < table.getRowCount(); row++) {
			System.out.println(table.getValueAt(row, 0) + " " + table.getValueAt(row, 1) + " "
					+ table.getValueAt(row, 2) + " " + table.getValueAt(row, 3) + " " + table.getValueAt(row, 4));
			//
			procesosIN.add(new Proceso(castToNumber(table.getValueAt(row, 0)), castToNumber(table.getValueAt(row, 1)),
					castToNumber(table.getValueAt(row, 2)), castToNumber(table.getValueAt(row, 3))));
		}

		Calendarizador calen = Calendarizador.getInstance();
		procesosOUT = new ArrayList<>();

		switch (algoritmo) {
		case 0:
			procesosOUT = calen.FIFO(procesosIN);
			break;
		case 1:
			procesosOUT = calen.SJF(procesosIN);
			break;
		case 2:
			procesosOUT = calen.SRTF(procesosIN);
			break;
		case 3:
			procesosOUT = calen.Prioridad(procesosIN);
			break;
		default:
			System.out.println("Llamada a default");
		}

		textArea.append("Arreglo resultante de algoritmo\n\n");
		for (Proceso p : procesosOUT) {
			System.out.println(p.toString() + "\n");
			textArea.append(p.toString() + "\n");
		}
		System.out.println();
		textArea.append("\n");
		
		procesosIN.clear();
		procesosOUT.clear();
	}

}
