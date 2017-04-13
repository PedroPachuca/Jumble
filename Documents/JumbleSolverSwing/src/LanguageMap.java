import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;



public class LanguageMap {

	String myLanguage;
	HashMap wordMap;
	
	// this needs a Map that maps keys ex:  "aehr" to the 
	// Set of String { "hare", "hear", "rhea"} that have those chars
	
	
	public LanguageMap(String lang, Scanner wordSource) {
		this.myLanguage=lang;
		wordMap = new HashMap();
		
		setUpMaps(wordSource);
	}
	private void setUpMaps(Scanner source) {
		while(source.hasNextLine()) {
			String word = source.nextLine();
			String key = alph(word);
			wordMap.put(key, word);
		}
		System.out.println("finished loading maps");
	}
	
	public String alph(String word) {
		char[] alphThis = word.toCharArray();
		Arrays.sort(alphThis);
		System.out.println(alphThis);
		return alphThis.toString();
	}
	
	public String getLanguage() {
		return myLanguage;
	}
	public Object findPossilities(String key) {
		Object values = wordMap.get(key);
		System.out.println(values);
		return values;
	}

}
