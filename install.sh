#!/bin/bash
# install script for Fuettr Server and Java-Application

echo "setting git credentials..."
sudo git config --global user.name "fuettr"
sudo git config --global user.email "fuettr@gmail.com"

echo "making sure the latest version is downloaded..."
sudo git pull

echo "copying rc.local..."
sudo rsync -aP /home/pi/git/fuettr_prototype/rc.local /etc/rc.local

echo "done"
echo "please reboot your system to start the applications (sudo reboot)"