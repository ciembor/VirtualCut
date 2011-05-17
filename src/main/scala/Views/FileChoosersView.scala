package virtualcut
package view

import swing._

object SaveFileChooser extends FileChooser {
  def showDialog = {
    this.showSaveDialog(VirtualCut.view.container)
  }
}

object OpenFileChooser extends FileChooser {
  def showDialog = {
    this.showOpenDialog(VirtualCut.view.container)
  }
}
