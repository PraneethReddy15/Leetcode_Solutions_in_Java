class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max=0;
        HashSet<Integer> set = new HashSet<>();
            int sum=0;
        int left=0, res=0;
        for(int right=0;right<nums.length;right++)
        {
            while(set.contains(nums[right]))
            {
                set.remove(nums[left]);
                sum-=nums[left];
                left++;
            }
            set.add(nums[right]);
            sum+=nums[right];
            // for(int i : set)
            // {
            //     sum+=i;
            // }
            res=Math.max(res,sum);
            // System.out.println(set);
        }
        return res;
    }
}