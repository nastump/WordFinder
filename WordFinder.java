package wordfinder;

public class WordFinder {

    private IOHelper helper = new IOHelper();
    private int gramCount = 0;
    private String strRack = null;
    
    private void findAnagrams(){
	
	String strLine, strWord, letter;
        
	Boolean isGram;
        int wordPosition, rackPosition;
//test
	while ((strLine = helper.readLineFromFile()) != null){			//read a line (word) from the file
	    strWord = strLine;							//make a copy to work on
	    rackPosition = 0;							//reset vars for each line
	    wordPosition = 0;
	    isGram = true;

	    while (rackPosition < 7){						//if a letter on the rack exists in the word replace it in the word with "^"
		letter = strRack.substring(rackPosition, rackPosition + 1);
		strWord = strWord.replaceFirst(letter, "^");
		rackPosition++;
	    }

	    while ((wordPosition <  strWord.length()) && isGram){		//check if the entire word was changed to "^"
		if (strWord.charAt(wordPosition) != '^'){
		    isGram = false;
		}
		wordPosition++;
	    }

	    if (isGram){							//if its an anagram output the word and add to the count
		System.out.println(strLine);
		gramCount++;
	    }

	}

//	helper.closeDictionary();

        System.out.println("\nTotal Anagrams Found: " + gramCount);
    }
    
    private void getRack(){
	String prompt1 = "Enter the rack: ";
	strRack = helper.getUserInput(prompt1);
    }
    
    public static void main(String[] args) {
	
	WordFinder wf = new WordFinder();
	wf.getRack();
	wf.findAnagrams();

	String prompt2 = "Again? (y/n): ";
	String repeat = "y";

    }
}
