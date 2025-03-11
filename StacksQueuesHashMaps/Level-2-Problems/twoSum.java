import java.util.*;
public class twoSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int key=sc.nextInt();
        int[] ans=twoSumfunc(arr,n,key);
        if(ans[0]==-1){
            System.out.println("No two sum solution");
        }else{
            System.out.println("Indices: " + ans[0] + " " + ans[1]);
        }

    }
    static int[] twoSumfunc(int[] arr,int n,int key){
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int find=0;
        for(int i=0;i<n;i++){
            find=key-arr[i];
            if(map.containsKey(find)){
                return new int[]{map.get(find),i};
            }
            map.put(arr[i],i);
        }     
        return new int[]{-1,-1};
    }
    
}
