// PART OF EXTRA CREDIT ASSIGNMENT
import structure5.*;
import java.util.Scanner;

public class WholeWordgen {
    /**
     * A method to read in a file and return it as a String
     * @return the String representation of the file
     */
    public static String loadFile() {
        Scanner in = new Scanner(System.in);
        StringBuffer textBuffer = new StringBuffer();
        while (in.hasNextLine()) {
            // Adds in each line to include in the text's String representation
            String line = in.nextLine();
            textBuffer.append(line);
            textBuffer.append("\n");
        }
        String text = textBuffer.toString();
        return text;
    }
    
    /**
     * A method that prints out a randomly-generated string based on the string
     * sequence probabilities from the input text
     * @param k the k-string sequence whose frequencies we want to use
     * @param text the input text represented as a String
     * @return returns our randomly generated text
     */
    public static String generateText(int k, String text) {
        WholeTable table = new WholeTable();
        String[] words = getWordArray(text);
        // Iterating through each word in the text...
        for (int i = 0; i < getTextLength(text); i++) {
            String tableKey = "";
            // Iterating through our edge cases where k is our k-string sequence...
            for (int j = i; j < i + k; j++) {
                tableKey += words[j % getTextLength(text)];
            }
            // Create the word, which is the WholeFrequencyTable's key
            String freqTableKey = words[(k + i) % getTextLength(text)];
            table.add(tableKey, freqTableKey);
        }
        // Iterate through the text, using the given k-value and 500 characters to generate new text
        String seed = text.substring(0, k);
        for (int j = 0; j < 500; j++) {
            String f = table.choose(seed.substring(j, j + k));
            seed = seed + f;
        }
        return seed;
    }


    /**
     * A method that retrieves the number of words in the text
     * @param text the string to be passed through
     * @return the length of the text string
     */
    public static int getTextLength(String text) {
        String[] words = text.split("");
        return words.length;
    }

    /**
     * A method that converts a string of words into an array of strings
     * @param text the string to be passed through
     * @return the array of strings
     */
    public static String[] getWordArray(String text) {
        String[] words = text.split("");
        return words;
    }

    /**
     * A main method to test our WholeWordGen program
     * @param args the arguments to be passed into our program
     */
    public static void main(String[] args) {
        // If an argument is passed into the terminal...
        if (args.length == 1) {
            int k = Integer.parseInt(args[0]);
            Assert.condition(k > 0, "k must be greater than 0");
            String text = loadFile();
            System.out.println(generateText(k, text));
        // If no argument is passed into the terminal...
        } else {
            System.out.println("Usage: java WordGen <k> < <input.txt>");
            System.exit(1);
        }
    }
}
