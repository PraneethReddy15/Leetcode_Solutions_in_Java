class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n= intervals.length;
        int res[][]= new int[n][2];
        res[0]=intervals[0];
        int e=0;
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<=res[e][1])
            {
                res[e][1]= Math.max(res[e][1], intervals[i][1]);
            }
            else{
                e++;
                res[e]= intervals[i];
            }  
        }
        return Arrays.copyOfRange(res,0,e+1);
    }
}