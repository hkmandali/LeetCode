public class Day01_StockSellBuy {
    public int maxProfit(int[] prices) {
        if(null == prices || 2 > prices.length)
            return 0;
        int max_profit = 0;
        int[] max_arr = new int[prices.length];
        max_arr[prices.length-1] = prices[prices.length-1];
        for(int i=prices.length-2;i>=0;--i) {
            max_arr[i]=Math.max(max_arr[i+1],prices[i]);
        }
        for(int i=0;i<prices.length-1;++i)
        {
            if(max_profit < max_arr[i+1] - prices[i])
            {
                max_profit = (max_arr[i+1] - prices[i]);
            }
        }
        return max_profit;
    }
    public static void main(String[] args) {
        System.out.println("the max profit is "+ new Day01_StockSellBuy().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
