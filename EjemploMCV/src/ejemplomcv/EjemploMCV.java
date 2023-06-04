/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplomcv;

import Controller.Controlador;
import Model.Modelo;
import View.Vista;
import Model.Estudiantes;
import Model.Conexion;
import Model.Conexionsql;
/**
 *
 * @author Alejandro Bautista
 */
public class EjemploMCV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Conexion conexion = new Conexion();
 ///       Conexionsql conexionsql = new Conexionsql();
        Modelo Modelo = new Modelo();
        Estudiantes Estudiantes = new Estudiantes();
        Vista Vista = new Vista();
        Controlador controlador = new Controlador(Modelo, Vista, Estudiantes);
        ///controlador.iniciar();
        
        Vista.setVisible(true);
    }
    
}
