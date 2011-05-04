#!/bin/bash

source ${0%/*}/config.inc.sh

if [ ! -d $CLASSES_PATH ]; then
  notice "Creating classes directory..."
  mkdir $CLASSES_PATH
fi
 
notice "Building VirtualCut..."
scalac $SOURCE_PATH/*.scala -d $CLASSES_PATH || error "Build failed."
success "Building complete."

exit 0
