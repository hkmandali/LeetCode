class Solution {
    int circle ;// this is num of courses
    public boolean findcourseOrder(int[] order,int[] visited,HashMap<Integer,List<Integer>> prereq,int currCourse)
    {
        if(visited[currCourse] == -1)
            return false;
        if(visited[currCourse] == 1)
            return true;
       visited[currCourse] = -1;
        if(prereq.containsKey(currCourse)) {
            List<Integer> dest = prereq.get(currCourse);
            for (int i :dest) {

                int course = i; // iterating through all the courses
                //System.out.println("course is "+course);
                if (!findcourseOrder(order, visited, prereq, course)) {
                    //System.out.println("calling find course util for " + course);
                    return false;
                }
            }
        }
        visited[currCourse] = 1;
        order[circle--]=currCourse;
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        circle = numCourses-1;
        int[] ret = new int[numCourses];
        if(null == prerequisites)
        {
            for(int i=0;i<numCourses;++i)
            {
                ret[i] =i;
            }
        }
        else {
            if (null != prerequisites) {
                int row = prerequisites.length;
                int col =0;
                if(row > 0)
                {
                    col =prerequisites[0].length;
                }
                //System.out.println("row is  "+row+"   col is "+col);
                if(0 == row || 0 ==col)
                {
                    for(int i=0;i<numCourses;++i)
                    {
                        ret[i] =i;
                    }
                    return ret;
                }
                HashMap<Integer, List<Integer>> map = new HashMap<>();
                for(int i=0;i<prerequisites.length;++i)
                {
                    int vertex = prerequisites[i][1];
                    int dest = prerequisites[i][0];
                    if(map.containsKey(vertex))
                    {
                        List<Integer> already = map.get(vertex);
                        already.add(dest);
                        map.put(vertex,already);
                    }
                    else
                    {
                        List<Integer> adding = new ArrayList<>();
                        adding.add(dest);
                        map.put(vertex,adding);
                    }

                }/*
                for(int i:map.keySet())
                {
                    System.out.println("map is "+ map.get(i).toString());
                }
                */
                int[] visited = new int[numCourses];
                for (int i = 0; i < numCourses; ++i) {
                    if (!findcourseOrder(ret, visited, map, i)) {
                  //      System.out.println("calling find course for " + i);
                        return new int[0];
                    }
                }
                
                return ret;
            }
        }
        return null;
    }
}