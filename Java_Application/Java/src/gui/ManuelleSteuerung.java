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
public class ManuelleSteuerung extends javax.swing.JDialog
{

    /**
     * Creates new form ManuelleSteuerung
     */
    public ManuelleSteuerung(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
               
        initComponents();
         
        setLocationRelativeTo(parent);
        pack();
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
        pCenter = new javax.swing.JPanel();
        pSteuerung = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pPosInfo = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pButton = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btSchließen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Manuelle Steuerung");

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pCenter.setLayout(new java.awt.BorderLayout());

        pSteuerung.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 4));
        pSteuerung.setLayout(new java.awt.BorderLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 16, 32));

        jLabel3.setText("TODO");
        jPanel3.add(jLabel3);

        jPanel11.add(jPanel3, java.awt.BorderLayout.CENTER);

        pSteuerung.add(jPanel11, java.awt.BorderLayout.CENTER);

        pCenter.add(pSteuerung, java.awt.BorderLayout.CENTER);

        pPosInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pPosInfo.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 16, 32));

        jLabel4.setText("TODO");
        jPanel6.add(jLabel4);

        pPosInfo.add(jPanel6, java.awt.BorderLayout.CENTER);

        pCenter.add(pPosInfo, java.awt.BorderLayout.EAST);

        jPanel1.add(pCenter, java.awt.BorderLayout.CENTER);

        pButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 0, 0, 0));
        pButton.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel4.setLayout(new java.awt.GridLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        btSchließen.setText("Schließen");
        btSchließen.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSchließenonSchließen(evt);
            }
        });
        jPanel5.add(btSchließen);

        jPanel4.add(jPanel5);

        pButton.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(pButton, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSchließenonSchließen(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btSchließenonSchließen
    {//GEN-HEADEREND:event_btSchließenonSchließen
        dispose();
    }//GEN-LAST:event_btSchließenonSchließen

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
            java.util.logging.Logger.getLogger(ManuelleSteuerung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ManuelleSteuerung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ManuelleSteuerung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ManuelleSteuerung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ManuelleSteuerung dialog = new ManuelleSteuerung(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSchließen;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel pButton;
    private javax.swing.JPanel pCenter;
    private javax.swing.JPanel pPosInfo;
    private javax.swing.JPanel pSteuerung;
    // End of variables declaration//GEN-END:variables
}