import java.util.Scanner;

class concatenate{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();  // leftover line consume
        
        String[] strarr=new String[n];

        for(int i=0;i<n;i++){
            strarr[i]=sc.nextLine();
        }
        StringBuffer sb=new StringBuffer();

        for(String word:strarr){
            sb.append(word);
        }
        System.out.println(sb.toString());
       
        

    }
}