package designProblems.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chandan on 19/02/19
 */
public class SearchManager {


    public boolean isExists(String input){
        //some validation : null
        Character firstChar = input.charAt(0);
        Node node = map.get(firstChar);
        if(node== null)
            return false;

        return checkIfExistsHelper(input, node);

    }


    public void insert(String input){
        //some validation : null
        Character firstChar = input.charAt(0);
        Node node = map.get(firstChar);
        // create new node
        if(node== null)
            node = new Node(firstChar, input.length()==1);
        // now insert remaining characters
        if(input.length()>1)
            insertHelper(input.substring(1), node);


        map.put(firstChar, node);
    }





    /* private methods */
    private boolean checkIfExistsHelper(String str, Node node)
    {
        if(node == null)
            return false;

        if(str.length()==1 ) // termination check
        {
            if(node == null || !node.isWord)
                return false;
            return true;
        }
        else {
            Character ch = str.charAt(0);
            if(ch== '.')
            {
                for(int i =0; i<26; i++)
                {
                    //Character tmpCh = // get character from 'a' + i
                    if(checkIfExistsHelper(str.substring(1), node.children[i]))
                        return true;
                }
                return false;
            }
            else
            return checkIfExistsHelper(str.substring(1), node.children[ch - '0']);
        }
    }


    private void insertHelper(String str, Node parentNode){
        Character ch = str.charAt(0);
        if(parentNode.children[ch - '0'] == null)
            parentNode.children[ch - '0'] = new Node(ch, str.length()==1);
        if(str.length()>1)
            insertHelper(str.substring(1), parentNode.children[ch - '0']);
    }



    /* private variables */
    private Map<Character, Node> map = new HashMap(26);


}
