//https://leetcode.com/problems/first-missing-positive/
class Solution {
    public int firstMissingPositive(int[] nums) {

        cyclicSort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }
    void cyclicSort(int[] arr){
        int i=0, n = arr.length;
        while(i<n){
            int correct = arr[i]-1;
            if(arr[i]>0 && arr[i]<=n && arr[i] != arr[correct]) swap(arr,i,correct);
            else i++;
        }
    }

    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
