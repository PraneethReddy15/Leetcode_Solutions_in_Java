class Solution {
    //  static {
    //     Runtime.getRuntime().gc();
    //     Runtime.getRuntime().addShutdownHook(new Thread(() -> {
    //         try (FileWriter writer = new FileWriter("display_runtime.txt")) {
    //             writer.write("0");
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    //     }));
    // }
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
