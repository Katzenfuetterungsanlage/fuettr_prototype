#!/bin/bash
# install script for Fuettr Server and Java-Application

THISUSER=/home/$USER

echo "\e[46msetting git credentials...\e[0m"
echo "\e[95m"
sudo git config --global user.name "fuettr"
sudo git config --global user.email "fuettr@gmail.com"
echo "\e[0m"

echo "\e[46mdownloading...\e[0m"
echo "\e[95m"
cd $THISUSER && mkdir git && cd git && git clone https://github.com/Katzenfuetterungsanlage/fuettr_prototype.git
echo "\e[0m"

echo "\e[46mcopying rc.local...\e[0m"
echo "\e[95m"
sudo rsync -aP $THISUSER/git/fuettr_prototype/rc.local /etc/rc.local
echo "\e[0m"

echo "\e[46minstalling node dependencies...\e[0m"
echo "\e[95m"
sudo npm install -g @angular/cli gulp
cd $THISUSER/git/Web_Application/Webserver/ng2 && sudo npm install
cd $THISUSER/git/Web_Application/Webserver/server && sudo npm install
echo "\e[0m"

echo "\e[46mbuilding server...\e[0m"
echo "\e[95m"
cd $THISUSER/git/Web_Application/Webserver/ng2 && ng build
cd $THISUSER/git/Web_Application/Webserver/server && gulp cleanAndBuild
echo "\e[0m"

echo "\e[46mstarting server...\e[0m"
echo "\e[95m"
cd $THISUSER/git/Web_Application/Webserver/server/dist && sudo node main.js
echo "\e[0m"

echo "\e[42mdone\e[0m"