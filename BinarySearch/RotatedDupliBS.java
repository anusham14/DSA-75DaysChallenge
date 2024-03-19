class Solution {
    public boolean search(int[] nums, int target) {

        int start = 0 , end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == nums[mid]) return true;

            //if duplicates present at both start & end skip that
            //pivot is the largest val after which it changes 
            if(nums[start] == nums[end] && nums[start]==nums[mid]){
                start++;
                end--;
            }

            //if duplicate present in 1st half or that array is increasing only
            else if(nums[start]<=nums[mid]){

                //if target lies in that range
                if(target>=nums[start] && target<nums[mid]) end = mid-1;
                //else target is in other half(might be non decresing)
                else start = mid+1;
            }
            //if duplicate present in 2nd half or that array is increasing only
            else{
                if(target> nums[mid] && target<=nums[end]) start = mid+1;
                else end = mid-1;
            }
        }
        return false;
    }

}
