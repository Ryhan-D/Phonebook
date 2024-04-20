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
    HashMap<String, Contactos> map;

    public Agenda() {
        cd = new contactosDAO();
        try {
            map = new HashMap<>(cd.getContactos());
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void alta(String tipoContacto, String nombre, String numeroTelefono, String email, String cumpleanios, String empresa) throws ParseException, DatosException {

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
        Date fechaAnio = (cumpleanios.isEmpty() ? null : formatoAnio.parse(cumpleanios));
        if ("Amigo".equalsIgnoreCase(tipoContacto)) {

            contacto = new Contactos_Amigos(nombre, numero, email, fechaAnio);

        } else {

            contacto = new Contactos_Profesionales(nombre, numero, email, empresa);

        }

        try {
            cd.insert(contacto);
            map.put(nombre, contacto);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void baja(String nombre) {
        try {
            cd.delete(nombre);
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void actualizar(String nombre, String numeroTelefono, String email, String cumpleanios, String empresa) throws ParseException, DatosException {

        SimpleDateFormat formatoAnio = new SimpleDateFormat("dd/MM/yyyy");

        //si escribes un email que no este sin rellenar debe contener (@ y .) o da exception
        if (!"".equals(email) && (!email.contains("@") || !email.contains("."))) {
            DatosException exExiste = new DatosException(true);
            throw exExiste;
        }

        Contactos c = (Contactos) map.get(nombre);
        c.setCorreo((email.isEmpty() ? c.getCorreo() : email));
        c.setNumero((numeroTelefono.isEmpty() ? c.getNumero() : Integer.valueOf(numeroTelefono)));

        if (c instanceof Contactos_Amigos) {
            Date fechaAnio = (cumpleanios.isEmpty() ? ((Contactos_Amigos) c).getFechaCumpleanios() : formatoAnio.parse(cumpleanios));
            ((Contactos_Amigos) c).setFechaCumpleanios(fechaAnio);

        } else if (c instanceof Contactos_Profesionales) {
            ((Contactos_Profesionales) c).setNombreEmpresa(empresa.isEmpty() ? ((Contactos_Profesionales) c).getNombreEmpresa() : empresa);
        }

        //update BBDD
        try {
            cd.update(c);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public String buscar(String nombre) {
        Contactos c = null;
        try {
            c = cd.select(nombre);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return c.toString();

    }

    //metodo interfaz con Scanner
    public String ordenarPorNombre() {

        ArrayList<String> ListaNombres = new ArrayList<>(map.keySet());

        Collections.sort(ListaNombres);

        StringBuilder sb = new StringBuilder();

        //al tener '\n' en el toString() de contactos hara salto de linea por cada contacto que se añada al StringBuilder en el bucle
        for (String c : ListaNombres) {
            sb.append(c.toString() + '\n');
        }
        return sb.toString();

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
                    String error = "Introduza nombre para guardar contacto";
                    errores.add("Error en fila=" + contador + " Linea= " + linea + " Error= " + error);
                }
                if (ex.getExiste() == true) {
                    String error = "Nombre introducido ya existe";
                    errores.add("Error en fila=" + contador + " Linea= " + linea + " Error= " + error);
                }
                if (ex.isEmail() == true) {
                    String error = "email introducido no valido";
                    errores.add("Error en fila=" + contador + " Linea= " + linea + " Error= " + error);
                }
            } catch (ParseException ex) {
                contador++;
                String error = "fecha de cumpleaños no valida dd/MM/yyyy";

                errores.add("Error en fila=" + contador + " Linea= " + linea + " Error= " + error);
            } catch (NumberFormatException ex) {
                contador++;
                String error = "Numero de telefono no valido";

                errores.add("Error en fila=" + contador + " Linea= " + linea + " Error= " + error);

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

    //Metodo trabajando con ficheros
    public void guardarAgenda(String documentotxt) throws IOException {

        File f = new File(documentotxt);
        File bck = new File(documentotxt + "bck");
        if (f.exists()) {

            f.renameTo(bck);
        }

        try (FileOutputStream fos = new FileOutputStream(f); ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(map);
            bck.delete();

        } catch (IOException e) {
            bck.renameTo(f);
            throw e;
        }

    }

    //Metodo trabajando con ficheros
    public void cargarAgenda(String documentotxt) throws FileNotFoundException, IOException, ClassNotFoundException {

        try (FileInputStream fis = new FileInputStream(documentotxt); ObjectInputStream ois = new ObjectInputStream(fis);) {
            map = (HashMap<String, Contactos>) ois.readObject();
        }
    }

    //metodo poner nombres en lista interfaz grafica
    public ArrayList<String> getNombres() {

        ArrayList<String> al;

        al = new ArrayList<>(map.keySet());

        Collections.sort(al);

        return al;
    }

    //metodo para asignar datos cuando elijan contactos en la lista interfaz grafica
    public Contactos cargarDatos(String nombre) {

        return map.get(nombre);

    }

}
