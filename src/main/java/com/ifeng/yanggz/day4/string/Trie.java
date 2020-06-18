package com.ifeng.yanggz.day4.string;

/**
 * 字典树
 * @Author yanggz
 * @Date 2020-06-16
 */
public class Trie {

    private static final TrieNode root = new TrieNode('/');

    /**
     * 构建trie 树
     * @param text
     */
    public void build(char[] text) {
        TrieNode p = root;
        for(int i=0; i<text.length; i++) {
            int index = text[i] - 'a';
            if(p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndChar = true;
    }

    /**
     * 查找字符串是否存在
     * @param word
     * @return
     */
    public boolean find(char[] word) {
        TrieNode p = root;
        for(int i=0; i<word.length; i++) {
            int index = word[i] - 'a';
            if(p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        if(p.isEndChar == false) {
            return false;
        }
        return true;
    }

    /**
     * 树节点
     */
    static class TrieNode {

        private TrieNode[] children = new TrieNode[26];
        private boolean isEndChar;
        private char data;

        TrieNode(char data) {
            this.data = data;
        }
    }
}
