package project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**
 *
 * @author 200316059 İkram Celal KESKİN
 */
public class Project2 {

    public class Main {

        public static void main(String[] args) throws IOException {
            Hashtable<Character, BST> dictionary = new Hashtable<>(); //Creating hash table using java framework
            // Read the words and meanings from the file with bufferReader
            BufferedReader br = new BufferedReader(new FileReader("my_words.txt"));
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(" – "); // Split the line into the word and its meaning
                String word = parts[0];
                String meaning = parts[1];
                char firstLetter = word.charAt(0);
                BST search = dictionary.get(firstLetter);
                if (search == null) {
                    search = new BST();
                    dictionary.put(firstLetter, search);
                }
                search.insert(word, meaning);  // Add the word to the dictionary
            }
            //Search from binary tree which we store our data
            String[] wordsToSearch = {"Dialogue", "Drum", "Deer", "Direction"};
            for (String word : wordsToSearch) {
                char firstLetter = word.charAt(0);
                BST mySearch = dictionary.get(firstLetter);
                String meaning = mySearch.search(word);
                if (meaning != null) {
                    System.out.println(word + ": " + meaning);
                } else {        // if words doesnt contain in the dictionary ,gives that message
                    System.out.println(word + " Dictionary do not contain the word");
                }
            }
        }
    }

}

