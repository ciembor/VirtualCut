package virtualcut
package view

import swing._

object SaveFileChooser extends FileChooser {
  def showDialog = {
    this.showSaveDialog(VirtualCut.Window.container)
  }
}

object OpenFileChooser extends FileChooser {
  def showDialog = {
    this.showOpenDialog(VirtualCut.Window.container)
    TrackView.setFile(this.selectedFile)
  }
  
}
