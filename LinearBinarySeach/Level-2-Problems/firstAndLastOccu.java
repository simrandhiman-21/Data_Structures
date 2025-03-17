import java.util.*;
public class firstAndLastOccu {
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


    int start=0;
    int end=n-1;
    
    int a=-1;
    int b=-1;

    while(start<=end){
        int mid=(start+end)/2;
        if(arr[mid]==key)
        {
            int temp=mid;
            int temp2=mid;
            while(temp>=0 && arr[temp]==key){
                a=temp;
                temp--;
            }   
            
            while(temp2<n && arr[temp2]==key){
                b=temp2;
                temp2++;
            }
            break;
        }

        if(arr[mid]<key){
            start=mid+1;
        }
        else{
            end=mid-1;
        }
    }
    if (a != -1) {
        System.out.println("First index at " + a + ", Last index at " + b);
    } else {
        System.out.println("Key not found.");
    }
        
    }
}
