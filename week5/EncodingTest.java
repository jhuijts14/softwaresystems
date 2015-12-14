package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;


/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "HelloWorld";

        System.out.println(Hex.encodeHexString(input.getBytes()));
        
        // P-5.120
        String hexString = "4d6f64756c652032";
        byte[] temp = Hex.decodeHex(hexString.toCharArray());
        
        System.out.println(new String(temp));
        
        // P-5.13)
        //		i)
        String base64Test = Base64.encodeBase64String(input.getBytes());
        System.out.println(base64Test);
       
        //		ii)
        String hexString64 = "010203040506";
        byte[] temp64 = Hex.decodeHex(hexString64.toCharArray());
        System.out.println(new String(temp64));
        String base64String = Base64.encodeBase64String(temp64);
        System.out.println(base64String);
        System.out.println("Base64 string length: " + base64String.length());
        
        //		iii)
        String decodeString = "U29mdHdhcmUgU3lzdGVtcw==";
        byte[] decodeTemp = Base64.decodeBase64(decodeString);
        System.out.println(new String(decodeTemp));
        
        //		iv)
        String[] a = new String[9];
        
        String aTemp = "";
        
        for (int i = 0; i < a.length; i++) {
        	aTemp += "a";
        	a[i] = aTemp;
        }
        
        for (int i = 0; i < a.length; i++) {
        	System.out.println(Base64.encodeBase64String(a[i].getBytes()));
        }
    }
}
