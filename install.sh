#!/bin/bash
# install script for Fuettr Server and Java-Application

THISUSER=/home/$USER

echo "Home directory: $THISUSER"

echo "setting git credentials..."
sudo git config --global user.name "fuettr"
sudo git config --global user.email "fuettr@gmail.com"

echo "downloading..."
cd $THISUSER && mkdir git && cd git && git clone https://github.com/Katzenfuetterungsanlage/fuettr_prototype.git

echo "copying rc.local..."
sudo rsync -aP $THISUSER/git/fuettr_prototype/rc.local /etc/rc.local

echo "installing node dependencies..."
sudo npm install -g @angular/cli gulp
cd $THISUSER/git/Web_Application/Webserver/ng2 && sudo npm install
cd $THISUSER/git/Web_Application/Webserver/server && sudo npm install

echo "building server..."
cd $THISUSER/git/Web_Application/Webserver/ng2 && ng build
cd $THISUSER/git/Web_Application/Webserver/server && gulp cleanAndBuild

echo "starting server..."
cd $THISUSER/git/Web_Application/Webserver/server/dist && sudo node main.js

echo "done"