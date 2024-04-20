/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cuerpo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MULTI
 */
public class Contactos_Amigos extends Contactos {

    private Date fechaCumpleanios;

    public Contactos_Amigos(String nombre,Integer numero,String correo,Date fechaCumpleanios) {
        super(nombre, numero, correo);
        this.fechaCumpleanios = fechaCumpleanios;
    }

   

    public Contactos_Amigos(String nombre, Integer numero, String correo) {
        super(nombre, numero, correo);
        fechaCumpleanios = null;
    }

    public Contactos_Amigos(String nombre, String correo) {
        super(nombre, null, correo);
        fechaCumpleanios = null;
    }

    public Contactos_Amigos(String nombre) {
        super(nombre, null, null);
        fechaCumpleanios = null;
    }

    public Contactos_Amigos(String nombre, Date fechaCumpleanio) {
        super(nombre, null, null);
        fechaCumpleanios = fechaCumpleanio;
    }

    public Contactos_Amigos(String nombre, String correo, Date fechaCumpleanio) {
        super(nombre, null, correo);
        fechaCumpleanios = fechaCumpleanio;
    }

    public Contactos_Amigos(String nombre, Integer numero, Date fechaCumpleanio) {
        super(nombre, numero, null);
        fechaCumpleanios = fechaCumpleanio;
    }

    public Date getFechaCumpleanios() {
        return fechaCumpleanios;
    }

    public void setFechaCumpleanios(Date fechaCumpleanios) {
        this.fechaCumpleanios = fechaCumpleanios;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoaño = new SimpleDateFormat("dd/MM/yyyy");

        return "Amigo" + super.toString() + (fechaCumpleanios == null ? "," : "," + formatoaño.format(fechaCumpleanios))+'\n';
    }
}
