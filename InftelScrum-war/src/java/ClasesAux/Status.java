/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesAux;

/**
 *
 * @author inftel20
 */
public class Status {
    String nombre;
    int posicion;
    
    public Status() {
    }


    public Status(String nombre, int posicion) {
        this.nombre = nombre;
        this.posicion = posicion;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
}
