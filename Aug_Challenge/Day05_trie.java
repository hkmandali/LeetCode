class WordDictionary {
   
    boolean isEndofString;
    WordDictionary[] child;
    /** Initialize your data structure here. */
    public WordDictionary() {
        //System.out.println("initializing day5");
        isEndofString = false;
        child = new WordDictionary[26];
        for(int i=0;i<26;++i)
        {
            child[i] = null;
        }
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int len = word.length();

        WordDictionary proceed = this;
        for(int i=0;i<len;++i)
        {
            char current = word.charAt(i);
            if(proceed.child[current - 'a'] == null)
            {
                proceed.child[current - 'a'] = new WordDictionary();
            }
            proceed = proceed.child[current-'a'];
        }
        proceed.isEndofString= true;
    }
    public boolean search(String word) {
        int len = word.length();

        WordDictionary proceed = this;
        for(int i=0;i<len;++i)
        {
            char current = word.charAt(i);
            if(current == '.')
            {
                for(int j=0;j<26;++j)
                {
                    if(proceed.child[j] != null)
                    {
                        /*
                        if(i == len-1 ) {
                            //System.out.println("it is last");
                            if (proceed.child[j].isEndofString)
                                return true;
                            else
                                return false;
                        }
                        */
                        //proceed = proceed.child[j];
                        if(proceed.child[j].search(word.substring(i+1))) {
                            //System.out.printf("matchinf substring");
                            //System.out.println("still some string is left");
                            return true;
                        }
                    }
                }
                return false;
            }
            if(proceed.child[current - 'a'] == null)
            {
                return false;
            }
            proceed = proceed.child[current-'a'];

        }
        //System.out.println("return true from helper");
        return proceed != null && proceed.isEndofString;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */