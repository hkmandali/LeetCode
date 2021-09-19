import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.AbstractExecutorService;

public class MaxTaxi {
    class Point implements Comparable<Point>
    {
        int start;
        int end;
        int money;
        Point(int x,int y,int z)
        {
            this.start =x;
            this.end =y;
            this.money =z;
        }

        @Override
        public int compareTo(Point o) {
            if(this.end < o.end)
            {
                return -1;
            }
            else if(this.end > o.end)
            {
                return 1;
            }
            else
                return this.start < o.start ? -1 :1;
        }
    }

    public long maxTaxiEarnings(int n, int[][] rides) {

        if(null == rides || 0 == rides.length)
        {
            return 0;
        }
        int len = rides.length;
        long[] ret = new long[len];
        Point[] ridearray = new Point[len];
        for(int i=0;i< rides.length;++i)
        {
            ridearray[i] = new Point(rides[i][0],rides[i][1],rides[i][2]);
        }
        Arrays.sort(ridearray);
        for(int i=0;i< ridearray.length;++i)
        {
            System.out.println(ridearray[i].start +"  "+ridearray[i].end+"  "+ridearray[i].money);
        }
        int length = ret.length;
        ret[0] = ridearray[0].money+ridearray[0].end - ridearray[0].start;
        for(int i=1;i<length;++i)
        {
            long curr_profit = ridearray[i].money+ ridearray[i].end -ridearray[i].start;
            int best_match = searchlatestindex(ridearray,i);
            if(best_match != -1)
                curr_profit += ret[best_match];
            ret[i] = Math.max(ret[i-1],curr_profit);
        }
        return ret[ret.length-1];
    }
    // this method is used to search the best job without overlapping the current one
    int searchlatestindex(Point[] rides,int currindex)
    {
        int start_index=0,end_index= currindex-1;
        while(start_index <= end_index)
        {
            int mid_index = start_index+(end_index-start_index)/2;
            if(rides[mid_index].end <= rides[currindex].start)
            {
                if(rides[mid_index+1].end > rides[currindex].start)
                {
                    return mid_index;
                }
                else
                    start_index = mid_index+1;
            }
            else
                end_index = mid_index-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] input = new int[][]{{13,18,1},{1,6,1},{11,12,2},{3,10,2},{10,12,3},{12,15,2}};

        System.out.println("the max profit we can achieve is "+new MaxTaxi().maxTaxiEarnings(20,input));
    }
}
