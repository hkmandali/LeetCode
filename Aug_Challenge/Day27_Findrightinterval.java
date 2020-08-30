https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3438/
class Point implements Comparable<Point>
{
    int x;
    int y;
    int index;
    Point(int x,int y,int index)
    {
        this.x = x;
        this.y = y;
        this.index = index;
    }
    public int compareTo(Point p)
    {
        if(this.x == p.x)
        {
            return this.y - p.y;
        }
        return this.x - p.x;
    }
}

class Solution {
    int binarysearch(Point[] points,int y)
    {
        int len = points.length;
        if(y > points[len-1].x)
        {
            return -1;
        }
        int left = 0;
        int right = len-1;
        while(left <= right)
        {
            int mid = left + (right -left)/2;
            if(points[mid].x >= y)
            {
                right = mid-1;
            }
            else
                left = mid+1;
        }
        
        return points[left].index;
    }
    public int[] findRightInterval(int[][] intervals) {
        if(null == intervals || 0 == intervals.length)
        {
            return null;
        }
        int row = intervals.length;
        int[] ret = new int[row];
        //Arrays.fill(ret,-1);
        Point[] points = new Point[row];
        
        for(int i=0;i<row;++i)
        {
            points[i] = new Point(intervals[i][0],intervals[i][1],i);
        }
        Arrays.sort(points);
        /*
        for(int i=0;i<points.length;++i)
        {
            System.out.println(points[i].x +"  "+points[i].y);
        }
        */
        for(int i=0;i<row;++i)
        {
            ret[i] = binarysearch(points,intervals[i][1]);
        }
        
        return ret;
    }
}