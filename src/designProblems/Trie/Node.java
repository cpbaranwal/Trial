package designProblems.Trie;

/**
 * @author chandan on 19/02/19
 */
public class Node {

    char ch;
    boolean isWord;
    Node[] children = new Node[26];

    public Node(Character ch, Boolean isWord)
    {
        this.ch = ch;
        this.isWord = isWord;
    }
}
