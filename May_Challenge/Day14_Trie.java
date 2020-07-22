
class Trie {

    /** Initialize your data structure here. */
    Trie[] child;
    boolean isEndofString;
    public Trie() {
        child = new Trie[26];
        isEndofString = false;
        for(int i=0;i<26;++i)
        {
            child[i] = null;
        }
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len = word.length();
        Trie crawl = this;
        for(int i=0;i<len;++i)
        {
            int index = word.charAt(i) -'a';
            if(crawl.child[index] == null)
            {
                crawl.child[index] = new Trie();
            }
            crawl = crawl.child[index];
        }
        crawl.isEndofString = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int len = word.length();
        Trie crawl = this;
        if(null == crawl)
            return false;
        for(int i=0;i<len;++i)
        {
            int index = word.charAt(i) -'a';
            if(crawl.child[index] == null)
            {
                return false;                
            }
            crawl = crawl.child[index];
        }
        if(!crawl.isEndofString)
            return false;
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        Trie crawl = this;
        if(null == crawl)
            return false;
        for(int i=0;i<len;++i)
        {
            int index = prefix.charAt(i) -'a';
            if(crawl.child[index] == null)
            {
                return false;                
            }
            crawl = crawl.child[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */