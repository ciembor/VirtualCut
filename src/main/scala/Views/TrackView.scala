package virtualcut
package view

import java.awt._
import java.awt.event._
import javax.swing._
import javax.swing.border._
//import components._
import waveform._
import java.io._
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import virtualcut.model.TrackModel

class TrackView(trackModel:TrackModel) {

  var scrollPane = new JScrollPane
  class Container(trackModel:TrackModel) extends WaveformPanelContainer
  var container = new Container(trackModel)

  def setView(trackModel:TrackModel) {
    container.setAudioToDisplay(trackModel.getAudioInputStream);
    scrollPane.setViewportView(container)
  }

}
