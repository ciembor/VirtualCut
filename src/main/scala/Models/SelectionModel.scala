package virtualcut
package model

class SelectionModel(parameters: ParametersModel, track:TrackModel) {
  var firstSample = 0
  var lastSample = 0
  //var framesNumber = 0
  
  def setLength(parameters: ParametersModel) = {
    var selectionDuration:Double = (60000000 / parameters.tempo.getNumber.doubleValue).toDouble // microseconds
    var selectionSamplesNumber:Long = ((selectionDuration * track.getChannelSamplesNumber) / track.getDuration).toLong
    
    if (track.getChannelSamplesNumber >= selectionSamplesNumber) {
      if (track.getChannelSamplesNumber - firstSample >= selectionSamplesNumber) {
        lastSample = firstSample + selectionSamplesNumber
      }
      else {
        lastSample = track.getChannelSamplesNumber
        firstSample = track.getChannelSamplesNumber - selectionSamplesNumber
      }
    } // if selection isn't longer then track
  }
  
  def setPosition(vector: Int) = {
  }
  
}
