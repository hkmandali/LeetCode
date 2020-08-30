https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3434/
class Trie{
    boolean isEndofString;
    Trie[] child;
    Trie()
    {
        isEndofString = false;
        child = new Trie[26];
        for(int i=0;i<26;++i)
        {
            child[i] = null;
        }
    }
    
}

class StreamChecker {

    Trie root;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        
        root = new Trie();
        sb = new StringBuilder();
        for(String word: words)
        {
            insert(word);
        }
    }
    void insert(String word)
    {
        int len = word.length();
        Trie itr = root;
        for(int i=len-1;i>=0;--i)
        {
            char curr = word.charAt(i);
            if(itr.child[curr-'a'] == null)
            {
                itr.child[curr-'a'] = new Trie();
            }
            itr= itr.child[curr-'a'];
        }
        itr.isEndofString = true;
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        /*
        if(null == root || root.child[letter-'a'] == null)
        {
            sb.append(letter);
            return false;
        }
        */
        Trie itr = root;//.child[letter-'a'];
        for(int i=sb.length()-1;i>=0;--i)
        {
            if(itr.child[sb.charAt(i) - 'a'] == null)
                return false;
            itr = itr.child[sb.charAt(i) - 'a'];
            if(itr.isEndofString)
            {
                return true;
            }
            
            
        }        
        
        return false;
        
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */