package com.ifeng.yanggz.day4;

import com.ifeng.yanggz.day4.hashmap.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<>();
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
        System.out.println(hashTable.get("jj"));
    }
}
