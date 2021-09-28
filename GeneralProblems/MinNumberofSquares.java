import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinNumberofSquares {
    int minsquares(int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;++i)
        {
            for(int j=1;j<=Math.sqrt(i);++j)
            {
                if(j*j == i)
                {
                    dp[i] =1;
                }
                else
                {
                    dp[i] = Math.min(dp[i],1+dp[i-j*j]);
                }
            }
        }

        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        System.out.println("enter any number");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println("min number of sqaures required is "+new MinNumberofSquares().minsquares(n));
    }
}
