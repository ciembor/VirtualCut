package waveform;

import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import java.awt.*;
import java.util.ArrayList;
import virtualcut.model.TrackModel;
/**
 * Created by IntelliJ IDEA.
 * User: Jonathan Simon
 * Date: Mar 20, 2005
 * Time: 5:08:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class WaveformPanelContainer extends JPanel {
    private ArrayList singleChannelWaveformPanels = new ArrayList();
    private TrackModel trackModel = null;

    public WaveformPanelContainer(TrackModel trackModel) {
        setLayout(new GridLayout(0,1));
        this.trackModel = trackModel;
    }

    public void setAudioToDisplay(TrackModel trackModel){
        this.trackModel = trackModel;
        this.singleChannelWaveformPanels.clear();

       // trackModel = new TrackModel(audioInputStream);
        for (int t=0; t<trackModel.getNumberOfChannels(); t++){
            SingleWaveformPanel waveformPanel
                    = new SingleWaveformPanel(trackModel, t);
            singleChannelWaveformPanels.add(waveformPanel);
            add(createChannelDisplay(waveformPanel, t));
        }
    }

    private JComponent createChannelDisplay(SingleWaveformPanel waveformPanel, int index) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(waveformPanel, BorderLayout.CENTER);

        JLabel label = new JLabel("Channel " + ++index);
        panel.add(label, BorderLayout.NORTH);

        return panel;
    }


}

/*   Swing Hacks
 *   Tips and Tools for Killer GUIs
 * By Joshua Marinacci, Chris Adamson
 *   First Edition June 2005
 *   Series: Hacks
 *   ISBN: 0-596-00907-0
 *   http://www.oreilly.com/catalog/swinghks/
 */
