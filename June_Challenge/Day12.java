class RandomizedSet {

    /** Initialize your data structure here. */
    HashMap<Integer,Integer> map;
    List<Integer> arrlist ;
    public RandomizedSet() {
        map = new HashMap<>();
        arrlist = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        int size = arrlist.size();
        map.put(val,size);
        arrlist.add(val);
        //System.out.println("inserted "+val+"   size is "+arrlist.size());
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.get(val) == null)
            return false;
        int index = map.get(val);
        int last = arrlist.get(arrlist.size()-1);
        //System.out.println("replcaing  "+arrlist.get(index) +"  with "+last);
        arrlist.set(index,last);
        arrlist.remove(arrlist.size()-1);
        map.put(last,index);
        map.remove(val);
        
        
        //System.out.println("removed "+val+"  size is "+arrlist.size());
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int size = arrlist.size();
        //System.out.println("size is "+size);
        Random rand = new Random();
        int index = rand.nextInt(size);
        //System.out.println("returning index "+arrlist.get(index));
        return arrlist.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */