/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Florian
 */
public class BenutzerAnlegen extends javax.swing.JFrame
{

    /**
     * Creates new form BenutzerAnlegen
     */
    public BenutzerAnlegen()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        pBenutzer = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        pButton = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btSpeichern = new javax.swing.JButton();
        btSchließen1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Benutzer anlegen");

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pBenutzer.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pBenutzer.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 16, 32));

        jPanel2.setLayout(new java.awt.GridLayout(0, 2, 0, 4));

        jLabel1.setText("Benutername:");
        jPanel2.add(jLabel1);

        jFormattedTextField1.setColumns(16);
        jPanel2.add(jFormattedTextField1);

        jLabel3.setText("Passwort:");
        jPanel2.add(jLabel3);

        jFormattedTextField2.setColumns(16);
        jPanel2.add(jFormattedTextField2);

        jLabel5.setText("Passwort wiederholen:");
        jPanel2.add(jLabel5);

        jFormattedTextField3.setColumns(16);
        jPanel2.add(jFormattedTextField3);

        jPanel3.add(jPanel2);

        pBenutzer.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(pBenutzer, java.awt.BorderLayout.CENTER);

        pButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 0, 0, 0));
        pButton.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel6.setLayout(new java.awt.GridLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        btSpeichern.setText("Speichern");
        jPanel7.add(btSpeichern);

        btSchließen1.setText("Schließen");
        jPanel7.add(btSchließen1);

        jPanel6.add(jPanel7);

        pButton.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(pButton, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(BenutzerAnlegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(BenutzerAnlegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(BenutzerAnlegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(BenutzerAnlegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new BenutzerAnlegen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSchließen1;
    private javax.swing.JButton btSpeichern;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel pBenutzer;
    private javax.swing.JPanel pButton;
    // End of variables declaration//GEN-END:variables
}