/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author Florian
 */
public class UpdateWorker extends SwingWorker
{   
    String adress = "https://raw.githubusercontent.com/Katzenfuetterungsanlage/fuettr_prototype/master/version.json";
    int port = 80; 
    
    @Override
    protected Object doInBackground() 
            throws Exception
    {
        Socket socket = null; 
        
        try
        {
            socket = new Socket(adress, port);
            
            BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
            
            System.out.println(bReader.readLine());
        }
        catch (Exception ex)
        {
            Logger.getLogger(UpdateWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }

    @Override
    protected void done()
    {
        
    }
    
    
}
