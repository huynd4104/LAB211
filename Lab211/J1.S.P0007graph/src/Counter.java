
import java.util.HashMap;
import java.util.Map;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Counter {

    Map<Character, Integer> charCounter = new HashMap<Character, Integer>();

    Map<String, Integer> wordCounter = new HashMap<String, Integer>();

    public void display() {
        System.out.println(wordCounter);
        System.out.println(charCounter);
    }

    public void analyze(String content) {
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1);
            } else {
                charCounter.put(ch, ((int) charCounter.get(ch)) + 1);
            }
        }
        StringTokenizer tokenizer = new StringTokenizer(content);
        //Vòng lặp while sẽ chạy liên tục cho đến khi hasMoreTokens() trả về false,
        //nghĩa là không còn token nào khác để xử lý
        while (tokenizer.hasMoreTokens()) {  
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) {
                wordCounter.put(token, 1);
            } else {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            }
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Validation ob = new Validation();
        String content = ob.checkInput("Enter your content: ","Input cannot be empty.");
//        System.out.println("Enter your content: ");
//        String content = sc.nextLine();

        Counter count = new Counter();
        count.analyze(content);
        count.display();
    }
}
