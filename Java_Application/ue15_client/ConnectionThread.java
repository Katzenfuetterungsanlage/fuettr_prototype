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
package ue15_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian Greistorfer <florian.greistorfer@outlook.com>
 */
public class ConnectionThread implements Runnable
{
  String address;
  int port;
  private final Socket socket;
  
  public ConnectionThread (Socket socket)
  {
   this.socket = socket;
  }

  @Override
  public void run()
  {
    try
    {
      

      BufferedWriter w = new BufferedWriter(
              new OutputStreamWriter(socket.getOutputStream()));

      w.write("Hallo, i bims, 1 Client.\n");
      w.flush();
      TimeUnit.SECONDS.sleep(2);

      BufferedReader r = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));

      System.out.println("" + r.readLine());
    }
    catch (IOException | InterruptedException ex)
    {
      Logger.getLogger(ConnectionThread.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
