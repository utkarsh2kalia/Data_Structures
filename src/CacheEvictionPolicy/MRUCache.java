package CacheEvictionPolicy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MRUCache {
    HashMap<Integer, Entry> hashmap;
    Entry start, end;
    private int LRU_SIZE;

    public MRUCache(int size) {
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
            Entry newNode = new Entry();
            newNode.left = null;
            newNode.right = null;
            newNode.value = value;
            newNode.key = key;
            if (hashmap.size() >= LRU_SIZE)
            {
                // remove the start
                hashmap.remove(start.key);
                removeNode(start);
                addAtTop(newNode);

            } else {
                addAtTop(newNode);
            }

            hashmap.put(key, newNode);
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

    public Map<Integer, Character> stateOfCache(){
        Map<Integer, Character> cache = new LinkedHashMap<>();
        Entry temp = start;
        while(temp!=null){
            cache.put(temp.key, (char)temp.value);
            temp = temp.right;
        }
        return cache;

    }
    public static void main(String[] args) throws java.lang.Exception {
        MRUCache mrucache = new MRUCache(5);
        mrucache.insert('A', 'A');
        mrucache.insert('B', 'B');
        mrucache.insert('C', 'C');
        mrucache.insert('D', 'D');
        mrucache.insert('E', 'E');
        System.out.println(mrucache.stateOfCache());
        mrucache.insert('F', 'F');
        System.out.println(mrucache.stateOfCache());
        mrucache.insert('C', 'C');
        System.out.println(mrucache.stateOfCache());
        mrucache.insert('G', 'G');
        System.out.println(mrucache.stateOfCache());
    }
}
