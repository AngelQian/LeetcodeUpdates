public class WordDictionary {
//A . means it can represent any one letter
    private TrieNode root;
    public WordDictionary(){
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c-'a']==null)
                cur.children[c-'a']=new TrieNode();
            cur = cur.children[c-'a'];
        }
        cur.isLeaf=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }
    public boolean search(String word, TrieNode node) {
        TrieNode cur = node;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(c=='.'){
                for(int j=0; j<26; j++){
                    if(cur.children[j]!=null)
                        if(search(word.substring(i+1), cur.children[j]))
                            return true;
                }
                return false;
            }
            else if(cur.children[c-'a']==null)
                return false;
            else
                cur = cur.children[c-'a'];    
        }
        return cur.isLeaf;
    }
}
class TrieNode{
    public boolean isLeaf;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode(){}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");