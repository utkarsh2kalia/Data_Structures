package CacheEvictionPolicy;

import java.util.*;
// Remove from the end and add to the head
class LRUCache {
    HashMap<Integer, Entry> hashmap;
    Entry start, end;
    private int LRU_SIZE;

    public LRUCache(int size) {
        this.LRU_SIZE = size;
        hashmap = new HashMap<Integer, Entry>();
    }

    public int get(int key) {
        if (hashmap.containsKey(key)) // Key Already Exist, just update the
        {
            Entry entry = hashmap.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        return -1;
    }

    public void insert(int key, int value) {
        if (hashmap.containsKey(key)) // Key Already Exist, bring it to top
        {
            Entry entry = hashmap.get(key);
            entry.value = value;
            removeNode(entry);
            addAtTop(entry);
        } else {
            Entry newnode = new Entry();
            newnode.left = null;
            newnode.right = null;
            newnode.value = value;
            newnode.key = key;
            if (hashmap.size() >= LRU_SIZE)
            {
                hashmap.remove(end.key);
                removeNode(end);
                addAtTop(newnode);

            } else {
                addAtTop(newnode);
            }

            hashmap.put(key, newnode);
        }
    }
    private void addAtTop(Entry node) {
        node.right = start;
        node.left = null;
        if (start != null)
            start.left = node;
        start = node;
        if (end == null)
            end = start;
    }

    private void removeNode(Entry node) {

        if (node.left != null) {
            node.left.right = node.right;
        } else {
            start = node.right;
        }

        if (node.right != null) {
            node.right.left = node.left;
        } else {
            end = node.left;
        }
    }

    public Map<Integer, Integer> stateOfCache(){
        Map<Integer, Integer> cache = new LinkedHashMap<>();
        Entry temp = start;
        while(temp!=null){
            cache.put(temp.key, temp.value);
            temp = temp.right;
        }
        return cache;

    }
    public static void main(String[] args) throws java.lang.Exception {
        LRUCache lrucache = new LRUCache(5);
        lrucache.insert('A', 'A');
        lrucache.insert('B', 'B');
        lrucache.insert('C', 'C');
        lrucache.insert('D', 'D');
        lrucache.insert('E', 'E');
        System.out.println(lrucache.stateOfCache());
        lrucache.insert('F', 'F');
        System.out.println(lrucache.stateOfCache());
        lrucache.insert('B', 'B');
        lrucache.insert('G', 'G');
        System.out.println(lrucache.stateOfCache());
    }
}