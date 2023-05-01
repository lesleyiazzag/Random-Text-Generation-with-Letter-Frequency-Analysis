// Students, please implement this class
import structure5.*;
import java.util.Random;
import java.util.Iterator;
/**
 * A FrequencyTable stores a set of characters each of which has
 * an associated integer frequency
 */
public class FrequencyTable {
  protected Hashtable<Character, Integer> data;
  private int totalFrequencies;
  /** Construct an empty FrequencyTable */
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
    if (!data.containsKey(ch)) {
      data.put(ch, 1);
    } else if (data.containsKey(ch)) {
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
    int x = random.nextInt(totalFrequencies) + 1;
    Iterator<Character> iterator = data.keys();
    while (iterator.hasNext()) {
      Character key = iterator.next();
      cumulativeFrequency += data.get(key);
      if (x <= cumulativeFrequency) {
        return key;
      }
    }
    return 'e';
  }

  /** Produce a string representation of the FrequencyTable
   * @return a String representing the FrequencyTable
   */
  public String toString() {
    //return this.data.toString();
    Set<Character> keySet = data.keySet();
    String string = "";
    for (char key : keySet) {
      string += "key: " + key + ", value: " + data.get(key) + "\n";
    }
    return string;
  }

  // Use main to test your FrequencyTable class
  /**
   *
   * @param args
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
