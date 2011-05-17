package virtualcut
package view

import swing._
import javax.swing.ImageIcon
import javax.swing.{UIManager}

object MenuBarView extends MenuBar {   
      
  contents += new Menu("Menu") {
    val exitMenuItem = new MenuItem("Exit")
    exitMenuItem.tooltip = "Exit VirtualCut"
    //exitMenuItem.icon = UIManager.getIcon("FileView.floppyDriveIcon")
    val openFile = new FileChooser()

    val openMenuItem = new MenuItem(Action("Open file") {
      OpenFileChooser.showDialog
    })
    openMenuItem.icon = UIManager.getIcon("FileView.directoryIcon")

    val saveFile = new FileChooser()
    val saveMenuItem = new MenuItem(Action("Save sample") {
      SaveFileChooser.showSaveDialog(VirtualCut.view.container)
    })
    saveMenuItem.icon = UIManager.getIcon("FileView.floppyDriveIcon")
    
    contents += openMenuItem
    contents += saveMenuItem
    contents += new Separator
    contents += exitMenuItem
  }
  
}
