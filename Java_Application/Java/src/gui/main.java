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
public class main extends javax.swing.JFrame
{

    /**
     * Creates new form main
     */
    public main()
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
        java.awt.GridBagConstraints gridBagConstraints;

        south = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        east = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        center1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        center = new javax.swing.JPanel();
        center2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        south1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fuetterung = new javax.swing.JMenu();
        ein_aus = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        fuetterungszeiten_verwalten = new javax.swing.JMenuItem();
        steuerung = new javax.swing.JMenu();
        manuelleSteuerung = new javax.swing.JMenuItem();
        positionsinformationen = new javax.swing.JMenuItem();
        einstellungen = new javax.swing.JMenu();
        update = new javax.swing.JMenuItem();
        geraeteinformationen = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Katzenfütterungsanlage");

        south.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        south.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Maschine:");
        jPanel2.add(jLabel1);

        jLabel4.setText("Ein/Aus");
        jPanel2.add(jLabel4);

        south.add(jPanel2, java.awt.BorderLayout.WEST);

        jLabel2.setText("Uhrzeit");
        jPanel1.add(jLabel2);

        jLabel3.setText("Datum");
        jPanel1.add(jLabel3);

        south.add(jPanel1, java.awt.BorderLayout.EAST);

        getContentPane().add(south, java.awt.BorderLayout.SOUTH);

        east.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        east.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Fütterrungszeiten");
        east.add(jLabel7, java.awt.BorderLayout.NORTH);

        center1.setLayout(new java.awt.GridBagLayout());

        jLabel9.setText("Zeit 1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        center1.add(jLabel9, gridBagConstraints);

        jLabel10.setText("Zeit 3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        center1.add(jLabel10, gridBagConstraints);

        jLabel8.setText("Zeit 2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        center1.add(jLabel8, gridBagConstraints);

        jLabel11.setText("Zeit 4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        center1.add(jLabel11, gridBagConstraints);

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        center1.add(jFormattedTextField1, gridBagConstraints);

        jFormattedTextField2.setEditable(false);
        jFormattedTextField2.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        center1.add(jFormattedTextField2, gridBagConstraints);

        jFormattedTextField3.setEditable(false);
        jFormattedTextField3.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        center1.add(jFormattedTextField3, gridBagConstraints);

        jFormattedTextField4.setEditable(false);
        jFormattedTextField4.setColumns(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        center1.add(jFormattedTextField4, gridBagConstraints);

        east.add(center1, java.awt.BorderLayout.CENTER);

        getContentPane().add(east, java.awt.BorderLayout.LINE_END);

        center.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        center.setLayout(new java.awt.BorderLayout());

        center2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        center2.setLayout(new java.awt.GridLayout(0, 2));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Letzte erfolgte Fütterung:");
        center2.add(jLabel6);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("<Uhrzeit>");
        center2.add(jLabel12);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Nächste Fütterung erfolgt in:");
        center2.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Stunden:Minuten");
        center2.add(jLabel14);

        center.add(center2, java.awt.BorderLayout.CENTER);

        south1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        south1.setLayout(new java.awt.BorderLayout());

        jList1.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Fehler1", "Fehler2", "Warnung1", "Warnung2" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        south1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fehler und Warnungen");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        south1.add(jLabel5, java.awt.BorderLayout.NORTH);

        center.add(south1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(center, java.awt.BorderLayout.CENTER);

        fuetterung.setText("Fütterung");

        ein_aus.setText("Ein-/Ausschalten");
        fuetterung.add(ein_aus);
        fuetterung.add(jSeparator1);

        fuetterungszeiten_verwalten.setText("Fütterungszeiten verwalten");
        fuetterung.add(fuetterungszeiten_verwalten);

        jMenuBar1.add(fuetterung);

        steuerung.setText("Steuerung");

        manuelleSteuerung.setText("manuelle Steuerung");
        steuerung.add(manuelleSteuerung);

        positionsinformationen.setText("Positionsinformationen");
        steuerung.add(positionsinformationen);

        jMenuBar1.add(steuerung);

        einstellungen.setText("Einstellungen");

        update.setText("Update");
        einstellungen.add(update);

        geraeteinformationen.setText("Geräteinformationen");
        einstellungen.add(geraeteinformationen);

        jMenuBar1.add(einstellungen);

        setJMenuBar(jMenuBar1);

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel center;
    private javax.swing.JPanel center1;
    private javax.swing.JPanel center2;
    private javax.swing.JPanel east;
    private javax.swing.JMenuItem ein_aus;
    private javax.swing.JMenu einstellungen;
    private javax.swing.JMenu fuetterung;
    private javax.swing.JMenuItem fuetterungszeiten_verwalten;
    private javax.swing.JMenuItem geraeteinformationen;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem manuelleSteuerung;
    private javax.swing.JMenuItem positionsinformationen;
    private javax.swing.JPanel south;
    private javax.swing.JPanel south1;
    private javax.swing.JMenu steuerung;
    private javax.swing.JMenuItem update;
    // End of variables declaration//GEN-END:variables
}
