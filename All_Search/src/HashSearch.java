import java.util.HashMap;
import java.util.Random;

public class HashSearch {

    public static void main(String[] args) {
        validation ob = new validation();
        int n = ob.checkInputInt("Enter number of elements: ");
        HashMap<Integer, String> map = new HashMap<>();
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int key = rand.nextInt(100);
            map.put(key, "Value" + key);
        }

        System.out.println("HashMap: " + map);
        int searchKey = ob.checkInputInt("Enter key to search: ");

        if (map.containsKey(searchKey)) {
            System.out.println("Found: " + map.get(searchKey));
        } else {
            System.out.println("Key not found.");
        }
    }
}