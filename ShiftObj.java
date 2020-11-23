package encryptdecrypt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShiftObj  extends EncryptionDecryptionAlgorithm {


    public ShiftObj(String messageToEncrypt, int shift) {
        super(messageToEncrypt, shift);
    }




    @Override
    public String decrypt(String message, int number) {
        String s = "";
        int len = message.length();
        for(int x = 0; x < len; x++) {
            char original = message.charAt(x);
            char c = (char) (message.charAt(x) - this.number);
            Pattern p = Pattern.compile("[a-z]");
            Pattern upperCase = Pattern.compile("[A-Z]");
            Matcher m = p.matcher(String.valueOf(original));
            Matcher m1 = upperCase.matcher(String.valueOf(original));
            if (m.matches()) {
                if (c < 97)
                    s += (char) (123 + original % 97 - number);
                else
                    s += (char) (message.charAt(x) - number);
            } else if (m1.matches()) {
                if (c < 65)
                    s += (char) (91 + (original % 65 - number));
                else
                    s += (char) (message.charAt(x) - number);
            }
            else {
                s += original;
            }
        }
        return s;
    }


    @Override
    public String encrypt(String message, int number) {


        String s = "";
            int len = message.length();
            for(int x = 0; x < len; x++) {
                char original = message.charAt(x);
                char c = (char) (message.charAt(x) + this.number);
                Pattern p = Pattern.compile("[a-z]");
                Pattern upperCase = Pattern.compile("[A-Z]");
                Matcher m = p.matcher(String.valueOf(original));
                Matcher m1 = upperCase.matcher(String.valueOf(original));
                if (m.matches()) {
                    if (c > 122)
                        s += (char) (message.charAt(x) - (26 - number));
                    else
                        s += (char) (message.charAt(x) + number);
                } else if (m1.matches()) {
                    if (c > 91)
                        s += (char) (message.charAt(x) - (26 - number));
                    else
                        s += (char) (message.charAt(x) + number);
                }
                else {
                    s += original;
                }
            }
            return s;
        }

    }

