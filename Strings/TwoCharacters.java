import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    
    private static boolean isAlternating(String s) {
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
    
    static int alternate(String s) {
        // beabeefeab
        // abef
        Set<Character> distinct = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            distinct.add(s.charAt(i));
        }
 
        List<Character> distinctList = new ArrayList<>(distinct);
        
        int max = 0;
        for(Character ch : distinctList){
            System.out.print(ch);
        }
        System.out.println();
        // abef
        for(int i = 0; i < distinct.size() - 1; i++) {
            for(int j = i + 1; j < distinct.size() ; j++) {
                char c1 = distinctList.get(i);
                
                char c2 = distinctList.get(j); 
                System.out.println("[^" + c1 + c2 + "]");
                String subset = s.replaceAll(
                    "[^" + c1 + "" + c2 + "]", ""
                );
                System.out.println(s);
                System.out.println(subset);
                
                if(isAlternating(subset)) {
                    int len = subset.length();
                    max = len > max ? len : max;
                }
                
            }
        }
        
        
        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
