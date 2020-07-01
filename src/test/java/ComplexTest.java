import com.fft.Complex.Complex;

import static com.fft.util.ComplexOperation.*;

/**
 * @author 关凯宁
 * @date 2020/7/1 7:29
 */
public class ComplexTest {

    public static void main(String[] args) {
        Complex a=new Complex(2,9);
        Complex b=new Complex(3,8);
        System.out.println(add(a,b).toString());
        System.out.println(min(a,b).toString());
        System.out.println(multy(a,b).toString());
        System.out.println(divide(a,b).toString());
        System.out.println(mod(a));
        System.out.println(2.1-3.4);
    }
}
