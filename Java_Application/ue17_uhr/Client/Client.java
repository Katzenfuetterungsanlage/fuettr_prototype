/*
 * Copyright (C) 2017 Florian Greistorfer <florian.greistorfer@outlook.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ue17_uhr.Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author Florian Greistorfer <florian.greistorfer@outlook.com>
 */
public class Client extends javax.swing.JFrame
{

  /**
   * Creates new form Client
   */
  public Client()
  {
    initComponents();
    ConnectionWorker worker = new ConnectionWorker();
    worker.execute();
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
    Zeitanzeige = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(255, 204, 204));
    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel1.setLayout(new java.awt.GridLayout());

    Zeitanzeige.setBackground(new java.awt.Color(153, 153, 0));
    Zeitanzeige.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
    Zeitanzeige.setForeground(new java.awt.Color(102, 102, 255));
    Zeitanzeige.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    Zeitanzeige.setText("00:00:00.000");
    jPanel1.add(Zeitanzeige);

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
    }
    catch (ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() ->
    {
      new Client().setVisible(true);

    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel Zeitanzeige;
  private javax.swing.JPanel jPanel1;
  // End of variables declaration//GEN-END:variables

  private class ConnectionWorker extends SwingWorker<Object, String>
  {

    String text;

    @Override
    protected Object doInBackground() throws Exception
    {
      String address = "127.0.0.1";
      int port = 666;
      try
      {
        Socket socket = new Socket(address, port);
        System.out.println("Verbindung hergestellt: " + socket);

        BufferedReader r = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        BufferedWriter w = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));

        while (true)
        {
          w.write("GET\n");
          w.flush();

          text = r.readLine();
          if (text.equals("403"))
          {
            text = "ERROR";
          }
          publish(text);
          TimeUnit.MILLISECONDS.sleep(250);
        }
      }
      catch (IOException ex)
      {
        Logger.getLogger(ClientConnect.class.getName()).log(Level.SEVERE, null, ex);
      }

      return null;
    }

    @Override
    protected void process(List<String> chunks)
    {
      Zeitanzeige.setText(text);
    }

  }
}
