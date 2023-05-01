// Students, please implement this class
// Reads the input text, builds the table, and prints out a randomly-generated
// string based on the character sequence probabilities from the input text.
import structure5.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class WordGen {

    /**
     *
     * @return
     */
    public static String loadFile() {
        Scanner in = new Scanner(System.in);
        StringBuffer textBuffer = new StringBuffer();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            textBuffer.append(line);
            textBuffer.append("\n");
        }
        String text = textBuffer.toString();
        return text;
    }
    
    /**
     *
     * @param k
     * @param text
     * @return
     */
    public static String generateText(int k, String text) {
        Table table = new Table();
        //int length = example.length();
        for (int i = 0; i < text.length(); i++) {
            String tableKey = "";
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
     *
     * @param args
     */
    public static void main(String[] args) {
        if (args.length == 1) { // if an argument is passed into the terminal...
            int k = Integer.parseInt(args[0]);
            Assert.condition(k > 0, "k must be greater than 0");
            String text = loadFile();
            System.out.println(generateText(k, text));
        } else { // if no argument is passed into the terminal...
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