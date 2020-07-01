import com.fft.util.BitReverse;

/**
 * @author 关凯宁
 * @date 2020/6/30 23:00
 */
public class bitRecerse {
    public static void main(String[] args) {
        int i=64;
        for (int j = 0; j < i; j++) {
            System.out.println(Integer.toBinaryString(j)+"\t"+
                    Integer.toBinaryString(BitReverse.bitReverseForInteger(j,6)));
        }
    }
}
