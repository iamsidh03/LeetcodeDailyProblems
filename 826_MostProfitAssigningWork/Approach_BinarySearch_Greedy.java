 import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
 public class Approach_BinarySearch_Greedy{
    public static void main(String[] args) {
       int[] difficulty = {2,4,6,8,10}, profit = {10,20,30,40,50}, worker = {4,5,6,7};
       System.out.println("Maximum Profit :"+maxProfitAssign(difficulty, profit, worker));
        }
        public static int maxProfitAssign(int []difficulty, int []profit ,int []worker){
                List<int[]> jobprofile =new ArrayList<>();
                jobprofile.add(new int[]{0,0});
                for(int i=0;i<difficulty.length;i++){
                    jobprofile.add(new int[]{difficulty[i],profit[i]});
        }
        Collections.sort(jobprofile, (a,b) ->Integer.compare(a[0],b[0]));
        for (int i = 0; i < difficulty.length; i++) {
            jobprofile.get(i+1)[1]=Math.max(jobprofile.get(i)[1],jobprofile.get(i+1)[1]);            
        }

        int netProfite=0;
        for(int i=0;i<worker.length;i++){
                int ability=worker[i];
                int jobprofit=0;
                int l=0,r=jobprofile.size()-1;
                while(l<=r){
                    int mid=(l+r)/2;
                    if(jobprofile.get(mid)[0]<=ability){
                        jobprofit=Math.max(jobprofit,jobprofile.get(mid)[1]);
                        l=mid+1;
                
                    }
                    else{
                        r=mid-1;
                    }
                   }
                   netProfite+=jobprofit;
    
}
return netProfite;
 }
}