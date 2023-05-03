// PART OF EXTRA CREDIT ASSIGNMENT
import structure5.*;
public class WholeTable {
    /* INSTANCE VARIABLES */
  protected Hashtable<String, WholeFrequencyTable> data;

  /** Constructs an empty table */
  public WholeTable() {
    this.data = new Hashtable<String, WholeFrequencyTable>();
  }

  /**
  * Updates the table as follows
  * If key already exists in the table, update its WholeFrequencyTable
  * by adding value to it
  * Otherwise, create a WholeFrequencyTable for key and add value to it
  * @param key is the desired k-word sequence
  * @param value is the string to add to the WholeFrequencyTable of key
  */
  public void add(String key, String value) {
    // If the key is not already in the Table...
    if (!data.containsKey(key)) {
      data.put(key, new WholeFrequencyTable());
    }
    // Add the value to the key's WholeFrequencyTable
    WholeFrequencyTable table = data.get(key);
    table.add(value);
  }

  /**
  * If key is in the table, return one of the strings from
  * its WholeFrequencyTable with probability equal to its relative frequency
  * Otherwise, determine a reasonable value to return
  * @param key is the k-string sequence whose frequencies we want to use
  * @return a string selected from the corresponding WholeFrequencyTable
  */
  public String choose(String key) {
    // If the WholeTable contains the key...
    if (data.containsKey(key)) {
      // Retrieve the related WholeFrequencyTable and return a string with probability equal to its relative frequency
      WholeFrequencyTable table = data.get(key);
      String value = table.choose();
      return value;
    }
    System.out.println("Unrecognized token");
    System.exit(1);
    return "e";
  }

  /** Produce a string representation of the WholeTable
  * @return a String representing this WholeTable
  */
  public String toString() {
    Set<String> keySet = data.keySet();
    String str = "";
    // Iteratively print out the keys and values in the WholeTable
    for (String key : keySet) {
      str += "key: " + key + ", value: " + data.get(key) + "\n";
    }
    return str;
  }

  /**
   * A main method to test our WholeTable class
   * @param args the arguments to be passed
   */
  public static void main(String[] args) {
    WholeTable table = new WholeTable();
    System.out.println(table.toString());
    table.add("th", "a");
    table.add("th", "e");
    table.add("th", "e");
    table.add("th", "u");
    System.out.println(table.toString());
    System.out.println(table.choose("th"));
    System.out.println(table.choose("va"));
  }
}
