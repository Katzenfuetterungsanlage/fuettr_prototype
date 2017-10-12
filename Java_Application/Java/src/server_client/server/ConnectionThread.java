/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_client.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author Florian
 */
public class ConnectionThread implements Runnable 
{
    private final Socket socket;

    public ConnectionThread(Socket socket)
    {
        this.socket = socket;
    }
    
    @Override
    public void run()
    {
        System.out.println("ConnectionThread ist gestartet");
        try
        {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
      
            while (true)
            {
                String request = reader.readLine();

                if (request.equals("Tell me the time"))
                {
                    String timeString = String.format("%1$tH:%1$tM", new Date(System.currentTimeMillis()));

                    writer.append(timeString).append("\n");
                    writer.flush();
                }
                else
                {
                    writer.write("403\n");
                    writer.flush();

                    System.out.println("Error gesendet");
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        finally
        {
            System.out.println("ConnectionThread beendet " + socket);
        }
    }
    
    
}
