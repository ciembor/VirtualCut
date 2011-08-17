# VirtualCut

## About

__VirtualCut__ is an application dedicated to extracting samples from audio files. 

## Installation and Usage

To build VirtualCut, you need to install Scala enviroment first. You will find it on [official Scala webpage](http://www.scala-lang.org/downloads). You will also need [SBT (Simple Build Tool)](http://code.google.com/p/simple-build-tool/downloads/list). Then you have to download __VirtualCut__ from [Github](http://github.com/ciembor/VirtualCut/):

     git clone git@github.com:ciembor/VirtualCut
     
Now go to the created directory:

     cd VirtualCut
     
Build __VirtualCut__ using __SBT__:
     
     sbt update
     sbt compile
     
If everything went right, run __VirtualCut__

     sbt run

