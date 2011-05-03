#!/bin/bash

CLASSES_DIR="classes"
SOURCE_DIR="src"

if [ ! -d $CLASSES_DIR ]; then
  mkdir $CLASSES_DIR
fi

scalac $SOURCE_DIR/*.scala -d $CLASSES_DIR
