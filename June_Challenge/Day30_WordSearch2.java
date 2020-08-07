class Trie{
    public Trie children[];
    public boolean endOfWord;
    
    public Trie(){
        endOfWord = false;
        children = new Trie[26];
        for(int i = 0; i < 26; ++i)
            children[i] = null;
    }
    
    void insert(String word){
        Trie curr = this;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a'] == null) curr.children[c - 'a'] = new Trie();
            curr = curr.children[c-'a'];
        }
        curr.endOfWord = true;
    }
};

class Solution {
     private void dfs(char[][] board, int i, int j, Trie trie, HashSet<String> result, String s){
        char c = board[i][j];
        if(c == '$') return;
        board[i][j] = '$';
        Trie t = trie.children[c - 'a'];
        if(t != null){
            String ss = s + c;
            //System.out.println(ss);
            if(t.endOfWord) result.add(ss);
            if(i < board.length-1) dfs(board, i+1, j, t, result, ss);
            if(i > 0) dfs(board, i-1, j, t, result, ss);
            if(j < board[0].length-1) dfs(board, i, j+1, t, result, ss);
            if(j > 0) dfs(board, i, j-1, t, result, ss);
        }
        board[i][j] = c;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        if(words.length == 0) return new ArrayList<String>();
        Trie trie = new Trie();
        for(String w: words){
            trie.insert(w);
        }
        
        HashSet<String> result_s = new HashSet();
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                dfs(board, i, j, trie, result_s, "");
            }
        }
        List<String> result = new ArrayList(result_s);
        return result;
    }
}