package encryptdecrypt;

public class UnicodeObj extends EncryptionDecryptionAlgorithm {
    public UnicodeObj(String messageToProcess, int shift) {
        super(messageToProcess, shift);
    }


    @Override
    public String encrypt(String message, int number) {
//        char[] chars = new char[26];
//
//        for (int i = 0; i < 26; i++) {
//            chars[i] = (char) (97 + i);
//        }


        char[] stringChars = message.toCharArray();
        for (int i = 0; i < stringChars.length; i++) {
            stringChars[i] = (char) (stringChars[i] + number);
        }


        StringBuilder sb = new StringBuilder();

        for (char c : stringChars) {
            sb.append(c);
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String message, int number) {
//        char[] chars = new char[26];
//
//
//        for (int i = 0; i < 26; i++) {
//            chars[i] = (char) (97 + i);
//        }

        char[] stringChars = message.toCharArray();
        for (int i = 0; i < stringChars.length; i++) {
            stringChars[i] = (char) (stringChars[i] - number);
        }


        StringBuilder sb = new StringBuilder();

        for (char c : stringChars) {
            sb.append(c);
        }
        return sb.toString();
    }
    }

