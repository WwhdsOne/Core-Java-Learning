package Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class 普通快排 {
    public static void main(String[] args) {
        // Generate 100 million numbers
        int[] numbers = new int[100000000];
        Random random = new Random();
        for (int i = 0; i < 100000000; ++i) {
            numbers[i] = random.nextInt(1000000000);
        }

        // Start timing
        long start = System.nanoTime();

        // Sort the numbers
        Arrays.sort(numbers);

        // Stop timing
        long end = System.nanoTime();
        long durationInNano = (end - start);  //Total execution time in nano seconds

        // Converting the time to milliseconds
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(durationInNano);  //Total execution time in milliseconds

        // Print the time taken
        System.out.println("Sorting took " + durationInMillis + " milliseconds.");
    }
}
