package common;

public class TrieNode {
    
    public TrieNode[] nodes;
    public boolean end;
    
    public TrieNode() {
        this.nodes = new TrieNode[26];
    }
}