
import java.nio.ByteBuffer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Curtis Vannor <cvannor@uab.edu>
 */
public class AudioProcessor {
    byte[] audiobytes;
    double[] real;
    double[] imag;
    double[][] results; 
    
    public AudioProcessor(byte[] bytes){
        this.audiobytes = bytes;
        results = new double[bytes.length][2];
        real = new double[bytes.length];
        imag = new double[bytes.length];
        for(int i = 0; i <bytes.length;++i){
            real[i] = (double)(bytes[i]);
            imag[i] = 0;
        }
        
        
        
        
    }
    
    public double[][] FFT() {
        // Length variables
		int n = real.length;
		if (n != imag.length)
			throw new IllegalArgumentException("Mismatched lengths");
		int levels = 31 - Integer.numberOfLeadingZeros(n);  // Equal to floor(log2(n))
		if (1 << levels != n)
			throw new IllegalArgumentException("Length is not a power of 2");
		
		// Trigonometric tables
		double[] cosTable = new double[n / 2];
		double[] sinTable = new double[n / 2];
		for (int i = 0; i < n / 2; i++) {
			cosTable[i] = Math.cos(2 * Math.PI * i / n);
			sinTable[i] = Math.sin(2 * Math.PI * i / n);
		}
		
		// Bit-reversed addressing permutation
		for (int i = 0; i < n; i++) {
			int j = Integer.reverse(i) >>> (32 - levels);
			if (j > i) {
				double temp = real[i];
				real[i] = real[j];
				real[j] = temp;
				temp = imag[i];
				imag[i] = imag[j];
				imag[j] = temp;
			}
		}
		
		// Cooley-Tukey decimation-in-time radix-2 FFT
		for (int size = 2; size <= n; size *= 2) {
			int halfsize = size / 2;
			int tablestep = n / size;
			for (int i = 0; i < n; i += size) {
				for (int j = i, k = 0; j < i + halfsize; j++, k += tablestep) {
					int l = j + halfsize;
					double tpre =  real[l] * cosTable[k] + imag[l] * sinTable[k];
					double tpim = -real[l] * sinTable[k] + imag[l] * cosTable[k];
					real[l] = real[j] - tpre;
					imag[l] = imag[j] - tpim;
					real[j] += tpre;
					imag[j] += tpim;
				}
			}
			if (size == n)  // Prevent overflow in 'size *= 2'
				break;
		}
                for(int iter = 0; iter<real.length;iter++){
                    results[iter][0] = real[iter];
                    results[iter][1] = imag[iter];
                }
                return results;
    }
    
    public double[][] powerSpectraStereo(Complex[] left, Complex[] right){
        double[][] outputArray;
        outputArray = new double[left.length][2];
        for (int i = 0; i < left.length / 2; i++)
        { 
            outputArray[i][0] = 10.0 * Math.log10((double)((left[i].re() * left[i].re()) + (left[i].im() * left[i].im())));
            outputArray[i][1] = 10.0 * Math.log10((double)((right[i].re() * right[i].re()) + (right[i].im() * right[i].im())));
        }
        
        return outputArray;
    }
    
    public double[] powerSpectraMono(Complex[] data){
        double[] outputArray;
        outputArray = new double[data.length];
        for (int i = 0; i < data.length / 2; i++)
        { 
            outputArray[i] = 10.0 * Math.log10((double)((data[i].re() * data[i].re()) + (data[i].im() * data[i].im())));
        }
        
        return outputArray;
    }
   
    
}
