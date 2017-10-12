/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_client.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Florian
 */
public class Server
{
    private final int port;

    public Server(int port)
    {
        this.port = port;
    }
    
    public void start() 
            throws IOException, InterruptedException
    {
        ServerSocket serverSocket = new ServerSocket(port);
        
        while (true)
        {
            Socket socket = serverSocket.accept();
            System.out.println("Verbindung hergstellt: " + socket);
            new Thread(new ConnectionThread(socket)).start();
        }
    }
    
    public static void main(String[] args) 
            throws IOException, InterruptedException
    {
        new Server(8080).start(); 
    }
}
