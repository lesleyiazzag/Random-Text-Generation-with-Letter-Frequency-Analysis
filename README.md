# Random Text Generation with Letter Frequency Analysis

## 📖 Overview

This project generates random text by analyzing the frequency of characters (or sequences of characters) in a given input text. The program simulates the structure of the input text using various levels of analysis to create new text that mimics the statistical distribution of characters and their sequences.

The project supports different levels of analysis:

- **Level 0**: Generates text based on individual character probabilities.
- **Level 1**: Generates text based on character pairs.
- **Level k**: Generates text using sequences of length `k`.

By varying the analysis level, the generated text moves from completely random to text that more closely resembles the original source.

---

## ⚙️ Features

- **Level 0 Analysis**: Generates text by randomly selecting characters based on their frequency in the input text.
- **Level 1 Analysis**: Generates text based on the probability of one character following another.
- **Level k Analysis**: Generates text based on the probability of characters following sequences of length `k`.

---

## 🔧 How It Works

1. **Frequency Analysis**: The program analyzes the input text and builds a table that tracks the frequency of characters or sequences of characters.
2. **Random Text Generation**: The program uses the frequency data to generate new text. The length of the output text and the level of analysis can be adjusted by the user.
3. **Data Structures Used**: The program utilizes hash tables to store character frequencies and sequences, with `Table` and `FrequencyTable` classes handling the data management.

---

## 🚀 Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/lesleyiazzag/Random-Text-Generation-with-Letter-Frequency-Analysis.git
    cd Random-Text-Generation-with-Letter-Frequency-Analysis
    ```

2. **Dependencies**:
    - Java Development Kit (JDK) for compiling and running the program.

---

## 🛠 Usage

1. **Compile the Program**:
    ```bash
    javac WordGen.java Table.java FrequencyTable.java
    ```

2. **Run the Program**:
    To generate random text with a specific level of analysis, use the following command:
    ```bash
    java WordGen <k> < input.txt
    ```
    - `<k>` is the length of the sequence (Level 1 uses `k=1`, Level 2 uses `k=2`, etc.).
    - `input.txt` is the file containing the text from which you want to analyze character frequencies.

---

## 🗂 Project Structure

- **WordGen.java**: Main program that handles reading the input text, performing analysis, and generating random text.
- **Table.java**: Manages a hash table storing character sequences and their associated frequency data.
- **FrequencyTable.java**: Handles the frequency data for each sequence and character pair.

---

## Acknowledgements

The lab writeup can be found on the [labs](https://williams-cs.github.io/cs136-s23-www/labs.html) 
section of the [course website](https://williams-cs.github.io/cs136-s23-www/).
