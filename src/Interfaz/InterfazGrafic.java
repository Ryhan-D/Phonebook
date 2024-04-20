package Interfaz;

import Control.Agenda;
import Control.DatosException;
import Control.archivoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class InterfazGrafic {
//
   public static void main(String[] args) throws ParseException, DatosException, IOException, FileNotFoundException, archivoException, SQLException {
//
//        Scanner sc = new Scanner(System.in);
//
        Agenda a = new Agenda();
        System.out.println(a.cargarDatos("Aaron"));
//        while (true) {
//            System.out.println("0.Salir");
//            System.out.println("1.Alta");
//            System.out.println("2.Baja");
//            System.out.println("3.Modificar");
//            System.out.println("4.Buscar");
//            System.out.println("5.Listado");
//            System.out.println("6.Importar contactos");
//            String next = sc.nextLine();
//            switch (next) {
//
//                case "0":
//                    return;
//
//                case "1":
//                    System.out.println("Indique tipo Contacto");
//                    String tipoContacto = sc.nextLine();
//                    System.out.println("Indique nombre de Contacto");
//                    String nombre = sc.nextLine();
//                    System.out.println("Indique numero de telefono");
//                    String telefono = sc.nextLine();
//                    System.out.println("Indique email");
//                    String email = sc.nextLine();
//                    System.out.println("Indique cumpleaños");
//                    String cumpleanios = sc.nextLine();
//                    System.out.println("Indique nombre Empresa");
//                    String empresa = sc.nextLine();
//                    try {
//                        a.alta(tipoContacto, nombre, telefono, email, cumpleanios, empresa);
//                    } catch (ParseException ex) {
//                        System.out.println("Introduzca fecha de nacimiento valida dd/mm/year");
//                    } catch (NumberFormatException ex) {
//                        System.out.println("Introduzca numero de telefono valido");
//                    } catch (DatosException ex) {
//                        if ("".equals(ex.getNombre())) {
//                            System.out.println("Introduza nombre para guardar contacto");
//                        } else if (ex.isEmail() == true) {
//                            System.out.println("Email introducido no valido");
//                        } else {
//                            System.out.println("El nombre " + ex.getNombre() + " ya existe");
//                        }
//                    }
//
//                    break;
//
//                case "2":
//                    System.out.println("Indique nombre para borrar");
//                    String baja = sc.nextLine();
//                    try {
//                        a.baja(baja);
//                    } catch (DatosException ex) {
//                        if ("".equals(ex.getNombre())) {
//                            System.out.println("No has ingresado ningun nombre");
//                        } else {
//                            System.out.println("el contacto " + ex.getNombre() + " que intenta eliminar no existe");
//                        }
//                    }
//                    break;
//
//                case "3":
//                    System.out.println("Indique nombre de Contacto");
//                    String nombreA = sc.nextLine();
//                    System.out.println("Indique numero de telefono");
//                    String telefonoA = sc.nextLine();
//                    System.out.println("Indique email");
//                    String emailA = sc.nextLine();
//                    System.out.println("Indique cumpleaños");
//                    String cumpleaniosA = sc.nextLine();
//                    System.out.println("Indique nombre Empresa");
//                    String empresaA = sc.nextLine();
//                    try {
//                        a.actualizar(nombreA, telefonoA, emailA, cumpleaniosA, empresaA);
//                    } catch (ParseException ex) {
//                        System.out.println("Introduzca fecha de nacimiento valida dd/mm/year");
//                    } catch (NumberFormatException ex) {
//                        System.out.println("Introduzca numero de telefono valido");
//                    } catch (DatosException ex) {
//                        if ("".equals(ex.getNombre())) {
//                            System.out.println("Introduza nombre para modificar contacto");
//                        }
//                        if (ex.isEmail() == true) {
//                            System.out.println("Email introducido no valido");
//                        }
//                        if (ex.getExiste() == true) {
//                            System.out.println("No existe el contacto con nombre " + ex.getNombre());
//                        }
//
//                    }
//                    break;
//
//                case "4":
//                    System.out.println("Indique nombre a buscar");
//                    String nombreB = sc.nextLine();
//                    try {
//                        System.out.println(a.buscar(nombreB));
//                    } catch (DatosException ex) {
//                        if ("".equals(ex.getNombre())) {
//                            System.out.println("No has ingresado ningun nombre");
//                        } else {
//                            System.out.println("Contacto " + ex.getNombre() + " no existe");
//                        }
//                    }
//                    break;
//
//                case "5":
//                    System.out.println(a.ordenarPorNombre());
//                    break;
//
//                case "6":
//                    System.out.println("Indique nombre de archivo contactos");
//                    String archivo = sc.nextLine();
//                    try {
//                        a.leerContactos(archivo);
//                    } catch (FileNotFoundException ex) {
//                        System.out.println("No existe el archivo");
//                    } catch (archivoException e) {
//                        System.out.println("Contactos que no se han podido dar de alta: ");
//                        for (String c : e.getError()) {
//                            System.out.println(c);
//                        }
//                    }
//                    break;
//                    case "7":
//                    System.out.println("Indique nombre para guardar agenda");
//                    archivo = sc.nextLine();
//                    try {
//                        a.guardarAgenda(archivo);
//                        System.out.println("Agenda con nombre " + archivo + " guardado");
//                    } catch (IOException e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//
//                case "8":
//                    System.out.println("Indique nombre para cargar agenda");
//                    archivo = sc.nextLine();
//                    try {
//                        a.cargarAgenda(archivo);
//                        System.out.println("Agenda con nombre " + archivo + " cargado");
//                    } catch (FileNotFoundException e) {
//                        System.out.println("No se ha encontrado el archivo con nombre " + archivo);
//                    } catch (StreamCorruptedException e) {
//                        System.out.println("Has intentado cargar un archivo con nombre " + archivo + " que no es una agenda");
//                    } catch (ClassNotFoundException | IOException e) {
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//
//
//            }
//
//        }
//
    }

}
