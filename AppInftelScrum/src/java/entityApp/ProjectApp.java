/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityApp;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author inftel20
 */
public class ProjectApp {
    private String nombre;
    private String descripcion;
    private String id_admin;
    private ArrayList<String> estados;

    public ProjectApp() {
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_admin() {
        return id_admin;
    }

    public void setId_admin(String id_admin) {
        this.id_admin = id_admin;
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }

   

    @Override
    public String toString() {
        return "ProjectApp{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", id_admin=" + id_admin + ", estados=" + estados + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProjectApp other = (ProjectApp) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id_admin, other.id_admin)) {
            return false;
        }
        return true;
    }
    
    
    
}
