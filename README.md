# VirtualCut

## About

__VirtualCut__ was created for musicians basing their work on samples, but lacking access to professional software working exclusively under commercial operating systems. VirtualCut is designed in particular for users of the GNU/Linux system and other Unix-like systems.

## Installation

To build VirtualCut, you need to install Scala enviroment first. You will find it on [official Scala webpage](http://www.scala-lang.org/downloads). You will also need [SBT (Simple Build Tool)](http://code.google.com/p/simple-build-tool/downloads/list). Then download __VirtualCut__ from [Github](http://github.com/ciembor/VirtualCut/):

     git clone git@github.com:ciembor/VirtualCut
     
Go to the created directory:

     cd VirtualCut
     
Build __VirtualCut__ using __SBT__:

     sbt compile
     
If everything went right, run __VirtualCut__:

     sbt run

## Usage

After an audio file has been loaded, the waveform is displayed. We can now set the length of the sample that we wish to cut. The length is specified on the basis of the __tempo__, __metre__ and __note__. Once these parameters have been set, a part of the waveform will be highlighted. This highlight can be moved in order to select the desired fragment. When you decide to cut it, click ‘save sample’ to save it to a new file. Such samples can be opened in any sound editor.
