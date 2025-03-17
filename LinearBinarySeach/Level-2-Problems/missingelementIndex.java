import java.util.*;
public class missingelementIndex {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);

            System.out.println("Enter the number of elements in the array");
            int n=sc.nextInt();
            // sc.nextLine();

            int arr[]=new int[n];
            System.out.println("Enter the elements of the Array");
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }

            System.out.println("Enter the element to be searched");
            int key=sc.nextInt();

            int element=findmissingindex(arr);
            int index=findindex(arr,key);

            System.out.println("Mising element is "+ element);
            System.out.println("index of element is "+ index);
        }
        static int findmissingindex(int[] arr){
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]!=i+1){
                    return arr[i]+1;
                }
            }
            return -1;
        }
        static int findindex(int[] arr,int key){

            int n=arr.length;
            int start=0;
            int end=n-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(arr[mid]==key){
                    return mid;
                }
                else if(arr[mid]<key){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        return -1;
        }         
}
