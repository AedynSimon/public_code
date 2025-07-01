import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class BlockCipher {
    
    private final short BLOCKSIZE = 16;
    private final byte PADDINGBYTE = (byte) 0x81;

    private String inputFilepath;
    private String outputFilePath;
    private String keyFilePath;
    private String modeOfOperation;

    public BlockCipher(String inputFilePath, String outputFilePath, String keyFilePath, String modeOfOperation) {
        this.inputFilepath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.keyFilePath = keyFilePath;
        this.modeOfOperation = modeOfOperation;
    }

    public void process() throws IOException {
        byte[] keyBytes = Files.readAllBytes(Paths.get(keyFilePath));
        byte[] inputBytes = Files.readAllBytes(Paths.get(inputFilepath));
        byte[] result;
        if (modeOfOperation.equals("E"))
            result = encrypt(keyBytes, inputBytes);
        else
            result = decrypt(keyBytes, inputBytes);
        Files.write(Paths.get(outputFilePath), result);
    }

    private byte[] encrypt(byte[] keyBytes, byte[] inputBytes) {
        byte[] paddedInputBytes = padProcess(inputBytes);
        byte[] xorResultBytes = xorProcess(keyBytes, paddedInputBytes);
        return swapProcess(keyBytes, xorResultBytes);
    }

    private byte[] decrypt(byte[] keyBytes, byte[] inputBytes) {
        byte[] preXorBytes = swapProcess(keyBytes, inputBytes);
        byte[] originalBytes = xorProcess(keyBytes, preXorBytes);
        return unpadProcess(originalBytes);
    }

    private byte[] padProcess(byte[] inputBytes) {
        int originalLength = inputBytes.length;
        int paddedLength = ((originalLength + BLOCKSIZE - 1) / BLOCKSIZE) * BLOCKSIZE;
        byte[] paddedInputBytes = new byte[paddedLength];
        System.arraycopy(inputBytes, 0, paddedInputBytes, 0, originalLength);
        for (int i = originalLength; i < paddedLength; i++)
            paddedInputBytes[i] = PADDINGBYTE;
        return paddedInputBytes;
    }

    private byte[] unpadProcess(byte[] inputBytes) {
        int newLength = inputBytes.length;
        while (newLength > 0 && inputBytes[newLength - 1] == PADDINGBYTE)
            newLength--;
        return Arrays.copyOf(inputBytes, newLength);
    }

    private byte[] xorProcess(byte[] keyBytes, byte[] inputBytes) {
        int inputLength = inputBytes.length;
        byte[] xorResultBytes = new byte[inputLength];
        for (int i = 0; i < inputLength; i++)
            xorResultBytes[i] = (byte) (keyBytes[i % BLOCKSIZE] ^ inputBytes[i]);
        return xorResultBytes;
    }

    private byte[] swapProcess(byte[] keyBytes, byte[] xorResultBytes) {
        for (int i = 0; i < xorResultBytes.length; i += BLOCKSIZE) {
            byte[] xorBlock = Arrays.copyOfRange(xorResultBytes, i, i + BLOCKSIZE);
            swapProcessHelper(keyBytes, xorBlock);
            System.arraycopy(xorBlock, 0, xorResultBytes, i, BLOCKSIZE);
        }
        return xorResultBytes;
    }

    private void swapProcessHelper(byte[] keyBytes, byte[] xorBlock) {
        int start = 0;
        int end = BLOCKSIZE - 1;
        int keyIndex = 0;
        while (start < end) {
            byte keyByte = keyBytes[keyIndex % BLOCKSIZE];
            if (keyByte % 2 == 1) {
                byte temp = xorBlock[start];
                xorBlock[start] = xorBlock[end];
                xorBlock[end] = temp;
                end--;
            }
            start++;
            keyIndex++;
        }
    }
}
