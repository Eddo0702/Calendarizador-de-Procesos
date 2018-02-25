package Pruebas;

import java.util.ArrayList;
import java.util.Collections;

import Modelo.Calendarizador;
import Modelo.Proceso;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Proceso> procesos = new ArrayList<>();
		// procesos.add(new Proceso(3, 5, 7, 1));
		// procesos.add(new Proceso(1, 2, 5, 2));
		// procesos.add(new Proceso(4, 0, 3, 3));
		// procesos.add(new Proceso(2, 4, 4, 4));
		// procesos.add(new Proceso(5, 3, 9, 5));

		procesos.add(new Proceso(1, 0, 7, 1));
		procesos.add(new Proceso(2, 2, 4, 2));
		procesos.add(new Proceso(3, 4, 1, 3));
		procesos.add(new Proceso(4, 5, 4, 4));

		/*
		 * procesos.add(new Proceso(1, 8, 14, 5)); procesos.add(new Proceso(2, 12, 22,
		 * 2)); procesos.add(new Proceso(3, 0, 8, 8)); procesos.add(new Proceso(4, 6,
		 * 16, 5)); procesos.add(new Proceso(5, 24, 26, 7)); procesos.add(new Proceso(6,
		 * 16, 24, 9)); procesos.add(new Proceso(7, 20, 12, 4)); procesos.add(new
		 * Proceso(8, 22, 18, 8));
		 */

		System.out.println("Arreglo inicial\n");
		for (Proceso p : procesos) {
			System.out.println(p);
		}

		Calendarizador calen = Calendarizador.getInstance();
		ArrayList<Proceso> procesos2;
		// procesos2 = calen.FIFO(procesos);
		// procesos2 = calen.SJF(procesos);
		// procesos2 = calen.Prioridad(procesos);
		// procesos2 = calen.SRTF(procesos);
		procesos2 = calen.RoundRobin(procesos, 3);

		System.out.println("\nArreglo resultante de algoritmo\n");
		for (Proceso p : procesos2) {
			System.out.println(p);
		}
	}

}
