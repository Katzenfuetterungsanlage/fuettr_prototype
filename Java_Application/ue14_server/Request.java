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
package ue14_server;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Florian Greistorfer <florian.greistorfer@outlook.com>
 */
public class Request
{

  private final String method;
  private final String url;
  private final String protocoll;
  private final HashMap<String, String> attributes;

  public Request(List<String> body)
  {
    attributes = new HashMap<>();
    String[] f = body.get(0).split("\\s+");
    if (f.length != 3)
    {
      throw new IllegalArgumentException("Invalid request");
    }
    method = f[0];
    url = f[1];
    protocoll = f[2];
    for (int i = 1; i < body.size(); i++)
    {
      String line = body.get(i);
      int j = line.indexOf(':');
      if (j > 0)
      {
        attributes.put(line.substring(0, j), line.substring(j + 1).trim());
      }
      else
      {
        System.out.println("Error: wrong request " + line);
      }
    }
  }

  public String getMethod()
  {
    return method;
  }

  public String getUrl()
  {
    return url;
  }

  public String getProtocoll()
  {
    return protocoll;
  }

  public HashMap<String, String> getAttributes()
  {
    return attributes;
  }

}
