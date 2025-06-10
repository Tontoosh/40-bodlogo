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
     * Complete the 'minimumLoss' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER_ARRAY price as parameter.
     */

    public static int minimumLoss(List<Long> price) {
    // Create a sorted copy of the prices list
    List<Long> sorted = new ArrayList<>(price);
    Collections.sort(sorted);

    // Map to store the original index of each price
    HashMap<Long, Integer> IndexMap = new HashMap<>();
    for (int i = 0; i < price.size(); i++) {
      IndexMap.put(price.get(i), i);
    }

    long minLoss = Long.MAX_VALUE;

    // Iterate through the sorted prices to calculate the minimum loss
    for (int i = 0; i < sorted.size() - 1; i++) {
      Long next = sorted.get(i + 1);
      Long current = sorted.get(i);
      // Check if the "next" price comes after the "current" price in the
      // original list
      if (next - current < minLoss
          && IndexMap.get(next) < IndexMap.get(current)) {
        minLoss = next - current;
      }
    }

    return (int) minLoss;
  }
}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> price = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        int result = Result.minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
