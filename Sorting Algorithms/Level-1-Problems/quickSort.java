import java.util.Scanner;

public class quickSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of products:");
        int n = sc.nextInt();
        double[] prices = new double[n];

        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextDouble();
        }
        sc.close();

        quickSort(prices, 0, n - 1);

        System.out.println("Sorted product prices:");
        for (double price : prices) {
            System.out.print(price + " ");
        }
    }

    static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(double[] arr, int low, int high) {
        double pivot = arr[high]; // Choosing last element as pivot
        int i = low - 1; // Pointer for the smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { 
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high); // Place pivot in the correct position
        return i + 1; // Return pivot index
    }

    static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

