package com.ifeng.yanggz.day4.hashmap;

public class HashTable<K, V> {

    // 装载因子
    private static final float LOAD_FACTOR = 0.75f;
    // 初始容量
    private static final int DEFAULT_CAPACITY_SIZE = 8;
    // 实际大小
    private int size;
    // 索引数量
    private int use;

    private Entry<K, V>[] table;

    public HashTable() {
        table = new Entry[DEFAULT_CAPACITY_SIZE];
    }

    // hash
    public int hash(K key) {
        int h;
        return key == null ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) & (table.length-1);
    }

    // put
    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> head = table[index];
        if(head == null) {
            // 头插法
            head = new Entry<>(key, value, null);
            table[index] = new Entry<>(null, null, head);
            size++;
            use++;
            if(use > table.length * LOAD_FACTOR) {
                resize();
            }
        } else {
            Entry tmp = head;
            do {
                // 覆盖旧值
                tmp = tmp.next;
                if(tmp.key == key) {
                    tmp.value = value;
                    return;
                }
            } while (tmp.next != null);
            head.next = new Entry<>(key, value, head.next);
            size++;
        }
    }

    // get
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> e = table[index];
        if(e == null || e.next == null) {
            return null;
        }
        while (e.next != null) {
            e = e.next;
            if(e.key == key) {
                return e.value;
            }
        }
        return null;
    }

    // remove
    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> e = table[index];
        if(e == null || e.next == null) {
            return;
        }

        Entry pre;
        Entry headNode = table[index];
        while (e.next != null) {
            pre = e;
            e = e.next;
            if(e.key == key) {
                pre.next = e.next;
                if(headNode.next == null) {
                    use--;
                }
                size--;
                return;
            }
        }
    }

    // resize
    public void resize() {
        Entry<K, V>[] oldTable = table;
        Entry<K, V>[] table = new Entry[size * 2];
        use = 0;
        for(int i=0; i<oldTable.length; i++) {
            if(oldTable[i] == null || oldTable[i].next == null) {
                continue;
            }

            Entry<K, V> e = oldTable[i];
            while (e.next != null) {
                e = e.next;
                int index = hash(e.key);
                if(table[index] == null) {
                    use++;
                    table[index] = new Entry<>(null, null, null);
                }
                table[index] = new Entry<>(e.key, e.value, table[index].next);
            }
        }
    }

    static class Entry<K, V> {

        private K key;
        private V value;
        private Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
