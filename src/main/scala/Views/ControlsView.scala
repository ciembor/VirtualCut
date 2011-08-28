package virtualcut
package view

import swing._
import javax.swing.ImageIcon
import javax.swing.{UIManager}
import virtualcut.controller.TrackController


class ControlsView extends FlowPanel {
  
 // minimumSize= new Dimension(300,100)
  
  object pauseButton extends Button("pause") {
    icon = new ImageIcon(getClass.getResource("/Pause.gif"))
    verticalTextPosition = Alignment.Bottom
    horizontalTextPosition = Alignment.Center
  }
        
  object playButton extends Button("play") {
    icon = new ImageIcon(getClass.getResource("/Play.gif"))
    verticalTextPosition = Alignment.Bottom
    horizontalTextPosition = Alignment.Center
  }
        
  object stopButton extends Button("stop") {
    icon = new ImageIcon(getClass.getResource("/Stop.gif"))
    verticalTextPosition = Alignment.Bottom
    horizontalTextPosition = Alignment.Center
  }

  object saveSampleButton extends Button("save sample") {
    icon = new ImageIcon(getClass.getResource("/Save.gif"))
    verticalTextPosition = Alignment.Bottom
    horizontalTextPosition = Alignment.Center
  }

  object zoomInButton extends Button("+") 
  object zoomOutButton extends Button("-") 

  contents += pauseButton
  contents += playButton
  contents += stopButton
  contents += saveSampleButton
  
  object ZoomPanel extends GridPanel(2,0) {
    vGap = 3
    
    contents += zoomInButton
    contents += zoomOutButton
  }
  
  contents += ZoomPanel
  
}
