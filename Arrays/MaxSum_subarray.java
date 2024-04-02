https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0 ,max_sum = Integer.MIN_VALUE , n = nums.length,i=0;
        while(i<n){
            sum+= nums[i];
            
            if(sum>max_sum) max_sum = sum;
            if(sum<0) {
                sum = 0;
            }
            i++;
        }
        return max_sum;
    }
}
