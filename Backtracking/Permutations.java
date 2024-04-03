//https://leetcode.com/problems/permutations/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permu(nums,ans,list,0);
        return ans;
    }

    public void permu(int[] nums,List<List<Integer>> ans,List<Integer> list,int index){

        //if last index reached exit the function
        if(index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            permu(nums,ans,list,index+1);
            list.remove(list.size()-1);

        }
    }
}
