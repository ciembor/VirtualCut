package virtualcut
package helper

import swing._
import virtualcut.controller.TrackController

class SaveFileChooser(trackController:TrackController) extends FileChooser {
  def showDialog = {
    this.showSaveDialog(VirtualCut.Window.container)
  }
}

class OpenFileChooser(trackController:TrackController) extends FileChooser {
  def showDialog = {
    this.showOpenDialog(VirtualCut.Window.container)
    trackController.setFile(this.selectedFile)
  }
}
