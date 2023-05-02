// Students, please implement this class
import structure5.*;
import java.util.Random;
import java.util.Iterator;
/**
 * A FrequencyTable stores a set of characters each of which has
 * an associated integer frequency
 */
public class FrequencyTable {
  /* INSTANCE VARIABLES */
  protected Hashtable<Character, Integer> data;
  private int totalFrequencies;
  
  /**
   * Construct an empty FrequencyTable
   */
  public FrequencyTable() {
    this.data = new Hashtable<Character, Integer>();
    this.totalFrequencies = 0;

  }

  /** add(char ch)
   * If ch is in the FrequencyTable, increment its associated frequency
   * Otherwise add ch to FrequencyTable with frequency 1
   * @param ch is the String to add to the FrequencyTable
   */
  public void add(char ch) {
    // If the key isn't in the FrequencyTable already...
    if (!data.containsKey(ch)) {
      data.put(ch, 1);
    // If the key is already in the FrequencyTable...
    } else if (data.containsKey(ch)) {
      // Get the frequency stored with the key and add 1 to it
      int i = data.get(ch);
      data.put(ch, i + 1);
    }
    totalFrequencies++;
  }

  /** Selects a character from this FrequencyTable with probabality equal to its relative frequency.
   * @return a character from the FrequencyTable
   */
  public char choose() {
    int cumulativeFrequency = 0;
    Random random = new Random();
    // Randomly generate a number between 1 and totalFrequencies
    int randomNumber = random.nextInt(totalFrequencies) + 1;
    Iterator<Character> iterator = data.keys();
    // Iterating through the keys in the FrequencyTable...
    while (iterator.hasNext()) {
      Character key = iterator.next();
      // Get the value at the given key and add to cumulativeFrequency
      cumulativeFrequency += data.get(key);
      // Choose the character specified at the key if its value is less than or equal to the cumulativeFrequency
      if (randomNumber <= cumulativeFrequency) {
        return key;
      }
    }
    return 'e';
  }

  /** Produce a string representation of the FrequencyTable
   * @return a String representing the FrequencyTable
   */
  public String toString() {
    Set<Character> keySet = data.keySet();
    String string = "";
    // Iteratively print out the keys and values in the FrequencyTable
    for (char key : keySet) {
      string += "key: " + key + ", value: " + data.get(key) + "\n";
    }
    return string;
  }

  /**
   * A main method to test our FrequencyTable class
   * @param args the arguments to be passed
   */
  public static void main(String[] args) {
    FrequencyTable table = new FrequencyTable();
    System.out.println(table.toString());
    table.add('a');
    table.add('a');
    table.add('P');
    table.add('l');
    System.out.println(table.toString());
    System.out.println(table.choose());
  }
}
