import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class WC {
  public static void main(String[] args) {
    if (args.length == 0) {
      final String userInput = takeUserInput();
      System.out.println(numberOfLinesInAString(userInput) + " " + numberOfWordsInAString(userInput) + " " + userInput.length());
      return;
    }

    if (args.length == 1) {
      final File file = new File(args[0]);
      if (!file.exists() || !file.isFile()) {
        takeUserInputAndOutputResult(args[0]);
      } else {
        System.out.println(numberOfLinesInAFile(args[0]) + " " + numberOfWordsInAFile(args[0]) + " " + file.length());
      }
      return;
    }

    final String filePath = args[1];
    final File file = new File(filePath);
    if (!file.exists() || !file.isFile()) {
      throw new IllegalArgumentException("File is invalid or it doesn't exist");
    }
    switch (args[0]) {
      case "-c" -> System.out.println(file.length());
      case "-l" -> System.out.println(numberOfLinesInAFile(filePath));
      case "-w" -> System.out.println(numberOfWordsInAFile(filePath));
      case "-m" -> System.out.println(numberOfCharactersInAFile(filePath));
      default -> throw new IllegalArgumentException("Invalid argument");
    }
    ;
  }

  private static void takeUserInputAndOutputResult(String arg) {
    final String userInput = takeUserInput();
    switch (arg) {
      case "-c" -> System.out.println(userInput.length());
      case "-l" -> System.out.println(numberOfLinesInAString(userInput));
      case "-w" -> System.out.println(numberOfWordsInAString(userInput));
      case "-m" -> System.out.println(userInput.length());
      default -> throw new IllegalArgumentException("Invalid argument");
    }
    ;
  }

  private static String takeUserInput() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String userInput = "";
    try {
      userInput = reader.readLine();
    } catch (Exception e) {

    }
    return userInput;
  }

  private static int numberOfLinesInAFile(String filePath) {
    int lines = 0;
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath));
      while (reader.readLine() != null) {
        lines++;
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("IOException thrown while counting number of lines in the file...");
    }
    return lines;
  }

  private static int numberOfLinesInAString(String text) {
    if (text == null) {
      return 0;
    }
    int lines = 1;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == '\n') {
        lines++;
      }
    }
    return lines;
  }

  private static int numberOfWordsInAFile(String filePath) {
    int words = 0;
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath));
      String sentence = null;
      do {
        sentence = reader.readLine();
        words += numberOfWordsInAString(sentence);
      } while (sentence != null);
      reader.close();
    } catch (IOException e) {
      System.out.println("IOException thrown while counting number of words in the file...");
    }
    return words;
  }

  private static int numberOfWordsInAString(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }
    String[] words = text.split("\\s+");
    int counter = 0;
    for (int i = 0; i < words.length; i++) {
      if (!words[i].isEmpty()) {
        counter++;
      }
    }
    return counter;
  }

  private static int numberOfCharactersInAFile(String filePath) {
    int characterCount = 0;
    try {
      FileReader fileReader = new FileReader(filePath);
      int data;
      while ((data = fileReader.read()) != -1) {
        characterCount++;
      }
      fileReader.close();
    } catch (IOException e) {
      System.out.println("IOException thrown while counting number of characters in the file...");
    }
    return characterCount;
  }
}
