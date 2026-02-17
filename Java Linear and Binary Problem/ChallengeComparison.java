import java.io.*;

public class ChallengeComparison {

    public static void main(String[] args) {
        compareStringConcatenation();
        compareFileReading();
    }

    public static void compareStringConcatenation() {
        int iterations = 1000000;
        String text = "hello";

        long startTimeBuffer = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbBuffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        long startTimeBuilder = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbBuilder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        System.out.println("--- String Concatenation ---");
        System.out.println("StringBuffer Time: " + durationBuffer + " ns");
        System.out.println("StringBuilder Time: " + durationBuilder + " ns");
    }

    public static void compareFileReading() {
        String filePath = "input.txt";

        long startTimeFileReader = System.nanoTime();
        try (FileReader fr = new FileReader(filePath);
                BufferedReader br = new BufferedReader(fr)) {
            while (br.readLine() != null) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimeFileReader = System.nanoTime();
        long durationFileReader = endTimeFileReader - startTimeFileReader;

        long startTimeISR = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(filePath);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr)) {
            while (br.readLine() != null) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimeISR = System.nanoTime();
        long durationISR = endTimeISR - startTimeISR;

        System.out.println("--- File Reading ---");
        System.out.println("FileReader Time: " + durationFileReader + " ns");
        System.out.println("InputStreamReader Time: " + durationISR + " ns");
    }
}
