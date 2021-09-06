import java.math.BigInteger;

public class Day06 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int len = releaseTimes.length;
        int max_index = 0;
        int max_time =releaseTimes[0];
        for(int i=1;i<len;++i)
        {
            //System.out.println("max index after " + i+  " iteration  is "+keysPressed.charAt(max_index));
            if(releaseTimes[i]-releaseTimes[i-1] > max_time)
            {
                max_index = i;
                max_time = releaseTimes[i]-releaseTimes[i-1];
            }
            else if(releaseTimes[i]-releaseTimes[i-1] == max_time)
            {
                if(keysPressed.charAt(i)-'0' > (keysPressed.charAt(max_index)-'0'))
                {
                    max_index = i;
                    max_time = releaseTimes[i]-releaseTimes[i-1];
                }
            }
        }
        //char ret = (char)(keysPressed.charAt(max_index));
        return keysPressed.charAt(max_index);
    }
    public static void main(String[] args) {
        int[] releaseTimes = {12,23,36,46,62};
        String keys = "spuda";
        System.out.println("the max char is "+new Day06().slowestKey(releaseTimes,keys));
    }
}
