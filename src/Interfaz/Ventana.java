package Interfaz;

import Control.Agenda;
import Control.DatosException;
import Control.archivoException;
import Cuerpo.Contactos;
import Cuerpo.Contactos_Amigos;
import Cuerpo.Contactos_Profesionales;
import java.awt.FileDialog;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Ventana extends java.awt.Frame {

    Agenda a;
    exceptionsDialog exceptionD;
    sionodialog siNo;
    FileDialog safe;
    FileDialog load;
    cargarContactos contactosLoad;
   

    public Ventana() {
        a = new Agenda();

        exceptionD = new exceptionsDialog(this, true);
        safe = new FileDialog(this, "Guardar", FileDialog.SAVE);
        load = new FileDialog(this, "Cargar", FileDialog.LOAD);
        contactosLoad = new cargarContactos(this, true);
        siNo = new sionodialog(this, true);
       

        initComponents();

        setLocationRelativeTo(null);
        exceptionD.setLocationRelativeTo(null);
        siNo.setLocationRelativeTo(null);
        contactosLoad.setLocationRelativeTo(null);
        safe.setLocationRelativeTo(null);
        load.setLocationRelativeTo(null);
        contactosLoad.setLocationRelativeTo(null);

        lista.add("<Añadir nuevo contacto>");

        for (String c : a.getNombres()) {
            lista.add(c);
        }

        choiceContacto.add("Grupo Contacto");
        choiceContacto.add("Amigo");
        choiceContacto.add("Profesional");

        choiceContacto.setEnabled(false);
        altaB.setEnabled(false);
        bajaB.setEnabled(false);
        modificarB.setEnabled(false);

        empresaTA.setVisible(false);
        nombreL.setVisible(false);
        telefonoL.setVisible(false);
        correoL.setVisible(false);
        empresaTA.setVisible(false);
        cumpleañosTA.setVisible(false);
        choiceContacto.setVisible(false);
        nombreTF.setVisible(false);
        telefonoTF.setVisible(false);
        correoTF.setVisible(false);
        cumpleañosTF.setVisible(false);

   
    }

    private void recargarLista() {

        ArrayList<String> al;

        al = new ArrayList<>(a.getNombres());

        lista.removeAll();
        lista.add("<Añadir nuevo contacto>");
        for (String c : al) {

            lista.add(c);
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel1 = new java.awt.Panel();
        altaB = new java.awt.Button();
        bajaB = new java.awt.Button();
        modificarB = new java.awt.Button();
        panel2 = new java.awt.Panel();
        panel4 = new java.awt.Panel();
        lista = new java.awt.List();
        listarB = new java.awt.Button();
        panel3 = new java.awt.Panel();
        nombreL = new java.awt.Label();
        telefonoL = new java.awt.Label();
        correoL = new java.awt.Label();
        cumpleañosTA = new java.awt.Label();
        empresaTA = new java.awt.Label();
        nombreTF = new java.awt.TextField();
        telefonoTF = new java.awt.TextField();
        correoTF = new java.awt.TextField();
        cumpleañosTF = new java.awt.TextField();
        choiceContacto = new java.awt.Choice();
        agendaL = new java.awt.Label();
        telefonicaL = new java.awt.Label();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        cargarContactosItem = new java.awt.MenuItem();

        setMinimumSize(new java.awt.Dimension(900, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(0, 0, 0));
        panel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 20));

        altaB.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        altaB.setLabel("ALTA");
        altaB.setMinimumSize(new java.awt.Dimension(110, 29));
        altaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaBActionPerformed(evt);
            }
        });
        panel1.add(altaB);

        bajaB.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        bajaB.setLabel("BAJA");
        bajaB.setMinimumSize(new java.awt.Dimension(110, 29));
        bajaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaBActionPerformed(evt);
            }
        });
        panel1.add(bajaB);

        modificarB.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        modificarB.setLabel("MODIFICAR");
        modificarB.setMinimumSize(new java.awt.Dimension(110, 29));
        modificarB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarBMouseClicked(evt);
            }
        });
        panel1.add(modificarB);

        add(panel1, java.awt.BorderLayout.SOUTH);

        panel2.setBackground(new java.awt.Color(153, 204, 255));
        panel2.setLayout(new java.awt.GridLayout(1, 2));

        panel4.setBackground(new java.awt.Color(102, 204, 255));
        panel4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        panel4.setLayout(new java.awt.GridBagLayout());

        lista.setBackground(new java.awt.Color(204, 255, 204));
        lista.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 2.4;
        gridBagConstraints.insets = new java.awt.Insets(20, 105, 20, 7);
        panel4.add(lista, gridBagConstraints);

        listarB.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        listarB.setLabel("LISTAR");
        listarB.setMinimumSize(new java.awt.Dimension(110, 29));
        listarB.setPreferredSize(new java.awt.Dimension(100, 29));
        listarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarBActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 7);
        panel4.add(listarB, gridBagConstraints);

        panel2.add(panel4);

        panel3.setBackground(new java.awt.Color(153, 204, 255));
        panel3.setMaximumSize(new java.awt.Dimension(5000, 5000));
        java.awt.GridBagLayout panel3Layout = new java.awt.GridBagLayout();
        panel3Layout.columnWidths = new int[] {0, 5, 0};
        panel3Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        panel3.setLayout(panel3Layout);

        nombreL.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        nombreL.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(9, 64, 27, 0);
        panel3.add(nombreL, gridBagConstraints);
        nombreL.getAccessibleContext().setAccessibleName("");

        telefonoL.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        telefonoL.setText("Telefono:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(9, 53, 27, 0);
        panel3.add(telefonoL, gridBagConstraints);

        correoL.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        correoL.setText("Correo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(9, 78, 27, 0);
        panel3.add(correoL, gridBagConstraints);

        cumpleañosTA.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        cumpleañosTA.setText("Cumpleaños:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 27, 0);
        panel3.add(cumpleañosTA, gridBagConstraints);

        empresaTA.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        empresaTA.setText("Empresa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(9, 52, 27, 0);
        panel3.add(empresaTA, gridBagConstraints);

        nombreTF.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        nombreTF.setMinimumSize(new java.awt.Dimension(250, 25));
        nombreTF.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.9;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 24, 26);
        panel3.add(nombreTF, gridBagConstraints);

        telefonoTF.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        telefonoTF.setMinimumSize(new java.awt.Dimension(250, 25));
        telefonoTF.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.9;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 24, 26);
        panel3.add(telefonoTF, gridBagConstraints);

        correoTF.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        correoTF.setMinimumSize(new java.awt.Dimension(250, 25));
        correoTF.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.9;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 24, 26);
        panel3.add(correoTF, gridBagConstraints);

        cumpleañosTF.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        cumpleañosTF.setMinimumSize(new java.awt.Dimension(250, 25));
        cumpleañosTF.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.9;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 24, 26);
        panel3.add(cumpleañosTF, gridBagConstraints);

        choiceContacto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choiceContactoItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(14, 34, 14, 14);
        panel3.add(choiceContacto, gridBagConstraints);

        agendaL.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        agendaL.setText("AGENDA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 74, 0);
        panel3.add(agendaL, gridBagConstraints);

        telefonicaL.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        telefonicaL.setText("TELEFONICA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 9;
        panel3.add(telefonicaL, gridBagConstraints);

        panel2.add(panel3);

        add(panel2, java.awt.BorderLayout.CENTER);

        menu1.setLabel("Archivo");

        cargarContactosItem.setLabel("Cargar contactos");
        cargarContactosItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarContactosItemActionPerformed(evt);
            }
        });
        menu1.add(cargarContactosItem);

        menuBar1.add(menu1);

        setMenuBar(menuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm

        siNo.setTxtL("Estas seguro que quieres cerrar la agenda?");
        siNo.setVisible(true);
        if (siNo.isRespuesta() == true) {
            System.exit(0);
        } else {
            siNo.setVisible(false);
        }


    }//GEN-LAST:event_exitForm

    //boton modificar
    private void modificarBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarBMouseClicked

        try {
            a.actualizar(nombreTF.getText(), telefonoTF.getText(), correoTF.getText(), cumpleañosTF.getText(), cumpleañosTF.getText());

            exceptionD.ponerMensaje(" Contacto actualizado");
            exceptionD.setVisible(true);
        } catch (ParseException ex) {

            exceptionD.ponerMensaje(" Introduzca fecha de nacimiento valida dd/mm/year");
            exceptionD.setVisible(true);
        } catch (NumberFormatException ex) {

            exceptionD.ponerMensaje(" Introduzca numero de telefono valido");
            exceptionD.setVisible(true);
        } catch (DatosException ex) {
            if (ex.isEmail() == true) {

                exceptionD.ponerMensaje(" Email introducido no valido");
                exceptionD.setVisible(true);
            }
        }


    }//GEN-LAST:event_modificarBMouseClicked

    //boton de baja
    private void bajaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaBActionPerformed

        siNo.setTxtL("¿Estas seguro de que quiere borrar el contacto " + nombreTF.getText() + "?");

        siNo.setVisible(true);

        if (siNo.isRespuesta() == true) {
            a.baja(nombreTF.getText());

            lista.remove(nombreTF.getText());

            choiceContacto.add("Grupo Contacto");
            choiceContacto.select("Grupo Contacto");
            choiceContacto.setEnabled(false);
            nombreTF.setText("");
            telefonoTF.setText("");
            correoTF.setText("");
            cumpleañosTF.setText("");
            bajaB.setEnabled(false);
            modificarB.setEnabled(false);

            panel4.revalidate();
            panel4.repaint();

        } else {
            siNo.setVisible(false);
        }
    }//GEN-LAST:event_bajaBActionPerformed

    //cuando hacemos click en un nombre de la lista
    private void listaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaItemStateChanged
        String nombre = lista.getSelectedItem();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if ("<Añadir nuevo contacto>".equalsIgnoreCase(nombre)) {
            altaB.setEnabled(true);
            choiceContacto.setEnabled(true);
            bajaB.setEnabled(false);
            modificarB.setEnabled(false);
            nombreTF.setEditable(true);
            nombreTF.setText("");
            telefonoTF.setText("");
            correoTF.setText("");
            cumpleañosTF.setText("");

            choiceContacto.select("Amigo");
            if (choiceContacto.getItemCount() > 2) {
                choiceContacto.remove("Grupo Contacto");
            }

            nombreL.setVisible(true);
            telefonoL.setVisible(true);
            correoL.setVisible(true);
            cumpleañosTA.setVisible(true);
            choiceContacto.setVisible(true);
            nombreTF.setVisible(true);
            telefonoTF.setVisible(true);
            correoTF.setVisible(true);
            cumpleañosTF.setVisible(true);
            agendaL.setVisible(false);
            telefonicaL.setVisible(false);

            validate();
            repaint();
        } else {
           
            System.out.println(lista.getItemCount()); 
            Contactos c = a.cargarDatos(nombre);

            if (c instanceof Contactos_Amigos) {
                cumpleañosTA.setVisible(true);
                empresaTA.setVisible(false);
                choiceContacto.setEnabled(false);

                if (((Contactos_Amigos) c).getFechaCumpleanios() == null) {
                    cumpleañosTF.setText("");
                } else {
                    cumpleañosTF.setText(sdf.format(((Contactos_Amigos) c).getFechaCumpleanios()));
                }

                choiceContacto.select("Amigo");
                if (choiceContacto.getItemCount() > 2) {
                    choiceContacto.remove("Grupo Contacto");
                }

            } else {
                cumpleañosTA.setVisible(false);
                empresaTA.setVisible(true);
                cumpleañosTF.setText(((Contactos_Profesionales) c).getNombreEmpresa());
                choiceContacto.select("Profesional");
                if (choiceContacto.getItemCount() > 2) {
                    choiceContacto.remove("Grupo Contacto");
                }
            }
            nombreTF.setText(c.getNombre());
            correoTF.setText(c.getCorreo());

            String numero = c.getNumero() + "";
            telefonoTF.setText(c.getNumero() == null ? "" : numero);
            nombreTF.setEditable(false);
            nombreL.setVisible(true);
            telefonoL.setVisible(true);
            correoL.setVisible(true);
            choiceContacto.setVisible(true);
            nombreTF.setVisible(true);
            telefonoTF.setVisible(true);
            correoTF.setVisible(true);
            cumpleañosTF.setVisible(true);
            agendaL.setVisible(false);
            telefonicaL.setVisible(false);

            validate();
            repaint();

            altaB.setEnabled(false);
            choiceContacto.setEnabled(false);
            bajaB.setEnabled(true);
            modificarB.setEnabled(true);
           
    }//GEN-LAST:event_listaItemStateChanged
    }

    //boton de alta
    private void altaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaBActionPerformed
        try {
            a.alta(choiceContacto.getSelectedItem(), nombreTF.getText(), telefonoTF.getText(), correoTF.getText(), cumpleañosTF.getText(), cumpleañosTF.getText());

        } catch (ParseException ex) {
            exceptionD.ponerMensaje(" Introduzca fecha de nacimiento valida dd/mm/year");
            exceptionD.setVisible(true);

        } catch (NumberFormatException ex) {

            exceptionD.ponerMensaje(" Introduzca numero de telefono valido");
            exceptionD.setVisible(true);
        } catch (DatosException ex) {
            if ("".equals(ex.getNombre())) {
                exceptionD.ponerMensaje(" Introduza nombre para guardar contacto");
                exceptionD.setVisible(true);
            } else if (ex.isEmail() == true) {
                exceptionD.ponerMensaje(" Email introducido no valido");
                exceptionD.setVisible(true);
            } else {
                exceptionD.ponerMensaje(" El nombre " + ex.getNombre() + " ya existe");
                exceptionD.setVisible(true);
            }
        }

        recargarLista();

    }//GEN-LAST:event_altaBActionPerformed

    //choice amigo o profesional
    private void choiceContactoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choiceContactoItemStateChanged

        if (choiceContacto.getSelectedItem().equalsIgnoreCase("Amigo")) {
            cumpleañosTA.setVisible(true);
            empresaTA.setVisible(false);

        } else {
            cumpleañosTA.setVisible(false);
            empresaTA.setVisible(true);

        }

    }//GEN-LAST:event_choiceContactoItemStateChanged

    //cargar contactos por archivo
    private void cargarContactosItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarContactosItemActionPerformed
        load.setVisible(true);

        String archivo = load.getFile();

        if (archivo != null) {

            try {
                a.leerContactos(archivo);

            } catch (IOException | ParseException | DatosException ex) {
                exceptionD.ponerMensaje(ex.getMessage());
                exceptionD.setVisible(true);
            } catch (archivoException ex) {

                String mensaje = "Contactos que no se han podido dar de alta: ";
                contactosLoad.ponerMensajelist(mensaje);

                for (String c : ex.getError()) {
                    contactosLoad.ponerMensajelist(c);

                }

                contactosLoad.setVisible(true);
            }
            recargarLista();
            contactosLoad.limpiarLista();

        }
    }//GEN-LAST:event_cargarContactosItemActionPerformed

    //metodo listar
    private void listarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarBActionPerformed
        //valor int 1, el 0 siempre sera ("Agregar nuevo contacto")
        for (int i = 1; i < lista.getItemCount(); i++) {
            String contacto = lista.getItem(i);

            Contactos c = (a.cargarDatos(contacto));

            if (c instanceof Contactos_Amigos) {
                contactosLoad.ponerMensajelist("TIPO: Amigo" + " NOMBRE: " + c.getNombre() + " TELEFONO: " + (c.getNumero() + "") + " CORREO: " + c.getCorreo() + " CUMPLEAÑOS: " + ((Contactos_Amigos) c).getFechaCumpleanios());
            } else {
                contactosLoad.ponerMensajelist("TIPO: Profesional" + " NOMBRE: " + c.getNombre() + " TELEFONO: " + (c.getNumero() + "") + " CORREO: " + c.getCorreo() + " EMPRESA: " + ((Contactos_Profesionales) c).getNombreEmpresa());
            }

        }
        contactosLoad.setVisible(true);
        contactosLoad.limpiarLista();
    }//GEN-LAST:event_listarBActionPerformed

    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                new Ventana().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label agendaL;
    private java.awt.Button altaB;
    private java.awt.Button bajaB;
    private java.awt.MenuItem cargarContactosItem;
    private java.awt.Choice choiceContacto;
    private java.awt.Label correoL;
    private java.awt.TextField correoTF;
    private java.awt.Label cumpleañosTA;
    private java.awt.TextField cumpleañosTF;
    private java.awt.Label empresaTA;
    private java.awt.List lista;
    private java.awt.Button listarB;
    private java.awt.Menu menu1;
    private java.awt.MenuBar menuBar1;
    private java.awt.Button modificarB;
    private java.awt.Label nombreL;
    private java.awt.TextField nombreTF;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private java.awt.Label telefonicaL;
    private java.awt.Label telefonoL;
    private java.awt.TextField telefonoTF;
    // End of variables declaration//GEN-END:variables
}
