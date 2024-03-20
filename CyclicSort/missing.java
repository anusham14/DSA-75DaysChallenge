//https://leetcode.com/problems/find-the-duplicate-number/
class Solution {
    public int findDuplicate(int[] nums) {
        cyclicSort(nums);
        for(int i=0;i<nums.length;i++){
            if(i+1 != nums[i]) return nums[i];
        }
        return -1;
    }

    void cyclicSort(int[] arr){
        int i=0, n = arr.length;
        while(i<n){
            int correct = arr[i]-1;
            if(arr[i] != arr[correct]) swap(arr,i,correct);
            else i++;
        }
    }

    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
