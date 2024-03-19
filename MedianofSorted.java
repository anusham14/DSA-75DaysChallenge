//Brute force 
//https://leetcode.com/problems/median-of-two-sorted-arrays/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length , len2 = nums2.length , i=0 , j=0 ,k=0;
        int[] store = new int[len1+len2];
        while(i<len1 && j<len2){
            if(nums1[i] <= nums2[j]){
                store[k] = nums1[i];
                i++;
            }
            else{
                store[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<len1){
            store[k] = nums1[i];
            i++; k++;
        }
        while(j<len2){
            store[k] = nums2[j];
            j++; k++;
        }
        int total_len = len1+len2 , start = 0;
        double median = 0.0;
        int mid = start + (total_len-start)/2;
        if(total_len % 2 ==0){
            median = (store[mid]+store[mid-1])/2.0;
        }
        else
            median = store[mid];
        return median;
    }
    
}
