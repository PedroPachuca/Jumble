import java.util.Scanner;



public class LanguageMap {

	String myLanguage;
	
	// this needs a Map that maps keys ex:  "aehr" to the 
	// Set of String { "hare", "hear", "rhea"} that have those chars
	
	
	public LanguageMap(String lang, Scanner wordSource) {
		this.myLanguage=lang;
		// more...
	}
	
	public String getLanguage() {
		return myLanguage;
	}

}
