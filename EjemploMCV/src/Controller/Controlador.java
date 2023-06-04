/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Modelo;
import View.Vista;
import Model.Estudiantes;
import java.util.HashSet;

/**
 *
 * @author Alejandro Bautista
 */
public class Controlador{
    private Modelo modelo;
    private Estudiantes estudiante;
    private Vista vista;

    
    public Controlador(Modelo modelo, Vista vista, Estudiantes estudiantes) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        estudiante.getVistaemple();
    }
    
/*    public void iniciar()
    {
        vista.setTitle("Estudiantes");
        vista.setLocationRelativeTo(null);
        
    }

    public void setModelo(String nombre, String apellido, String correo) {
        modelo.setNombre(nombre);
        modelo.setApellido(apellido);
        modelo.setCorreo(correo);
    }
 */   
    
}
