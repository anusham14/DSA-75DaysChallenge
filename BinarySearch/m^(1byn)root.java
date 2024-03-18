public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
      // partially correct solution
       int s = 1 , e = m;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(multiply(mid,n) >m) e = mid-1;
            else if(multiply(mid,n) < m) s = mid+1;
            else if(multiply(mid,n) == m) return  mid;
        }
        return -1;
    }

    public static int multiply(int num,int n){
        int ans = 1 ;
        for(int i=0;i<n;i++){
            ans *= num;
        }
        return ans;
    }

}
