import java.util.Scanner;

public class reverseString {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=sc.nextLine();
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        //String rev=sb.reverse().toString();
        System.out.println("Reversed string is: "+sb.toString());



        
    }
}
