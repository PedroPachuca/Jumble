import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;



public class LanguageMap {

	String myLanguage;
	HashMap<String, HashSet<String>> wordMap;
	
	// this needs a Map that maps keys ex:  "aehr" to the 
	// Set of String { "hare", "hear", "rhea"} that have those chars
	
	
	public LanguageMap(String lang, Scanner wordSource) {
		this.myLanguage=lang;
		wordMap = new HashMap<String, HashSet<String>>();
		
		setUpMaps(wordSource);
	}
	private void setUpMaps(Scanner source) {
		while(source.hasNextLine()) {
			String word = source.nextLine();
			String key = alph(word);
			if(wordMap.get(key) == null) {
				wordMap.put(key, new HashSet<String>());
			}
			wordMap.get(key).add(word);
		}
		System.out.println("finished loading maps");
	}
	
	public String alph(String word) {
		char[] alphThis = word.toCharArray();
		Arrays.sort(alphThis);
		String alphabetized = new String(alphThis);
		return alphabetized;
	}
	
	public String getLanguage() {
		return myLanguage;
	}
	public HashSet<String> findPossilities(String key) {
		HashSet<String> values = wordMap.get(key);
		return values;
	}

}
