package org.example.trie;

public class TrieIterative {

    public static class Node {
        boolean isWordEnd;
        Node[] children;

        public Node(boolean endOfWord) {
            this.isWordEnd = endOfWord;
            if (!endOfWord) {
                children = new Node[26];
            }
        }
    }

    Node root = new Node(false);

    public void insert(String word) {

        Node currentNode = root;

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            boolean iswWordEnd = i == word.length() - 1;

            Node newNode = new Node(iswWordEnd);
            currentNode.children['z' - c] = newNode;
            currentNode = newNode;
        }
    }

    public boolean search(String word) {

        Node currentNode = root;

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            if (currentNode.children== null || currentNode.children['z' - c] == null) {
                return false;
            }
            currentNode = currentNode.children['z' - c];
        }

        return true;
    }

    public static void main(String[] args) {
        TrieIterative trieIterative = new TrieIterative();
        trieIterative.insert("abcd");
        trieIterative.insert("abed");
        trieIterative.insert("abcdk");

        System.out.println(trieIterative.search("abcdke"));
    }
}
