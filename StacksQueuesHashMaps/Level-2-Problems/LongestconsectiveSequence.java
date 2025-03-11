import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

class LongestconsectiveSequence{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        func(arr,n);
    }

    static void func(int[] arr,int n){
        TreeMap<Integer, Boolean> map = new TreeMap<>();
        for(int i=0;i<n;i++){            
            map.put(arr[i],true);
        }
        int maxlen=0;
        int currcount=0;
        int prev=Integer.MIN_VALUE;
        for(int num:map.keySet()){
            if(num==prev+1) currcount++;
            else currcount=1;
            maxlen=Math.max(maxlen,currcount);
            prev=num;
        }
        System.out.println("Longest Consecutive is "+maxlen);
    }    
}
