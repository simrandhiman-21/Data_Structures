import java.util.Scanner;

public class countingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int n = sc.nextInt();
        int[] ages = new int[n];

        System.out.println("Enter the ages of students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
            if (ages[i] < 10 || ages[i] > 18) {
                System.out.println("Invalid age! Please enter a value between 10 and 18.");
                i--; // Re-enter valid age
            }
        }
        sc.close();

        countingSort(ages, 10, 18); // Sorting ages in the given range

        System.out.println("Sorted student ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }

    static void countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;  // Range of ages (10 to 18 -> 9 values)
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Step 1: Count occurrences of each age
        for (int num : arr) {
            count[num - min]++;
        }

        // Step 2: Compute cumulative frequencies
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in correct position
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Step 4: Copy sorted values back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
