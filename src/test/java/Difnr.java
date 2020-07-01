import com.fft.Complex.Complex;

import java.io.*;
import java.util.Arrays;

/**
 * @author 关凯宁
 * @date 2020/6/30 22:34
 */
public class Difnr {

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(bi.readLine());
        BufferedReader br=new BufferedReader(new FileReader(new File("src\\main\\resources\\test-"+size+".txt")));
        double[] input=new double[size];
        for (int i = 0; i < size; i++) {
            input[i]=Double.parseDouble(br.readLine().trim());
        }
        Complex[] target= Arrays.stream(input).mapToObj(k->new Complex(k,0)).toArray(Complex[]::new);
//        DIFnrFFT.compute(size,target);
//        DIFrnFFT.compute(size,target);
        for (Complex c:target){
            System.out.println(c.toString());
        }
    }
}
