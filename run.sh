#!/bin/bash

CLASSES_DIR="classes"

if [ ! -d $CLASSES_DIR ] || [ ! -f $CLASSES_DIR/VirtualCut.class ]; then
  echo -e "You have to build VirtualCut first. Type \033[1;32m./build.sh\033[0m in the project directory."
  exit 0
fi

cd classes
scala VirtualCut
