
package Cuerpo;

public class Contactos_Profesionales extends Contactos {

    private String nombreEmpresa;

    public Contactos_Profesionales(String nombre, Integer numero, String correo, String nombemp) {
        super(nombre, numero, correo);
        nombreEmpresa = nombemp;
    }

    public Contactos_Profesionales(String nombre, String nombreEmpres) {
        super(nombre, null, null);
        nombreEmpresa = nombreEmpres;
    }

    public Contactos_Profesionales(String nombre) {
        super(nombre, null, null);
        nombreEmpresa = null;
    }

    public Contactos_Profesionales(String nombre, Integer numero) {
        super(nombre, numero, null);
        nombreEmpresa = null;
    }

    public Contactos_Profesionales(String nombre, String correo, String nombreEmpres) {
        super(nombre, null, correo);
        nombreEmpresa = nombreEmpres;
    }

    public Contactos_Profesionales(String nombre, Integer numero, String correo) {
        super(nombre, numero, correo);
        nombreEmpresa = null;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String toString() {

        return "Profesional" + super.toString() + (nombreEmpresa == null ? ", " : "," + nombreEmpresa);
    }
}
