import java.util.*;
        public class mergeSort {
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
            MergeSortfunc(arr,0,n-1);
            System.out.println("Printing array ");
            for(int z:arr){
                System.out.print(z+" ");
            }    
        }
        static void MergeSortfunc(int[] arr,int start ,int end){

                if(start>=end) return ;
                    int mid=(start+end)/2;
                    MergeSortfunc(arr, start,mid);
                    MergeSortfunc(arr, mid+1,end);
                
            int[] temp=new int[end-start+1];
            int i = start, j = mid + 1, k = 0;

                while (i <= mid && j <= end) {
                    if (arr[i] <= arr[j]) {
                        temp[k++] = arr[i++];
                    } else {
                        temp[k++] = arr[j++];
                    }
                }

                while (i <= mid) {
                    temp[k++] = arr[i++];
                }

                while (j <= end) {
                    temp[k++] = arr[j++];
                }
                //copy 
                System.arraycopy(temp, 0, arr, start, temp.length);
                
        }
    }
    