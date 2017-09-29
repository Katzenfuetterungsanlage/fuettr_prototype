import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
  <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
      <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
          <a class="navbar-brand" href="main.html"><img alt="Brand" src="favicon.ico" width="26"></a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav">
              <li><a href="main.html">Home</a></li>
              <li><a href="feed.html">Fütterung</a></li>
              <li><a href="control.html">Steuerung</a></li>
              <li class="dropdown">
                  <a class="dropdown-toggle" data-toggle="dropdown" href="#">Einstellungen
                  <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                      <li class="active"><a href="info.html">Geräteinfo</a></li>
                      <li><a href="update.html">Update</a></li>
                  </ul>
              </li>
          </ul>
      </div>
  </div>
</nav>
<div class="page-header container-fluid">
<h1>Geräteinformation</h1>
</div>
<div class="jumbotron container-fluid">
  <div class="col-xs-4">
      <table class="table table-hover">
          <tbody>
              <tr>
                  <td class="text-right">Seriennummer:</td>
                  <td>{{serialnumber}}</td>
              </tr>
              <tr>
                  <td class="text-right">Interner Rechner:</td>
                  <td>{{processor}}</td>
              </tr>
              <tr>
                  <td class="text-right">WLAN Status:</td>
                  <td>{{wlanstate}}</td>
              </tr>
              <tr>
                  <td class="text-right">IP Adresse:</td>
                  <td>{{ipadress}}</td>
              </tr>
              <tr>
                  <td class="text-right">Softwareversion:</td>
                  <td>{{version}}</td>
              </tr>
          </tbody>
      </table>
  </div>
  <div class="col-xs-8">

  </div>
</div>
  `
})
export class AppComponent {
  title = 'app';
  serialnumber = 'RP2B-000000';
  processor = 'Raspberry Pi 2 Model B+';
  wlanstate = 'not connected';
  ipadress = '10.0.0.7';
  version = 'alpha 0.1.0';
}
