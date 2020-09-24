import java.util.*;

class TrieNode {
    
    Map<Character, TrieNode> children;
    boolean isEndOfName;
    
    public TrieNode(){
        children = new HashMap<>();
        isEndOfName = false;
    }
    
}