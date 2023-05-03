// PART OF EXTRA CREDIT ASSIGNMENT
import structure5.*;
import java.util.Random;
import java.util.Iterator;

public class WholeFrequencyTable {
    protected Hashtable<String, Integer> data;
    private int totalFrequencies;
  
  /**
   * Construct an empty WholeFrequencyTable
   */
  public WholeFrequencyTable() {
    this.data = new Hashtable<String, Integer>();
    this.totalFrequencies = 0;

  }

  /** add(String str)
   * If str is in the WholeFrequencyTable, increment its associated frequency
   * Otherwise add str to WholeFrequencyTable with frequency 1
   * @param str is the String to add to the WholeFrequencyTable
   */
  public void add(String str) {
    // If the key isn't in the WholeFrequencyTable already...
    if (!data.containsKey(str)) {
      data.put(str, 1);
    // If the key is already in the WholeFrequencyTable...
    } else if (data.containsKey(str)) {
      // Get the frequency stored with the key and add 1 to it
      int i = data.get(str);
      data.put(str, i + 1);
    }
    totalFrequencies++;
  }

  /** Selects a string from this WholeFrequencyTable with probabality equal to its relative frequency.
   * @return a string from the WholeFrequencyTable
   */
  public String choose() {
    int cumulativeFrequency = 0;
    Random random = new Random();
    // Randomly generate a number between 1 and totalFrequencies
    int randomNumber = random.nextInt(totalFrequencies) + 1;
    Iterator<String> iterator = data.keys();
    // Iterating through the keys in the FrequencyTable...
    while (iterator.hasNext()) {
      String key = iterator.next();
      // Get the value at the given key and add to cumulativeFrequency
      cumulativeFrequency += data.get(key);
      // Choose the string specified at the key if its value is less than or equal to the cumulativeFrequency
      if (randomNumber <= cumulativeFrequency) {
        return key;
      }
    }
    return "e";
  }

  /** Produce a string representation of the WholeFrequencyTable
   * @return a String representing the WholeFrequencyTable
   */
  public String toString() {
    Set<String> keySet = data.keySet();
    String string = "";
    // Iteratively print out the keys and values in the FrequencyTable
    for (String key : keySet) {
      string += "key: " + key + ", value: " + data.get(key) + "\n";
    }
    return string;
  }

  /**
   * A main method to test our WholeFrequencyTable class
   * @param args the arguments to be passed
   */
  public static void main(String[] args) {
    WholeFrequencyTable table = new WholeFrequencyTable();
    System.out.println(table.toString());
    table.add("a");
    table.add("a");
    table.add("P");
    table.add("l");
    System.out.println(table.toString());
    System.out.println(table.choose());
  }
}
