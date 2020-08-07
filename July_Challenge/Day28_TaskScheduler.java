class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(null == tasks || 0 == tasks.length)
            return 0;
        // we need to findout the maximum occurence character and schedule it first and the min time when it can be scheduled again is after n time frames 
        int[] count = new int[26];
        for(int i=0;i<tasks.length;++i)
        {
            count[tasks[i]-'A']++;
        }
        Arrays.sort(count);
        int max_charcount = count[25]; // max character count
        int spaces = (max_charcount-1)*n; // these are the maximum num of spaces which our final schedule can have , case when all of them are same characters
        
        for(int i=24;i>=0;--i)
        {
            spaces = spaces - Math.min(max_charcount-1,count[i]); // this is because if the max character and the current character are of the same count , we need to reduce -1 
            if(spaces <= 0 )
            {
                spaces =0;
                break;
            }
        }
        return tasks.length+spaces;
    }
}