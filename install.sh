#!/bin/bash
# install script for Fuettr Server and Java-Application

THISUSER=/home/$USER

echo -e "\e[44msetting git credentials...\e[0m"
sudo git config --global user.name "fuettr"
sudo git config --global user.email "fuettr@gmail.com"

echo -e "\e[44mdownloading...\e[0m"
cd $THISUSER && mkdir git && cd git && git clone https://github.com/Katzenfuetterungsanlage/fuettr_prototype.git

echo -e "\e[44mcopying rc.local...\e[0m"
sudo rsync -aP $THISUSER/git/fuettr_prototype/rc.local /etc/rc.local

echo -e "\e[44minstalling node dependencies...\e[0m"
sudo npm install -g @angular/cli gulp
cd $THISUSER/git/Web_Application/Webserver/ng2 && sudo npm install
cd $THISUSER/git/Web_Application/Webserver/server && sudo npm install

echo -e "\e[44mbuilding server...\e[0m"
cd $THISUSER/git/Web_Application/Webserver/ng2 && ng build
cd $THISUSER/git/Web_Application/Webserver/server && gulp cleanAndBuild

echo -e "\e[44mstarting server...\e[0m"
cd $THISUSER/git/Web_Application/Webserver/server/dist && sudo node main.js

echo -e "\e[42mdone\e[0m"