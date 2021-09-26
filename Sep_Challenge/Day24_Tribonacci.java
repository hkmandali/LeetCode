public class Day24_Tribonacci {
    public int tribonacci(int n) {
        int[] res = new int[38];
        res[0] = 0;
        res[1] =1;
        res[2] =1;
        for(int i=3;i<=n;++i)
        {
            res[i] = res[i-1] + res[i-2] + res[i-3];
        }

        return res[n];
    }
    public static void main(String[] args) {
        System.out.println("n tribonnaci number is "+new Day24_Tribonacci().tribonacci(24));
    }
}
