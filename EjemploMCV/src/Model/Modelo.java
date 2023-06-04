/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
/*
  *@web http://jc-mouse.blogspot.com/
  *@author Mouse


*/
/**
 *
 * @author Alejandro Bautista
 */
public class Modelo {
    //Variables
    private String nombre;
    private String apellido;
    private String correo;
    
    public void setNombre(String nom){
        this.nombre=nom;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public void setApellido(String ape){
        this.apellido=ape;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public void setCorreo(String corre){
        this.correo=corre;
    }
    
    public String getCorreo(){
        return this.correo;
    }

}
