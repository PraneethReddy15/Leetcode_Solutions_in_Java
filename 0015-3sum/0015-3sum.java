class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res= new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            int l=i+1;
            int r= nums.length-1;
            int x= nums[i];
            while(l<r)
            {
                List<Integer> temp = new ArrayList<>();
                if(x+nums[l]+nums[r]==0)
                {
                    temp.add(x);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    l++;
                    r--;
                }
                else if(x+nums[l]+nums[r]<0)
                {
                    l++;
                }
                else r--;
               
                // temp.clear();
            }
        }
        List<List<Integer>> al = new ArrayList<>();
        for(List<Integer> i : res)
        {
            al.add(i);
        }
        return al;
    }
}
