import java.util.*;
public class FindPeakElement {
    public static void main(String[] args) {
        
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the number of elements in the array");
    int n=sc.nextInt();
    sc.nextLine();

    int arr[]=new int[n];
    System.out.println("Enter the elements of the Array");
    for(int i=0;i<n;i++)
    {
        arr[i]=sc.nextInt();
    }

    int start=0;
    int end=n-1;
    while(start<end){
        int mid=(start+end)/2;
        if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
            System.out.println("peak element is "+arr[mid] +"  at index "+mid);
            break;
        }
        else if(arr[mid]<arr[mid-1]){
            end=mid;
        }
        else{
            start=mid+1;
        }
    }
  }  
}
