package virtualcut
package model

import waveform.AudioInfo
import java.awt._

import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import java.io._

class TrackModel(aiStream: AudioInputStream) extends AudioInfo(aiStream: AudioInputStream) {
  var zoom:Double = 1
  
  def getZoom(): Double = {
    return zoom
  }
  
  def getSize(): Dimension = {
    var width = (getWidth() * getZoom()).toInt;
    var height = 200 * getNumberOfChannels();
    return new Dimension(width, height);
  }
  
  def getXScaleFactor(panelWidth:Int):Double = {
    panelWidth / ((samplesContainer(0).length).toDouble / zoom)
  }
  
  def getDuration():Double = {
    var trackDuration:Double = 1000000 * audioInputStream.getFrameLength().toDouble / audioInputStream.getFormat().getFrameRate().toDouble
    return trackDuration
  }
  
  def getChannelSamplesNumber():Int = {
    samplesContainer(0).length
  }
}
