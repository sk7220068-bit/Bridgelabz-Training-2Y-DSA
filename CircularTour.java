
public class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0;
        int surplus = 0;
        int totalSurplus = 0;

        for (int i = 0; i < n; i++) {
            int net = petrol[i] - distance[i];
            totalSurplus += net;
            surplus += net;

            if (surplus < 0) {
                start = i + 1;
                surplus = 0;
            }
        }

        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = { 4, 6, 7, 4 };
        int[] distance = { 6, 5, 3, 5 };
        System.out.println(findStartingPoint(petrol, distance));
    }
}
