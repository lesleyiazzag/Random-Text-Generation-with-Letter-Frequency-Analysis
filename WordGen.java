import structure5.*;
import java.util.Scanner;

/**
 * Reads the input text, builds the table, and prints out a randomly-generated
 * string based on the character sequence probabilities from the input text.
 */
public class WordGen {

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
     * A method that prints out a randomly-generated string based on the character
     * sequence probabilities from the input text
     * @param k the k-letter sequence whose frequencies we want to use
     * @param text the input text represented as a String
     * @return returns our randomly generated text
     */
    public static String generateText(int k, String text) {
        Table table = new Table();
        //int length = example.length();
        // Iterating through each character in the text...
        for (int i = 0; i < text.length(); i++) {
            String tableKey = "";
            // Iterating through our edge cases...
            for (int j = i; j < i + k; j++) {
                tableKey += text.charAt(j % text.length());
            }
            char freqTableKey = text.charAt((k + i) % text.length());
            table.add(tableKey, freqTableKey);
        }
        //System.out.println(table.toString());
        String seed = text.substring(0, k);
        for (int j = 0; j < 500; j++) {
            char f = table.choose(seed.substring(j, j + k));
            seed = seed + f;
        }
        return seed;
    }

    /**
     * A main method to test our WordGen program
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

// Table table = new Table();
// int k = 2;
// String example = "The theatre is their thing";
// //int length = example.length();
// for (int i = 0; i < example.length() - k; i++) {
//     String tableKey = example.substring(i, k + i);
//     char freqTableKey = example.charAt(k + i);
//     table.add(tableKey, freqTableKey);
// }
// //System.out.println(table.toString());
// String seed = example.substring(0, k);
// for (int j = 0; j < 50; j++) {
//     char f = table.choose(seed.substring(j, j + k));
//     seed = seed + f;
// }
// System.out.println(seed);

// bonus?