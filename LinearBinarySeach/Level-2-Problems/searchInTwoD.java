import java.util.*;
public class searchInTwoD {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

    System.out.println("Enter the number of elements in the Matrix");
    int n=sc.nextInt();
    sc.nextLine();
    

    int matrix[][]=new int[n][n];
    System.out.println("Enter the elements of the Matrix");
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++){
            matrix[i][j]=sc.nextInt();
        }
    }
    int key=sc.nextInt();
    sc.nextLine();
    boolean flag=false;
    int row=0;
    int col=0;

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++){
            if(matrix[i][j]==key){
                row=i;
                col=j;
                flag=true;
            }
        }
    }
    if(flag){
        System.out.println("Found key at index row"+row+" col"+col);
    }
    else{
        System.out.println("Key not found");
    }


    }
    
}
