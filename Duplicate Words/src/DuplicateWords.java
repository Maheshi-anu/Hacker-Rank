import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DuplicateWords {
    public static void main(String[] args) {
        LinkedList<String> sentenceList = new LinkedList<>();

        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int i = 0; i <= testCases; ++i){
            String sentence = input.nextLine();
            sentenceList.add(sentence);
        }
        for (String s:sentenceList) {
            System.out.println(removeDuplicates(s));
        }

    }
    public static String removeDuplicates(String sentence){
        Queue<String> queue = new LinkedList<>();

        String tempWord = "";
        for (int i = 0; i < sentence.length(); i++){
            if (sentence.charAt(i) != ' '){
                tempWord += sentence.charAt(i);
            }
            else {
                queue.add(tempWord);
                tempWord = "";
            }
        }
        queue.add(tempWord);
        String output = "";
        int length = queue.size();

        for (int j = 0; j < length; j++) {
            String current = queue.poll();
            output += current + " ";

            if (queue.peek() != null) {
                while (queue.peek().equalsIgnoreCase(current)) {
                    queue.poll();
                    if (queue.peek() == null) {
                        break;
                    }
                }
            }
            if (queue.peek() == null) {
                break;
            }
        }
        return output;
    }
}
