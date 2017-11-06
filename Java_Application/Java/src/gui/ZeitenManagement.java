/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import methods.StreamReader;
import methods.StreamWriter;

/**
 *
 * @author Florian
 */
public class ZeitenManagement extends javax.swing.JDialog
{
    boolean gespeichert = false;
    boolean zeitenVeraendert = false; 
    
    //Datenaustausch
    public boolean zeitenVeraendert()
    {
        return zeitenVeraendert;
    }
    
    private void spinnerFuellen ()
    {
        StreamReader streamReader = new StreamReader(); 
        String string = streamReader.einlesen("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\data\\testZeit.txt");
        
        //test
        System.out.format("%s %n",string);
        
        String[] token = string.split(";"); 
        String zeit1 = token[0];
        String zeit2 = token[1];
        String zeit3 = token[2];
        String zeit4 = token[3];    
        
        //test
        System.out.format("%s %n",zeit1);
        System.out.format("%s %n",zeit2);
        System.out.format("%s %n",zeit3);
        System.out.format("%s %n",zeit4);
        
        Date date1 = null,date2 = null,date3 = null,date4 = null;
        
        DateFormat format = new SimpleDateFormat("HH:mm", Locale.GERMANY);
        try
        {
            date1 = format.parse(zeit1);
            date2 = format.parse(zeit2);
            date3 = format.parse(zeit3);
            date4 = format.parse(zeit4);
        } catch (ParseException ex)
        {
            Logger.getLogger(ZeitenManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        spZeit1.setValue(date1);
        spZeit2.setValue(date2);
        spZeit3.setValue(date3);
        spZeit4.setValue(date4);
    }
    /**
     * Creates new form ZeitenManagemeint
     */
    public ZeitenManagement(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);

        initComponents();
        
        JSpinner.DateEditor at1 = new JSpinner.DateEditor(spZeit1, "HH:mm");
        spZeit1.setEditor(at1);
        
        JSpinner.DateEditor at2 = new JSpinner.DateEditor(spZeit2, "HH:mm");
        spZeit2.setEditor(at2);
        
        JSpinner.DateEditor at3 = new JSpinner.DateEditor(spZeit3, "HH:mm");
        spZeit3.setEditor(at3);
        
        JSpinner.DateEditor at4 = new JSpinner.DateEditor(spZeit4, "HH:mm");
        spZeit4.setEditor(at4);
        
        spinnerFuellen();
         
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
        pButton = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btSpeichern = new javax.swing.JButton();
        btSchließen = new javax.swing.JButton();
        pZeiten = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        Date date1 = new Date();
        SpinnerDateModel sm1 =
        new SpinnerDateModel(date1, null, null, Calendar.HOUR_OF_DAY);
        spZeit1 = new javax.swing.JSpinner(sm1);
        Date date2 = new Date();
        SpinnerDateModel sm2 =
        new SpinnerDateModel(date2, null, null, Calendar.HOUR_OF_DAY);
        spZeit2 = new javax.swing.JSpinner(sm2);
        Date date3 = new Date();
        SpinnerDateModel sm3 =
        new SpinnerDateModel(date3, null, null, Calendar.HOUR_OF_DAY);
        spZeit3 = new javax.swing.JSpinner(sm3);
        Date date4 = new Date();
        SpinnerDateModel sm4 =
        new SpinnerDateModel(date4, null, null, Calendar.HOUR_OF_DAY);
        spZeit4 = new javax.swing.JSpinner(sm4);
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Zeitenmanagement");

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 0, 0, 0));
        pButton.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        btSpeichern.setText("Speichern");
        btSpeichern.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                onSpeichern(evt);
            }
        });
        jPanel5.add(btSpeichern);

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

        pZeiten.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pZeiten.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 16, 32));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel10.setText("Zeit 2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(jLabel10, gridBagConstraints);

        jLabel2.setText("Zeiten");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(jLabel2, gridBagConstraints);

        jLabel8.setText("Zeit 1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(jLabel8, gridBagConstraints);

        jLabel11.setText("Zeit 3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(jLabel11, gridBagConstraints);

        jLabel12.setText("Zeit 4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(jLabel12, gridBagConstraints);

        jLabel13.setText("Aktiv");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(jLabel13, gridBagConstraints);

        jLabel14.setText("Uhrzeit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 2);
        jPanel6.add(jLabel14, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(jRadioButton1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(jRadioButton2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(jRadioButton3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(jRadioButton4, gridBagConstraints);

        spZeit1.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                spZeit1StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(spZeit1, gridBagConstraints);

        spZeit2.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                spZeit2StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(spZeit2, gridBagConstraints);

        spZeit3.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                spZeit3StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(spZeit3, gridBagConstraints);

        spZeit4.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                spZeit4StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 4);
        jPanel6.add(spZeit4, gridBagConstraints);

        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 1, 1, 1));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("Es wird empholen die vier Fütterungszeiten über den ganzen Tag zu verteilen.");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        jPanel7.add(jLabel4, gridBagConstraints);

        jLabel1.setText("Weiters ist zu beachten, dass eine Fütterung nur gestart wird, wenn der Punkt in der Spalte aktiv gesetzt ist.");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        jPanel7.add(jLabel1, gridBagConstraints);

        jPanel2.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jPanel3.add(jPanel2);

        pZeiten.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(pZeiten, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onSchließen(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onSchließen
    {//GEN-HEADEREND:event_onSchließen
       if (gespeichert == false)
       {
           if (JOptionPane.showConfirmDialog(this, "Fenster wirklich schließen? Nicht gespeicherte Inhalte gehen verloren!",
                 "Hinweis", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
           {
               dispose();
           }
       }
       else
       {           
           zeitenVeraendert = true; 
           
           dispose();
       }
    }//GEN-LAST:event_onSchließen

    private void onSpeichern(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onSpeichern
    {//GEN-HEADEREND:event_onSpeichern
        DateFormat df = new SimpleDateFormat("HH:mm");

        Date date1 = (Date) spZeit1.getValue();   
        String zeit1 = df.format(date1);
        
        Date date2 = (Date) spZeit2.getValue();   
        String zeit2 = df.format(date2);
        
        Date date3 = (Date) spZeit3.getValue();   
        String zeit3 = df.format(date3);
        
        Date date4 = (Date) spZeit4.getValue();   
        String zeit4 = df.format(date4);
        
        System.out.println("ZeitenManagement");
        System.out.println(zeit1);
        System.out.println(zeit2);
        System.out.println(zeit3);
        System.out.println(zeit4);
        
        String string = zeit1 + ";" + zeit2 + ";" + zeit3 + ";" + zeit4 + ";";
        
        if (date1.equals(date2) || date1.equals(date3) || date1.equals(date4) || date2.equals(date3) || date2.equals(date4) || date3.equals(date4))
        {
            JOptionPane.showMessageDialog(this, "Es müssen 4 verschiedene Uhrzeiten gewählt werden!", "Fehler",ERROR_MESSAGE);
        }
        else
        {
            if (date1.after(date2) || date1.after(date3) || date1.after(date4) || date2.after(date3) || date2.after(date4) || date3.after(date4))
            {
                JOptionPane.showMessageDialog(this, "Die Uhrzeiten müssen in aufsteigender Reihenfolge angeordnet werden!", "Fehler",ERROR_MESSAGE);
            }
            else 
            {
                StreamWriter streamWriter = new StreamWriter(); 
                streamWriter.schreiben("D:\\Schule\\Diplomarbeit\\Git\\fuettr_prototype\\Java_Application\\Java\\src\\data\\testZeit.txt",string);

                System.out.println("Zeiten gespeichert!"); 
        
                gespeichert = true;
            }
        }           
    }//GEN-LAST:event_onSpeichern

    private void spZeit1StateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_spZeit1StateChanged
    {//GEN-HEADEREND:event_spZeit1StateChanged
        gespeichert = false; 
    }//GEN-LAST:event_spZeit1StateChanged

    private void spZeit2StateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_spZeit2StateChanged
    {//GEN-HEADEREND:event_spZeit2StateChanged
        gespeichert = false; 
    }//GEN-LAST:event_spZeit2StateChanged

    private void spZeit3StateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_spZeit3StateChanged
    {//GEN-HEADEREND:event_spZeit3StateChanged
        gespeichert = false; 
    }//GEN-LAST:event_spZeit3StateChanged

    private void spZeit4StateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_spZeit4StateChanged
    {//GEN-HEADEREND:event_spZeit4StateChanged
        gespeichert = false; 
    }//GEN-LAST:event_spZeit4StateChanged

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
            java.util.logging.Logger.getLogger(ZeitenManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ZeitenManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ZeitenManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ZeitenManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ZeitenManagement dialog = new ZeitenManagement(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btSpeichern;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JPanel pButton;
    private javax.swing.JPanel pZeiten;
    private javax.swing.JSpinner spZeit1;
    private javax.swing.JSpinner spZeit2;
    private javax.swing.JSpinner spZeit3;
    private javax.swing.JSpinner spZeit4;
    // End of variables declaration//GEN-END:variables

}
