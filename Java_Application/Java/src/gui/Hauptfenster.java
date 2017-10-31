/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingWorker;


/**
 *
 * @author Florian
 */
public class Hauptfenster extends javax.swing.JFrame
{
    
    boolean zustand = false;
    
    /**
     * Creates new form Hauptfenster
     */
    public Hauptfenster()
    {
        initComponents();
        UhrzeitWorker uworker = new UhrzeitWorker();
        uworker.execute();
        DatumWorker dworker = new DatumWorker();
        dworker.execute();
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

        jPanel15 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pEast = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        pCenter = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        CenterSouth = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        CenterNorth = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pSouth = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbZustand = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbUhrzeit = new javax.swing.JLabel();
        lbDatum = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        raspberry = new javax.swing.JMenu();
        neustarten = new javax.swing.JMenuItem();
        herunterfahren = new javax.swing.JMenuItem();
        fuetterung = new javax.swing.JMenu();
        ein_aus = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        fuetterungszeiten_verwalten = new javax.swing.JMenuItem();
        steuerung = new javax.swing.JMenu();
        manuelleSteuerung = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        positionsinformationen = new javax.swing.JMenuItem();
        einstellungen = new javax.swing.JMenu();
        update = new javax.swing.JMenuItem();
        benutzer_anlegen = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        geraeteinformation = new javax.swing.JMenuItem();

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Letzte erfolgte Fütterung: ");
        jPanel15.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("<Uhrzeit>");
        jPanel15.add(jLabel11);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Nächste Fütterung erfolgt in: ");
        jPanel16.add(jLabel12);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("<Stunden:Minuten>");
        jPanel16.add(jLabel13);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Katzenfütterungsanlage");

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pEast.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 4, 0, 0));
        pEast.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Fütterungszeiten");
        jPanel8.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Zeit 1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Zeit 2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Zeit 3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Zeit 4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jLabel9, gridBagConstraints);

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setColumns(10);
        jFormattedTextField1.setText("Uhrzeit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jFormattedTextField1, gridBagConstraints);

        jFormattedTextField2.setEditable(false);
        jFormattedTextField2.setColumns(10);
        jFormattedTextField2.setText("Uhrzeit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jFormattedTextField2, gridBagConstraints);

        jFormattedTextField3.setEditable(false);
        jFormattedTextField3.setColumns(10);
        jFormattedTextField3.setText("Uhrzeit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jFormattedTextField3, gridBagConstraints);

        jFormattedTextField4.setEditable(false);
        jFormattedTextField4.setColumns(10);
        jFormattedTextField4.setText("Uhrzeit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jFormattedTextField4, gridBagConstraints);

        jPanel8.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel7, java.awt.BorderLayout.CENTER);

        pEast.add(jPanel6, java.awt.BorderLayout.LINE_END);

        jPanel1.add(pEast, java.awt.BorderLayout.EAST);

        pCenter.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.BorderLayout());

        CenterSouth.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 0, 0));
        CenterSouth.setLayout(new java.awt.BorderLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Fehler und Warnungen");
        jPanel14.add(jLabel14, java.awt.BorderLayout.NORTH);

        jList1.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Fehler 1", "Fehler 2", "Warnung 1", "Warnung 2" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel14.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel14, java.awt.BorderLayout.CENTER);

        CenterSouth.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel10.add(CenterSouth, java.awt.BorderLayout.SOUTH);

        CenterNorth.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 4, 1));
        CenterNorth.setLayout(new java.awt.BorderLayout());

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 2, 0));
        jPanel13.setLayout(new java.awt.GridLayout(0, 1, 0, 8));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Letzte erfolgte Fütterung: ");
        jPanel17.add(jLabel15);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("<Uhrzeit>");
        jPanel17.add(jLabel16);

        jPanel13.add(jPanel17);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Nächste Fütterung erfolgt in: ");
        jPanel18.add(jLabel17);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("<Stunden:Minuten>");
        jPanel18.add(jLabel18);

        jPanel13.add(jPanel18);

        jPanel12.add(jPanel13, java.awt.BorderLayout.CENTER);

        CenterNorth.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel10.add(CenterNorth, java.awt.BorderLayout.CENTER);

        pCenter.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel1.add(pCenter, java.awt.BorderLayout.CENTER);

        pSouth.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 0, 0, 0));
        pSouth.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Maschine: ");
        jPanel5.add(jLabel1);

        lbZustand.setText("Ein/Aus");
        jPanel5.add(lbZustand);

        jPanel3.add(jPanel5, java.awt.BorderLayout.WEST);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        lbUhrzeit.setText("Uhrzeit");
        jPanel4.add(lbUhrzeit);

        lbDatum.setText("Datum");
        jPanel4.add(lbDatum);

        jPanel3.add(jPanel4, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pSouth.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.add(pSouth, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        raspberry.setText("Raspberry");

        neustarten.setIcon(new javax.swing.ImageIcon("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\icons\\restartIcon16x16.png")); // NOI18N
        neustarten.setText("Neustarten");
        raspberry.add(neustarten);

        herunterfahren.setIcon(new javax.swing.ImageIcon("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\icons\\powerIcon16x16.png")); // NOI18N
        herunterfahren.setText("Herunterfahren");
        raspberry.add(herunterfahren);

        jMenuBar1.add(raspberry);

        fuetterung.setText("Fütterung");
        fuetterung.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onFütterungszeitenVerwalten(evt);
            }
        });

        ein_aus.setIcon(new javax.swing.ImageIcon("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\icons\\switchIcon16x16.png")); // NOI18N
        ein_aus.setText("Ein-/Ausschalten");
        ein_aus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onEinAusSchalten(evt);
            }
        });
        fuetterung.add(ein_aus);
        fuetterung.add(jSeparator1);

        fuetterungszeiten_verwalten.setIcon(new javax.swing.ImageIcon("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\icons\\timeIcon16x16.png")); // NOI18N
        fuetterungszeiten_verwalten.setText("Fütterungszeiten verwalten");
        fuetterungszeiten_verwalten.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onFuetterungszeitenVerwalten(evt);
            }
        });
        fuetterung.add(fuetterungszeiten_verwalten);

        jMenuBar1.add(fuetterung);

        steuerung.setText("Steuerung");

        manuelleSteuerung.setIcon(new javax.swing.ImageIcon("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\icons\\remotecontrolIcon16x16.png")); // NOI18N
        manuelleSteuerung.setText("manuelle Steuerung");
        manuelleSteuerung.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onManuelleSteuerung(evt);
            }
        });
        steuerung.add(manuelleSteuerung);
        steuerung.add(jSeparator3);

        positionsinformationen.setIcon(new javax.swing.ImageIcon("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\icons\\infoIcon16x16.png")); // NOI18N
        positionsinformationen.setText("Positionsinformationen");
        positionsinformationen.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onPositionsinformation(evt);
            }
        });
        steuerung.add(positionsinformationen);

        jMenuBar1.add(steuerung);

        einstellungen.setText("Einstellungen");

        update.setIcon(new javax.swing.ImageIcon("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\icons\\downloadIcon16x16.png")); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onUpdate(evt);
            }
        });
        einstellungen.add(update);

        benutzer_anlegen.setIcon(new javax.swing.ImageIcon("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\icons\\userIcon16x16.png")); // NOI18N
        benutzer_anlegen.setText("Benutzer anlegen");
        benutzer_anlegen.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onBenutzerAnlegen(evt);
            }
        });
        einstellungen.add(benutzer_anlegen);
        einstellungen.add(jSeparator2);

        geraeteinformation.setIcon(new javax.swing.ImageIcon("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\icons\\info_aboutIcon16x16.png")); // NOI18N
        geraeteinformation.setText("Geräteinformation");
        geraeteinformation.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onGeraeteinformation(evt);
            }
        });
        einstellungen.add(geraeteinformation);

        jMenuBar1.add(einstellungen);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onEinAusSchalten(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onEinAusSchalten
    {//GEN-HEADEREND:event_onEinAusSchalten
        if (zustand != true)
        {
            zustand = true;
            lbZustand.setText("Ein");
        }                    
        else
        {
            zustand = false;
            lbZustand.setText("Aus");
        }                 
    }//GEN-LAST:event_onEinAusSchalten

    private void onFütterungszeitenVerwalten(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onFütterungszeitenVerwalten
    {//GEN-HEADEREND:event_onFütterungszeitenVerwalten
        //Delete
    }//GEN-LAST:event_onFütterungszeitenVerwalten

    private void onManuelleSteuerung(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onManuelleSteuerung
    {//GEN-HEADEREND:event_onManuelleSteuerung
        final ManuelleSteuerung strDlg = new ManuelleSteuerung(this, true); 
        strDlg.setVisible(true);
    }//GEN-LAST:event_onManuelleSteuerung

    private void onPositionsinformation(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onPositionsinformation
    {//GEN-HEADEREND:event_onPositionsinformation
        final Positionsinformation posDlg = new Positionsinformation(this, true); 
        posDlg.setVisible(true);
    }//GEN-LAST:event_onPositionsinformation

    private void onUpdate(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onUpdate
    {//GEN-HEADEREND:event_onUpdate
        final Update infoDlg = new Update(this, true); 
        infoDlg.setVisible(true);
    }//GEN-LAST:event_onUpdate

    private void onFuetterungszeitenVerwalten(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onFuetterungszeitenVerwalten
    {//GEN-HEADEREND:event_onFuetterungszeitenVerwalten
        //Objektobjekt erzeugen ==> Dialog ist MODAL! (modal ... blockieren des Elternfensters) 
        final ZeitenManagement zeitenDlg = new ZeitenManagement(this, true); // true = modal (blockiert das Hauptfenster) , false = nicht modal 
        zeitenDlg.setVisible(true); //Dialog sichtbar setzen
        //An dieser Stelle "blockiert" das Programm, solange der Dialog geöffnet ist!        
    }//GEN-LAST:event_onFuetterungszeitenVerwalten

    private void onGeraeteinformation(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onGeraeteinformation
    {//GEN-HEADEREND:event_onGeraeteinformation
        final GeraeteInfo infoDlg = new GeraeteInfo(this, true); 
        infoDlg.setVisible(true);
    }//GEN-LAST:event_onGeraeteinformation

    private void onBenutzerAnlegen(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onBenutzerAnlegen
    {//GEN-HEADEREND:event_onBenutzerAnlegen
        final BenutzerAnlegen infoDlg = new BenutzerAnlegen(this, true); 
        infoDlg.setVisible(true);
    }//GEN-LAST:event_onBenutzerAnlegen

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
            java.util.logging.Logger.getLogger(Hauptfenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Hauptfenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Hauptfenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Hauptfenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Hauptfenster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CenterNorth;
    private javax.swing.JPanel CenterSouth;
    private javax.swing.JMenuItem benutzer_anlegen;
    private javax.swing.JMenuItem ein_aus;
    private javax.swing.JMenu einstellungen;
    private javax.swing.JMenu fuetterung;
    private javax.swing.JMenuItem fuetterungszeiten_verwalten;
    private javax.swing.JMenuItem geraeteinformation;
    private javax.swing.JMenuItem herunterfahren;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuBar jMenuBar1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lbDatum;
    private javax.swing.JLabel lbUhrzeit;
    private javax.swing.JLabel lbZustand;
    private javax.swing.JMenuItem manuelleSteuerung;
    private javax.swing.JMenuItem neustarten;
    private javax.swing.JPanel pCenter;
    private javax.swing.JPanel pEast;
    private javax.swing.JPanel pSouth;
    private javax.swing.JMenuItem positionsinformationen;
    private javax.swing.JMenu raspberry;
    private javax.swing.JMenu steuerung;
    private javax.swing.JMenuItem update;
    // End of variables declaration//GEN-END:variables

private class UhrzeitWorker extends SwingWorker<Object,String>
{
    String uhrzeit; 

    @Override
    protected Object doInBackground() throws Exception
    {
        while (true)
        {
            uhrzeit = String.format("%1$tH:%1$tM", new Date(System.currentTimeMillis()));
                        
            publish(uhrzeit); // gibt Text an process weiter

            TimeUnit.MILLISECONDS.sleep(500);
        } 
    }

        @Override
        protected void process(List<String> chunks)
        {
            lbUhrzeit.setText(uhrzeit);
        }    
    }

private class DatumWorker extends SwingWorker<Object,String>
{
    String datum; 

    @Override
    protected Object doInBackground() throws Exception
    {
        while (true)
        {
            datum = String.format("%1$td.%1$tm.%1$tY", new Date(System.currentTimeMillis()));
            
            publish(datum); // gibt Text an process weiter
            
            TimeUnit.MILLISECONDS.sleep(500);
        } 
    }

        @Override
        protected void process(List<String> chunks)
        {
            lbDatum.setText(datum);
        }    
    }



}
