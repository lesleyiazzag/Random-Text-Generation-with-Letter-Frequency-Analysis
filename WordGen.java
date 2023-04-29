// Students, please implement this class
// Reads the input text, builds the table, and prints out a randomly-generated
// string based on the character sequence probabilities from the input text.
import structure5.*;
import java.util.Random;
import java.util.Scanner;
public class WordGen {
    // Scanner in = new Scanner(System.in);
    // StringBuffer textBuffer = new StringBuffer();
    // while (in.hasNextLine()) {
    //     String line = in.nextLine();
    //     textBuffer.append(line);
    //     textBuffer.append("\n");
    // }
    // String text = textBuffer.toString();
    // 'text' now contains the full contents of the input.
    
    
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
    // for (int j = 0; j < 10; j++) {
    //     char f = table.choose(seed.substring(j, j + k));
    //     seed = seed + f;
    // }

    public static void main(String[] args) {
        Table table = new Table();
        int k = 2;
        String example = "The theatre is their thing";
        //int length = example.length();
        for (int i = 0; i < example.length() - k; i++) {
            String tableKey = example.substring(i, k + i);
            char freqTableKey = example.charAt(k + i);
            table.add(tableKey, freqTableKey);
        }
        //System.out.println(table.toString());

        String seed = example.substring(0, k);
        for (int j = 0; j < 50; j++) {
            char f = table.choose(seed.substring(j, j + k));
            seed = seed + f;
        }
        System.out.println(seed);
    }
}
