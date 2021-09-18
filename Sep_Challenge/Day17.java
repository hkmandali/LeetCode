import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day17 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ret;
        if(null == nums1 || null == nums2)
        {
            return null;
        }
        HashMap<Integer,Integer> countmap1 = new HashMap<>();
        for (int j : nums1) {
            countmap1.put(j, countmap1.getOrDefault(j, 0) + 1);
        }
        ret = new ArrayList<>();
        for (int j : nums2) {
            if (countmap1.containsKey(j)) {
                countmap1.put(j, countmap1.get(j) - 1);
                if (countmap1.get(j) == 0) {
                    countmap1.remove(j);
                }
                ret.add(j);
            }
        }

        return ret.stream().mapToInt(i -> i).toArray();

    }
    public static void main(String[] args) {
        System.out.println("value is "+ Arrays.toString(new Day17().intersect(new int[]{4,9,5},new int[]{9,4,9,8,4})));
    }
}
