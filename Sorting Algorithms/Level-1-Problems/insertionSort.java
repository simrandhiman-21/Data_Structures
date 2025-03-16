import java.util.*;
        public class insertionSort{
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
            insertionsortfunc(arr,n);
        }

        static void insertionsortfunc(int[] arr,int n){

               for(int i=1;i<n;i++){
                   int curr = i;
                   int prev=i-1;
                    while(prev>=0 && arr[prev]>curr){
                        arr[prev+1]=arr[prev]; 
                        prev--;
                    }
                    arr[prev+1]=curr;
               }
            
                System.out.println("Printing array ");
                for(int i:arr){
                    System.out.print(i+" ");
                }
    
        }
    }
