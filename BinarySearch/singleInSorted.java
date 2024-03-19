//https://leetcode.com/problems/single-element-in-a-sorted-array/
class Solution {
    public int singleNonDuplicate(int[] nums) {

        //if all numbers are repeating twice means ele at even == ele at odd
        //if mid is in even arr[mid]==arr[mid+1] it means the single ele is in right
        //if mid is odd means single ele is in left
        int start = 0 , end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mid %2 == 1) mid--;
            if(nums[mid] == nums[mid+1]) start = mid+2;
            else end = mid;
        }
        return nums[start];
        
    }
}
