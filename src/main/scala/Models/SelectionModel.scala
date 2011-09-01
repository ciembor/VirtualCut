package virtualcut
package model

import java.awt._

class SelectionModel(parameters: ParametersModel, track:TrackModel) {

  private var firstFrame:Int = 0
  private var lastFrame:Int = 0
  private var height = track.getSize.height
  
  def pixelToSample(pixel:Int):Int = {
    (pixel / track.getZoom).toInt
  }

  private def frameToPixel(frame:Int):Int = {
    (frame * track.getZoom).toInt
  }
  
  def size:Dimension = {
    new Dimension(getLength, height);
  }
  
  def getLength = {
    frameToPixel(lastFrame - firstFrame)
  }
  
  def max = {
    track.getSize.width - getLength
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
  
  /****************************** TEST *********************************
   for(i <- 1 until 300) {
    var selectionDuration:Double = (60000000 / i.toDouble).toDouble // microseconds
    var selectionSamplesNumber:Int = ((selectionDuration * track.getChannelSamplesNumber) / track.getDuration).toInt
    
    if (track.getChannelSamplesNumber >= selectionSamplesNumber) {
      if (track.getChannelSamplesNumber - firstFrame >= selectionSamplesNumber) {
        lastFrame = firstFrame + selectionSamplesNumber
        println(i + ": " + lastFrame + "    | length: " + getLength)
      }
      else {
        lastFrame = track.getChannelSamplesNumber
        firstFrame = track.getChannelSamplesNumber - selectionSamplesNumber
        println(i + ": " + lastFrame + "    | length: " + getLength)
      }
    } // if selection isn't Inter then track
    else {
     println(i + ": error")
    }
   }
  *********************************************************************/
  
  
}
