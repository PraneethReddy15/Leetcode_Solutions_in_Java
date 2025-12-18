class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=0;
        int min=Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++)
        {
            max+=weights[i];
            min=Math.max(min,weights[i]);
        }
        // System.out.println(min+" "+max);
        while(min<=max)
        {
            int mid=min+(max-min)/2;
            if(canShip(mid,weights,days))
            {
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return min;
    }
    public boolean canShip(int mid, int[] weights, int days)
    {
        int dayCount=1;
        int curLoad=0;
        for(int i=0;i<weights.length;i++)
        {
            if(curLoad+weights[i]>mid)
            {
                dayCount++;
                curLoad=0;
            }
            curLoad+=weights[i];
            if(dayCount>days)
            {
                return false;
            }
        }
        return true;
    }
}