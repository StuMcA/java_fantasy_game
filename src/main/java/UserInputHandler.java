import java.io.InputStream;
import java.util.Scanner;

public class UserInputHandler {
    public Scanner getScanner(InputStream inputStream) {
        return new Scanner(inputStream);
    }
}
