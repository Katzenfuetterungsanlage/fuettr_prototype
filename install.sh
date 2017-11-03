#!/bin/bash
# install script for Fuettr Server and Java-Application

USER = $HOME

echo "Home directory: $USER"

echo "setting git credentials..."
sudo git config --global user.name "fuettr"
sudo git config --global user.email "fuettr@gmail.com"

echo "downloading..."
cd $USER && mkdir git && cd git && git clone https://github.com/Katzenfuetterungsanlage/fuettr_prototype.git

echo "copying rc.local..."
sudo rsync -aP $USER/git/fuettr_prototype/rc.local /etc/rc.local

echo "installing node dependencies..."
sudo npm install -g @angular/cli gulp
cd $USER/git/Web_Application/Webserver/ng2 && sudo npm install
cd $USER/git/Web_Application/Webserver/server && sudo npm install

echo "building server..."
cd $USER/git/Web_Application/Webserver/ng2 && ng build
cd $USER/git/Web_Application/Webserver/server && gulp cleanAndBuild

echo "starting server..."
cd $USER/git/Web_Application/Webserver/server/dist && sudo node main.js

echo "done"