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
    
    private static int partition(List<Integer> arr, int begin, int end) {
        // 3 2 4 5 7
        
        int pivot = arr.get(end); //7 
        int i = (begin - 1); // -1
        
        // 0 1 2 3 4
        for (int j = begin; j < end; j++) {
            if (arr.get(j) <= pivot) {
                i++;  
                int swapTemp = arr.get(i); 
                arr.set(i,arr.get(j)); 
                arr.set(j,swapTemp); 
            } 
        } 
    
        int swapTemp = arr.get(i+1);
        arr.set(i+1,pivot);
        arr.set(end,swapTemp);  

        return i+1;
    }
    
    public static List<Integer> sort(List<Integer> arr,int begin,int end){ 
        
        if (begin < end) { 
            // 3 2 4 5 7
         int partitionIndex = partition(arr, begin, end);

         sort(arr, begin, partitionIndex-1);
         sort(arr, partitionIndex+1, end);
        }
        return arr;
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        // 3 2 4 5 7
        sort(arr,0,arr.size()-1);
        return arr;
    }
 
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.quickSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
