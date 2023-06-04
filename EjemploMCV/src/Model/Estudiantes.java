/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Alejandro Bautista
 */
import Model.Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import Model.Conexionsql;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro Bautista
 */
public class Estudiantes {
    // Atributos privados
    private String Insertar = "CALL InsertarEstudiantes(?,?,?,?)";
    private String Modificar = "CALL ModificarPacientes(?,?,?,?,?)";
    private String Eliminar = "CALL BorrarPaciente(?)";
    private String vistaemple = "select * from vistaestudiante";
    private String vistaDepto = "select * from vistadepto"; 
    private int Columnas = 0;
    private Connection cnn;

    public Estudiantes() {
        cnn = Conexion.Conectar();
    }  

    public String getInsertar() {
        return Insertar;
    }

    public void setInsertar(String Insertar) {
        this.Insertar = Insertar;
    }

    public String getModificar() {
        return Modificar;
    }

    public void setModificar(String Modificar) {
        this.Modificar = Modificar;
    }

    public String getEliminar() {
        return Eliminar;
    }

    public void setEliminar(String Eliminar) {
        this.Eliminar = Eliminar;
    }

    public String getVistaemple() {
        return vistaemple;
    }

    public void setVistaemple(String vistaemple) {
        this.vistaemple = vistaemple;
    }

    public String getVistaDepto() {
        return vistaDepto;
    }

    public void setVistaDepto(String vistaDepto) {
        this.vistaDepto = vistaDepto;
    }    

    public ResultSet llenarCombo() {
          ResultSet rs = null;
          Statement smt = null;
        try {
            Connection cnn;
            cnn = Conexion.Conectar();
            smt = cnn.createStatement();
///            rs= smt.executeQuery(getVistaDepto());
        } catch (SQLException ex) {
            Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public DefaultTableModel CargarDatos() {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            Connection cnn;
            cnn = Conexion.Conectar();
            Statement smt = cnn.createStatement();
            ResultSet rs = smt.executeQuery(getVistaemple());
            ResultSetMetaData md = rs.getMetaData();
            int columnas = md.getColumnCount();
            for (int i = 1; i <= columnas; i++) {
                modelo.addColumn(md.getColumnLabel(i));
            }
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
                fila = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }
    
    public String IngresarDatos(String Nombre, 
            String Apellido, 
            String Correo)
    {
        String resultado;
        try {  
            cnn = Conexion.Conectar();            
            CallableStatement cmst = cnn.prepareCall(getInsertar());
            cmst.setString(1, Nombre);
            cmst.setString(2, Apellido);
            cmst.setString(3, Correo);
            cmst.execute();
            resultado = " Los datos se ingresaron exitosamente !!!";
            cnn.close();
        } catch (SQLException sqlex) {
            resultado = " No se realizo la operacion " + sqlex.getMessage();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            resultado = " No se realizo la operacion " + ex.getMessage();
        }
        return resultado;
    }
    
    
}
