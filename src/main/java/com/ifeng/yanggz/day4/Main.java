package com.ifeng.yanggz.day4;

import com.ifeng.yanggz.day4.hashmap.HashTable;
import com.ifeng.yanggz.day4.hashmap.LRUBaseHashTable;

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

        LRUBaseHashTable<String, String> lruBaseHashTable = new LRUBaseHashTable<>(5);
        lruBaseHashTable.add("aa", "aa");
        lruBaseHashTable.add("bb", "bb");
        lruBaseHashTable.add("cc", "cc");
        lruBaseHashTable.add("dd", "dd");
        lruBaseHashTable.add("ee", "ee");
        lruBaseHashTable.add("ff", "ff");

        lruBaseHashTable.printALL();
        lruBaseHashTable.add("gg", "gg");
        lruBaseHashTable.printALL();
    }
}
