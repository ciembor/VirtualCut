package virtualcut
package view

import java.awt._
import java.awt.event._
import javax.swing._
import javax.swing.border._
import waveform._
import java.io._
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import virtualcut.model.TrackModel
import virtualcut.model.SelectionModel

import waveform.AudioInfo

class TrackView(trackModel:TrackModel) {

  var scrollPane = new JScrollPane
  var layeredPane = new JLayeredPane
  var selectionPanel = new JPanel()
  
  layeredPane.add(selectionPanel, JLayeredPane.DRAG_LAYER)

  selectionPanel.setOpaque(false)
  selectionPanel.setLayout(null)
  
  class Waveform(trackModel:TrackModel) extends WaveformPanelContainer(trackModel:TrackModel)
  
  def setSelection(selectionModel:SelectionModel) {
    selectionPanel.removeAll
    var selection = new SelectionView(selectionModel)
    selection.update
    selectionPanel.setSize(trackModel.getSize())    
    selectionPanel.add(selection)
    scrollPane.repaint()
  }
  
  def setView(trackModel:TrackModel, selectionModel:SelectionModel) {

    var waveform = new Waveform(trackModel)
    
    setSelection(selectionModel)
    
    waveform.setAudioToDisplay(trackModel)
    
    layeredPane.add(waveform, JLayeredPane.DEFAULT_LAYER)
    layeredPane.setPreferredSize(trackModel.getSize())

    scrollPane.setViewportView(layeredPane)
    var spWidth = scrollPane.getWidth;
    if (spWidth == 0) {
      spWidth = 800
    }
    
    scrollPane.setPreferredSize(new Dimension(spWidth, trackModel.getSize.height + 18))
    
  }

}
