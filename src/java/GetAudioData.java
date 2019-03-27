/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Curtis Vannor <cvannor@uab.edu>
 */

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;




public class GetAudioData{
    File file;
    AudioInputStream audioInputStream;
    int bytesPerFrame;
    AudioFormat format;
    long frame;
    boolean endianCheck;
    int numBytes;
    byte[] audioBytes;
    byte[] bytesMono;
    byte[][] bytesSorted;
    Complex[] complexBytes;
    
    public GetAudioData(String path){
        int totalFramesRead = 0;
        file = new File(path);
        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
            bytesPerFrame = audioInputStream.getFormat().getFrameSize();
            format = audioInputStream.getFormat();
            frame = audioInputStream.getFrameLength();
            endianCheck = format.isBigEndian();
            if (bytesPerFrame == AudioSystem.NOT_SPECIFIED) {
            // some audio formats may have unspecified frame size
            // in that case we may read any amount of bytes
            bytesPerFrame = 1;
            } 
            // Set an arbitrary buffer size of 1024 frames.
            numBytes = 1024 * bytesPerFrame; 
            audioBytes = new byte[numBytes];
            
            try {
                int numBytesRead = 0;
                int numFramesRead = 0;
                // Try to read numBytes bytes from the file.
                while ((numBytesRead = audioInputStream.read(audioBytes)) != -1) {
                // Calculate the number of frames actually read.
                numFramesRead = numBytesRead / bytesPerFrame;
                totalFramesRead += numFramesRead;
                // Here, do something useful with the audio data that's 
                // now in the audioBytes array...
                }
                                
            } catch (Exception ex) {
            // Handle the error...
            }
        } catch (Exception e) {
        // Handle the error...
        }
    
    }

    @SuppressWarnings("empty-statement")
    public byte[][] SortBytes(){
        bytesSorted = new byte[numBytes][2];
        byte[] leftChannel = new byte[numBytes];
        byte[] rightChannel = new byte[numBytes];
        if (endianCheck == false){
            for (int i = 0; i<audioBytes.length; i+=4){
                leftChannel[i] = (byte) (((audioBytes[i+1] & 0xff) <<8)|(audioBytes[i] & 0xff));
                rightChannel[i] = (byte) (((audioBytes[i+3] & 0xff) <<8)|(audioBytes[i+2] & 0xff));
            }

            for( int i = 0; i < audioBytes.length; i++ )
		{
                    bytesSorted[i][0] = leftChannel[i];
                    bytesSorted[i][1] = rightChannel[i];
		}
        }
        return bytesSorted;
    }
    
    public byte[] makeMono(byte[][] sortedBytes){
        bytesMono = new byte[numBytes];
        for (int i = 0; i<bytesSorted.length;i++){
            bytesMono[i]  = (byte)((bytesSorted[i][0] + bytesSorted[i][1])/2.0);
            
        }
        return bytesMono;
    }
    
    /**
     *
     * @return
     */
    public Complex[] convertToComplex(double[][] input){
        complexBytes = new Complex[input.length];
        
        for (int i = 0;i<bytesSorted.length;i++){
            complexBytes[i] = new Complex(input[i][0],input[i][1]);
        }
        return complexBytes;
    }
    
    
    public byte[] getColumn(byte[][] array, int index){
        byte[] column = new byte[array.length];
        for(int i = 0; i<column.length; i++){
            column[i] = array[i][index];
        }
        return column;
    }

}
