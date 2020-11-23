package encryptdecrypt;

public abstract class EncryptionDecryptionAlgorithm implements Encrypt, Decrypt {

    protected String messageToProcess;
    protected String encryptedMessage;
    protected String decryptedMessage;
    protected int number;

    public EncryptionDecryptionAlgorithm(String messageToProcess, int shift) {
        this.messageToProcess = messageToProcess;
        this.number = shift;
    }

    public void print(String messageOption) {
        System.out.println(messageOption);
    }

    public String readFromFile() {

        return null;
    }


    public abstract String decrypt(String message, int number);
}