/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author eduar
 */

// Implementamos Comparable porque nos servira para ordenar los procesos segun
// su tiempo de llegada
public class Proceso implements Comparable<Proceso> {

	private String nombre;
	private int llegada;
	private int rafaga;
	private int prioridad;
	private int tiempoEspera;
	private boolean isRunning = false;

	public Proceso(int id, int llegada, int rafaga, int prioridad) {
		nombre = "P" + id;
		this.llegada = llegada;
		this.rafaga = rafaga;
		this.prioridad = prioridad;
	}

	public void Update() {
		if (isRunning) {
			rafaga--;
		} else {
			tiempoEspera++;
		}
	}

	public void setEstado(boolean active) {
		isRunning = active;
	}

	public int getRafaga() {
		return rafaga;
	}

	public int getLlegada() {
		return llegada;
	}

	@Override
	public int compareTo(Proceso p) {
		if (llegada < p.llegada) {
			return -1;
		}
		if (llegada > p.llegada) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Proceso " + nombre + " Llegada: " + llegada + " Rafaga: " + rafaga + " Prioridad: " + prioridad
				+ " TE: " + tiempoEspera;
	}
}
