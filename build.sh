#!/bin/bash

source ${0%/*}/config.inc.sh

if [ ! -d $CLASSES_PATH ]; then
  notice "Creating classes directory..."
  mkdir $CLASSES_PATH
fi
 
notice "Building VirtualCut..."
#scalac $SOURCE_PATH/Model/*.scala -d $CLASSES_PATH || error "Build failed (Model)."
#scalac $SOURCE_PATH/View/*.scala -d $CLASSES_PATH || error "Build failed (View)."
#scalac $SOURCE_PATH/Controller/*.scala -d $CLASSES_PATH || error "Build failed (Controller)."
scalac $SOURCE_PATH/*.scala -d $CLASSES_PATH || error "Build failed."
success "Building complete."

exit 0
