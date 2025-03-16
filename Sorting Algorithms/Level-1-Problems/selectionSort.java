import java.util.*;
        public class selectionSort {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter size of array ");
            int n=sc.nextInt();
            System.out.println("Enter Elements of Array");
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            Selectionsortfunc(arr,n);
        }
        static void Selectionsortfunc(int[] arr,int n){

               for(int i=0;i<n-1;i++){
                int minIndex = i;
                    for (int j = i + 1; j < n; j++) {
                        if(arr[minIndex]>arr[j]){
                            minIndex = j;
                        }
                    }
                    int swap=arr[minIndex];
                    arr[minIndex]=arr[i];
                    arr[i]=swap;
               }
            
                System.out.println("Printing array ");
                for(int i:arr){
                    System.out.print(i+" ");
                }
    
        }
    }
