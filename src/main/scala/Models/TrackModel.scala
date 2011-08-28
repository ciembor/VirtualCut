package virtualcut
package model

import waveform.AudioInfo
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import java.io._

class TrackModel(aiStream: AudioInputStream) extends AudioInfo(aiStream: AudioInputStream) {
  var zoom:Double = 0.5
  
  def getXScaleFactor(panelWidth:Int):Double = {
    panelWidth / ((samplesContainer(0).length).toDouble / zoom)
  }
}
