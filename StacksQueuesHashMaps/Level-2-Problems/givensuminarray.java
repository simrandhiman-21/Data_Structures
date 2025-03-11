import java.util.*;

public class givensuminarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        func(arr, n, 0);
    }

    public static void func(int[] arr, int n, int key) {        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(Arrays.asList(-1))); // Handle case where prefix sum itself is k

        int sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            if (map.containsKey(sum - key)) {
                for (int start : map.get(sum - key)) {
                    System.out.println((start + 1) + " " + j); // Printing 0-based index in required format
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(j);
        }
    }
}
