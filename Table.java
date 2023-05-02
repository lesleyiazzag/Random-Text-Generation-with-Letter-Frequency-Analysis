import structure5.*;
/**
* A Table holds a collection of strings, each of which has an
* associated FrequencyTable
*/
public class Table {

  /* INSTANCE VARIABLES */
  protected Hashtable<String, FrequencyTable> data;

  /** Constructs an empty table */
  public Table() {
    this.data = new Hashtable<String, FrequencyTable>();
  }

  /**
  * Updates the table as follows
  * If key already exists in the table, update its FrequencyTable
  * by adding value to it
  * Otherwise, create a FrequencyTable for key and add value to it
  * @param key is the desired k-letter sequence
  * @param value is the character to add to the FrequencyTable of key
  */
  public void add(String key, char value) {
    // If the key is not already in the Table...
    if (!data.containsKey(key)) {
      data.put(key, new FrequencyTable());
    }
    // Add the value to the key's FrequencyTable
    FrequencyTable table = data.get(key);
    table.add(value);
  }

  /**
  * If key is in the table, return one of the characters from
  * its FrequencyTable with probability equal to its relative frequency
  * Otherwise, determine a reasonable value to return
  * @param key is the k-letter sequence whose frequencies we want to use
  * @return a character selected from the corresponding FrequencyTable
  */
  public char choose(String key) {
    // If the Table contains the key...
    if (data.containsKey(key)) {
      // Retrieve the related FrequencyTable and return a char with probability equal to its relative frequency
      FrequencyTable table = data.get(key);
      char value = table.choose();
      return value;
    }
    System.out.println("Unrecognized token");
    System.exit(1);
    return 'e';
  }

  /** Produce a string representation of the Table
  * @return a String representing this Table
  */
  public String toString() {
    //return this.data.toString();
    Set<String> keySet = data.keySet();
    String str = "";
    // Iteratively print out the keys and values in the Table
    for (String key : keySet) {
      str += "key: " + key + ", value: " + data.get(key) + "\n";
    }
    return str;
  }

  /**
   * A main method to test our Table class
   * @param args the arguments to be passed
   */
  public static void main(String[] args) {
    Table table = new Table();
    System.out.println(table.toString());
    table.add("th", 'a');
    table.add("th", 'e');
    table.add("th", 'e');
    table.add("th", 'u');
    System.out.println(table.toString());
    System.out.println(table.choose("th"));
    System.out.println(table.choose("va"));
  }
}
