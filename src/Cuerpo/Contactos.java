/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cuerpo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author MULTI
 */
abstract public class Contactos implements Comparable,Serializable {

    private String nombre;
    private Integer numero;
    private String correo;

    public Contactos(String nombre, Integer numero, String correo) {
        this.nombre = nombre;
        this.numero = numero;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contactos other = (Contactos) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public int compareTo(Object o) {
        final Contactos other = (Contactos) o;
        return this.getNombre().compareTo(other.getNombre());
    }

    @Override
    public String toString() {

        return "," + nombre + (numero == null ? "," : "," + numero) + (correo == null ? "," : "," + correo);

    }
}
