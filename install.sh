#!/bin/bash
# install script for Fuettr Server and Java-Application

THISUSER=/home/$USER

echo -e "setting git credentials... \e[44mBlue"
sudo git config --global user.name "fuettr"
sudo git config --global user.email "fuettr@gmail.com"

echo -e "downloading... \e[44mBlue"
cd $THISUSER && mkdir git && cd git && git clone https://github.com/Katzenfuetterungsanlage/fuettr_prototype.git

echo -e "copying rc.local... \e[44mBlue"
sudo rsync -aP $THISUSER/git/fuettr_prototype/rc.local /etc/rc.local

echo -e "installing node dependencies... \e[44mBlue"
sudo npm install -g @angular/cli gulp
cd $THISUSER/git/Web_Application/Webserver/ng2 && sudo npm install
cd $THISUSER/git/Web_Application/Webserver/server && sudo npm install

echo -e "building server... \e[44mBlue"
cd $THISUSER/git/Web_Application/Webserver/ng2 && ng build
cd $THISUSER/git/Web_Application/Webserver/server && gulp cleanAndBuild

echo -e "starting server... \e[44mBlue"
cd $THISUSER/git/Web_Application/Webserver/server/dist && sudo node main.js

echo -e "done \e[42mGreen""