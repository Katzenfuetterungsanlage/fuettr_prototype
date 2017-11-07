/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import jdk.nashorn.internal.parser.JSONParser;
import methods.StreamReader;

/**
 *
 * @author Florian
 */
public class GeraeteInfo extends javax.swing.JDialog
{

    /**
     * Creates new form GeraeteInfo
     */
    public GeraeteInfo(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
               
        initComponents();
         
        StreamReader streamReader = new StreamReader(); 
        String internerRechner = streamReader.einlesen("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\internerRechner.txt",true);
        
        lbInternerRechner.setText(internerRechner);
        
        String seriennummer = streamReader.einlesen("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\seriennummer.txt",true);
        
        lbSeriennummer.setText(seriennummer);
        
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
        pButton = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btSchließen = new javax.swing.JButton();
        pInfo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbSeriennummer = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbInternerRechner = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbWlanStatus = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbIpAdresse = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbVersionsnummer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Geräteinformation");

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel1.setLayout(new java.awt.BorderLayout());

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

        pInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pInfo.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 16, 32));

        jPanel2.setLayout(new java.awt.GridLayout(0, 2));

        jLabel1.setText("Seriennummer:");
        jPanel2.add(jLabel1);

        lbSeriennummer.setText("<seriennummer>");
        jPanel2.add(lbSeriennummer);

        jLabel3.setText("interner Rechner: ");
        jPanel2.add(jLabel3);

        lbInternerRechner.setText("<raspberry_x>");
        jPanel2.add(lbInternerRechner);

        jLabel5.setText("WLAN-Status: ");
        jPanel2.add(jLabel5);

        lbWlanStatus.setText("<verbunden>");
        jPanel2.add(lbWlanStatus);

        jLabel7.setText("IP-Adresse: ");
        jPanel2.add(jLabel7);

        lbIpAdresse.setText("<10.0.0.10>");
        jPanel2.add(lbIpAdresse);

        jLabel9.setText("Version: ");
        jPanel2.add(jLabel9);

        lbVersionsnummer.setText("<versionsnummer>");
        jPanel2.add(lbVersionsnummer);

        jPanel3.add(jPanel2);

        pInfo.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(pInfo, java.awt.BorderLayout.CENTER);

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
            java.util.logging.Logger.getLogger(GeraeteInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GeraeteInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GeraeteInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GeraeteInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                GeraeteInfo dialog = new GeraeteInfo(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbInternerRechner;
    private javax.swing.JLabel lbIpAdresse;
    private javax.swing.JLabel lbSeriennummer;
    private javax.swing.JLabel lbVersionsnummer;
    private javax.swing.JLabel lbWlanStatus;
    private javax.swing.JPanel pButton;
    private javax.swing.JPanel pInfo;
    // End of variables declaration//GEN-END:variables

//private void version()
//{
//    StreamReader streamReader = new StreamReader(); 
//    String string_json = streamReader.einlesen("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\data\\version.json");
//    
//    System.out.format("%s",string_json);
//}
//    
}
