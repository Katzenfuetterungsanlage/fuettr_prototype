#!/bin/bash
# install script for Fuettr Server and Java-Application

sudo git config --global user.name "fuettr"
sudo git config --global user.email "fuettr@gmail.com"
cd /home/pi/git/fuettr_prototype && sudo rsync -aP /home/pi/git/fuettr_prototype/rc.local /etc/rc.local && sudo reboot