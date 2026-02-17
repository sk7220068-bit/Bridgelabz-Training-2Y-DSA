public class NullPointerDemo {
    public static void main(String[] args) {
        generateException();
        handleException();
    }

    public static void generateException() {
        System.out.println("Generating NullPointerException:");
        String text = "Bridgelabz";
        try {
            System.out.println(text.length());
        } catch (Exception e) {
            System.out.println("Exception caught in generateException: " + e);
        }
    }

    public static void handleException() {
        System.out.println("\nHandling NullPointerException:");
        String text = "Bridgelabz";
        try {
            System.out.println(text.charAt(0));
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
