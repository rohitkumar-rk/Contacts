import java.util.*;

public class Contacts {

	/*HashMap to store contacts, 
	It maps Name -> Telephone Number */
	public Map<String, Long> contactsMap;

	/*Trie to store all names in contacts for showing
	suggestions while searching contacts */
	public Trie trie;

	public Contacts() {

        //Root has empty map and false in 'isEndOfName'
        trie = new Trie();
        contactsMap = new HashMap<>();
    }

    /**
     * Saves the given contact
     * @param name name of the contact
     * @param mobileNo mobileNo of the contact
     * This function adds the given contact to the hashmap
     * as well as adds given name to trie
     */
    public void addContact(String name, long mobileNo){
    	contactsMap.put(name, mobileNo);
    	trie.insert(name);
    }

    /**
     * Returns the mobile number for given name
     * @param name Contact whose mobile no we need to return
     * @return long
     */
    public long getContact(String name){
    	return contactsMap.get(name);
    }

    /**
     * Returns names of Contacts that start with given query
     * @param query 
     * @return List<String>
     * Return null if no names found
     */
    public List<String> searchName(String query){
        return trie.search(query);
    }

    public static void main(String[] args) {
        
        Contacts contacts = new Contacts();
        contacts.addContact("rohit", 9825476841L);
        contacts.addContact("rohan", 9874568452L);
        contacts.addContact("rajkumar", 8547587456L);

        System.out.println("Rohit : "  + contacts.getContact("rohit"));

        List<String> list = contacts.searchName("ro");

        if(list == null){
            System.out.println("No contacts starting with given query");
        }

        else {
            System.out.print("List : ");

            for(String name : list)
                System.out.print(name + "  ");
        }
        
    }

}
