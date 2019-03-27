
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.io.Writer;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Curtis Vannor <cvannor@uab.edu>
 */



@MultipartConfig
@WebServlet(name = "FormExecute", urlPatterns = {"/process"})
public class FormExecute extends HttpServlet{
    PrintWriter writer;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        writer = response.getWriter();
        String path = request.getParameter("homepath");
        GetAudioData data = new GetAudioData(path);
        byte[][] bytes = data.SortBytes();
        byte[] monoData = data.makeMono(bytes);
        AudioProcessor FFT = new AudioProcessor(monoData);
        double trans[][] = FFT.FFT();
        Complex[] cmplx;
        cmplx = data.convertToComplex(trans);
        double[] powerSpectra = FFT.powerSpectraMono(cmplx);

        int count = 0;
        int count2 = 0;
        
        writer.println("Complex Frequency Data\n");
        for (int i =0; i<cmplx.length;i++){
            writer.println(cmplx[i]);
            
        }
        
        

      
 
        // code to process the form...
 
    }

    
}

