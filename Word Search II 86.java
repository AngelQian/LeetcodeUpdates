public class Solution {
    Set<String> set = new HashSet<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word:words)
            trie.insert(word);
        
        int row=board.length, col=board[0].length;
        boolean[][] f = new boolean[row][col];
        
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++)
                findWordsHelper(board, i, j, "", trie, f);
                
        return new ArrayList<>(set);
    }
    
    private void findWordsHelper(char[][] board, int indexX, int indexY, String word, Trie trie, boolean[][] f){
       if(indexX<0 || indexY<0 || indexX>=board.length || indexY>=board[0].length)
            return ;
        if(f[indexX][indexY]==true)
            return ;
        
        word+=board[indexX][indexY];    
        if (!trie.startsWith(word)) 
            return ;
       
        if(trie.search(word))
            set.add(word);
        
        f[indexX][indexY]=true;    
        findWordsHelper(board, indexX+1, indexY, word, trie, f);     
        findWordsHelper(board, indexX, indexY+1, word, trie, f);
        findWordsHelper(board, indexX-1, indexY, word, trie, f);
        findWordsHelper(board, indexX, indexY-1, word, trie, f);
        f[indexX][indexY]=false;
    }
    
    class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String item = "";

    // Initialize your data structure here.
    public TrieNode() { }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return node.item.equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return true;
    }
}
    
    
    
}