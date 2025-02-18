// Time Complexity : O(n)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Using array as buckets and from the bucket create a linked list
class MyHashMap {
   class Node {
      int key, value;
      Node next;
      public Node(int key, int value) {
        this.key = key;
        this.value = value;
      }
   }
     int buckets;
     Node[] storage;

    int getBucket(int key){
        return Integer.hashCode(key) % this.buckets;
    }

    public MyHashMap() {
        this.buckets = 1000;
        storage = new Node[this.buckets];
    }

    private Node find(Node dummy, int key)
    {
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
         if(storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null) {
            prev.next.value = value;
        }
        else {
            prev.next = new Node(key, value);
        }
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null) {
            return -1;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return;
        }
        Node prev = find(storage[bucket], key);
        if(prev.next != null) {
            prev.next = prev.next.next;
        }
    }
}


