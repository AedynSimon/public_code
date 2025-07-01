import java.nio.file.Files;
import java.nio.file.Paths;

public class ErrorChecking {
    
    private String cipherType = "";
    private String inputFilePath = "";
    private String keyFilePath = "";
    private String modeOfOperation = "";

    public ErrorChecking(String cipherType, String inputFilePath, String keyFilePath, String modeOfOperation) {
        this.cipherType = cipherType;
        this.inputFilePath = inputFilePath;
        this.keyFilePath = keyFilePath;
        this.modeOfOperation = modeOfOperation;
    }

    public void process() {
        checkCipherType();
        checkInputFilePath();
        checkKeyFilePath();
        checkModeOfOperation();
    }

    private void checkCipherType() {
        if (!cipherType.equals("B") && !cipherType.equals("S")) {
            System.err.println("Invalid Function Type");
            System.exit(1);
        }
    }

    private void checkInputFilePath() {
        if (!Files.exists(Paths.get(inputFilePath))) {
            System.err.println("Input File Does Not Exist");
            System.exit(1);
        }
    }

    private void checkKeyFilePath() {
        if (!Files.exists(Paths.get(keyFilePath))) {
            System.err.println("Key File Does Not Exist");
            System.exit(1);
        }
    }

    private void checkModeOfOperation() {
        if (!modeOfOperation.equals("E") && !modeOfOperation.equals("D")) {
            System.err.println("Invalid Mode Type");
            System.exit(1);
        }
    }
}
