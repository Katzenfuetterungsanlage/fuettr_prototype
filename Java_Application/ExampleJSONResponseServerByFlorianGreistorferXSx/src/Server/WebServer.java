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
package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Florian Greistorfer <florian.greistorfer@outlook.com>
 */
public class WebServer
{

  private final int port;

  public WebServer(int port)
  {
    this.port = port;
  }

  public void start() throws IOException, InterruptedException
  {
    ServerSocket serverSocket = new ServerSocket(port);
    while (true)
    {
      Socket socket = serverSocket.accept();
      new Thread(new ConnectionThread(socket)).start();
    }
  }

  public static void main(String[] args) throws IOException, InterruptedException
  {
    new WebServer(666).start();
  }
}
