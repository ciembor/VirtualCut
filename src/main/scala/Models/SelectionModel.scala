package virtualcut
package model

class SelectionModel(parameters: ParametersModel, track:TrackModel) {

  private var firstFrame:Int = 10
  private var lastFrame:Int = 14
  
  def frameToSample(pixel:Int):Int = {
    (pixel / track.zoom).toInt
  }
  
  private def frameToPixel(frame:Int):Int = {
    (frame * track.zoom).toInt
  }
  
  def setLength(parameters: ParametersModel):Int = {
    var selectionDuration:Double = (60000000 / parameters.tempo.getNumber.doubleValue).toDouble // microseconds
    var selectionSamplesNumber:Int = ((selectionDuration * track.getChannelSamplesNumber) / track.getDuration).toInt
    
    if (track.getChannelSamplesNumber >= selectionSamplesNumber) {
      if (track.getChannelSamplesNumber - firstFrame >= selectionSamplesNumber) {
        lastFrame = firstFrame + selectionSamplesNumber
        return 0
      }
      else {
        lastFrame = track.getChannelSamplesNumber
        firstFrame = track.getChannelSamplesNumber - selectionSamplesNumber
        return 0
      }
    } // if selection isn't Inter then track
    else {
      return -1
    }
  }
  
  def setPosition(vector: Int) = {
    if (vector > 0) {
      if (lastFrame + vector <= track.getChannelSamplesNumber) {
        firstFrame += vector
        lastFrame += vector
      }
    }
    else {
      if (lastFrame + vector >= 0) {
        firstFrame += vector
        lastFrame += vector
      }
    }
  }
  
  class SampleModel() {
  }
  
  def getSample():SampleModel = {
    var channelsNumber = track.getNumberOfChannels()
    var framesNumber = lastFrame - firstFrame
    var frames = Array.ofDim[Int](channelsNumber, framesNumber)
    System.out.println(frames.length);
    System.out.println(frames(0).length);
    var trackFrames = track.getSamplesContainer()

    for (i <- 0 until channelsNumber) {
      var count = 0
      for (j <- firstFrame until lastFrame) {
        frames(i)(count) = trackFrames(i)(j)
        count += 1
      }
    }
    
    return new SampleModel()
  }
  
  getSample()
  
}
