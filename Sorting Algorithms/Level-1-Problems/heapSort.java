import java.util.Scanner;

public class heapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of applicants:");
        int n = sc.nextInt();
        double[] salaries = new double[n];

        System.out.println("Enter the expected salary demands:");
        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextDouble();
        }
        sc.close();

        heapSort(salaries);

        System.out.println("Sorted salary demands:");
        for (double salary : salaries) {
            System.out.print(salary + " ");
        }
    }

    static void heapSort(double[] arr) {
        int n = arr.length;

        // Step 1: Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Swap root (largest) with last element
            swap(arr, 0, i);
            
            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    static void heapify(double[] arr, int n, int i) {
        int largest = i;  // Assume root is the largest
        int left = 2 * i + 1;  // Left child index
        int right = 2 * i + 2; // Right child index

        // Check if left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is larger than the largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest element is not the root, swap and heapify again
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
