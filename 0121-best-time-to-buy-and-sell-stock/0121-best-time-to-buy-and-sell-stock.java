class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int l=0;
        int r=1;
        while(r<prices.length)
        {
            if(prices[r]>prices[l])
            {
                int profit=prices[r]-prices[l];
                max=Math.max(max,profit);
            }
            else{
                l=r;
            }
            r++;
        }
        return max;
    }
}