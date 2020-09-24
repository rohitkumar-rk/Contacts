import java.util.*;

class Trie {
    
    public final TrieNode root;

    public Trie() {
        //Root has empty map and false in 'isEndOfName'
        root = new TrieNode();
    }
    
    /**
     * Inserts a name into the trie
     * @param name Name to be inserted 
     * @return void
     */
    public void insert(String name) {

        TrieNode current = root;
        
        for(int i = 0; i < name.length(); i++){
            char ch = name.charAt(i);
            TrieNode node = current.children.get(ch);

            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }

            current = node;
        }

        current.isEndOfName = true;
    }
    
    /**
     * Returns names starting with given string
     * @param query  Prefix of names to be searched
     * @return List<String> A list of names
     * Return null if no names found
     */
    public List<String>  search(String query) {
        TrieNode current = root;
        
        for(int i = 0; i < query.length(); i++){
            char ch = query.charAt(i);
            TrieNode node = current.children.get(ch);
            
            if(node == null)
                return null;
            
            current = node;
        }

        List<String> namesSearched = new LinkedList<>();
        displayContactsUtil(current, query, namesSearched);
        return namesSearched;
    }
    
    /**
     * Utility function for search
     * This function simply adds all the names starting with prefix
     * tp namesSearched list
     * @param currentNode Node we got after traversing prefix in Trie
     * @param prefix  Prefix of names to be searched
     * @param namesSearched List of names
     * @return void
     */
    public void searchContactsUtils(TrieNode currentNode, 
    	String prefix, List<String> namesSearched) { 	

        /*If prefix is end of word, add it to list */
        if (currentNode.isEndOfName) 
            namesSearched.add(prefix);
        
        /* Find all ajacent nodes to currNode and
         call function recursively  */
        for (char i = 'a'; i <= 'z'; i++)  { 
            TrieNode nextNode = currentNode.children.get(i);

            if (nextNode != null) { 
                displayContactsUtil(nextNode, prefix + i, namesSearched); 
            } 
            
        } 
    }


}

