#!/bin/bash

CLASSES_DIR="classes"

if [ ! -d $CLASSES_DIR ]; then
  mkdir $CLASSES_DIR
fi

scalac src/*.scala -d $CLASSES_DIR
