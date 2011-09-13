package virtualcut
package model

import virtualcut.Sample
import java.awt._

class SelectionModel(parameters: ParametersModel, track:TrackModel) {

  private var firstFrame:Int = 0
  private var lastFrame:Int = 0
  private var height = track.getSize.height
  
  private var isPlay = true
  
  var sample:Sample = null
  
  def firstSample = {
    firstFrame
  }
  
  def play = {
    sample.play()
    isPlay = true
  }
  
  def stop = {
    sample.clipstop()
    isPlay = false
  }
  
  def setSample = {
    
    var old = sample

    sample = new Sample(track, this)
    if (isPlay == true) {
      sample.play()
    }
    
    if (old != null) {
      println("changing sample...")
      old.clipstop
      println("done!")
    }
    
  }
  
  def pixelToSample(pixel:Int):Int = {
    (pixel / track.getZoom).toInt
  }
  
  def point:Point = {
    new Point(frameToPixel(firstFrame), 0)
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
  
  def getFrameLength = {
    lastFrame - firstFrame
  }
  
  def max = {
   println("track.getSize.width" + track.getSize.width)
    track.getSize.width - getLength
  }
  
  def setLength(parameters: ParametersModel):Int = {
    var selectionDuration:Double = (60000000 / parameters.tempo.getNumber.doubleValue).toDouble // microseconds
    var selectionSamplesNumber:Int = ((selectionDuration * track.getChannelSamplesNumber) / track.getDuration).toInt
    var trackWidth = pixelToSample(track.getSize.width)

        
    if (trackWidth >= selectionSamplesNumber) {
      if (trackWidth - (firstFrame + selectionSamplesNumber) >= 0) {
        lastFrame = firstFrame + selectionSamplesNumber
        println("pierwszy if - " + " selectionSamplesNumber: " + selectionSamplesNumber + " | trackWidth: " + trackWidth + " | lastFrame: " + lastFrame)
      }
      else {
        lastFrame = trackWidth
        firstFrame = trackWidth - selectionSamplesNumber
        println("drugi if - " + " selectionSamplesNumber: " + frameToPixel(selectionSamplesNumber) + " | trackWidth: " + frameToPixel(trackWidth) + " | lastFrame: " + frameToPixel(lastFrame) + " | firstFrame: " + frameToPixel(firstFrame))

      }
      
      setSample
      return 0
    } // if selection isn't Inter then track
    else {
      return -1
    }
  }
  
  def setPosition(position: Double) = {
    var pos = pixelToSample(position.toInt)
    if (pos >= 0 && position.toInt <= max) {
      var tmp = lastFrame - firstFrame
      firstFrame = pos
      lastFrame = pos + tmp
    }
    println("selection size: " + (lastFrame - firstFrame) + "      [" + firstFrame + "; " + lastFrame + "]" + track.getZoom)
    
    setSample
  }

  
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
