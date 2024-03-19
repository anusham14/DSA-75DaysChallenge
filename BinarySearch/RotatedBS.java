//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
class Solution {
    public int search(int[] nums, int target) {

        int pivot = findPivot(nums);
        //int s = 0 , e = nums.length-1;
        if(pivot == -1){
            
            return binarySearch(nums,target,0,nums.length-1);
        } 
        if (nums[pivot] == target) {
            return pivot;
        }
        else if(target >= nums[0])  
            return binarySearch(nums,target,0,pivot-1);
        
        return binarySearch(nums,target,pivot+1,nums.length-1);
    }

    public int binarySearch(int[] nums , int target, int s ,int e){
        while(s<=e){

            int mid = s + (e-s)/2;
            if(nums[mid] < target) s = mid+1;
            else if(nums[mid] > target) e = mid-1;
            else if(nums[mid] == target) return mid;
           
        }
         return -1;
    }

    int findPivot(int[] arr){
        int start = 0 , end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid > start && arr[mid-1] > arr[mid])
                return mid-1;
            else if(mid < end && arr[mid] > arr[mid+1])
                return mid;
            else if(arr[start]>= arr[mid]) end = mid-1;
            else start = mid+1;

        }
        return -1;
    }
}
