class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums)
        {
            hs.add(i);
        }
        
        int count=0;

        for(int i: hs)
        {
            if(hs.contains(i-1)) continue;
            int c=0;
            int x=i;
            if(!hs.contains(i-1))
            {
                while(hs.contains(x++))
                {
                    c++;
                }
            }
            count=Math.max(count,c);
        }
        return count;
    }
}
