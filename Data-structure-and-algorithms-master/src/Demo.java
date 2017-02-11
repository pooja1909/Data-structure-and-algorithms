import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Demo {
	
    public static void main(String args[]) throws IOException {
        ArrayList<String> words = new ArrayList<>(); // data structure to store the words of the file read
        ArrayList<String> temp_words = new ArrayList<>(); // data structure to store the words of the file read
        ArrayList<String> concat_words = new ArrayList<>(); // data structure to store the words of the file read
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        int count = 0;
        String curr_longest_concat_word = null;
        String curr_second_longest_concat_word = null;
        String read_words;
		String prev_word = "/";
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\pooja\\Desktop\\WordChallenge\\WordChallenge\\words for problem.txt"));
        while ((read_words = br.readLine()) != null) { // reading the words from the file
            //for (String curr_word : words) { 

                if (read_words.contains(prev_word)) { //check if a current word from the file is a concatenated word
						concat_words.add(read_words);
                }
           //}
            words.add(read_words); // adding all the words of a file in an arraylist to find the concatenated words
			prev_word = read_words;
        }
		
		String []words_array = new String[words.size()];
		
		
		//loop through the concatenated words and see if they can be segmented.
		for (String curr_word : concat_words){
			
                        words.remove(curr_word);
			words.toArray(words_array);
			
			if (check_words(curr_word, new HashSet<>(Arrays.asList(words_array))))
			{
				int length_concat_curr = curr_word.length();
                    if (length_concat_curr > max) {
                        second_max = max;  
                        curr_second_longest_concat_word = curr_longest_concat_word; // second longest concatenated word
                        max = length_concat_curr; 
                        curr_longest_concat_word = curr_word; //longest concatenated word
                    }else if (length_concat_curr > second_max) {
						second_max = length_concat_curr;
						curr_second_longest_concat_word = curr_word;
					}
					//count++; // to keep a track of the concatenated words in a file
				count++;
			}
			
		}							
		
        System.out.println("The longest concatenated word: "  +curr_longest_concat_word);
        System.out.println("The 2nd longest concatenated word: " +curr_second_longest_concat_word);
        System.out.println("The total count of concatenated words in the file: " +count);
    }
	
	private static boolean check_words(String inputString, HashSet<String> dict){
 
      int inputLength = inputString.length();
 
      //memoization table where value at index i represents
      //that if string[0..i-1] can be segmented or not
      boolean[] isBreakPossible = new boolean[inputLength+1];
      //Possible to break with blank "" will always be true, it will serve as base case
      isBreakPossible[0] = true;
 
      for(int i=1; i<= inputLength; i++){
 
         if(isBreakPossible[i] == false && dict.contains(inputString.substring(0, i)))
            isBreakPossible[i] = true;
         //We have detected subString[0..i] to be in dictionary. Now we will check for remaining string  
 
         if(isBreakPossible[i]){
            //if subString detected in dictionary is of length equal to inputString. return true
            if(i==inputLength)
               return true;
            else{
               //process for substring[i+1..inputLength]
               for(int j=i+1;j<= inputLength;j++){
                  if(isBreakPossible[j] == false && dict.contains(inputString.substring(i,j)))
                     isBreakPossible[j] = true;
 
                  //if we are done processing for rest string i.e. j == inputLength
                  //and there exist a prefix in dictionary ending at j
                  if(j==inputLength && isBreakPossible[j])
                     return true;
               }
            }
         }
 
      }
      //we have looked into all the prefixes, no match return false
      return false;
   }
	
		
	}
	

 
