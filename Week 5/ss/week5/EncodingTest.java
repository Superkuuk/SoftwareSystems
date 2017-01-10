package ss.week5;

import org.apache.commons.codec.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";
        System.out.println(Hex.encodeHexString(input.getBytes()));
        
        input = "4d6f64756c652032";
        System.out.println(new String(Hex.decodeHex(input.toCharArray())));
        
        input = "Hello World";
        System.out.println(Base64.encodeBase64String(input.getBytes()));
        
        input = "010203040506";
        System.out.println(Base64.encodeBase64String(
        		new String(Hex.decodeHex(input.toCharArray())).getBytes()));
        //The Base64 encoding is shorter (AQIDBAUG), so less data is used.
        
        input = "U29mdHdhcmUgU3lzdGVtcw==";
        System.out.println(new String(Base64.decodeBase64(input.getBytes()))); //Software Systems
        
        input = "a";
        for (int i = 0; i < 10; i++) {
        	System.out.println(Base64.encodeBase64String(input.getBytes()));
        	input += "a";
        }
        /*
         * YQ==
         * YWE=
         * YWFh
         * YWFhYQ==
         * YWFhYWE=
         * YWFhYWFh
         * YWFhYWFhYQ==
         * YWFhYWFhYWE=
         * YWFhYWFhYWFh
         * YWFhYWFhYWFhYQ==
         */
        
        
    }
}
