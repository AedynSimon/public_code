import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StreamCipher {

    private String inputFilepath;
    private String outputFilePath;
    private String keyFilePath;

    public StreamCipher(String inputFilePath, String outputFilePath, String keyFilePath) {
        this.inputFilepath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.keyFilePath = keyFilePath;
    }

    public void process() throws IOException {
        byte[] keyBytes = Files.readAllBytes(Paths.get(keyFilePath));
        byte[] inputBytes = Files.readAllBytes(Paths.get(inputFilepath));
        byte[] result = xorProcess(keyBytes, inputBytes);
        Files.write(Paths.get(outputFilePath), result);
    }

    private byte[] xorProcess(byte[] keyBytes, byte[] inputBytes) {
        int inputLength = inputBytes.length;
        int keyLength = keyBytes.length;
        byte[] xorResultBytes = new byte[inputLength];
        for (int i = 0; i < inputLength; i++)
            xorResultBytes[i] = (byte) (inputBytes[i] ^ keyBytes[i % keyLength]);
        return xorResultBytes;
    }
}
