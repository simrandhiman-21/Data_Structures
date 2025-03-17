import java.util.*;
public class search {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n=sc.nextInt();
        sc.nextLine();

        String arr[]=new String[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextLine();
        }
        System.out.println("Enter the element to be searched");
        String key=sc.nextLine();
        boolean flag=false;
        for(String word:arr){
            if(word.equals(key)){
                flag=true;
                break;
            }
        }
        if(flag){
            System.out.println("Word Found ");
        }
        else{
            System.out.println("Word Not Found");
        }
        
    }    
    
}
