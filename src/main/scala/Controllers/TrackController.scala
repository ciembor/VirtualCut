package virtualcut
package controller

import virtualcut.model.TrackModel
import virtualcut.model.ParametersModel
import virtualcut.model.SelectionModel
import virtualcut.view.TrackView


import java.io._
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem

class TrackController(parameters:ParametersModel, trackModel: TrackModel, trackView: TrackView) {

  var file = new File("/home/ciembor/mr-magoo.wav");
  
  object selection extends SelectionModel(parameters, trackModel)
  selection.setLength(parameters)
//  var scrollPane = new JScrollPane
  
  def setParameters(parameters:ParametersModel) {
    selection.setLength(parameters)
    trackView.setSelection(selection)
  }
  
  def setFile(file: File) {
    var audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream (new FileInputStream (file)));
    trackModel.setAudio(audioInputStream);
    trackView.setView(trackModel, selection)
  }

  def setZoom(zoom: Double) {
    trackModel.zoom = zoom
    trackView.setView(trackModel, selection)
  }

  setFile(file)
  
}

