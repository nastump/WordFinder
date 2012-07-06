package wordfinder;

import java.io.*;

public class IOHelper {
    
    BufferedReader br;
    DataInputStream in;
    
    IOHelper(){
	try{
            FileInputStream fstream = new FileInputStream("enable1.txt");	//setup to read from dictionary
            in = new DataInputStream(fstream);
            br = new BufferedReader(new InputStreamReader(in));
	    } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public String getUserInput(String prompt){

        String input = null;
	Boolean fileOpen = false;
        
        System.out.print(prompt);
        
        try{									//read in from the user
                BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
                input = is.readLine();
                
                if (input.length() == 0) return null;
                
            } catch (IOException e) {
                System.out.println("IOException: " + e);
            }
        return input.toLowerCase();						//convert to lower case and return
    }
    
    public String readLineFromFile(){
	String line = null;
	try {
	    line = br.readLine();
	} catch (Exception e){
	    System.err.println("Error: " + e.getLocalizedMessage());
	}
	
	if (line == null){
	    closeDictionary();
	    return null;
	} else return line;
    }
    
    private void closeDictionary(){
	try{
	    in.close();
	} catch (Exception e){
	    System.err.println("Error: " + e.getMessage());
	}
    }
}
