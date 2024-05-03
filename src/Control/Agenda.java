package Control;

import Cuerpo.Contactos;
import Cuerpo.Contactos_Amigos;
import Cuerpo.Contactos_Profesionales;
import Cuerpo.contactosDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Agenda {

    contactosDAO cd;

    public Agenda() {
        cd = new contactosDAO();
    }

    public void alta(String tipoContacto, String nombre, String numeroTelefono, String email, String cumpleanios, String empresa) throws ParseException, DatosException, SQLexcep {

        SimpleDateFormat formatoAnio = new SimpleDateFormat("dd/MM/yyyy");

        //si no hay nombre el metodo lanza una exception
        if ("".equals(nombre)) {
            DatosException exRepetido = new DatosException("", false);
            throw exRepetido;
        }

        //si escribes un email debe contener (@ y .) o da exception
        if (!"".equals(email) && (!email.contains("@") || !email.contains("."))) {
            DatosException exRepetido = new DatosException(true);
            throw exRepetido;
        }

        Contactos contacto;
        Integer numero = numeroTelefono.isEmpty() ? null : Integer.valueOf(numeroTelefono);

        if ("Amigo".equalsIgnoreCase(tipoContacto)) {
            Date fechaAnio = (cumpleanios.isEmpty() ? null : formatoAnio.parse(cumpleanios));
            contacto = new Contactos_Amigos(nombre, numero, email, fechaAnio);

        } else {

            contacto = new Contactos_Profesionales(nombre, numero, email, empresa);
        }
        try {
            cd.insert(contacto);

        } catch (SQLException ex) {
            //error code 1 es PK violated, error code 20001 es el error del trigger nombre ya existe
            if (ex.getErrorCode() == 1 || ex.getErrorCode() == 20001) {
                DatosException exRepetido = new DatosException(nombre, true);
                throw exRepetido;
            } else {
                SQLexcep SQLex = new SQLexcep(ex.getErrorCode());
                throw SQLex;
            }
        }
    }

    public void baja(String nombre) throws SQLexcep {
        try {
            cd.delete(nombre);

        } catch (SQLException ex) {
            //no deberia saltar exception, ya que el usuario no tiene opcion de elegir un nombre que no exista
            //exception solo seria algun problema con la BBDD al abrir conexion o cerrar conexion
            SQLexcep SQLex = new SQLexcep(ex.getErrorCode());
            throw SQLex;
        }

    }

    public void actualizar(String nombre, String numeroTelefono, String email, String cumpleanios, String empresa) throws ParseException, DatosException, SQLexcep {

        SimpleDateFormat formatoAnio = new SimpleDateFormat("dd/MM/yyyy");

        //si escribes un email que no este sin rellenar debe contener (@ y .) o da exception
        if (!"".equals(email) && (!email.contains("@") || !email.contains("."))) {
            DatosException exExiste = new DatosException(true);
            throw exExiste;
        }

        Contactos c = null;
        try {
            c = (Contactos) cd.select(nombre);
            c.setCorreo((email.isEmpty() ? "" : email));
            c.setNumero((numeroTelefono.isEmpty() ? null : Integer.valueOf(numeroTelefono)));

            if (c instanceof Contactos_Amigos) {
                ((Contactos_Amigos) c).setFechaCumpleanios(cumpleanios.isEmpty() ? null : formatoAnio.parse(cumpleanios));

            } else {
                ((Contactos_Profesionales) c).setNombreEmpresa(empresa.isEmpty() ? "" : empresa);
            }
        } catch (SQLException ex) {
            SQLexcep SQLex = new SQLexcep(ex.getErrorCode());
            throw SQLex;
        }

        //update BBDD
        try {
            cd.update(c);
        } catch (SQLException ex) {
            SQLexcep SQLex = new SQLexcep(ex.getErrorCode());
            throw SQLex;
        }
    }

    //metodo interfaz con Scanner
    public String buscar(String nombre) throws SQLexcep {
        Contactos c = null;
        try {
            c = cd.select(nombre);
        } catch (SQLException ex) {

            SQLexcep SQLex = new SQLexcep(ex.getErrorCode());
            throw SQLex;
        }

        return c.toString();

    }

    //metodo interfaz con Scanner, no lo usamos trabajando con BBDD
    public String ordenarPorNombre() {

//        ArrayList<String> ListaNombres = new ArrayList<>(map.keySet());
//        Collections.sort(ListaNombres);
//
//        StringBuilder sb = new StringBuilder();
//
//        //al tener '\n' en el toString() de contactos hara salto de linea por cada contacto que se añada al StringBuilder en el bucle
//        for (String c : ListaNombres) {
//            sb.append(c.toString() + '\n');
//        }
//        return sb.toString();
        return null;

    }

    private static int contador;

    //metodo cargar contactos
    public void leerContactos(String archivo) throws FileNotFoundException, IOException, ParseException, DatosException, archivoException {
        String rutaArchivo = archivo;

        FileReader fr = new FileReader(rutaArchivo);

        BufferedReader br = new BufferedReader(fr);

        ArrayList<String> errores = new ArrayList<>();

        String linea = br.readLine();

        while (linea != null) {
            String[] datosSeparados = linea.split(",");
            try {

                alta(datosSeparados[1], datosSeparados[2], datosSeparados[3], datosSeparados[4], datosSeparados[5], datosSeparados[6]);
                contador++;
            } catch (DatosException ex) {
                contador++;

                if ("".equals(ex.getNombre())) {
                    errores.add("Error en fila=" + contador + " Linea= " + linea + " Error= Introduza nombre para guardar contacto");
                }
                if (ex.getExiste() == true) {
                    errores.add("Error en fila=" + contador + " Linea= " + linea + " Error= Nombre introducido ya existe");
                }
                if (ex.isEmail() == true) {
                    errores.add("Error en fila=" + contador + " Linea= " + linea + " Error= email introducido no valido");
                }
            } catch (ParseException ex) {
                contador++;
                errores.add("Error en fila=" + contador + " Linea= " + linea + " Error= fecha de cumpleaños no valida dd/MM/yyyy");
            } catch (NumberFormatException ex) {
                contador++;
                errores.add("Error en fila=" + contador + " Linea= " + linea + " Error= Numero de telefono no valido");

            } catch (Exception ex) {
                contador++;
                errores.add("Error en fila=" + contador + " Linea= " + linea + " Error= " + ex);
            }

            linea = br.readLine();

        }
        contador = 0;
        if (errores != null) {
            archivoException exArchivo = new archivoException(errores);
            throw exArchivo;
        }
    }

//    //Metodo trabajando con ficheros no lo usamos trabajando con BBDD
//    public void guardarAgenda(String documentotxt) throws IOException {
//
//        File f = new File(documentotxt);
//        File bck = new File(documentotxt + "bck");
//        if (f.exists()) {
//
//            f.renameTo(bck);
//        }
//
//        try (FileOutputStream fos = new FileOutputStream(f); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//
////            oos.writeObject(map);
//            bck.delete();
//
//        } catch (IOException e) {
//            bck.renameTo(f);
//            throw e;
//        }
//
//    }
//
//    //Metodo trabajando con ficheros, no lo usamos trabajando con BBDD
//    public void cargarAgenda(String documentotxt) throws FileNotFoundException, IOException, ClassNotFoundException {
//
//        try (FileInputStream fis = new FileInputStream(documentotxt); ObjectInputStream ois = new ObjectInputStream(fis);) {
//            map = (HashMap<String, Contactos>) ois.readObject();
//        }
//    }
    
    
    //metodo poner nombres en lista interfaz grafica
    public ArrayList<String> getNombres() throws SQLexcep {

        ArrayList<String> al = null;

        try {
            al = cd.nombres();
            Collections.sort(al);
        } catch (SQLException ex) {
            SQLexcep SQLex = new SQLexcep(ex.getErrorCode());
            throw SQLex;
        }
        return al;
    }

    //metodo para asignar datos cuando elijan contactos en la lista interfaz grafica
    public String[] cargarDatos(String nombre) throws SQLexcep {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Contactos c = null;
        String[] datos = new String[5];

        try {
            c = cd.select(nombre);

            datos[0] = c instanceof Contactos_Amigos ? "a" : "p";
            datos[1] = c.getNombre();
            datos[2] = c.getNumero() == null ? "" : c.getNumero() + "";
            datos[3] = c.getCorreo();
            datos[4] = c instanceof Contactos_Amigos ? (((Contactos_Amigos) c).getFechaCumpleanios() == null ? "" : sdf.format(((Contactos_Amigos) c).getFechaCumpleanios())) : ((Contactos_Profesionales) c).getNombreEmpresa();

        } catch (SQLException ex) {
            SQLexcep SQLex = new SQLexcep(ex.getErrorCode());
            throw SQLex;
        }
        return datos;
    }

}
