package virtualcut;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

import java.io.*;

import virtualcut.model.SelectionModel;
import virtualcut.model.TrackModel;
 
import javax.sound.sampled.Clip;
import java.io.IOException; 
import javax.sound.sampled.DataLine; 
import javax.sound.sampled.FloatControl; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
 
public class Sample extends Thread{
    
    private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb 

    
    ByteArrayInputStream bais;
    AudioInputStream sample;

    AudioFileFormat.Type	targetFileType = AudioFileFormat.Type.WAVE;
    AudioFileFormat fileFormat;
    AudioFormat audioFormat;
    int firstSample;
    
    SourceDataLine auline = null;
    Clip clip;
    DataLine.Info info;
    
    private byte[] samplebytes;

    public Sample(TrackModel track, SelectionModel selection) {
      audioFormat = track.getFormat();
      fileFormat = new AudioFileFormat(targetFileType, audioFormat, (int)track.getFrameLength());
      samplebytes = new byte[selection.getFrameLength() * track.getNumberOfChannels() * 2];
      
      firstSample = selection.firstSample();
      
      firstSample *= track.getNumberOfChannels() * 2;
      
      for (int i = 0; i < samplebytes.length; i++) {
        samplebytes[i] = track.bytes[i + firstSample];
      }
      
      bais = new ByteArrayInputStream(samplebytes);
      sample = new AudioInputStream(bais, audioFormat, samplebytes.length / audioFormat.getFrameSize());
 
      info = new DataLine.Info(Clip.class, audioFormat);

      //sample.write(samplebytes, 0, samplebytes.length);
        
        try {
                clip = (Clip) AudioSystem.getLine(info);

      clip.open(sample);
      } 
      catch (LineUnavailableException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

    }

    public void play() {
      clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void clipstop() {
      System.out.println("before stop");
      clip.stop();

      System.out.println("before stop");

    }

    public void destroy() {
      if (clip.isOpen()) {
        clip.close();
      } 
    }
    /*public void play() {
      try { 
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(audioFormat);
        } catch (LineUnavailableException e) { 
            e.printStackTrace();
            return;
        } catch (Exception e) { 
            e.printStackTrace();
            return;
        } 
        
                   System.out.println("start");

        auline.start();
        int nBytesRead = 0;
        byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
 
        try { 
            while (nBytesRead != -1) { 
                nBytesRead = sample.read(abData, 0, abData.length);
                if (nBytesRead >= 0) 
                    auline.write(abData, 0, nBytesRead);
            } 
        } catch (IOException e) { 
            e.printStackTrace();
            return;
        } finally { 
            auline.drain();
            auline.close();
            System.out.println("end");
        } 
 
    }*/
 
    public void save()  {
      
      File targetFile = new File("/home/ciembor/target.wav");
      
      try
      {
         AudioSystem.write(sample, targetFileType, targetFile);
      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.out.println("Can't write audio to file.");
      }

    }
}
