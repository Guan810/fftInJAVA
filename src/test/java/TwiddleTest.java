import com.fft.Complex.Complex;
import com.fft.util.TwiddleFactor;

/**
 * @author 关凯宁
 * @date 2020/7/1 7:49
 */
public class TwiddleTest {

    public static void main(String[] args) {
        Complex[] t= TwiddleFactor.twiddles(8);
        for (Complex c:t){
            System.out.println(c.toString());
        }
    }
}
