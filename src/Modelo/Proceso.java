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

	private int processID = 1;
	private int arrivalTime = 0;
	private int burstTime = 1;
	private int waitingTime = 0;
	private int turnAroundTime = 1;

	// ****************

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

	// ****************

	public Proceso(int processID, int arrivalTime, int burstTime) {
		this.processID = processID;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getBurstTime() {
		return burstTime;
	}

	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	public int getTurnAroundTime() {
		return turnAroundTime;
	}

	public void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}

}
