import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
 
class CreateArray {
    public static void main(String[] args) {
        // C1:
        String[] car1 = new String[] { "9", "2", "3" };
        System.out.println(Arrays.toString(car1));
        // C2: create an ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
 
        // add elements
        numbers.add(9);
        numbers.add(2);
        numbers.add(3);
        System.out.println("Unsorted ArrayList: " + numbers);
 
        // sắp xếp
        Collections.sort(numbers);
        System.out.println("Sorted ArrayList: " + numbers);
 
        // An array of Integer
        Integer arr[] = { 4, 6, 1, 8, 3, 9, 7, 4, 2 };
 
        // Creates a wrapper list over arr[]
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list); // [4, 6, 1, 8, 3, 9, 7, 4, 2]
 
        list.set(0, 5); // overwrite the elements
        System.out.println(list); // [5, 6, 1, 8, 3, 9, 7, 4, 2]
        
        //So sánh bằng equals
        String[] s1 = { "huy", "danh", "nguyen"};
        String[] s2 = { "danh", "nguyen", "huy"};
        System.out.println(Arrays.equals(s1, s2)); // Output : false
        Arrays.sort(s1);
        Arrays.sort(s2);
        System.out.println(Arrays.equals(s1, s2)); // Output : true
    }
}

