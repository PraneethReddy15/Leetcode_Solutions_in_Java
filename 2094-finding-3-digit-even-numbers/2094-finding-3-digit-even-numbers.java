class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> al = new HashSet<>();
        Map<Integer,Integer> m= new HashMap<>();
        for(int i : digits)
        {
            m.put(i,m.getOrDefault(i,0)+1);
        }
        for(int i=100;i<=998;i++)
        {
            Map<Integer,Integer> m1=new HashMap<>();
            int x=i;
            boolean res=true;
            if(x%2==0)
            {
                while(x>0)
                {
                    int rem=x%10;
                    m1.put(rem,m1.getOrDefault(rem,0)+1);
                    if(m.containsKey(rem)==false || m1.get(rem)>m.get(rem)){
                        res=false;
                        break;
                    }
                    x/=10;
                }
                if(res)
                {
                    al.add(i);
                }
            }
        }
        int x=0;
        int arr[]= new int[al.size()];
        for(int i : al)
        {
            arr[x++]=i;
        }
        Arrays.sort(arr);
        return arr;
    }
}