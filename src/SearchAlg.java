/*
 * 
 */



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class SearchAlg {
    
    ArrayList<ArrayList<Character>> file2Darray;
    String[] wordBank;
    Map<String, List<Integer>> answer = new HashMap<>();
    
    
    //Global index of where it is in the word in wordBank
    int curLetIndx;
    
    public SearchAlg(ArrayList<ArrayList<Character>> file2Darray, String[] wordBank) {
      
        this.file2Darray = file2Darray;
        this.wordBank = wordBank;
       
    }
    
    
    
      
    // Walking through each row and column and checking for the letter
    public Map<String, List<Integer>> coordFinder() {
        
        int rowsize = file2Darray.size();
        //Pull first word
        for (String word: wordBank) {
           
            //Zero out the index because new word
            curLetIndx = 0;
            
            //Check for first letter of word correct
            for (int row = 0; row < rowsize; row++) {
                
                int colsize = file2Darray.get(row).size();
                        
                for (int col = 0; col < colsize; col++)  {
                    
                      
                    if (letterCorNxt(word, file2Darray.get(row).get(col))) {
                    //Found first letter, look in all directions    
                        
                        // Make sure word will not be out of bounds
                        //Searching Right and Bounds
                        if (col + (word.length()-1) < colsize) {
                            
                            int curCol = col; 
                            int curRow = row;
                            curLetIndx = 1;
                            while (curCol < colsize && curLetIndx != 0) {
                                curCol++;
                                if (curCol < colsize && letterCorNxt(word, file2Darray.get(curRow).get(curCol)) && curLetIndx == word.length()) {
                                    //Add the coordinate to the Map
                                    if (answer.containsKey(word)) { 
                                        answer.get(word).add(row+1);
                                        answer.get(word).add(col+1);
                                        answer.get(word).add(curRow+1);
                                        answer.get(word).add(curCol+1);
                                    } else {
                                        List<Integer> coord = new ArrayList(); //The order is Start(Row, Col) End(Row, Col) in List
                                        coord.add(row+1);
                                        coord.add(col+1);
                                        coord.add(curRow+1);
                                        coord.add(curCol+1);
                                        answer.put(word, coord);
                                        //Starts col row);
                                        //Ends: x=" + (curCol +1)curRow
                                    }
                                }
                                
                            }
                            
                             
                            
                        } 
                        
                        //Search Left and Bounds
                        if (col - (word.length()-1) >= 0 ) {
                            curLetIndx = 1; /*This resets it to 1 in case coordinates have already been found on SAME letter*/
                            int curCol = col; 
                            int curRow = row;
                            while (curCol >= 0) {
                                curCol--;
                                if (curCol >= 0 && letterCorNxt(word, file2Darray.get(curRow).get(curCol)) && curLetIndx == word.length()) {
                                    if (answer.containsKey(word)) { 
                                        answer.get(word).add(row+1);
                                        answer.get(word).add(col+1);
                                        answer.get(word).add(curRow+1);
                                        answer.get(word).add(curCol+1);
                                    } else {
                                        List<Integer> coord = new ArrayList(); //The order is Start(Row, Col) End(Row, Col) in List
                                        coord.add(row+1);
                                        coord.add(col+1);
                                        coord.add(curRow+1);
                                        coord.add(curCol+1);
                                        answer.put(word, coord);
                                        
                                   
                                    }

                                   //System.out.println("\n" + word + "\n" + "Starts: x=" + col + " " + "y=" + row);
                                   //System.out.println("Ends: x=" + (curCol - 1) + " " + "y=" + curRow);
                                }
                                
                                
                            }
                        }
                        
                        //Search Downwards and Bounds
                        if (row + (word.length()-1) < rowsize) {
                            curLetIndx = 1; /*This resets it to 1 in case coordinates have already been found on SAME letter*/
                            int curCol = col; 
                            int curRow = row;
                            
                            while (curRow < rowsize && curLetIndx != 0) {
                                curRow++;
                                if (curRow < rowsize && letterCorNxt(word, file2Darray.get(curRow).get(curCol)) && curLetIndx == word.length()) {
                                   if (answer.containsKey(word)) { 
                                        answer.get(word).add(row+1);
                                        answer.get(word).add(col+1);
                                        answer.get(word).add(curRow+1);
                                        answer.get(word).add(curCol+1);
                                    } else {
                                        List<Integer> coord = new ArrayList(); //The order is Start(Row, Col) End(Row, Col) in List
                                        coord.add(row+1);
                                        coord.add(col+1);
                                        coord.add(curRow+1);
                                        coord.add(curCol+1);
                                        answer.put(word, coord);
                                        
                                    }
                                    //System.out.println("\n" + word + "\n" + "Starts: x=" + col + " " + "y=" + row);
                                   //System.out.println("Ends: x=" + curCol + " " + "y=" + (curRow+1));
                                }
                                
                            }
                            
                        }
                        
                        //Search Upwards and Bounds
                        if (row - (word.length()-1) >= 0 ) {
                            curLetIndx = 1; /*This resets it to 1 in case coordinates have already been found on SAME letter*/
                            int curCol = col; 
                            int curRow = row;
                            while (curRow >= 0) {
                                curRow--;
                                if (curRow >= 0 && letterCorNxt(word, file2Darray.get(curRow).get(curCol)) && curLetIndx == word.length()) {
                                   if (answer.containsKey(word)) { 
                                        answer.get(word).add(row+1);
                                        answer.get(word).add(col+1);
                                        answer.get(word).add(curRow+1);
                                        answer.get(word).add(curCol+1);
                                    } else {
                                        List<Integer> coord = new ArrayList(); //The order is Start(Row, Col) End(Row, Col) in List
                                        coord.add(row+1);
                                        coord.add(col+1);
                                        coord.add(curRow+1);
                                        coord.add(curCol+1);
                                        answer.put(word, coord);
                                        
                                   }
                                    //System.out.println("\n" + word + "\n" + "Starts: x=" + col + " " + "y=" + row);
                                   //System.out.println("Ends: x=" + curCol + " " + "y=" + (curRow-1));
                                }
                                
                                
                            }
                        }
                        
                        //Search Upper Left and Bounds
                        if (row - (word.length()-1) >= 0 && col - (word.length()-1) >= 0  ) {
                            curLetIndx = 1;
                            int curCol = col; 
                            int curRow = row;
                            while (curRow >= 0 && curCol >= 0) {
                                curRow--;
                                curCol--;
                                if (curRow >= 0 && curCol>=0 && letterCorNxt(word, file2Darray.get(curRow).get(curCol)) && curLetIndx == word.length()) {
                                   if (answer.containsKey(word)) { 
                                        answer.get(word).add(row+1);
                                        answer.get(word).add(col+1);
                                        answer.get(word).add(curRow+1);
                                        answer.get(word).add(curCol+1);
                                    } else {
                                        List<Integer> coord = new ArrayList(); //The order is Start(Row, Col) End(Row, Col) in List
                                        coord.add(row+1);
                                        coord.add(col+1);
                                        coord.add(curRow+1);
                                        coord.add(curCol+1);
                                        answer.put(word, coord);
                                        
                                   
                                    }
                                   //System.out.println("\n" + word + "\n" + "Starts: x=" + col + " " + "y=" + row);
                                   //System.out.println("Ends: x=" + (curCol-1) + " " + "y=" + (curRow-1));
                                }
                            }
                            
                        }
                        
                        //Search Upper Right and Bounds
                        if (row - (word.length()-1) >= 0 && col + (word.length()-1) < colsize) {
                            curLetIndx = 1;
                            int curCol = col; 
                            int curRow = row;
                            while (curRow >= 0 && curCol < colsize) {
                                curRow--;
                                curCol++;
                                if (curRow >= 0 && curCol < colsize && letterCorNxt(word, file2Darray.get(curRow).get(curCol)) && curLetIndx == word.length()) {
                                   if (answer.containsKey(word)) { 
                                        answer.get(word).add(row+1);
                                        answer.get(word).add(col+1);
                                        answer.get(word).add(curRow+1);
                                        answer.get(word).add(curCol+1);
                                    } else {
                                        List<Integer> coord = new ArrayList(); //The order is Start(Row, Col) End(Row, Col) in List
                                        coord.add(row+1);
                                        coord.add(col+1);
                                        coord.add(curRow+1);
                                        coord.add(curCol+1);
                                        answer.put(word, coord);
                                        
                                    }
                                    //System.out.println("\n" + word + "\n" + "Starts: x=" + col + " " + "y=" + row);
                                   //System.out.println("Ends: x=" + (curCol+1) + " " + "y=" + (curRow-1));
                                }
                            }
                            
                        }
                        
                        //Search Downward Left and Bounds
                        if (row + (word.length()-1) < rowsize && col - (word.length()-1) >= 0 ) {
                            curLetIndx = 1;
                            int curCol = col; 
                            int curRow = row;
                            while (curRow < rowsize && curCol >= 0) {
                                curRow++;
                                curCol--;
                                if (curRow < rowsize && curCol >= 0 && letterCorNxt(word, file2Darray.get(curRow).get(curCol)) && curLetIndx == word.length()) {
                                   if (answer.containsKey(word)) { 
                                        answer.get(word).add(row+1);
                                        answer.get(word).add(col+1);
                                        answer.get(word).add(curRow+1);
                                        answer.get(word).add(curCol+1);
                                    } else {
                                        List<Integer> coord = new ArrayList(); //The order is Start(Row, Col) End(Row, Col) in List
                                        coord.add(row+1);
                                        coord.add(col+1);
                                        coord.add(curRow+1);
                                        coord.add(curCol+1);
                                        answer.put(word, coord);
                                        
                                    }
                                    //System.out.println("\n" + word + "\n" + "Starts: x=" + col + " " + "y=" + row);
                                   //System.out.println("Ends: x=" + (curCol-1) + " " + "y=" + (curRow+1));
                                }
                            }
                            
                        }
                        
                        //Search Downward Right and Bounds
                        if (row + (word.length()-1) < rowsize && col + (word.length()-1) < colsize) {
                            curLetIndx = 1;
                            int curCol = col; 
                            int curRow = row;
                            while (curRow < rowsize && curCol < colsize) {
                                curRow++;
                                curCol++;
                                if (curRow < rowsize && curCol < colsize && letterCorNxt(word, file2Darray.get(curRow).get(curCol)) && curLetIndx == word.length()) {
                                   if (answer.containsKey(word)) { 
                                        answer.get(word).add(row+1);
                                        answer.get(word).add(col+1);
                                        answer.get(word).add(curRow+1);
                                        answer.get(word).add(curCol+1);
                                    } else {
                                        List<Integer> coord = new ArrayList(); //The order is Start(Row, Col) End(Row, Col) in List
                                        coord.add(row+1);
                                        coord.add(col+1);
                                        coord.add(curRow+1);
                                        coord.add(curCol+1);
                                        answer.put(word, coord);
                                        
                                    }
                                    //System.out.println("\n" + word + "\n" + "Starts: x=" + col + " " + "y=" + row);
                                   //System.out.println("Ends: x=" + (curCol+1) + " " + "y=" + (curRow+1));
                                }
                            }
                            
                        }
                            
                            
                    }      
                            
                }
                        
                        
                        
                        
                        
            }
                    
        }
            
        return answer;
        
    }
    
    
    
    
    /*Checks whether letter is correct and returns second letter*/
    public boolean letterCorNxt(String word2Check, char matrLet) {
                       
        boolean flag = true;
        
        if (curLetIndx < word2Check.length() && word2Check.charAt(curLetIndx) == matrLet) {
            curLetIndx++;
            
        } else {
            flag = false;
            curLetIndx = 0;
        }
        
        return flag;
    }
        
        
    

    

}

