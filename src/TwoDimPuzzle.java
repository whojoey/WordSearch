/*
 * 
 */


import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *@author Joseph Hu
 */
public class TwoDimPuzzle {
    
    public static void main(String[] args) throws IOException {
        
        ReadFile f = new ReadFile();
        int count = 0;
        f.buildLines();
        f.buildArrays();
        SearchAlg s = new SearchAlg(f.row, f.wordBank);
        Map<String, List<Integer>> answer = s.coordFinder();
        for (String key: answer.keySet()) {
            System.out.print(key + ": ");
            for (Integer i : answer.get(key)) { 
                count++;
                switch (count) { 
                    case 1: System.out.print("["+"(" + i + ",");  
                        break;
                    case 2: System.out.print(i + ")-");
                        break;
                    case 3: System.out.print("("+ i + ",");
                        break;
                    case 4: count = 0;
                        System.out.print(i + ")]");
                        break;
                }
            }
            System.out.print("\n");
        }
    }
    
    
}
