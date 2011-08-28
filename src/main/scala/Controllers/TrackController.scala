package virtualcut
package controller

import virtualcut.model.TrackModel
import virtualcut.view.TrackView


import java.io._
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem

class TrackController(trackModel: TrackModel, trackView: TrackView) {

  var file = new File("/home/ciembor/mr-magoo.wav");
  

//  var scrollPane = new JScrollPane
  
  def setFile(file: File) {
    var audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream (new FileInputStream (file)));
    trackModel.setAudio(audioInputStream);
    trackView.setView(trackModel)
  }

  def setZoom(zoom: Double) {
    trackModel.zoom = zoom
    trackView.setView(trackModel)
  }

  setFile(file)
  
}
