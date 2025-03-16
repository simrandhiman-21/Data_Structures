import java.util.*;
class bubblesort{
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
        bubblesortfunc(arr,n);
    }
    static void bubblesortfunc(int[] arr,int n){

            for(int i=0;i<n;i++){
                for(int j=0;j<n-i-1;j++){
                    if(arr[j]>arr[j+1]){
                        int swap=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=swap;
                    }
                }
            }

            System.out.println("Printing array ");
            for(int i:arr){
                System.out.print(i+" ");
            }

    }
}