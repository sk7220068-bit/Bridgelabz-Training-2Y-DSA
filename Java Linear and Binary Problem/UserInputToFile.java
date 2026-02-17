import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInputToFile {

    public static void main(String[] args) {
        String filePath = "output_from_user.txt";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                FileWriter fw = new FileWriter(filePath)) {

            System.out.println("Enter text to write to file (type 'exit' to stop):");
            String line;
            while (true) {
                line = br.readLine();
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }
                fw.write(line + System.lineSeparator());
            }
            System.out.println("Data written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
