package virtualcut
package view

import swing._
import javax.swing.ImageIcon
import javax.swing.{UIManager}

object ControlsView extends FlowPanel {
  
  minimumSize= new Dimension(300,100)
  
  val pauseButton = new Button("pause") {
    icon = new ImageIcon(getClass.getResource("/Pause.gif"))
    verticalTextPosition = Alignment.Bottom
    horizontalTextPosition = Alignment.Center
  }
        
  val playButton = new Button("play") {
    icon = new ImageIcon(getClass.getResource("/Play.gif"))
    verticalTextPosition = Alignment.Bottom
    horizontalTextPosition = Alignment.Center
  }
        
  val stopButton = new Button("stop") {
    icon = new ImageIcon(getClass.getResource("/Stop.gif"))
    verticalTextPosition = Alignment.Bottom
    horizontalTextPosition = Alignment.Center
  }

  val saveSampleButton = new Button(Action("Save sample") { 
    SaveFileChooser.showDialog
    }) {
    icon = new ImageIcon(getClass.getResource("/Save.gif"))
    verticalTextPosition = Alignment.Bottom
    horizontalTextPosition = Alignment.Center
  }
        
  contents += pauseButton
  contents += playButton
  contents += stopButton
  contents += saveSampleButton
  
}
