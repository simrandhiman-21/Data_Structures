import java.util.*;

public class compareBoth {
   public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String str="hello";

        int iterations=1_000_000;

        StringBuilder sb=new StringBuilder();
        long starttime= System.nanoTime();

        for(int i=0;i<iterations;i++){
            sb.append(str);
        }
        long endtime=System.nanoTime();
        long diffsb=starttime-endtime;

        
        StringBuffer buff=new StringBuffer();
        long starttimebuff= System.nanoTime();
        
        for(int i=0;i<iterations;i++){
            buff.append(str);
        }
        
        long endtimebuff=System.nanoTime();
        long diffbuff=starttimebuff-endtimebuff;

        System.out.println("Time taken by StringBuilder: " + diffsb / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuffer: " + diffbuff / 1_000_000 + " ms");




   } 
}
