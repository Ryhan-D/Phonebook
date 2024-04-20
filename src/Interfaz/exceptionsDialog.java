
package Interfaz;

public class exceptionsDialog extends java.awt.Dialog {

   
    public exceptionsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         
    }
public void ponerMensaje(String txt){
    
    lException.setText(txt);
    pack();

}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okB = new java.awt.Button();
        panel1 = new java.awt.Panel();
        lException = new java.awt.Label();

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

        panel1.setLayout(new java.awt.GridBagLayout());

        lException.setText("label1");
        panel1.add(lException, new java.awt.GridBagConstraints());

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
                exceptionsDialog dialog = new exceptionsDialog(new java.awt.Frame(), true);
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
    private java.awt.Label lException;
    private java.awt.Button okB;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
