# min-loss

# ---Асуулт---"english" :
Lauren has a chart of distinct projected prices for a house over the next several years. She must buy the house in one year and sell it in another, and she must do so at a loss. She wants to minimize her financial loss.
Example
Her minimum loss is incurred by purchasing in year  at  and reselling in year  at . Return .
Function Description
Complete the minimumLoss function in the editor below.
minimumLoss has the following parameter(s):
int price[n]: home prices at each year
Returns
int: the minimum loss possible
Input Format
The first line contains an integer , the number of years of house data.
The second line contains  space-separated long integers that describe each .
Constraints
All the prices are distinct.
A valid answer exists.
Subtasks
 for  of the maximum score.
Sample Input 0
3
5 10 3
Sample Output 0
2
Explanation 0
Lauren buys the house in year  at  and sells it in year  at  for a minimal loss of .
Sample Input 1
5
20 7 8 2 5
Sample Output 1
2
Explanation 1
Lauren buys the house in year  at  and sells it in year  at  for a minimal loss of .

#---Асуулт---"Монголоор" :
Лаурен ирэх хэдэн жилд орон сууцны үнийн төсөөллийг харуулсан хүснэгттэй. Тэр орон сууцыг нэг жилд худалдаж аваад, өөр жилд заавал алдагдалтайгаар зарах ёстой. Түүний зорилго бол хамгийн бага алдагдал хүлээх явдал юм.

Жишээ:

Тэр хамгийн бага алдагдалтай байх тохиолдол нь:
Нэг жилд 5₮-өөр худалдаж аваад, дараа жилд 3₮-өөр зарсан. Энэ тохиолдолд түүний алдагдал 2₮ байна.
Параметрүүд:
price[n]: Жил бүрийн орон сууцны үнэ
Буцаах утга:
int: Боломжит хамгийн бага алдагдлын хэмжээ

Оролтын формат:

Эхний мөрөнд n — орон сууцны үнийн жилүүдийн тоо байна.

Хоёр дахь мөрөнд n ширхэг зайгаар тусгаарлагдсан бүхэл тоо байна — тус бүр тухайн жилд орон сууц хэдэн төгрөгөөр байсан.

Нөхцөлүүд:

Бүх үнийн утгууд давтагдахгүй.

Зөв хариу байх нь баталгаатай.

Хэсэг оноо авах дэд даалгавар: n ≤ 10⁵

Жишээ Оролт 0:

3  
5 10 3
Жишээ Гаралт 0:

2
Тайлбар 0:

Лаурен 5₮-өөр худалдан авч, 3₮-өөр зарсан. Алдагдал = 2₮.

Жишээ Оролт 1:

5  
20 7 8 2 5
Жишээ Гаралт 1:

2
Тайлбар 1:

7₮-өөр авч, 5₮-өөр зарсан — хамгийн бага алдагдалтай хувилбар юм.
#---Код---"java"

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

#---Тайлбар--- ![Screenshot 2025-06-09 163038](https://github.com/user-attachments/assets/d70a9111-75e8-4ad1-bbc9-79153a90e7e3)
Хувилбар үүсгэх:
price нэртэй анхны үнийн жагсаалтыг хуулж, sorted нэртэй жагсаалтад хадгална. Дараа нь үүнийг өсөх дарааллаар эрэмбэлнэ.

Индексд хадгалах:
IndexMap нэртэй HashMap үүсгээд, анхны жагсаалтын үнэ бүрийн индексд хадгална. Ингэснээр ямар үнэ хэдэн онд байсан бэ гэдгийг санах боломжтой болдог.

Хамгийн бага алдагдал хайх:
Эрэмбэлэгдсэн sorted жагсаалтыг ашиглан дараалсан хоёр үнэ (current ба next)-ийн ялгааг тооцно.

Алдагдлын нөхцөлийг шалгах:
Хоёр үнэ хоорондын ялгаа (next - current) өмнө олдсон хамгийн бага алдагдлаас бага байж, өндөр үнэ бага үнийн дараа байх ёстой (энэ нь анхны жагсаалтад дарааллаараа байх ёстой). Энэ нь: Лаурен заавал хямд үнээр хожим нь зарж байгаа эсэхийг шалгаж байна гэсэн үг.

Алдагдлыг шинэчлэх:
Хэрэв дээрх нөхцөлүүд биелсэн бол minLoss хувьсагчийг шинэ утгаар шинэчилнэ.

Хариу буцаах:
Бүх харьцуулалтыг хийсний дараа хамгийн бага алдагдлыг int төрөлд хөрвүүлэн буцаана.

