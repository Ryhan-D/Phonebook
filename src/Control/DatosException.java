package Control;

public class DatosException extends Exception {

    private String nombre;
    private boolean existe;
    private boolean email;

    public DatosException(boolean email) {

        this.email = email;

    }

    DatosException(String nombr, boolean exist) {

        nombre = nombr;
        existe = exist;

    }

    public boolean getExiste() {
        return existe;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEmail() {
        return email;
    }

}
