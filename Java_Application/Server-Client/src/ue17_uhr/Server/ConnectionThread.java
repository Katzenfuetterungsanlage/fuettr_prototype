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
package ue17_uhr.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian Greistorfer <florian.greistorfer@outlook.com>
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
    System.out.println("ConnectionThread gestartet");
    try
    {
      // o -> timeout infinity, readLine will block
      socket.setSoTimeout(0);

      BufferedReader r = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));

      BufferedWriter w = new BufferedWriter(
              new OutputStreamWriter(socket.getOutputStream()));
      while (true)
      {
        String request = r.readLine();

        if (request.equals("GET"))
        {
          String timeString = String.format("%1$tH:%1$tM:%1$tS.%1$tL", new Date(System.currentTimeMillis()));

          w.append(timeString).append("\n");
          w.flush();
        }
        else
        {
          w.write("403\n");
          w.flush();

          System.out.println("Error gesendet");
        }
      }
    }
    catch (Exception ex)
    {
      Logger.getLogger(ConnectionThread.class.getName()).log(Level.SEVERE, null, ex);
    }
    finally
    {
      System.out.println("ConnectionThread beendet " + socket);
    }
  }

}
