

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Joseph Hu
 */

public class ReadFile {

    ArrayList<ArrayList<Character>> row = new ArrayList<>();
    String[] wordBank;
    ArrayList<String> line = new ArrayList<>();
        
  
    /*Read from the file and build the 2d array*/
    public void buildLines() throws IOException {
        
        File input = new File("input.txt");
        BufferedReader wordFile = new BufferedReader(new FileReader(input));
        String curLine = null;
        String delim = "[ ]+";
        
        //Store in all
        while ((curLine = wordFile.readLine()) != null) {
                 
            
            //Get out of loop if Blank Line
            if (curLine.equals("")) {
                curLine = "";
                break;
            }
            line.add(curLine);
           
        }
        
        //Create the word Bank from the file
        String s;
        while ((s = wordFile.readLine()) != null) {
            curLine += s + " ";
        }
        wordBank = curLine.split(delim);
        
            
        
           

       
    }
    
    public void buildArrays() {
        //Stores the contents of each line into 2D array
        for (String eachLine: line) {
            
            //Strips the white space
            String trimString = eachLine.replaceAll("\\s+","");
            ArrayList<Character> temp = new ArrayList<>();
            int strLength = trimString.length();
            
            //add to the column of arrayList
            for(int i = 0; i < strLength; i++)
                temp.add(trimString.charAt(i));
            
                        
            row.add(temp);
            //temp.clear(); Why does this affect my ArrayList even after you clear?
                        
        }
    }
     
       
    
}