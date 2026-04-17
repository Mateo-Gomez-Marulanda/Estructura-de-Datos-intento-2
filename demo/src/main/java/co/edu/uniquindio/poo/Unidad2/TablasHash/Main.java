package co.edu.uniquindio.poo.Unidad2.TablasHash;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(5);

        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);
        hashTable.put("four", 4);
        hashTable.put("five", 5);

        System.out.println("Size: " + hashTable.size());
        System.out.println("Value for 'three': " + hashTable.get("three"));
        System.out.println("Contains 'two': " + hashTable.containsKey("two"));

        hashTable.remove("two");
        System.out.println("Contains 'two' after removal: " + hashTable.containsKey("two"));
    }
}
