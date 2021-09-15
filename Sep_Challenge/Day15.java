public class Day15 {
    public int maxTurbulenceSize(int[] arr) {
        int max = 0, len = 0;

        for(int i = 0; i < arr.length; i++) {
            if(i >= 2 && ((arr[i-2] > arr[i-1] && arr[i-1] < arr[i]) ||
                    (arr[i-2] < arr[i-1] && arr[i-1] > arr[i])) ) {
                len++;
            } else if(i >= 1 && arr[i-1] != arr[i]) {
                len = 2;
            } else {
                len = 1;
            }
            max = Math.max(max, len);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println("max turbulence length is  "+new Day15().maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
    }
}
