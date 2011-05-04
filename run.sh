#!/bin/bash

source ${0%/*}/config

notice "Checking for classes..."
if [ ! -d $CLASSES_PATH ] || [ ! -f $CLASSES_PATH/VirtualCut.class ]; then
  error "You have to build VirtualCut first. \n       Type ${GREEN}./build.sh${NORMAL} in the project directory."
fi

cd $CLASSES_PATH

notice "Running VirtualCut..."
scala VirtualCut || error "Cannot run VirtualCut."

exit 0
