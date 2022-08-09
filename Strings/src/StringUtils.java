import java.util.Arrays;

// import java.util.HashMap;
// import java.util.Map;

public class StringUtils {
  public int findVowels(String str) {
    int count = 0;
    for (char ch : str.toCharArray())
      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
        count++;
    return count;
    // set = {a,e,i,o,u} - set.contains(ch.toLowerCase())
  }

  public void reverseWord(String str) {
    char[] arr = str.toCharArray();
    for (int i = arr.length - 1; i >= 0; i--)
      System.out.print(arr[i]);
    // StringBuilder - (append)
  }

  public void reverseSentence(String str) {
    String[] strings = str.split("\\s+");
    for (int i = strings.length - 1; i >= 0; i--)
      System.out.print(strings[i] + " ");
    // Collections.reverse(Arrays.asList(str.trim().split(" ")))
  }

  public boolean areRotations(String str1, String str2) {
    if (str1.length() != str2.length())
      return false;
    if (!(str1 + str2).contains(str2))
      return false;
    return true;
  }

  public char getMaxOccurences(String str) {
    // Map<Character, Integer> freq = new HashMap<Character, Integer>();
    // for (char ch : str.toCharArray()) {
    // if (freq.containsKey(ch))
    // freq.replace(ch, freq.get(ch) + 1);
    // else
    // freq.put(ch, 1);
    // }
    final int ASCII_SIZE = 256;
    int[] freq = new int[ASCII_SIZE];
    for (char ch : str.toCharArray())
      freq[ch]++;
    int max = 0;
    char result = ' ';
    for (int i = 0; i < freq.length; i++)
      if (freq[i] > max) {
        max = freq[i];
        result = (char) i;
      }
    return result;
  }

  public String capatalize(String sentence) {
    if (sentence == null || sentence.trim().isEmpty())
      return "";
    String[] words = sentence.trim().replaceAll(" +", " ").split(" ");
    for (int i = 0; i < words.length; i++)
      words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
    return String.join("", words);
  }

  public boolean areAnagrams(String first, String second) {
    if (first == null || second == null || first.length() != second.length())
      return false;

    var a = first.toLowerCase().toCharArray();
    Arrays.sort(a);

    var b = second.toLowerCase().toCharArray();
    Arrays.sort(b);

    return Arrays.equals(a, b);
  }

  public boolean isPalindrome(String str) {
    // StringBuilder string = new StringBuilder(str);
    // string.reverse();
    // return string.toString().equals(str);
    if (str == null)
      return false;
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      if (str.charAt(left++) != str.charAt(right--))
        return false;
    }
    return true;
  }
}
