class Solution {
    public int subsetXORSum(int[] nums) {
        int xor=0;
        for(int i=0;i<(1<<nums.length);i++)
        {
            int j=nums.length-1;
            int temp=i,x1=0;
            while(temp>0)
            {
                if((temp&1)==1) x1^=nums[j];
                temp>>=1;
                j--;
            }
            xor+=x1;
        }
        return xor;
    }
}