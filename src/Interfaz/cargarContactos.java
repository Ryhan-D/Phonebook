package Interfaz;

public class cargarContactos extends java.awt.Dialog {

    public cargarContactos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        

    }

    public void ponerMensajelist(String txt) {

        lista.add(txt);

        pack();

    }
   public void limpiarLista(){
   lista.removeAll();
   }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        okB = new java.awt.Button();
        panel1 = new java.awt.Panel();
        lista = new java.awt.List();

        setMinimumSize(new java.awt.Dimension(700, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(new java.awt.BorderLayout(3, 0));

        okB.setLabel("OK");
        okB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBActionPerformed(evt);
            }
        });
        add(okB, java.awt.BorderLayout.SOUTH);

        panel1.setPreferredSize(new java.awt.Dimension(90, 140));
        panel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 0.6;
        panel1.add(lista, gridBagConstraints);

        add(panel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void okBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_okBActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                cargarContactos dialog = new cargarContactos(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.List lista;
    private java.awt.Button okB;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
