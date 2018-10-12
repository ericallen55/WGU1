package Eric.Allen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WGU {

    /*
    Business requirements that need to be clarified.
        distinct letter - are A and a the same letter.  Assumption Yes
        distinct letters between - if string has one letter return that letter, if there are 2 with no letters between them return them with a 0 between
     */

  /**
   * Takes a list of strings and converts them.
   * @param strings List of strings to convert
   * @return list of parsed strings
   */
  public List<String> WGU(List<String> strings) {
	List<String> outputStrings = new ArrayList<>();
	strings.forEach(string -> {
	  outputStrings.add(parseString(string));
	});

	System.out.println(Arrays.toString(outputStrings.toArray()));
	return outputStrings;
  }

  /**
   * Start of string parsing deals with special cases of null 0 and 1 length strings
   * @param string string to parse
   * @return fully parsed string
   */
  String parseString(String string){
	StringBuilder stringBuilder = new StringBuilder();

	List<String> strings = splitStringOnNonAlphaChars(string);
	strings.forEach(temp -> {
	  if(temp == null || temp.length() == 0){}
	  else if(temp.length() == 1)
		stringBuilder.append(temp);
	  else
		stringBuilder.append(singleString(temp));
	});
	return stringBuilder.toString();
  }

  /**
   * Takes a single string and converts it to the format
   * @param string string to convert
   * @return formated string
   */
  String singleString(String string){
	char[] characters = string.toCharArray();
	long length = countUniqueCharSkippingFirstAndLast(string);
	return characters[0] + Long.toString(length) + characters[characters.length - 1];
  }

  /**
   * Splits an input string on non alpha chars using a regex with lookahead and behind
   * @param input string to split
   * @return list of strings split on non alpha
   */
  List<String> splitStringOnNonAlphaChars(String input){
	return Arrays.asList(input.split("(?<=\\P{Alpha})|(?=\\P{Alpha})"));
  }

  /**
   * Counts the unique alpha chars between the first and last alpha char
   * @param input string to process
   * @return first alpha char number and last alpha char
   */
  long countUniqueCharSkippingFirstAndLast(String input){
	String temp = input.substring(1, input.length() - 1);
	return temp.chars().distinct().count();
  }
}
