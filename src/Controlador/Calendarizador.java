/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Proceso;
import Modelo.Resultado;
import java.util.ArrayList;

/**
 *
 * @author eduar
 */
public class Calendarizador {
    
    //public ArrayList<Proceso> cola = null;

    public Calendarizador() {
    }
    
    public Resultado shortestRemainingJobFirst(ArrayList<Proceso> procesos){
        ArrayList<Proceso> cola = procesos;
        Resultado resultado = new Resultado(cola);
        
        
        
        return resultado;
    }
    
    public void burst(){
    
    }
    
}
