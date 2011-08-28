package virtualcut
package controller

import swing._
import virtualcut.view.ControlsView
import javax.swing.{UIManager}
import virtualcut.model.TrackModel


class ControlsController(trackModel: TrackModel, trackController:TrackController, controlsView:ControlsView) {
  controlsView.saveSampleButton.action = Action(controlsView.saveSampleButton.text){ 
 //   icon = controlsView.saveSampleButton.icon
    VirtualCut.saveFileChooser.showDialog
  }
  
  controlsView.zoomInButton.action = Action(controlsView.zoomInButton.text) { 
    if (trackModel.zoom <= 0.5)
    {
      trackController.setZoom(trackModel.zoom * 2)
    }
  }
  
  controlsView.zoomOutButton.action = Action(controlsView.zoomOutButton.text) { 
    trackController.setZoom(trackModel.zoom / 2)
  }
  
}
