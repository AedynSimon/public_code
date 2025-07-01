import java.io.IOException;

public class Cipher {

    public static void main(String[] args) {
        if (args.length != 5) {
            System.exit(1);
        }

        String cipherType = args[0];
        String inputFilePath = args[1];
        String outputFilePath = args[2];
        String keyFilePath = args[3];
        String modeOfOperation = args[4];

        ErrorChecking checker = new ErrorChecking(cipherType, inputFilePath, keyFilePath, modeOfOperation);
        checker.process();

        try {
            if (cipherType.equals("B")) {
                BlockCipher blockCipher = new BlockCipher(inputFilePath, outputFilePath, keyFilePath, modeOfOperation);
                blockCipher.process();
            } else {
                StreamCipher streamCipher = new StreamCipher(inputFilePath, outputFilePath, keyFilePath);
                streamCipher.process();
            }
        } catch (IOException exception) {
            System.err.println("Error: Exception thrown during cipher processing!");
            System.exit(1);
        }
    }
}
