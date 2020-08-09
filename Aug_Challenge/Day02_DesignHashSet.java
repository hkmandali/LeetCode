class MyHashSet {

    List<Integer> map ;
    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new ArrayList();
    }
    
    public void add(int key) {
        int size = map.size();
        boolean present = false;
        for(int i=0;i<size;++i)
        {
            if(map.get(i) == key)
            {
                present = true;
                break;
            }
        }
        if(!present)
            map.add(key);
    }
    
    public void remove(int key) {
        int size = map.size();
        boolean present = false;
        for(int i=0;i<size;++i)
        {
            if(map.get(i) == key)
            {
                map.remove(i);
                break;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int size = map.size();
        boolean present = false;
        for(int i=0;i<size;++i)
        {
            if(map.get(i) == key)
            {
                present = true;
                break;
            }
        }
        return present;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */