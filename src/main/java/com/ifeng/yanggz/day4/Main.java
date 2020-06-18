package com.ifeng.yanggz.day4;

import com.ifeng.yanggz.day4.hashmap.HashTable;
import com.ifeng.yanggz.day4.hashmap.LRUBaseHashTable;
import com.ifeng.yanggz.day4.string.BF;
import com.ifeng.yanggz.day4.string.Trie;

public class Main {
    public static void main(String[] args) {
        /*HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("aa", "bb");
        hashTable.put("bb", "bb");
        hashTable.put("cc", "bb");
        hashTable.put("dd", "bb");
        hashTable.put("ee", "bb");
        hashTable.put("ff", "bb");
        hashTable.put("gg", "bb");
        hashTable.put("hh", "bb");
        hashTable.put("jj", "cc");
        hashTable.put("kk", "aa");
        String r = hashTable.get("kk");
        System.out.println(r);

        hashTable.remove("aa");
        System.out.println(hashTable.get("aa"));
        System.out.println(hashTable.get("jj"));*/

        /*LRUBaseHashTable<String, String> lruBaseHashTable = new LRUBaseHashTable<>(5);
        lruBaseHashTable.add("aa", "aa");
        lruBaseHashTable.add("bb", "bb");
        lruBaseHashTable.add("cc", "cc");
        lruBaseHashTable.add("dd", "dd");
        lruBaseHashTable.add("ee", "ee");
        lruBaseHashTable.add("ff", "ff");

        lruBaseHashTable.printALL();
        lruBaseHashTable.add("gg", "gg");
        lruBaseHashTable.printALL();*/

        /*String word1 = "hello";
        String word2 = "yanggz";
        String word3 = "lisi";
        String word4 = "lisid";

        Trie trie = new Trie();
        trie.build(word1.toCharArray());
        trie.build(word2.toCharArray());
        trie.build(word3.toCharArray());

        System.out.println(trie.find(word4.toCharArray()));*/

        String mainStr = "hello word yanggz";
        String modeStr = "yanggz";
        System.out.println(BF.bf(mainStr, modeStr));
    }
}
