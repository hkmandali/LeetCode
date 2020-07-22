class StockSpanner {
    Stack<Integer> prices = new Stack<>();
    Stack<Integer> weight = new Stack<>();
    public StockSpanner() {
        prices = new Stack<>();
        weight = new Stack<>();
    }
    
    public int next(int price) {
        int ret =1;
        while(!prices.isEmpty() && prices.peek() <= price)
        {
            prices.pop();
            ret += weight.pop();
        }
        prices.push(price);
        weight.push(ret);
        return ret;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */