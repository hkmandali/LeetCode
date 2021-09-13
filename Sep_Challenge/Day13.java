// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3973/
public class Day13 {
    int maxNumberOfBalloons(String text) {
        int[] countchar = new int[26];
        int occur;
        for(int i=0;i<text.length();++i)
        {
            countchar[text.charAt(i)-'a']++;
        }
        occur = Math.min(countchar[0],Math.min(countchar[0],Math.min(countchar[11]/2,Math.min(countchar[14]/2,countchar[13]))));
        return occur;
    }
    public static void main(String[] args) {
        System.out.println("the max num of balloons are "+new Day13().maxNumberOfBalloons("loonbalxballpoon"));
    }
}
