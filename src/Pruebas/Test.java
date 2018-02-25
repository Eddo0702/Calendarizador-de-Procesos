package Pruebas;

import java.util.ArrayList;
import java.util.Collections;

import Modelo.Calendarizador;
import Modelo.Proceso;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Proceso> procesos = new ArrayList<>();
		procesos.add(new Proceso(3, 5, 7, 1));
		procesos.add(new Proceso(1, 2, 5, 2));
		procesos.add(new Proceso(4, 0, 3, 3));
		procesos.add(new Proceso(2, 4, 4, 4));
		procesos.add(new Proceso(5, 3, 9, 5));

		System.out.println("Arreglo desordenado\n");
		for (Proceso p : procesos) {
			System.out.println(p);
		}

		Collections.sort(procesos);

		System.out.println("\nArreglo ordenado\n");
		for (Proceso p : procesos) {
			System.out.println(p);
		}

		Calendarizador calen = Calendarizador.getInstance();
		ArrayList<Proceso> procesos2 = calen.FIFO(procesos);
		System.out.println("\nArreglo resultante de algoritmo\n");
		for (Proceso p : procesos2) {
			System.out.println(p);
		}
	}

}
