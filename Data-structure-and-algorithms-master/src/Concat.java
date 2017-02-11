
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Concat {

    public static void main(String args[]) throws IOException {
        ArrayList<String> words = new ArrayList<>(); // data structure to store
        // the words of the file												// read
        ArrayList<String> concat_words = new ArrayList<>(); // data structure to
        // store the words
        // of the file read
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        int count = 0;
        String curr_longest_concat_word = null;
        String curr_second_longest_concat_word = null;
        String read_words;
          //		String prev_word = "/";
        BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\pooja\\Desktop\\WordChallenge\\WordChallenge\\words for problem.txt"));

        HashSet<String> words_list = new HashSet<String>();

        while ((read_words = br.readLine()) != null) { // reading the words from
            // the file

            for (int i = 1; i < read_words.length(); i++) {
                if (words_list.contains(read_words.substring(0, i))) {
                    concat_words.add(read_words);
                    break;
                }
            }
            words_list.add(read_words);

            words.add(read_words); // adding all the words of a file in an
            // arraylist to find the concatenated words
        }

        for (String curr_word : concat_words) {
            words_list.remove(curr_word);
            if (check_words(curr_word, words_list)) {
                int length_concat_curr = curr_word.length();
                if (length_concat_curr > max) {
                    second_max = max;
                    curr_second_longest_concat_word = curr_longest_concat_word;  // second longest concat word
                    max = length_concat_curr;
                    curr_longest_concat_word = curr_word; //longest concat word
                } else if (length_concat_curr > second_max) {
                    second_max = length_concat_curr; 
                    curr_second_longest_concat_word = curr_word;
                }
                count++;
            }
            words_list.add(curr_word);

        }

        System.out.println("The longest concatenated word: " + curr_longest_concat_word);
        System.out.println("The 2nd longest concatenated word: " + curr_second_longest_concat_word);
        System.out.println("The total count of concatenated words in the file: " + count);

    }

    private static boolean check_words(String inputConcat, HashSet<String> words_list) {

        int concat_len = inputConcat.length();

        boolean[] check_break = new boolean[concat_len + 1];
        // base case
        check_break[0] = true;

        for (int i = 1; i <= concat_len; i++) {

            if (check_break[i] == false && words_list.contains(inputConcat.substring(0, i))) {
                check_break[i] = true;
            }
            // check rest of the string

            if (check_break[i]) {
                if (i == concat_len) {
                    return true;
                } else {
                    for (int j = i + 1; j <= concat_len; j++) {
                        if (check_break[j] == false && words_list.contains(inputConcat.substring(i, j))) {
                            check_break[j] = true;
                        }

                        // completed processing
                        if (j == concat_len && check_break[j]) {
                            return true;
                        }
                    }
                }
            }

        }
        // we are checking for prefixes for match, if no match returns false
        return false;
    }

}
