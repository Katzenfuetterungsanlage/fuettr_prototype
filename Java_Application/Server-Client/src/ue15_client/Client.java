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

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florian Greistorfer <florian.greistorfer@outlook.com>
 */
public class Client
{

  String address;
  int port;

  public static void main(String[] args) throws Exception
  {
    Client client = new Client();
  }

  public Client() throws InterruptedException
  {
    while (true)
    {
      System.out.print("Ip-Addresse: ");
      Scanner scanner = new Scanner(System.in);
      address = scanner.nextLine();
      System.out.print("Port: ");
      port = scanner.nextInt();

      Socket socket = null;
      try
      {
        socket = new Socket(address, port);
      }
      catch (IOException ex)
      {
        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }
      System.out.println("Verbindung hergestellt: " + socket);
      TimeUnit.SECONDS.sleep(2);

      new Thread(new ConnectionThread(socket)).start();

    }
  }

}
