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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

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

      LinkedList<String> inputLines = new LinkedList<>();
      System.out.println("Wait for Request:");
      while (true)
      {
        String line = r.readLine();
        if (line == null)
        {
          return;
        }
        if (line.length() == 0)
        {
          handleRequest(inputLines);
          System.out.println("Wait for Request:");
        }
        else
        {
          inputLines.add(line);
        }
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    finally
    {
      System.out.println("ConnectionThread beendet " + socket);
    }

  }

  private void handleRequest(List<String> header) throws IOException
  {
    Request req = new Request(header);

    if (!req.getMethod().equals("GET"))
    {
      sendResponse(404);
    }

    switch (req.getUrl())
    {
      case "/warnings":
          sendResponse(200, getDefaultBody());
          break;
      default:
        sendResponse(404);
    }

  }

  private void sendResponse(int statusCode) throws IOException
  {
    sendResponse(statusCode, null);
  }

  private void sendResponse(int statusCode, String body) throws IOException
  {
    if (body == null)
    {
      body = "";
    }
    BufferedWriter w = new BufferedWriter(
            new OutputStreamWriter(socket.getOutputStream()));

    w.append("HTTP/1.1 ").append("" + statusCode).append("\n");
    w.append("Date: ").append(String.format("%tc", new GregorianCalendar())).append("\n");
    w.append("Server: ").append("Bester Server Weltweit Europas in Oesterreich").append("\n");
    w.append("Connection: Keep-Alive\n");
    w.append("Content-Length: ").append(String.valueOf(body.length())).append("\n");
    w.append("Connection-Type: text/html\n");
    w.append("\n");
    w.append(body);
    w.flush();

  }

  private String getDefaultBody()
  {
    String string = "{" + '"' + "warnings" + '"' + ": [{" + '"' + "warning" + '"' + ": " + '"' + "warning 1" + '"' + "}, {" + '"' + "warning" + '"' + ": " + '"' + "warning 2" + '"' + "}, {" + '"' + "warning" + '"' + ": " + '"' + "warning 3" + '"' + "}]}";
    return string;
  }
}
