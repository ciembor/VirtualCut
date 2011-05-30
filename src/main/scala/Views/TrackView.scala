package virtualcut
package view

import java.awt._
import java.awt.event._
import javax.swing._
import javax.swing.border._
import components._
import waveform._
import java.io._
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem

object TrackView extends JScrollPane {

  // var file = new File("/home/ciembor/mr-magoo.wav");
  var  file = new File("/home/ciembor/Alesis-Fusion-Bass-Loop.wav");

  var scrollPane = new JScrollPane
  
  def setFile(file: File) {
    var container = new WaveformPanelContainer
    var audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream (new FileInputStream (file)));
    container.setAudioToDisplay(audioInputStream);
    scrollPane.setViewportView(container)
  }

  setFile(file)

}
