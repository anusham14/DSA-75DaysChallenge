//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeDuplicates(int[] nums) {
        //i keeps the main ele 
        //j keeps track if main ele is repeated or not 
        
        int i = 0 , j = 0;
        for(int k=0;k<nums.length;k++){
            //if not j searches further
            if(nums[i]==nums[j]) j++;
            //if yes then exchange i's next ele to repeated ele
            else{
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return i+1;
    }
}
