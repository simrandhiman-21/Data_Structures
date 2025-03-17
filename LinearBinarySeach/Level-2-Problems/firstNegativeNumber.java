import java.util.Scanner;

public class firstNegativeNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int neg=-1;
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                neg=i;
                break;
            }
        }
        System.out.print("Index of first negative is "+neg);    
    }    
}
