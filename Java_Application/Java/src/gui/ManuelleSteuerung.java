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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pCenter = new javax.swing.JPanel();
        pSteuerung = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        pZustimmung = new javax.swing.JPanel();
        pMotor1_1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        pMotor2_2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        pText = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pPosInfo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pMotor1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pMotor2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pSensor1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pSensor2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
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

        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 16, 32));

        jPanel12.setLayout(new java.awt.GridLayout(3, 0, 0, 8));

        pZustimmung.setLayout(new java.awt.BorderLayout());

        pMotor1_1.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Motor 1");
        pMotor1_1.add(jLabel2, java.awt.BorderLayout.NORTH);

        jPanel14.setLayout(new java.awt.GridLayout(1, 0));

        jButton4.setText("Links Drehen");
        jPanel14.add(jButton4);

        jPanel13.add(jPanel14);

        jButton5.setText("Rechts Drehen");
        jPanel13.add(jButton5);

        jButton6.setText("Stop");
        jPanel13.add(jButton6);

        pMotor1_1.add(jPanel13, java.awt.BorderLayout.WEST);

        pZustimmung.add(pMotor1_1, java.awt.BorderLayout.CENTER);

        jPanel12.add(pZustimmung);

        pMotor2_2.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Motor 2");
        pMotor2_2.add(jLabel3, java.awt.BorderLayout.NORTH);

        jPanel16.setLayout(new java.awt.GridLayout(1, 0));

        jButton7.setText("Links Drehen");
        jPanel16.add(jButton7);

        jPanel15.add(jPanel16);

        jButton8.setText("Rechts Drehen");
        jPanel15.add(jButton8);

        jButton9.setText("Stop");
        jPanel15.add(jButton9);

        pMotor2_2.add(jPanel15, java.awt.BorderLayout.WEST);

        jPanel12.add(pMotor2_2);

        pText.setLayout(new java.awt.BorderLayout());

        jPanel22.setLayout(new java.awt.GridBagLayout());

        jLabel15.setText("Wenn die manuelle Steuerung aktiv ist werden währenddessen keine automatischen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel22.add(jLabel15, gridBagConstraints);

        jLabel16.setText("Fütterungen ausgeführt, weil diese deaktiviert sind.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel22.add(jLabel16, gridBagConstraints);

        jLabel17.setText("Die automatische Fütterung muss vom User selbst wieder aktiviert werden.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel22.add(jLabel17, gridBagConstraints);

        pText.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel12.add(pText);

        jPanel10.add(jPanel12);

        jPanel11.add(jPanel10, java.awt.BorderLayout.CENTER);

        pSteuerung.add(jPanel11, java.awt.BorderLayout.CENTER);

        pCenter.add(pSteuerung, java.awt.BorderLayout.CENTER);

        pPosInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pPosInfo.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 16, 32));

        jPanel2.setLayout(new java.awt.GridLayout(4, 0));

        pMotor1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Motor 1");
        pMotor1.add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel7.setLayout(new java.awt.GridLayout(1, 0, 8, 0));

        jLabel5.setText("Pos1");
        jPanel7.add(jLabel5);

        jLabel6.setText("Pos2");
        jPanel7.add(jLabel6);

        jPanel9.add(jPanel7);

        pMotor1.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel2.add(pMotor1);

        pMotor2.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Motor 2");
        pMotor2.add(jLabel4, java.awt.BorderLayout.NORTH);

        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel8.setLayout(new java.awt.GridLayout(1, 0, 8, 0));

        jLabel7.setText("Pos1");
        jPanel8.add(jLabel7);

        jLabel8.setText("Pos2");
        jPanel8.add(jLabel8);

        jPanel17.add(jPanel8);

        pMotor2.add(jPanel17, java.awt.BorderLayout.CENTER);

        jPanel2.add(pMotor2);

        pSensor1.setLayout(new java.awt.BorderLayout());

        jLabel9.setText("Sensor 1");
        pSensor1.add(jLabel9, java.awt.BorderLayout.NORTH);

        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel19.setLayout(new java.awt.GridLayout(1, 0, 8, 0));

        jLabel11.setText("(nicht)betätigt");
        jPanel19.add(jLabel11);

        jLabel10.setText("Pos1");
        jPanel19.add(jLabel10);

        jPanel18.add(jPanel19);

        pSensor1.add(jPanel18, java.awt.BorderLayout.CENTER);

        jPanel2.add(pSensor1);

        pSensor2.setLayout(new java.awt.BorderLayout());

        jLabel12.setText("Sensor 2");
        pSensor2.add(jLabel12, java.awt.BorderLayout.NORTH);

        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel21.setLayout(new java.awt.GridLayout(1, 0, 8, 0));

        jLabel14.setText("(nicht)betätigt");
        jPanel21.add(jLabel14);

        jLabel13.setText("Pos1");
        jPanel21.add(jLabel13);

        jPanel20.add(jPanel21);

        pSensor2.add(jPanel20, java.awt.BorderLayout.CENTER);

        jPanel2.add(pSensor2);

        jPanel3.add(jPanel2);

        pPosInfo.add(jPanel3, java.awt.BorderLayout.CENTER);

        pCenter.add(pPosInfo, java.awt.BorderLayout.EAST);

        jPanel1.add(pCenter, java.awt.BorderLayout.CENTER);

        pButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 0, 0, 0));
        pButton.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        btSchließen.setText("Schließen");
        btSchließen.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onSchließen(evt);
            }
        });
        jPanel5.add(btSchließen);

        jPanel4.add(jPanel5);

        pButton.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(pButton, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onSchließen(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onSchließen
    {//GEN-HEADEREND:event_onSchließen
        dispose();
    }//GEN-LAST:event_onSchließen

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
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel pButton;
    private javax.swing.JPanel pCenter;
    private javax.swing.JPanel pMotor1;
    private javax.swing.JPanel pMotor1_1;
    private javax.swing.JPanel pMotor2;
    private javax.swing.JPanel pMotor2_2;
    private javax.swing.JPanel pPosInfo;
    private javax.swing.JPanel pSensor1;
    private javax.swing.JPanel pSensor2;
    private javax.swing.JPanel pSteuerung;
    private javax.swing.JPanel pText;
    private javax.swing.JPanel pZustimmung;
    // End of variables declaration//GEN-END:variables
}
