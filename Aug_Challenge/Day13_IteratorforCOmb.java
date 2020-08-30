https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3422/
class CombinationIterator {
    int index;
    List<String> combinations;
    private void precomputeCombinations(String characters,int length,String curr,int start)
    {
        if(curr.length() == length)
        {
            combinations.add(new String(curr));
            return;
        }
        
        for(int i=start;i<characters.length();++i)
        {
            precomputeCombinations(characters,length,curr+characters.charAt(i),i+1);
        }
    }
    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayList();
        precomputeCombinations(characters,combinationLength,new String(),0);
        index=0;
        /*
        for(int i=0;i<combinations.size();++i)
        {
            System.out.println(combinations.get(i));
        }
        */
        //System.out.println("first one is "+combinations.get(0));
    }
    
    public String next() {
        //System.out.println("next is "+combinations.get(index));
        return this.combinations.get(index++);
    }
    
    public boolean hasNext() {
        //System.out.println("index is "+index +"    size is "+combinations.size());
        return (this.combinations.size() != index );
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */