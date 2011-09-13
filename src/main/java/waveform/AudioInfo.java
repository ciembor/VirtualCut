package waveform;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
/**
 * Created by IntelliJ IDEA.
 * User: Jonathan Simon
 * Date: Mar 6, 2005
 * Time: 8:48:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class AudioInfo {
    protected static final int NUM_BITS_PER_BYTE = 8;


    protected AudioInputStream audioInputStream;
    protected int[][] samplesContainer;
    public byte[] bytes;

    //cached values
    protected int sampleMax = 0;
    protected int sampleMin = 0;
    protected double biggestSample;

    public AudioInfo(AudioInputStream aiStream) {
        setAudio(aiStream);
        save();
    }

    public int[][] getSamplesContainer() {
      return samplesContainer;
    }

    public void setAudio(AudioInputStream aiStream) {
        this.audioInputStream = aiStream;
        createSampleArrayCollection();
    }

    public AudioInputStream getAudioInputStream() {
      return audioInputStream;
    }

    public int getNumberOfChannels(){
        int numBytesPerSample = audioInputStream.getFormat().getSampleSizeInBits() / NUM_BITS_PER_BYTE;
        return audioInputStream.getFormat().getFrameSize() / numBytesPerSample;
    }

    private void createSampleArrayCollection() {
        try {
            audioInputStream.mark(Integer.MAX_VALUE);
            audioInputStream.reset();
            bytes = new byte[(int) (audioInputStream.getFrameLength()) * ((int) audioInputStream.getFormat().getFrameSize())];
            int result = 0;
            try {
                result = audioInputStream.read(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //convert sample bytes to channel separated 16 bit samples
            samplesContainer = getSampleArray(bytes);

            //find biggest sample. used for interpolating the yScaleFactor
            if (sampleMax > sampleMin) {
                biggestSample = sampleMax;
            } else {
                biggestSample = Math.abs(((double) sampleMin));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected int[][] getSampleArray(byte[] eightBitByteArray) {
        int[][] toReturn = new int[getNumberOfChannels()][eightBitByteArray.length / (2 * getNumberOfChannels())];
        int index = 0;

        //loop through the byte[]
        for (int t = 0; t < eightBitByteArray.length;) {
            //for each iteration, loop through the channels
            for (int a = 0; a < getNumberOfChannels(); a++) {
                //do the byte to sample conversion
                //see AmplitudeEditor for more info
                int low = (int) eightBitByteArray[t];
                t++;
                int high = (int) eightBitByteArray[t];
                t++;
                int sample = (high << 8) + (low & 0x00ff);

                if (sample < sampleMin) {
                    sampleMin = sample;
                } else if (sample > sampleMax) {
                    sampleMax = sample;
                }
                //set the value.
                toReturn[a][index] = sample;
            }
            index++;
        }

        return toReturn;
    }

    public double getYScaleFactor(int panelHeight){
        return (panelHeight / (biggestSample * 2 * 1.2));
    }

    public int[] getAudio(int channel){
        return samplesContainer[channel];
    }

    public int getIncrement(double xScale) {
        try {
            int increment = (int) (samplesContainer[0].length / (samplesContainer[0].length * xScale));
            return increment;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    protected int getWidth() {
        try {
            int increment = (int) (samplesContainer[0].length /*/ (samplesContainer[0].length * xScale)*/);
            return increment;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public AudioFormat getFormat() {
      return audioInputStream.getFormat();
    }
    
    public long getFrameLength() {
      return audioInputStream.getFrameLength();
    }
    
    public void save()  {


      File targetFile = new File("/home/ciembor/targ.wav");
      
      AudioFileFormat.Type	targetFileType = AudioFileFormat.Type.WAVE;
      AudioFormat audioFormat = audioInputStream.getFormat();
      
            
      AudioFileFormat fileFormat = new AudioFileFormat(targetFileType, audioFormat, (int)audioInputStream.getFrameLength()) ;
      
      byte[] samplebytes = new byte[(bytes.length/2) - 40000];

      for (int i = 40000; i < bytes.length / 2; i++) {
        samplebytes[i - 40000] = bytes[i];
      }
      ByteArrayInputStream bais = new ByteArrayInputStream(samplebytes);
      AudioInputStream outputAIS = new AudioInputStream(bais, audioFormat, samplebytes.length / audioFormat.getFrameSize());
      
      try
      {
         AudioSystem.write(outputAIS, targetFileType, targetFile);
      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.out.println("Can't write audio to file.");
      }

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
