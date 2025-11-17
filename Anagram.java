/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	// need to get all the char change it to small cap and ignore space
	// if 
	public static boolean isAnagram(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		str1 = str1.replace(" ", "");
		str2 = str2.replace(" ", "");
		if (str1.length() != str2.length()){
			return false;
		}else { for (int i = 0; i<str1.length();i++ ){
					for (int j=0; j<str2.length();j++){
						if (str1.charAt(i)==str2.charAt(j)) {
							str2.replace("" + str1.charAt(i), "");
						}
					}
			}
		} return true;
		
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		str = str.replace("?", "");
		str = str.replace("!", "");
		str = str.replace(".", "");
		str = str.replace("?", "");
		return str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order.
	// using lenght and random 
	// my mistake - when i do replace it change all the chars that equal if the word is - null
	// and we replace "ll" to "m" it will be numm, replace is not right here
	// i need to make res as null and than to add random char to res and delete the char from str
	public static String randomAnagram(String str) {
		String res="";
		String copy = str;
		for (int i = 0 ; i<copy.length();i++){
			int j = (int)(Math.random() * str.length());			
			res = res + str.charAt(j); 
			str = str.substring(0, j) + str.substring(j + 1);		}
			return res;
	}}