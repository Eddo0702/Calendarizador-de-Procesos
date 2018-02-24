/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author eduar
 */
public class Resultado {
    public ArrayList<Integer> waitingTimes = null;
    private double averageWaitingTime = 0;
    private String report = "";

    public Resultado(ArrayList<Proceso> cola) {
        for (int i = 0; i < cola.size(); i++) {
            waitingTimes.add(0);
        }
    }
    
    public void addToReport (String entry){
        if(report.equals(""))
            report += entry;
        else
            report += "|" + entry ;
    }
    
    public void addTowaitingTime(int processId, int waitingTime){
        int index = processId - 1;
        waitingTimes.set(index, waitingTimes.get(index)+waitingTime);
    }
    
    public void terminar(){
        int totalWaitingTime = 0;
        
        for(int i=0; i<waitingTimes.size();i++){
            totalWaitingTime += waitingTimes.get(i);
        }
        
        averageWaitingTime = totalWaitingTime/waitingTimes.size();
    }
}
