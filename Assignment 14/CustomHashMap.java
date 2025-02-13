import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int SIZE = 10;
    private LinkedList<Entry<K, V>>[] map;

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        map = (LinkedList<Entry<K, V>>[]) new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(K key, V value) {
        int index = hashFunction(key);
        for (Entry<K, V> entry : map[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        map[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = hashFunction(key);
        for (Entry<K, V> entry : map[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hashFunction(key);
        map[index].removeIf(entry -> entry.key.equals(key));
    }

    public void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + ": ");
            for (Entry<K, V> entry : map[i]) {
                System.out.print("[" + entry.key + "=" + entry.value + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        
        hashMap.put("apple", 10);
        hashMap.put("banana", 20);
        hashMap.put("orange", 30);
        
        System.out.println("Get apple: " + hashMap.get("apple")); // Expected: 10
        
        hashMap.remove("banana");
        
        hashMap.printMap(); // Should print all elements except "banana"
    }
}

