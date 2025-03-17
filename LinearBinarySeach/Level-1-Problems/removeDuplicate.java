import java.util.*;
public class removeDuplicate {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=sc.nextLine();
        StringBuilder sb=new StringBuilder(str);
        HashSet<Character> set=new HashSet<>();
        
        for(int i=0;i<sb.length();i++){
            set.add(sb.charAt(i));
        }

        for(char i:set){
            System.out.println(i+" ");
        }
        
    }
    
}
