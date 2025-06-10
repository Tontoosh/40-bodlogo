

# File: ./algorithm/hard/6/README.md

# count string

---Асуулт---"english" :
A regular expression is used to describe a set of strings. For this problem the alphabet is limited to 'a' and 'b'.

We define  to be a valid regular expression if:
1)  is "" or "".
2)  is of the form "", where  and  are regular expressions.
3)  is of the form "" where  and  are regular expressions.
4)  is of the form "" where  is a regular expression.

Regular expressions can be nested and will always have have two elements in the parentheses. ('' is an element, '' is not; basically, there will always be pairwise evaluation) Additionally, '' will always be the second element; '' is invalid.

The set of strings recognized by  are as follows:
1) If  is "", then the set of strings recognized .
2) If  is "", then the set of strings recognized .
3) If  is of the form "" then the set of strings recognized = all strings which can be obtained by a concatenation of strings  and , where  is recognized by  and  by .
4) If  is of the form "" then the set of strings recognized = union of the set of strings recognized by  and .
5) If  is of the form "" then the the strings recognized are the empty string and the concatenation of an arbitrary number of copies of any string recognized by .

Task
Given a regular expression and an integer, , count how many strings of length  are recognized by it.

Input Format

The first line contains the number of test cases .  test cases follow.
Each test case contains a regular expression, , and an integer, .

Constraints

It is guaranteed that  will conform to the definition provided above.
Output Format

Print  lines, one corresponding to each test case containing the required answer for the corresponding test case. As the answers can be very big, output them modulo .

Sample Input
3  
((ab)|(ba)) 2  
((a|b)*) 5  
((a*)(b(a*))) 100
Sample Output
2  
32  
100
Explanation

For the first case, the only strings recognized are "" and "". Of the  possible strings of length ,  of them fit that expression.
For the second case, the RegEx recognizes any string of any length containing only 's and 's. The number of strings of length  recognized by this expression is .
For the third case, the RegEx recognizes any string having one , preceeded and followed by any number of 's. There are  strings of length  which have a single  in them.

---Асуулт---"Монголоор" :
Энэ бодлогод бид зөвхөн 'a' ба 'b' гэсэн хоёр үсгийг агуулсан үгийн олонлогийг дүрсэлдэг тогтмол илэрхийлэл (regular expression) ашиглана.

Тогтмол илэрхийлэл дараах нөхцлүүдийг хангах бол зөвшөөрөгдөнө:

"a" эсвэл "b" бол шууд зөв.

"(R1R2)" хэлбэртэй бол зөв. Энд R1 ба R2 нь өөрсдөө тогтмол илэрхийлэл.

"(R1|R2)" хэлбэртэй бол зөв. Энд | нь эсвэл (OR)-ийн утгатай.

"(R1*)” хэлбэртэй бол зөв. Энэ нь R1-ийн дурын тооны давталтыг илэрхийлнэ (0 ба түүнээс дээш удаа).

Тайлбар:

Илэрхийлэл үргэлж хоёр элементийг хамарсан хаалттай бүтэцтэй байна. Жишээ нь: ((a|b)*) зөв, харин (a|) бол буруу.

* тэмдэг үргэлж хоёр дахь элемент байж болохгүй ((*a) буруу), зөвхөн "(R1*)" хэлбэртэй байна.

Илэрхийлэл ямар үгсийг хүлээн зөвшөөрөх вэ:

"a" гэвэл зөвхөн "a" үгийг.

"b" гэвэл зөвхөн "b" үгийг.

"(R1R2)" бол R1 ба R2-оор тодорхойлогдох үгсийг нийлүүлэн гарсан бүх үгсийг.

"(R1|R2)" бол R1 эсвэл R2-оор тодорхойлогдох үгс.

"(R1*)" бол R1-оор тодорхойлогдох үгийг дурын тоогоор давтсан үгс (0 удаа давтах ч боломжтой, өөрөөр хэлбэл хоосон үг ч багтана).

Даалгавар:
Тогтмол илэрхийлэл r болон бүхэл тоо l өгөгдөх ба, уг илэрхийлэлд таарах яг урт нь l үг хэд байгааг ол.

Оролт:

Эхний мөрөнд туршилтын тоо t (жишээ нь: 3).
Дараагийн t мөр бүрд:

Тогтмол илэрхийлэл r

Бүхэл тоо l

Гаралт:

Туршилт бүрийн хувьд 1 мөрөнд, тухайн тогтмол илэрхийлэлд таарах яг урт l үг хэд байгааг хэвлэ.

Тоо их байж болзошгүй учраас 10^9 + 7 модулоор гаргана.

Жишээ оролт:
3  
((ab)|(ba)) 2  
((a|b)*) 5  
((a*)(b(a*))) 100
Гаралт:

2  
32  
100
Тайлбар:

Эхний илэрхийлэл (ab) ба (ba) хоёрын аль нэгийг зөвшөөрнө. 2 тэмдэгттэй үг 2 ширхэг л байна.

Хоёр дахь нь a болон b үсгийг дурын удаа давтахыг зөвшөөрнө. Тиймээс урт нь 5 байх бүх боломжит үгс: 2^5 = 32

Гурав дахь нь ганц b үсэг дунд нь орсон, хоёр талаараа дурын тооны a үсэгтэй үгсийг зөвшөөрнө. Жишээ нь: aaabaa, baaa, aaaaab, гэх мэт. Яг нэг b ба бусад нь a гэсэн үгс, урт нь 100 байх боломжит ийм үгсийн тоо: 100.
---Код---" "
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
    static List<List<int[]>> graph;
    static List<int[]> dfa;
    static List<List<Integer>> matrix;
    static List<Integer> finalStates;
    static List<Integer> epsilon;
    static boolean[] visited;

    static void buildNFA(String s, int[] index, int in, int out) {
        if (s.charAt(index[0]) == 'a') {
            graph.get(in).add(new int[]{out, 1});
            index[0]++;
            return;
        }
        if (s.charAt(index[0]) == 'b') {
            graph.get(in).add(new int[]{out, 2});
            index[0]++;
            return;
        }
        int m1 = graph.size();
        graph.add(new ArrayList<>());
        int m2 = graph.size();
        graph.add(new ArrayList<>());
        index[0]++;
        buildNFA(s, index, m1, m2);
        if (s.charAt(index[0]) == '*') {
            graph.get(m2).add(new int[]{m1, 0});
            graph.get(in).add(new int[]{m2, 0});
            graph.get(m2).add(new int[]{out, 0});
            index[0] += 2;
            return;
        }
        if (s.charAt(index[0]) == '|') {
            graph.get(in).add(new int[]{m1, 0});
            graph.get(m2).add(new int[]{out, 0});
            index[0]++;
            buildNFA(s, index, m1, m2);
            index[0]++;
            return;
        }
        graph.get(in).add(new int[]{m1, 0});
        buildNFA(s, index, m2, out);
        index[0]++;
    }

    static void dfsEpsilon(int node) {
        if (visited[node]) return;
        visited[node] = true;
        epsilon.add(node);
        for (int[] e : graph.get(node)) {
            if (e[1] == 0) dfsEpsilon(e[0]);
        }
    }

    static void dfs(List<Integer> state, int type) {
        visited = new boolean[graph.size()];
        epsilon = new ArrayList<>();
        for (int node : state) {
            for (int[] e : graph.get(node)) {
                if (e[1] == type) dfsEpsilon(e[0]);
            }
        }
    }

    static void NFAtoDFA() {
        Map<List<Integer>, Integer> map = new HashMap<>();
        List<List<Integer>> states = new ArrayList<>();
        dfa = new ArrayList<>();
        epsilon = new ArrayList<>();
        visited = new boolean[graph.size()];
        dfsEpsilon(0);
        Collections.sort(epsilon);
        states.add(new ArrayList<>(epsilon));
        map.put(new ArrayList<>(epsilon), 0);
        dfa.add(new int[]{-1, -1});
        int n = 1;
        for (int i = 0; i < n; i++) {
            dfs(states.get(i), 1);
            Collections.sort(epsilon);
            if (!epsilon.isEmpty()) {
                List<Integer> eCopy = new ArrayList<>(epsilon);
                if (!map.containsKey(eCopy)) {
                    map.put(eCopy, n++);
                    states.add(eCopy);
                    dfa.add(new int[]{-1, -1});
                }
                dfa.get(i)[0] = map.get(eCopy);
            }
            dfs(states.get(i), 2);
            Collections.sort(epsilon);
            if (!epsilon.isEmpty()) {
                List<Integer> eCopy = new ArrayList<>(epsilon);
                if (!map.containsKey(eCopy)) {
                    map.put(eCopy, n++);
                    states.add(eCopy);
                    dfa.add(new int[]{-1, -1});
                }
                dfa.get(i)[1] = map.get(eCopy);
            }
        }
        matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>(Collections.nCopies(n, 0)));
        }
        for (int i = 0; i < n; i++) {
            if (dfa.get(i)[0] != -1) matrix.get(i).set(dfa.get(i)[0], matrix.get(i).get(dfa.get(i)[0]) + 1);
            if (dfa.get(i)[1] != -1) matrix.get(i).set(dfa.get(i)[1], matrix.get(i).get(dfa.get(i)[1]) + 1);
        }
        finalStates = new ArrayList<>();
        for (int i = 0; i < states.size(); i++) {
            visited = new boolean[graph.size()];
            epsilon = new ArrayList<>();
            for (int node : states.get(i)) dfsEpsilon(node);
            if (epsilon.contains(1)) finalStates.add(i);
        }
    }

    static void mmult(List<List<Integer>> A, List<List<Integer>> B) {
        int n = A.size();
        List<List<Integer>> R = new ArrayList<>();
        for (int i = 0; i < n; i++) R.add(new ArrayList<>(Collections.nCopies(n, 0)));
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    sum = (sum + A.get(i).get(k) * 1L * B.get(k).get(j)) % 1000000007;
                }
                R.get(i).set(j, (int) sum);
            }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A.get(i).set(j, R.get(i).get(j));
    }

    static void mexp(List<List<Integer>> M, int power) {
        int n = M.size();
        List<List<Integer>> R = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            R.add(new ArrayList<>(Collections.nCopies(n, 0)));
            R.get(i).set(i, 1);
        }
        while (power > 0) {
            if ((power & 1) != 0) mmult(R, M);
            power >>= 1;
            if (power > 0) mmult(M, M);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                M.get(i).set(j, R.get(i).get(j));
    }

    public static int countStrings(String r, int l) {
        graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        int[] index = {0};
        buildNFA(r, index, 0, 1);
        NFAtoDFA();
        mexp(matrix, l);
        long res = 0;
        for (int j : finalStates) {
            res = (res + matrix.get(0).get(j)) % 1000000007;
        }
        return (int) res;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        for (int tItr = 0; tItr < t; tItr++) {
            String[] parts = bufferedReader.readLine().split(" ");
            String r = parts[0];
            int l = Integer.parseInt(parts[1]);
            int result = Result.countStrings(r, l);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}


---Тайлбар--- 
![count string](https://github.com/user-attachments/assets/061d7327-42aa-4134-b601-9f8d6980493b)


# File: ./algorithm/med/2/README.md

# Highest Value Palindrome

## ---Асуулт---"english" :
Palindromes are strings that read the same from the left or right, for example madam or 0110.

You will be given a string representation of a number and a maximum number of changes you can make. Alter the string, one digit at a time, to create the string representation of the largest number possible given the limit to the number of changes. The length of the string may not be altered, so you must consider 's left of all higher digits in your tests. For example  is valid,  is not.

Given a string representing the starting number, and a maximum number of changes allowed, create the largest palindromic string of digits possible or the string '-1' if it is not possible to create a palindrome under the contstraints.

Example


Make  replacements to get .



Make  replacement to get .

Function Description

Complete the highestValuePalindrome function in the editor below.

highestValuePalindrome has the following parameter(s):

string s: a string representation of an integer
int n: the length of the integer string
int k: the maximum number of changes allowed
Returns

string: a string representation of the highest value achievable or -1
Input Format

The first line contains two space-separated integers,  and , the number of digits in the number and the maximum number of changes allowed.
The second line contains an -digit string of numbers.

Constraints

Each character  in the number is an integer where .
Output Format

Sample Input 0

STDIN   Function
-----   --------
4 1     n = 4, k = 1
3943    s = '3943'
Sample Output 0

3993
Sample Input 1

6 3
092282
Sample Output 1

992299
Sample Input 2

4 1
0011
Sample Output 2

-1
Explanation

Sample 0

There are two ways to make  a palindrome by changing no more than  digits:
## ---Асуулт---"Монголоор" :
 Бодлогын тайлбар :
Палиндром гэдэг нь хоёр талаасаа ижилхэн уншигддаг тоо буюу тэмдэгт мөр юм.
Жишээ нь: “madam” болон “0110” бол палиндромууд.
Танд нэг тоог тэмдэгт мөр (string) хэлбэрээр өгнө.
Та тухайн тэмдэгт мөр дотроос зарим цифрүүдийг өөрчлөх боломжтой.
Гэхдээ хамгийн ихдээ k удаа өөрчилж болно.
Тэмдэгт мөрийн уртыг өөрчилж болохгүй.
Зорилго нь: боломжийн хамгийн их утгатай палиндром үүсгэх юм.
Хэрвээ палиндром үүсгэх боломжгүй бол "-1" гэж буцаах хэрэгтэй.
 Функцийн тайлбар :
highestValuePalindrome гэдэг функц бичих шаардлагатай.
Энэ функц гурван параметр авна:
Нэгт: s — анхны тоог илэрхийлэх тэмдэгт мөр
Хоёрт: n — тэмдэгт мөрийн урт
Гуравт: k — өөрчилж болох дээд тоо
Функцийн зорилго бол: хамгийн том утгатай палиндром үүсгээд буцаах.
Хэрвээ бүтэх боломжгүй бол "-1" буцаана.
 Оролт болон гаралтын жишээ:
 Жишээ 1:
Оролт: n = 4, k = 1, s = "3943"
Гаргалт: "3993"
Тайлбар: Зөвхөн 4-ийг 9 болгож 1 өөрчлөлт хийснээр палиндром үүссэн.
 Жишээ 2:
Оролт: n = 6, k = 3, s = "092282"
Гаргалт: "992299"
Тайлбар: 3 өөрчлөлт хийснээр хамгийн том палиндром үүссэн.
 Жишээ 3:
Оролт: n = 4, k = 1, s = "0011"
Гаргалт: "-1"
Тайлбар: Зөвхөн 1 удаа өөрчлөх боломжтой ч палиндром болгоход 2 өөрчлөлт хэрэгтэй тул боломжгүй.
## ---Код---"java"

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
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */

    public static String highestValuePalindrome(String s, int n, int k) {

        char[] arr = s.toCharArray();
        int left = 0;
        int right = n - 1;
        int changes = 0;

        while (left < right) {
            if (arr[left] != arr[right]) {
                char maxChar = (char) Math.max(arr[left], arr[right]);
                arr[left] = maxChar;
                arr[right] = maxChar;
                changes++;
            }
            left++;
            right--;
        }

        if (changes > k) {
            return "-1"; 
        }

        left = 0;
        right = n - 1;
        while (left <= right) {
            if (left == right) {
                if (k - changes > 0) {
                    arr[left] = '9';
                }
            } else {
                if (arr[left] < '9') {
                    if (k - changes >= 2 && arr[left] == s.charAt(left) && arr[right] == s.charAt(right)) {
                        
                        arr[left] = '9';
                        arr[right] = '9';
                        changes += 2;
                    } else if (k - changes >= 1 && s.charAt(left) != s.charAt(right)) {
                        
                        arr[left] = '9';
                        arr[right] = '9';
                        changes++;
                    }
                }
            }
            left++;
            right--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Read the number of digits, maximum changes, and the string representation
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();

        // Call the function to find the highest value palindrome
        String result = highestValuePalindrome(s, n, k);

        // Output: Print the result
        System.out.println(result);

        // Close the scanner
        scanner.close();
    }
}


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
## ---Тайлбар--- ![Screenshot 2025-06-09 171040](https://github.com/user-attachments/assets/f4c92a95-a77f-405f-b1e8-6a13259d2d6d)
Энэ програмын зорилго нь өгөгдсөн тоон тэмдэгт мөрийг хамгийн том утгатай палиндром болгох явдал юм. Тухайн тэмдэгт мөрийг зөвхөн хязгаарлагдмал тооны удаа өөрчилж болно. Хэрэв палиндром болгоход шаардлагатай өөрчлөлт нь зөвшөөрөгдсөн хязгаараас хэтэрвэл, ямар ч өөрчлөлт хийж чадахгүй тул “-1” гэсэн хариуг буцаадаг.

Програм эхлээд тэмдэгт мөрийг тэмдэгт бүрт задлан боловсруулж, зүүн ба баруун талаас зэрэг шалгадаг. Хоёр талаасаа ялгаатай тоонууд байвал, илүү том утгатайг нь аль аль талд нь бичиж палиндром болгоход шаардлагатай өөрчлөлтийг тоолдог.

Хэрвээ энэ эхний алхамд зөвшөөрсөн өөрчлөлтийн хэмжээнээс давсан бол шууд “боломжгүй” гэж үзээд дуусдаг. Хэрвээ хангалттай өөрчлөлт хийх боломж байвал, үлдсэн өөрчлөлтийн эрхийг ашиглан палиндромын дотоод утгыг аль болох “9” болгож ихэсгэхийг зорьдог. Ялангуяа хоёр талаасаа хоёуланг нь өөрчлөх боломжтой тохиолдолд, хоёр өөрчлөлтөөр нэг хосыг "9" болгож чаддаг.

Хэрвээ яг голд нэг орон тоо байгаа бол үлдсэн өөрчлөлтийн эрх байвал, тэр оронг мөн “9” болгоно. Эцэст нь, бүх өөрчлөлтүүдийг хийсний дараа хамгийн их утгатай палиндромыг бүтээж буцаадаг.


# File: ./algorithm/med/3/README.md

# Pairs

---Асуулт---"english" :
Given an array of integers and a target value, determine the number of pairs of array elements that have a difference equal to the target value.

Example


There are three values that differ by : , , and . Return .

Function Description

Complete the pairs function below.

pairs has the following parameter(s):

int k: an integer, the target difference
int arr[n]: an array of integers
Returns

int: the number of pairs that satisfy the criterion
Input Format

The first line contains two space-separated integers  and , the size of  and the target value.
The second line contains  space-separated integers of the array .

Constraints

each integer  will be unique
Sample Input

STDIN       Function
-----       --------
5 2         arr[] size n = 5, k =2
1 5 3 4 2   arr = [1, 5, 3, 4, 2]
Sample Output

3
Explanation

There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1]. .

---Асуулт---"Монголоор" :
Өгөгдсөн бүхэл тоонуудын массив болон зорилтот утгыг ашиглан, ялгаа нь тухайн зорилтот утгатай тэнцүү байх массив дахь хосуудын тоог тодорхойл.
Жишээ:
Жишээ нь, доорх массив дахь 3 утга дараах ялгаатай байна: 5 ба 3, 4 ба 2, 3 ба 1. Тэгэхээр хариу нь 3 байна.
Функцийн тодорхойлолт:
pairs функц нь дараах параметрүүдтэй байна:
int k: нэг бүхэл тоо, зорилтот ялгааны утга
int arr[n]: бүхэл тоонуудын массив
Буцаах утга:
int: өгөгдсөн шалгуурыг хангаж буй хосуудын тоо
Оролтын формат:
Эхний мөр нь хоёр зайгаар тусгаарлагдсан бүхэл тоо агуулна: массивын хэмжээ n ба ялгааны зорилтот утга k
Хоёрдугаар мөр нь n ширхэг бүхэл тоо агуулна — массивын элементүүд
Хязгаарлалт:
Массив дахь бүхэл тоо бүр давтагдашгүй байна
Жишээ оролт:
5 2
1 5 3 4 2
Жишээ гаралт:
3
Тайлбар:
Массив дахь 3 хос ялгаа нь 2-той тэнцүү байна. Эдгээр нь:
[5, 3]
[4, 2]
[3, 1]
Тиймээс хариу нь 3 юм.
---Код---" "
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
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    
    public static int pairs(int k, List<Integer> arr) {
    // Write your code here
  Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : arr) {
            if (set.contains(num - k)) count++;
            if (set.contains(num + k)) count++;
            set.add(num);
        }
        return count;
    }
    }
    



    

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

---Тайлбар---
![pairs](https://github.com/user-attachments/assets/b0dcb354-d974-43d5-b93f-694a028d7aa7)


# File: ./algorithm/med/4/README.md

# min-penalty-path

---Асуулт---"english" :
Consider an undirected graph containing  nodes and  edges. Each edge  has an integer cost, , associated with it.

The penalty of a path is the bitwise OR of every edge cost in the path between a pair of nodes,  and . In other words, if a path contains edges , then the penalty for this path is  OR  OR ... OR .

Given a graph and two nodes,  and , find the path between  and  having the minimal possible penalty and print its penalty; if no such path exists, print  to indicate that there is no path from  to .

Note: Loops and multiple edges are allowed. The bitwise OR operation is known as or in Pascal and as | in C++ and Java.

Input Format

The first line contains two space-separated integers,  (the number of nodes) and  (the number of edges), respectively.

Each line  of the  subsequent lines contains three space-separated integers , , and , respectively, describing edge  connecting the nodes  and  and its associated penalty ().

The last line contains two space-separated integers,  (the starting node) and  (the ending node), respectively.

Constraints

Output Format

Print the minimal penalty for the optimal path from node  to node ; if no path exists from node  to node , print .

Sample Input

3 4
1 2 1
1 2 1000
2 3 3
1 3 100
1 3
Sample Output

3
Explanation

The optimal path is .
 and .
The penalty for this path is:  OR , so we print .

---Асуулт---"Монголоор" :
Хамгийн бага торгуульт замыг олох зорилготойгоор, нодууд ба ирмэгүүдээс тогтсон чиглэлгүй граф өгөгджээ. Граф дахь бүх ирмэг бүр тодорхой бүхэл тоон зардал (торгууль) агуулна.
Нэг замын торгууль нь тухайн замд багтсан бүх ирмэгийн торгуулийн битийн "OR" үйлдлийн нийлбэр юм. Өөрөөр хэлбэл, хэрэв зам нь ирмэгүүдийн дарааллаар явбал, түүний торгууль нь w1 OR w2 OR ... OR wn байна.
Танд нэг граф болон хоёр орой (нодууд) өгөгдөх ба, энэ хоёр оройн хоорондын хамгийн бага торгуульт замыг олоорой. Хэрэв ийм зам байхгүй бол -1 гэж хэвлэнэ үү.
Тайлбар: Граф нь давхардсан ирмэг болон өөр дээрээ буцдаг ирмэг (loop) агуулж болно. Bitwise OR үйлдлийг Pascal хэл дээр or, харин C++ ба Java дээр | гэж бичдэг.
Оролтын формат:
Эхний мөрөнд хоёр бүхэл тоо: n (нодуудын тоо) болон m (ирмэгийн тоо)
Дараагийн m мөр бүрд гурван бүхэл тоо: u v w — u болон v нодуудыг холбосон ирмэг ба торгууль w
Сүүлийн мөрөнд хоёр бүхэл тоо: s болон t — эхлэл ба төгсгөлийн нодууд
Хязгаарлалт:
Тусгай хязгаарлалт заагаагүй боловч, граф нь өөр дээрээ ирмэгтэй болон олон ирмэгтэй байж болно.
Гаралтын формат:
Хамгийн бага боломжит торгуульт замыг хэвлэнэ. Хэрвээ зам байхгүй бол -1 гэж хэвлэнэ үү.
Жишээ оролт:
3 4  
1 2 1  
1 2 1000  
2 3 3  
1 3 100  
1 3
Жишээ гаралт:
3
Тайлбар:
Хамгийн бага торгуульт зам нь:
1 → 2 → 3
Торгууль нь:
1 OR 3 = 3
Тиймээс хариу нь 3 болно.
---Код---" "
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

/*
 * Complete the 'beautifulPath' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. 2D_INTEGER_ARRAY edges
 *  2. INTEGER A
 *  3. INTEGER B
 */

int beautifulPath(vector<vector<int>> edges, int A, int B) {
 vector<vector<pair<int, int>>> graph(10e4 + 1); // {node, {child, weight}}
    vector<vector<bool>> seen(10e4 + 1, vector<bool>(1024, false)); // {node, {with what weight we came}}
    for (vector<int> &edge : edges) {
        graph[edge[0]].push_back({edge[1], edge[2]});
        graph[edge[1]].push_back({edge[0], edge[2]});
    }
    int penaltyCost = INT_MAX;
    queue<vector<int>> todo; // {weight, node} minHeap
    todo.push({0, A});
    seen[A][0] = true; // Assume we reached node A with 0 total weight
    while (!todo.empty()) {
        vector<int> cur = todo.front();
        todo.pop();
        // If we reach target, save min penalty
        if (cur[1] == B) {
            penaltyCost = min(penaltyCost, cur[0]);
        }
        for (pair<int, int> &child : graph[cur[1]]) {
            if (seen[child.first][cur[0] | child.second] == false) {
                // Update new weight by OR'ing with parent's weight
                todo.push({cur[0] | child.second, child.first});
                seen[child.first][cur[0] | child.second] = true;
            }
        }
    }
    return (penaltyCost == INT_MAX ? -1 : penaltyCost);
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string first_multiple_input_temp;
    getline(cin, first_multiple_input_temp);

    vector<string> first_multiple_input = split(rtrim(first_multiple_input_temp));

    int n = stoi(first_multiple_input[0]);

    int m = stoi(first_multiple_input[1]);

    vector<vector<int>> edges(m);

    for (int i = 0; i < m; i++) {
        edges[i].resize(3);

        string edges_row_temp_temp;
        getline(cin, edges_row_temp_temp);

        vector<string> edges_row_temp = split(rtrim(edges_row_temp_temp));

        for (int j = 0; j < 3; j++) {
            int edges_row_item = stoi(edges_row_temp[j]);

            edges[i][j] = edges_row_item;
        }
    }

    string second_multiple_input_temp;
    getline(cin, second_multiple_input_temp);

    vector<string> second_multiple_input = split(rtrim(second_multiple_input_temp));

    int A = stoi(second_multiple_input[0]);

    int B = stoi(second_multiple_input[1]);

    int result = beautifulPath(edges, A, B);

    fout << result << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}

vector<string> split(const string &str) {
    vector<string> tokens;

    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));

        start = end + 1;
    }

    tokens.push_back(str.substr(start));

    return tokens;
}


---Тайлбар--- 
![min-penalty](https://github.com/user-attachments/assets/0ffa93df-596a-4f3c-af17-4a4e61bb2d3c)


# File: ./algorithm/med/5/README.md

# lily


---Асуулт---"english" :
Whenever George asks Lily to hang out, she's busy doing homework. George wants to help her finish it faster, but he's in over his head! Can you help George understand Lily's homework so she can hang out with him?

Consider an array of  distinct integers, . George can swap any two elements of the array any number of times. An array is beautiful if the sum of  among  is minimal.

Given the array , determine and return the minimum number of swaps that should be performed in order to make the array beautiful.

Example


One minimal array is . To get there, George performed the following swaps:

    Swap      Result
          [7, 15, 12, 3]
    3 7   [3, 15, 12, 7]
    7 15  [3, 7, 12, 15]
   
It took  swaps to make the array beautiful. This is minimal among the choices of beautiful arrays possible.

Function Description

Complete the lilysHomework function in the editor below.

lilysHomework has the following parameter(s):

int arr[n]: an integer array
Returns

int: the minimum number of swaps required
Input Format

The first line contains a single integer, , the number of elements in . The second line contains  space-separated integers, .

Constraints

Sample Input

STDIN       Function
-----       --------
4           arr[]size n = 4
2 5 3 1     arr = [2, 5, 3, 1]
Sample Output

2
Explanation

Define  to be the beautiful reordering of . The sum of the absolute values of differences between its adjacent elements is minimal among all permutations and only two swaps ( with  and then  with ) were performed.

---Асуулт---"Монголоор" :
Жорж Лилигээ хамт тоглохыг урих бүрд Лили гэрийн даалгавар хийж завгүй байдаг.
Жорж түүнд хурдан дуусгахад нь туслахыг хүсдэг ч даалгавар нь түүний ойлгож чадахааргүй хэцүү байна!
Та Жоржид Лилигийн даалгаврыг ойлгуулахад нь тусалж чадах уу, ингэснээр Лили Жоржтой хамт тоглож чадна.

Бодлого:

arr гэж нэрлэгдэх бүхэл тоонуудын дахин давтагдаагүй массив өгөгдсөн гэж үзье.
Жорж энэ массив дахь аль ч хоёр элементийг дурын тооны удаа сольж болно.
Массив "үзэсгэлэнтэй" байх нь дараах нөхцөлтэй:
массив дахь хөрш элементүүдийн ялгааны абсолют утгуудын нийлбэр хамгийн бага байх.
Танд өгөгдсөн arr массивыг ашиглан, массивыг үзэсгэлэнтэй болгохын тулд хийгдэх ёстой хамгийн бага солилцоо (swap)-ны тоог олоорой.
Жишээ:
Нэг боломжит үзэсгэлэнтэй массив бол [3, 7, 12, 15] юм.
Үүнийг бүтээхийн тулд Жорж дараах солилцоог хийжээ:
Солилцоо	Үр дүн
3 ↔ 7	[3, 15, 12, 7]
7 ↔ 15	[3, 7, 12, 15]
Ингээд нийт 2 солилцоо хийсэн бөгөөд энэ нь боломжит үзэсгэлэнтэй массивууд дундаас хамгийн бага нь юм.
Функцийн тодорхойлолт:
Параметр:
int arr[n] — бүхэл тоонуудын массив
Буцаах утга:
int — массивыг үзэсгэлэнтэй болгохын тулд шаардлагатай хамгийн бага солилцооны тоо
Оролтын формат:
Эхний мөрөнд нэг бүхэл тоо n — массивын хэмжээ
Хоёр дахь мөрөнд n ширхэг зайгаар тусгаарлагдсан бүхэл тоо arr өгөгдөнө
Хязгаарлалт:
Массивын бүх элементүүд давтагдахгүй
Жишээ оролт:
4
2 5 3 1
Жишээ гаралт:
2
Тайлбар:
arr массивын үзэсгэлэнтэй хувилбар бол 1 2 3 5 юм.
Хөрш элементүүдийн ялгаанууд: |2-1| + |3-2| + |5-3| = 1 + 1 + 2 = 4
Энэ нь боломжит хамгийн бага утгуудын нэг бөгөөд, энэ хувилбар руу хүрэхийн тулд ердөө 2 солилцоо хийсэн
(Жишээлбэл: 5 ↔ 1, дараа нь 2 ↔ 3 гэх мэт).
---Код---"java8"
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int lilysHomework(int arr[], int arr2[]) 
        {        
        boolean isIdentical = true;
        Map<Integer, Integer> locations = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            locations.put(arr[i], i);
            if (arr[i]!=arr2[i])
            {
                isIdentical = false;
            }
        }
        int swapCount=0;
        if (isIdentical)
        {
            return swapCount;
        }
        for (int i=0; i<arr.length; i++)
        {
            if (arr[i]!=arr2[i])
            {
                int arrIndex = locations.get(arr2[i]);
                locations.put(arr[i], arrIndex);
                
                int temp = arr[i];
                arr[i]= arr2[arrIndex];
                arr[arrIndex] = temp;
                
                swapCount++;
            }
        }
        return swapCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int numberOfElements = scn.nextInt();

        int[] values = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            int value = scn.nextInt();
            values[i] = value;
        }
        int valuesCopy[] = values.clone();
        int sortedArray[] = values.clone();
        
        Arrays.sort(sortedArray);
        
        int[] reverseSortedArray = IntStream.range(0, sortedArray.length)
                          .map(i -> sortedArray[sortedArray.length-i-1])
                          .toArray();
        int regArraySwapCount = Result.lilysHomework(values, sortedArray);
        
        int reverseArraySwapCount = Result.lilysHomework(valuesCopy, reverseSortedArray);
        
        int result = Math.min(regArraySwapCount, reverseArraySwapCount);
        System.out.println(result);
       
    }
}
---Тайлбар--- 
![lily](https://github.com/user-attachments/assets/72dfbf79-7fb8-4350-b1f6-8b3e2080a5ad)


# File: ./algorithm/med/bodlogo1/README.md

# ПХ. 40 бодлого

Бодлого 1. Climbing Leader Board
тоглогч тус бүр лидербордын оргилд хүрэхийг тулд, тоглоомын дараах үнэлгээг дагаж, өөрийн байр сууриа хянадаг. Энэхүү тоглоом  (Dense Ranking)-ийг ашигладаг.
 - Хамгийн өндөр оноотой тоглогч 1-р байранд орно.
 - Ижил оноотой тоглогчид ижил зэрэглэл авна, дараагийн тоглогч нь шууд дараагийн зэрэглэл авна.
Жишээ:
 ranked = [100, 90, 90, 80]
 player = [70, 80, 105]
Лидерборд дараах байдлаар эрэмбэлэгдэнэ:
100 (1-р байр), 90 (2-р байр), 90 (2-р байр), 80 (3-р байр) 
Хэрвээ тоглогчийн оноо дараах байдалтай байвал:
  - 70 → 4-р байр
  - 80 → 3-р байр
  - 105 → 1-р байр
Буцаах ёстой үр дүн: [4, 3, 1]

 Функцийн тайлбар
Доорх climbingLeaderboard функцыг гүйцээн хэрэгжүүлнэ үү.
climbingLeaderboard функц дараах параметрүүдтэй:
int ranked[n]: лидерборд дээрх оноонууд (ихээс бага руу эрэмбэлэгдсэн)
int player[m]: тоглогчийн тоглолт бүрийн дараах оноонууд

Буцаах утга
int[m]: тоглогчийн оноо бүрийн дараа авсан байрлалуудын жагсаалт

 Оролтын формат
Эхний мөрөнд n бүхэл тоо өгөгдөнө — лидерборд дээрх тоглогчдын тоо.
Дараагийн мөрөнд хоорондоо зайгаар тусгаарлагдсан n ширхэг бүхэл тоо өгөгдөнө — лидербордын оноонууд (ranked[]), буурахаар эрэмбэлэгдсэн байна.
Гурав дахь мөрөнд m бүхэл тоо өгөгдөнө — тоглогчийн тоглосон тоглоомуудын тоо.
Сүүлийн мөрөнд хоорондоо зайгаар тусгаарлагдсан m ширхэг бүхэл тоо өгөгдөнө — тоглогчийн оноонууд (player[]), өсөхөөр эрэмбэлэгдсэн байна. 

Хязгаарлалт
 1<n<2*10^5
 1<m<2*10^5
 0<ranked[i]<19^9 эсвэл 0<i<n буурахаар эрэмбэлсэн байна.
 0<player[j]<10^9 эсвэл 0<j<m өсөхөөр эрэмбэлсэн байна.

 Үр дүн: 
 ![Screenshot (351)](https://github.com/user-attachments/assets/4c38aba0-1a11-4d72-b19c-f819645cf847)

 холбоос: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true



# File: ./algorithm/med/bodlogo2/README.md

# Compare the Triplets
Алис болон Боб хоёр гурван төрлийн шалгуураар оноо авдаг. Тэдгээр шалгуур бүрт 0-оос 100 хүртэлх бүхэл тоон оноо өгдөг. Бид эдгээр шалгуурт оноо өгөхдөө дараах байдлаар харьцуулалт хийнэ:

 - Хэрэв Алисын оноо тухайн шалгуур дээр Бобын онооноос их байвал Алис 1 оноо авна.
 - Хэрэв Бобын оноо тухайн шалгуур дээр Алисын онооноос их байвал Боб 1 оноо авна.
 - Хэрэв хоёул адил оноо авсан бол хэн ч оноо авахгүй.

Алис болон Бобын оноог гурван шалгуур тус бүрээр өгсөн гэж үзье. Эдгээр оноонуудыг харьцуулж, тус бүрийн авсан оноог дараалалтайгаар буцаан.

Оролт:
 - Эхний мөрөнд гурван бүхэл тоо (Алисын оноо): a[0], a[1], a[2]
 - Дараагийн мөрөнд гурван бүхэл тоо (Бобын оноо): b[0], b[1], b[2]

Гаралт:
 - Хоёр бүхэл тоо бүхий массив/жагсаалт буцаана: [Алисын оноо, Бобын оноо]

Үр дүн:

 ![Screenshot (355)](https://github.com/user-attachments/assets/02844d00-ca9c-49fb-91ee-66983bd8a370)

 Бодогын холбоос: https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=true  



# File: ./algorithm/med/bodlogo3/README.md

#  Бодлогын нэр: Extra Long Factorials

n бүхэл тооны факториал буюу n! нь дараах томъёогоор тодорхойлогдоно:

n! = n × (n−1) × (n−2) × ... × 2 × 1

 Бүтэл тооны факториалыг тооцоолон хэвлэ.

 Функцийн тодорхойлолт: 
extraLongFactorials гэдэг функцыг доорх загварын дагуу гүйцээнэ. Энэ нь зөвхөн үр дүнг хэвлэх (print) үүрэгтэй бөгөөд утга буцаах шаардлагагүй.

  n: нэг бүхэл тоо

 Тайлбар:
Факториалын утга нь маш хурдан томорч, long long (C/C++ дахь 64-bit) хувьсагч ч хадгалах боломжгүй болж болзошгүй.
Иймээс BigInteger гэх мэт том тоог дэмждэг төрлүүдийг ашиглах шаардлагатай. Java, Python, Ruby гэх мэт хэлнүүдэд энэ боломж байдаг бол C/C++ дээр тусгай аргаар зохицуулах хэрэгтэй болдог.
  
 Оролт формат
Оролт нь ганц бүхэл тоо n байна.

 Хязгаарлалт
1 ≤ n ≤ 1000

 Гаралт формат
n! буюу n тооны факториалын утгыг ганц мөрөнд хэвлэнэ.

 Жишээ оролт: 25

 Жишээ гаралт: 115511210043330985984000000

Тайлбар:
25! = 25 × 24 × 23 × ... × 2 × 1

 Үр дүн: ![Screenshot (357)](https://github.com/user-attachments/assets/e1bc97b0-97cc-4fd6-9f96-c039e68865b7)

 Бодлогын холбоос: https://www.hackerrank.com/challenges/extra-long-factorials/problem

  








# File: ./algorithm/med/bodlogo4/README.md

# Бодлогын нэр: Non-Divisible Subset

Массив S ялгаатай бүхэл тоонууд өгөгдсөн, дараах нөхцөлийг хангах хамгийн их хэмжээтэй дэд массив элемэнтүүдийг олж  хэмжээг хэвлэ. Тухайн дэд массив элемэнтүүдийн  хоёр тооны нийлбэр k тоонд хуваагдахгүй байх ёстой.

Жишээ: 

 k = 4
 S = [19, 10, 12, 10, 24, 25, 22]

Үүсгэж болох зарим багц:

S'[0] = [10, 12, 25]

S'[1] = [19, 22, 24]

 Бүх боломжит хувилбаруудыг шалгасны дараа хамгийн урт зөв багц нь 3 элементтэй байна.
 
 Функцийн тайлбар
 Функцийн нэр: nonDivisibleSubset

 Оролт параметрүүд:
int S[n]: бүхэл тоонуудын массив

int k: хуваагч тоо

  Буцах утга:
int: дээрх нөхцөлийг хангах S массивын хамгийн олон элементтэй дэд массив элемэнтүүд хэмжээ. 

 Оролтын формат:
1-р мөр: n ба k гэсэн 2 бүхэл тоо (хоорондоо зайгаар тусгаарлагдсан)
2-р мөр: n ширхэг бүхэл тоо, тус бүр нь S[i] утга

 Хязгаарлалт:
1 ≤ n ≤ 10⁵
1 ≤ k ≤ 100
1 ≤ S[i] ≤ 10⁹

Бүх өгөгдсөн тоонууд давхардалгүй байна

Жишээ оролт: 
4 3      S[] size n = 4, k = 3

1 7 2 4  S = [1, 7, 2, 4]

Жишээ гаралт:  3

Үр дүн: 
![Screenshot (358)](https://github.com/user-attachments/assets/087e07c1-414a-4c35-9898-eda023455d7b)

Бодлогын холбоос: https://www.hackerrank.com/challenges/non-divisible-subset/problem 













# File: ./algorithm/med/bodlogo5/README.md

# Queen's Attack II
Танд хатан болон хэд хэдэн саад байрлуулсан квадрат шатрын самбар өгөгдөнө. Хатан хэдэн нүд рүү довтолж чадахыг тодорхойл.
Хатан n × n хэмжээтэй шатрын самбар дээр байрласан байна. Самбарын мөрүүд нь доороос дээш чиглэлтэйгээр 1-ээс n хүртэл дугаарлагддаг. Баганууд нь зүүнээс баруун тийш чиглэлтэйгээр мөн 1-ээс n хүртэл дугаарлагддаг. Самбарын аль ч нүдийг (r, c) хосоор илэрхийлэх ба энэ нь тухайн нүдний мөр r, багана c-г илтгэнэ.
Хатан (r_q, c_q) байрлалд байрласан. Нэг удаагийн нүүдлээрээ хатан дараах найман чиглэлд байгаа дурын нүд рүү довтолж чадна: зүүн, баруун, дээш, доош, мөн дөрвөн диагональ чиглэл.
Доорх зурган дээр (4, 4) байрлалд байгаа хатан ямар нүднүүд рүү довтолж чадахыг ногоон дугуйгаар тэмдэглэсэн байна:

![1485426500-a4039ebb00-chess1](https://github.com/user-attachments/assets/65930abb-73c0-4cd8-be55-77c44608bd89)

Самбар дээр сааднууд байрлах ба эдгээр нь тухайн чиглэлд саадаас цааш байрлах нүднүүд рүү хатан довтлохоос сэргийлнэ. Жишээлбэл, дээрх зурган дээрх (3, 5) байрлалд байгаа саад нь хатанг дараах нүднүүд рүү довтлохоос сэргийлнэ: (3, 5), (2, 6), болон (1, 7).

![image](https://github.com/user-attachments/assets/b020861c-106b-43e5-b8ac-b8e7d3b2e35a)

Хатангийн байрлал болон самбар дээрх бүх саадны байршлууд өгөгдсөн нөхцөлд, хатан (r_q, c_q) байрлалаас хэдэн нүд рүү довтлох боломжтойг олж, хэвлэ.

Доорх queensAttack нэртэй функцийг гүйцээх шаардлагатай.

Функцийн тайлбар: 

  - int n, самбарын хэмжээ (n x n)
  - int k, саадны тоо
  - int r_q, int c_q, хатангийн мөр ба баганын дугаар
  - int obstacles[k][2] k ширхэг саадны байршил (мөр, багана)

Буцаах утга:
 - Хатангийн довтолж чадах нүдний тоо (int төрөлтэй).

Оролтын формат:
Эхний мөрөнд хоёр бүхэл тоо: n (самбарын хэмжээ), k (саадны тоо).

Дараагийн мөрөнд хатангийн байрлалын координат: r_q (мөр), c_q (багана).

Дараагийн k мөр бүрт нэг саадны байрлал өгөгдөнө: r[i] ба c[i].

Хязгаарлалт:
 0 < n ≤ 100,000
 0 ≤ k ≤ 100,000 

Нэг нүдэнд олон саад байж болно.

Хатан байрлаж буй нүдэнд хэзээ ч саад байхгүй.
Дэд даалгаврууд:
30% оноо авах нөхцөлд:

 0 < n ≤ 100 
 0 ≤ k ≤ 100

Нийт 55% оноо авах нөхцөлд:

 0 < n ≤ 1000
 0 ≤ k ≤ 10^5

 Оролт:
  40
  44

Гаралт: 9

Үр дүн: 
![Screenshot (359)](https://github.com/user-attachments/assets/4d944fcf-347f-4229-b9c2-de85a82ce19d)

Бодлогийн холбоос: https://www.hackerrank.com/challenges/queens-attack-2/problem






# File: ./algorithm/med/min-loss/README.md

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



# File: ./data_structure/hard/1/README.md

# Find the running median

---Асуулт---"english" :
The median of a set of integers is the midpoint value of the data set for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your set of integers in non-decreasing order, then:

If your set contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted set ,  is the median.
If your set contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted set ,  is the median.
Given an input stream of  integers, perform the following task for each  integer:

Add the  integer to a running list of integers.
Find the median of the updated list (i.e., for the first element through the  element).
Print the updated median on a new line. The printed value must be a double-precision number scaled to  decimal place (i.e.,  format).
Example

Sorted          Median
[7]             7.0
[3, 7]          5.0
[3, 5, 7]       5.0
[2, 3, 5, 7]    4.0
Each of the median values is stored in an array and the array is returned for the main function to print.

Note: Add formatting to the print statement.

Function Description
Complete the runningMedian function in the editor below.

runningMedian has the following parameters:
- int a[n]: an array of integers

Returns
- float[n]: the median of the array after each insertion, modify the print statement in main to get proper formatting.

Input Format

The first line contains a single integer, , the number of integers in the data stream.
Each line  of the  subsequent lines contains an integer, , to be inserted into the list.

Constraints

Sample Input

STDIN   Function
-----   --------
6       a[] size n = 6
12      a = [12, 4, 5, 3, 8, 7]
4
5
3
8
7
Sample Output

12.0
8.0
5.0
4.5
5.0
6.0
Explanation

There are  integers, so we must print the new median on a new line as each integer is added to the list:



# ---Асуулт---"Монголоор" :
Бүхэл тоонуудын цуглуулгын медиан гэдэг нь тухайн өгөгдлийн дунд хэсгийн утга бөгөөд энэ утгаас бага, их тоонуудын тоо ижил байна.
Медианыг олохын тулд эхлээд бүх тоонуудыг өсөх дарааллаар эрэмбэлнэ. Дараа нь:

Хэрвээ таны цуглуулгад сондгой тооны элемент байвал, медиан нь дунд талын элемент байна. Эрэмбэлэгдсэн цуглуулгад тэр нь медиан болно.

Хэрвээ таны цуглуулгад тэгш тооны элемент байвал, медиан нь хоёр дунд талын элементийн дундаж байна. Эрэмбэлэгдсэн цуглуулгад энэ нь медиан болно.

Өгөгдсөн урсгалаар ирэх 
𝑛
n ширхэг бүхэл тооны хувьд дараах үйлдлийг бүр тоо дээр гүйцэтгэнэ:

𝑖
i дахь тоог жагсаалт руу нэмнэ.

Шинэчлэгдсэн жагсаалтын медианыг олно (жишээ нь эхний 
𝑖
i тооны хувьд).

Шинэ медианыг шинэ мөрөнд хэвлэнэ. Хэвлэгдэх утга нь нэг оронгийн нарийвчлалтай хөвөгч таслалттай тоо байх ёстой (жишээ нь %.1f формат).

Жишээ:

csharp
Copy
Edit
Эрэмбэлэгдсэн       Медиан
[7]                 7.0
[3, 7]              5.0
[3, 5, 7]           5.0
[2, 3, 5, 7]        4.0
Медиануудын утгыг массивт хадгалж, энэ массивыг үндсэн функц хэвлэнэ.
Тайлбар: Хэвлэлийн мөрөнд формат нэмэх шаардлагатай.
Функцийн тодорхойлолт:
runningMedian функцыг дараах байдлаар гүйцээнэ:
runningMedian нь дараах параметртэй:
int a[n]: бүхэл тоонуудын массив
Буцаах утга:
float[n]: бүр тоо нэмэгдэх бүрд үүсэх жагсаалтын медиан
Оролтын формат:
Эхний мөрөнд нэг бүхэл тоо өгөгдөнө — урсгалаар ирэх тоонуудын тоо 
n.
Дараагийн 
n мөр тус бүрд нэг бүхэл тоо a[i] өгөгдөнө.

Жишээ оролт:

STDIN   Function
-----   --------
6       a[] хэмжээтэй массив (n = 6)
12      a = [12, 4, 5, 3, 8, 7]
4
5
3
8
7
Жишээ гаралт:

12.0  
8.0  
5.0  
4.5  
5.0  
6.0  

# ---Код---" "
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'runningMedian' function below.
 *
 * The function is expected to return a DOUBLE_ARRAY.
 * The function accepts INTEGER_ARRAY a as parameter.
 */
vector<double> runningMedian(vector<int> const&a) {
    if(0==a.size())
        return vector<double>();
    map<int,int> aux; 
    aux.insert({a[0],1});
    auto lowerMed = aux.begin();
    vector<double> retq;
    retq.push_back(1.0*(lowerMed->first));
    int pos=0;
    for(int i=1; i<a.size();i++)
    {
        if(!aux.count(a[i]))
            aux.insert({a[i],1});
        else{aux[a[i]]++;}
        if((a[i]<lowerMed->first)&&(i&1))
            pos--;
        else if((a[i]>=lowerMed->first)&&(0==(i&1)))
            pos++;
        if(0>pos)
        {
            lowerMed--;
            pos=lowerMed->second-1;
        }
        else if(lowerMed->second<=pos)
        {
            lowerMed++;
            pos=0;
        }
        if(0==(i&1))
        {
            retq.push_back(1.0*(lowerMed->first));
        }
        else
        {
            auto x=lowerMed;
            if(pos+1>=lowerMed->second)
                x++; 
            retq.push_back(0.5*(lowerMed->first + x->first));
        }
    }
    return retq;
}
int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string a_count_temp;
    getline(cin, a_count_temp);

    int a_count = stoi(ltrim(rtrim(a_count_temp)));

    vector<int> a(a_count);

    for (int i = 0; i < a_count; i++) {
        string a_item_temp;
        getline(cin, a_item_temp);

        int a_item = stoi(ltrim(rtrim(a_item_temp)));

        a[i] = a_item;
    }

    vector<double> result = runningMedian(a);

    for (size_t i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << "\n";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}

# ---Тайлбар---
![find running median](https://github.com/user-attachments/assets/c760a0af-af4f-4bdc-9425-7afe3292ff5b)


# File: ./data_structure/hard/2/README.md

# min average time

---Асуулт---"english" :
Tieu owns a pizza restaurant and he manages it in his own way. While in a normal restaurant, a customer is served by following the first-come, first-served rule, Tieu simply minimizes the average waiting time of his customers. So he gets to decide who is served first, regardless of how sooner or later a person comes.

Different kinds of pizzas take different amounts of time to cook. Also, once he starts cooking a pizza, he cannot cook another pizza until the first pizza is completely cooked. Let's say we have three customers who come at time t=0, t=1, & t=2 respectively, and the time needed to cook their pizzas is 3, 9, & 6 respectively. If Tieu applies first-come, first-served rule, then the waiting time of three customers is 3, 11, & 16 respectively. The average waiting time in this case is (3 + 11 + 16) / 3 = 10. This is not an optimized solution. After serving the first customer at time t=3, Tieu can choose to serve the third customer. In that case, the waiting time will be 3, 7, & 17 respectively. Hence the average waiting time is (3 + 7 + 17) / 3 = 9.

Help Tieu achieve the minimum average waiting time. For the sake of simplicity, just find the integer part of the minimum average waiting time.

Input Format

The first line contains an integer N, which is the number of customers.
In the next N lines, the ith line contains two space separated numbers Ti and Li. Ti is the time when ith customer order a pizza, and Li is the time required to cook that pizza.

The  customer is not the customer arriving at the  arrival time.

Output Format

Display the integer part of the minimum average waiting time.
Constraints

1 ≤ N ≤ 105
0 ≤ Ti ≤ 109
1 ≤ Li ≤ 109
Note

The waiting time is calculated as the difference between the time a customer orders pizza (the time at which they enter the shop) and the time she is served.

Cook does not know about the future orders.

Sample Input #00

3
0 3
1 9
2 6
Sample Output #00

9
Sample Input #01

3
0 3
1 9
2 5
Sample Output #01

8
Explanation #01

Let's call the person ordering at time = 0 as A, time = 1 as B and time = 2 as C. By delivering pizza for A, C and B we get the minimum average wait time to be

(3 + 6 + 16)/3 = 25/3 = 8.33 

---Асуулт---"Монголоор" :
Tieu пиццаны ресторан ажиллуулдаг бөгөөд тэрээр үүнийг өөрийнхөөрөө удирддаг.
Хэвийн рестораны хувьд үйлчлүүлэгчдийг ирсэн дарааллаар нь үйлчилдэг бол, Tieu үйлчлүүлэгчдийн дундаж хүлээлгийн хугацааг багасгахыг зорьдог. Тиймээс хэн түрүүлж ирсэн нь хамаагүй, хэн түрүүлж үйлчлүүлэхээ Tieu өөрөө шийддэг.

Янз бүрийн төрлийн пицца хийхэд янз бүрийн хугацаа шаардагддаг. Мөн нэг пиццаг хийж эхэлсний дараа, тэр пицца бүрэн бэлэн болтол өөр пицца хийх боломжгүй. Жишээлбэл, гурван үйлчлүүлэгч t = 0, t = 1, t = 2 үед ирдэг гэж үзье. Тэдний пицца хийх хугацаа нь тус бүртээ 3, 9, 6 минут байна. Хэрвээ Tieu ирсэн дарааллаар үйлчилбэл, үйлчлүүлэгчдийн хүлээлгийн хугацаа нь 3, 11, 16 минут болно. Энэ тохиолдолд дундаж хүлээлгийн хугацаа нь (3 + 11 + 16) / 3 = 10 минут болно. Гэхдээ энэ нь хамгийн оновчтой шийдэл биш. Эхний үйлчлүүлэгчийг t = 3 үед дуусгасны дараа Tieu гурав дахь үйлчлүүлэгчид үйлчилбэл, тэдний хүлээлгийн хугацаа нь 3, 7, 17 минут болно. Ингэснээр дундаж хүлээлгийн хугацаа нь (3 + 7 + 17) / 3 = 9 минут болно.

Tieu-д үйлчлүүлэгчдийн дундаж хүлээлгийн хугацааг хамгийн бага байлгахад нь туслаарай. Хялбар болгохын тулд дундаж хугацааны зөвхөн бүхэл хэсгийг ол.

Оролтын формат:
Эхний мөрөнд N бүхэл тоо өгөгдөнө — үйлчлүүлэгчдийн тоо.
Дараагийн N мөр бүрт хоёр бүхэл тоо өгөгдөнө:

Ti — i дахь үйлчлүүлэгчийн захиалга өгсөн цаг

Li — тухайн пиццаны хийгдэх хугацаа

Жич: i дахь мөр дээр байгаа үйлчлүүлэгч нь Ti хугацаанд ирсэн үйлчлүүлэгчтэй заавал таарах албагүй.

Гаралтын формат:
Хүлээлгийн дундаж хугацааны бүхэл хэсгийг хэвлэ.


Жишээ оролт #00:
3
0 3
1 9
2 6
Жишээ гаралт #00:
9
Жишээ оролт #01:
3
0 3
1 9
2 5
Жишээ гаралт #01:
8
Тайлбар #01:
0 үед захиалсан үйлчлүүлэгчийг A,
1 үед захиалсан үйлчлүүлэгчийг B,
2 үед захиалсан үйлчлэгчийг C гэж нэрлэе.
Хэрвээ A → C → B дарааллаар үйлчилбэл хүлээлгийн хугацаа нь:

A: 3 минут

C: 6 минут (тэр 2-р минут ирсэн ч 3-аас эхэлж 5 минут хүлээнэ → 3+5 = 8 → 8 − 2 = 6)

B: 16 минут
Ингээд дундаж нь (3 + 6 + 16) / 3 = 8.33 бөгөөд бүхэл хэсэг нь 8 болно.
---Код---"PYTHON3"
#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'minimumAverage' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY customers as parameter.
#
import heapq

def minimumAverage(customers):
    customers.sort()
    n = len(customers)
    i = 0
    current_time = 0
    waiting_time = 0
    h = []

    while i < n or h:
        # Add all custoemrs with arrival time less or equal to current time so that no customer that arrives later is processed, as that is not valid.
        while i < n and customers[i][0] <= current_time:
            heapq.heappush(h, (customers[i][1], customers[i][0]))
            i += 1

        # From the clients whose arrival time is less than the current time, extract the one whose pizza has the least preparation time.
        if h:
            prep_time, arrival_time = heapq.heappop(h)
            current_time += prep_time
            waiting_time += current_time - arrival_time

        # In case there are no customers to process, move to next customer. :)
        else:
            current_time = customers[i][0]

    return waiting_time // n
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    customers = []

    for _ in range(n):
        customers.append(list(map(int, input().rstrip().split())))

    result = minimumAverage(customers)

    fptr.write(str(result) + '\n')

    fptr.close()


---Тайлбар--- ![image](https://github.com/user-attachments/assets/0f7ada5b-3efa-454b-adaf-5a97dd33d53b)



# File: ./data_structure/hard/3/README.md

# truck-tour

---Асуулт---"english" :
Suppose there is a circle. There are  petrol pumps on that circle. Petrol pumps are numbered  to  (both inclusive). You have two pieces of information corresponding to each of the petrol pump: (1) the amount of petrol that particular petrol pump will give, and (2) the distance from that petrol pump to the next petrol pump.

Initially, you have a tank of infinite capacity carrying no petrol. You can start the tour at any of the petrol pumps. Calculate the first point from where the truck will be able to complete the circle. Consider that the truck will stop at each of the petrol pumps. The truck will move one kilometer for each litre of the petrol.

Input Format

The first line will contain the value of .
The next  lines will contain a pair of integers each, i.e. the amount of petrol that petrol pump will give and the distance between that petrol pump and the next petrol pump.

Constraints:


Output Format

An integer which will be the smallest index of the petrol pump from which we can start the tour.

Sample Input

3
1 5
10 3
3 4
Sample Output

1
Explanation

We can start the tour from the second petrol pump.

---Асуулт---"Монголоор" :
Гэрлэн тойрог байна гэж төсөөлье. Тэр тойрог дээр шатахуун түгээх станцууд байрлана. Шатахуун түгээх станцуудыг 0-аас n-1 хүртэл дугаарласан байдаг (хоёуланг нь оролцуулна). Шатахуун түгээх станц бүрийн хувьд танд хоёр төрлийн мэдээлэл байна: (1) тухайн шатахуун түгээх станц хэр хэмжээний шатахуун өгч чадах вэ, (2) тэр станцаас дараагийн станц хүртэлх зай. Эхэндээ таньд хязгааргүй багтаамжтай, гэхдээ шатахуунгүй сав байгаа. Та аяллаа аль ч шатахуун түгээх станцаас эхлүүлж болно. Ачааны машин тойргийг бүрэн тойрон явах боломжтой хамгийн эхний цэгийг ол. Ачааны машин шатахуун түгээх станц бүр дээр зогсож явна гэж үзнэ. Ачааны машин шатахууны нэг литрт нэг километр явна. Эхний мөрөнд n-ийн утга өгөгдөнө. Дараагийн n мөр тус бүрт хоёр бүхэл тоо өгөгдөх ба, эхнийх нь тухайн станц хэр их шатахуун өгөхийг, хоёр дахь нь дараагийн станц хүртэлх зайг илэрхийлнэ. Аяллаа эхэлж болох хамгийн бага дугаартай шатахуун түгээх станцын индексийг хэвлэнэ. Бид аяллаа хоёр дахь шатахуун түгээх станцаас эхлүүлж чадна.


---Код---" "
#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'truckTour' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
#

def truckTour(petrol_pumps):
    start_index = 0
    total_liters = 0
    total_distance = 0

    for i in range(len(petrol_pumps)):
        liters, distance = petrol_pumps[i]
        total_liters += liters
        total_distance += distance
        # Arriving to next petrol pump

        if total_liters - total_distance < 0:
            # Initialize start index before restarting in start index
            start_index = i + 1
            total_liters = 0
            total_distance = 0
    
    return start_index
 

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    petrolpumps = []

    for _ in range(n):
        petrolpumps.append(list(map(int, input().rstrip().split())))

    result = truckTour(petrolpumps)

    fptr.write(str(result) + '\n')

    fptr.close()

---Тайлбар
![truck tour](https://github.com/user-attachments/assets/a925d4dd-976d-4796-95ce-349d3d87dd25)
ар--- 


# File: ./data_structure/hard/4/README.md

# queries-with-fixed-length

---Асуулт---"english" :
Consider an -integer sequence, . We perform a query on  by using an integer, , to calculate the result of the following expression:

In other words, if we let , then you need to calculate .

Given  and  queries, return a list of answers to each query.

Example


The first query uses all of the subarrays of length : . The maxima of the subarrays are . The minimum of these is .

The second query uses all of the subarrays of length : . The maxima of the subarrays are . The minimum of these is .

Return .

Function Description

Complete the solve function below.

solve has the following parameter(s):

int arr[n]: an array of integers
int queries[q]: the lengths of subarrays to query
Returns

int[q]: the answers to each query
Input Format

The first line consists of two space-separated integers,  and .
The second line consists of  space-separated integers, the elements of .
Each of the  subsequent lines contains a single integer denoting the value of  for that query.

Constraints

Sample Input 0

5 5
33 11 44 11 55
1
2
3
4
5
Sample Output 0

11
33
44
44
55
Explanation 0

For , the answer is

.
For , the answer is
.
For , the answer is
.
For , the answer is
.
For , the answer is
.
Sample Input 1

5 5
1 2 3 4 5
1
2
3
4
5
Sample Output 1

1
2
3
4
5
Explanation 1

For each query, the "prefix" has the least maximum value among the consecutive subsequences of the same size.

---Асуулт---"Монголоор" :
n бүхэл тооноос бүрдсэн дараалал өгөгдсөн гэж үзье.
Бид уг дараалалд нэг бүхэл тоо болох d ашиглан дараах илэрхийллийг бодох асуулт тавина:

min(all subarray maxima of length d)
Өөрөөр хэлбэл, урт нь d тэнцүү бүх дэд массивуудын хамгийн их утгуудыг олж, тэдгээрийн дундаас хамгийн бага утгыг авна.

Танд arr массив болон queries гэсэн d утгуудын жагсаалт өгөгдөнө.
Танд асуулт бүрийн хариуг жагсаалтаар буцаах хэрэгтэй.

Жишээ:

Эхний асуулт нь урт нь 1 тэнцүү бүх дэд массивуудыг авна: [33], [11], [44], [11], [55].
Эдгээрийн хамгийн их утгууд: 33, 11, 44, 11, 55. Эдгээрийн хамгийн бага нь: 11.

Хоёр дахь асуулт нь урт нь 2 тэнцүү дэд массивуудыг авна: [33 11], [11 44], [44 11], [11 55].
Хамгийн их утгууд: 33, 44, 44, 55. Эдгээрийн хамгийн бага нь: 33.

Ингээд үр дүн нь: [11, 33, 44, 44, 55].

Функцийн тайлбар:

solve функц дараах параметрүүдтэй:

int arr[n]: бүхэл тоон дараалал

int queries[q]: дэд массивын уртуудыг илэрхийлэх бүхэл тоонуудын жагсаалт

Буцаах утга:

int[q]: асуулт бүрийн хариу

Оролтын формат:

Эхний мөрөнд хоёр бүхэл тоо: n ба q

Хоёр дахь мөрөнд n ширхэг бүхэл тоо (arr)

Дараагийн q мөрөнд тус бүр нэг бүхэл тоо байгаа ба энэ нь d утга
---Код---" "
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

/*
 * Complete the 'solve' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY arr
 *  2. INTEGER_ARRAY queries
 */
void add(deque<int>& q, int v){
    while(!q.empty() && q.back() < v) q.pop_back();
    q.push_back(v);      
}

int getMax(deque<int>& q){ return q.front(); }

void pop(deque<int>& q, int rv){
    if(!q.empty() && rv == q.front()) q.pop_front();
}

int computeMinOfSubarrays(vector<int> maxs){
    int ans = INT_MAX;
    for(auto m : maxs) ans = min(ans, m);
    return ans;    
}

vector<int> solve(vector<int> arr, vector<int> queries) {
   vector<int> mins;
   for(auto subArrayLength : queries){
       deque<int> q; vector<int> maxs; 
       int size = 0;
       int toBeRemoved = 0;
       for(int i=0; i<arr.size(); ++i){
           add(q, arr[i]);
           size++;
           if(size == subArrayLength){
               size -= 1;
               maxs.push_back(getMax(q));
               pop(q, arr[toBeRemoved++]);
           }
       }
       mins.push_back(computeMinOfSubarrays(maxs));
   } 
   return mins; 
}
int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string first_multiple_input_temp;
    getline(cin, first_multiple_input_temp);

    vector<string> first_multiple_input = split(rtrim(first_multiple_input_temp));

    int n = stoi(first_multiple_input[0]);

    int q = stoi(first_multiple_input[1]);

    string arr_temp_temp;
    getline(cin, arr_temp_temp);

    vector<string> arr_temp = split(rtrim(arr_temp_temp));

    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        int arr_item = stoi(arr_temp[i]);

        arr[i] = arr_item;
    }

    vector<int> queries(q);

    for (int i = 0; i < q; i++) {
        string queries_item_temp;
        getline(cin, queries_item_temp);

        int queries_item = stoi(ltrim(rtrim(queries_item_temp)));

        queries[i] = queries_item;
    }

    vector<int> result = solve(arr, queries);

    for (size_t i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << "\n";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}

vector<string> split(const string &str) {
    vector<string> tokens;

    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));

        start = end + 1;
    }

    tokens.push_back(str.substr(start));

    return tokens;
}

---Тайлбар--- 
![image](https://github.com/user-attachments/assets/4798e20a-129f-4934-83fc-ded97dbbcfca)


# File: ./data_structure/hard/5/README.md

# merging

---Асуулт---"english" :
People connect with each other in a social network. A connection between Person  and Person  is represented as . When two persons belonging to different communities connect, the net effect is the merge the communities which  and  belong to.

At the beginning, there are  people representing  communities. Suppose person  and  connected and later  and  connected, then ,, and  will belong to the same community.

There are two types of queries:

 communities containing persons  and  are merged if they belong to different communities.

 print the size of the community to which person  belongs.

Input Format

The first line of input contains 2 space-separated integers  and , the number of people and the number of queries.
The next  lines will contain the queries.

Constraints



Output Format

The output of the queries.

Sample Input

STDIN Function ----- -------- 3 6 n = 3, q = 6 Q 1 print the size of the community containing person 1 M 1 2 merge the communities containing persons 1 and 2 ... Q 2 M 2 3 Q 3 Q 2

Sample Output

1
2
3
3
Explanation

Initial size of each of the community is .

---Асуулт---"Монголоор" :
Хүмүүс нийгмийн сүлжээнд хоорондоо холбогддог. Хүн a болон хүн b хоёрын хоорондын холбоог (a, b) гэж тэмдэглэнэ.
Хэрвээ хоёр хүн өөр өөр нийгэмлэгт харьяалагддаг бөгөөд тэд холбогдвол, тухайн хоёрын харьяалагдаж байсан нийгэмлэгүүд нэгдэх болно.

Эхэндээ n хүн байна гэж үзвэл, бүгд тус тусдаа n ширхэг нийгэмлэгт харьяалагдана.
Хэрвээ хүн 1 ба 2 холбогдож, дараа нь хүн 2 ба 3 холбогдвол, 1, 2, 3 бүгд нэг нийгэмлэгт харьяалагдах болно.

Хоёр төрлийн асуулт байна:

M a b — хэрвээ хүн a ба хүн b өөр өөр нийгэмлэгт харьяалагдаж байвал тэдний нийгэмлэгүүдийг нэгтгэнэ.

Q a — хүн a харьяалагдаж буй нийгэмлэгийн хэмжээг хэвлэнэ.

Оролтын формат:

Эхний мөрөнд 2 бүхэл тоо өгөгдөнө: n (хүмүүсийн тоо) ба q (асуултын тоо).
Дараагийн q мөр тус бүрт нэг асуулт байна.

Гаралтын формат:

"Асуулт бүрийн хариуг" хэвлэнэ.

Жишээ оролт:

3 6  
Q 1  
M 1 2  
Q 2  
M 2 3  
Q 3  
Q 2
Жишээ гаралт:

1  
2  
3  
3
---Код---" "
def union_join(member1, member2):
    if people_community_dict[member1] > people_community_dict[member2]:
        people_community_dict[member2] += people_community_dict[member1]
        people_community_dict[member1] = member2
    else:
        people_community_dict[member1] += people_community_dict[member2]
        people_community_dict[member2] = member1


def union_find(member):
    memberList = []
    # only when member is parent node id it will break it
    while people_community_dict[member] > 0:
        # looping to find the big parent (As parent )
        memberList.append(member)
        member = people_community_dict[member]
    # redirect all the members when loop through it to the parent
    for m in memberList:
        people_community_dict[m] = member
    return member


if __name__ == '__main__':
    num_of_people, num_of_query = map(int, input().split())
    # use -1 as init, only community root having -num and the abs(num) is the size of community
    people_community_dict = {i: -1 for i in range(1, num_of_people + 1)}

    for _ in range(num_of_query):
        cur_query = input().split()
        if cur_query[0] == "Q":
            member_id = int(cur_query[1])
            community_root = union_find(member_id)
            print(abs(people_community_dict[community_root]))
        else:
            member_id1, member_id2 = int(cur_query[1]), int(cur_query[2])
            root_m1, root_m2 = union_find(member_id1), union_find(member_id2)
            if root_m1 != root_m2:
                union_join(root_m1, root_m2)
---Тайлбар--- 
![image](https://github.com/user-attachments/assets/73a6a052-3032-4e12-90db-f1ca89a18f20)


# File: ./data_structure/medium/1/README.md

# waiter

# ---Асуулт---"english" :

You are given a list of numbers.
For each element at position 
𝑖
i, we define 
𝑃
(
𝑖
)
P(i) and 
𝑁
(
𝑖
)
N(i) as:

𝑃
(
𝑖
)
P(i) = closest index 
𝑗
j such that 
𝑗
<
𝑖
j<i and 
𝑎
[
𝑗
]
>
𝑎
[
𝑖
]
a[j]>a[i]. If no such 
𝑗
j exists then 
𝑃
(
𝑖
)
=
0
P(i)=0.

𝑁
(
𝑖
)
N(i) = closest index 
𝑘
k such that 
𝑘
>
𝑖
k>i and 
𝑎
[
𝑘
]
>
𝑎
[
𝑖
]
 a[k]>a[i]. If no such 𝑘 exists then 𝑁
(
𝑖
)
=
0
N(i)=0.

We define 
𝑆
(
𝑖
)
=
𝑃
(
𝑖
)
∗
𝑁
(
𝑖
)
S(i)=P(i)∗N(i).
You need to find out the maximum 
𝑆
(
𝑖
)
S(i) among all 
𝑖
i.

Input Format:
The first line contains an integer 
𝑛
n, the number of integers.
The next line contains the 
𝑛
n integers describing the list 
𝑎
[
1..
𝑛
]
a[1..n].

Constraints

Output Format:
Output the maximum 
𝑆
(
𝑖
)
S(i) among all indices from 1 to 
𝑛
n.

Sample Input:
5
5 4 3 4 5

Sample Output:
8

Explanation:
We can compute the following:
The largest of these is 8, so it is the answer.

# ---Асуулт---"Монголоор" :
Танд тоонуудын жагсаалт өгөгдсөн.
Жагсаалтын 
𝑖
i байрлал дахь элементийн хувьд 
𝑃
(
𝑖
)
P(i) ба 
𝑁
(
𝑖
)
N(i)-г дараах байдлаар тодорхойлно:

𝑃
(
𝑖
)
P(i) = 
𝑗
<
𝑖
j<i бөгөөд 
𝑎
[
𝑗
]
>
𝑎
[
𝑖
]
a[j]>a[i] байх хамгийн ойр индекс 
𝑗
j. Хэрвээ ийм 
𝑗
j байхгүй бол 
𝑃
(
𝑖
)
=
0
P(i)=0.

𝑁
(
𝑖
)
N(i) = 
𝑘
>
𝑖
k>i бөгөөд 
𝑎
[
𝑘
]
>
𝑎
[
𝑖
]
a[k]>a[i] байх хамгийн ойр индекс 
𝑘
k. Хэрвээ ийм 
𝑘
k байхгүй бол 
𝑁
(
𝑖
)
=
0
N(i)=0.

𝑆
(
𝑖
)
=
𝑃
(
𝑖
)
∗
𝑁
(
𝑖
)
S(i)=P(i)∗N(i) гэж тодорхойлъё.
Бүх 
𝑖
i-гийн хувьд хамгийн их 
𝑆
(
𝑖
)
S(i)-г ол.

Оролтын формат:
Эхний мөрөнд 
𝑛
n бүхэл тоо байна — тоонуудын тоо.
Дараагийн мөрөнд жагсаалтыг илэрхийлэх 
𝑛
n ширхэг бүхэл тоо өгөгдөнө 
𝑎
[
1..
𝑛
]
a[1..n].

Гаралтын формат:
1-ээс 
𝑛
n хүртэлх бүх индексийн хувьд хамгийн их 
𝑆
(
𝑖
)
S(i)-г хэвлэ.

Жишээ оролт:
5
5 4 3 4 5

Жишээ гаралт:
8
# ---Код---" "
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

long long solve(vector<long> arr) {
    vector<long> prevBigger(arr.size() + 1);
    vector<long> nextBigger(arr.size() + 1);
    for (int i =2; i<= arr.size(); i++ ){
        if (arr[i - 1] < arr[i - 2]) {
            prevBigger[i] = i - 1;
        } else {
            long it = prevBigger[i - 1];
            
            while (arr[it - 1] < arr[i - 1] && it != 0) {
                it = prevBigger[it];
            }
            
            prevBigger[i] = prevBigger[it];
        } 
    } 
    
    for (int i = arr.size() - 1; i >= 1; i--) {
        if (arr[i] > arr[i - 1]) {
            nextBigger[i] = i+ 1;
        } else {
            long it = nextBigger[i+1];
            while (it != 0 && arr[i - 1] > arr[it - 1]) {
                it = nextBigger[it];
            }
            nextBigger[i] = nextBigger[it];
        }
    }
    long long res = 0;
    for (int i = 1; i<= arr.size(); i++) {
        long long t = prevBigger[i] * nextBigger[i];
        if (t > res) {
            res = t;
        }
    }
    return res;
}

int main()
{
    // std::ifstream in("input.txt");
    // std::streambuf *cinbuf = std::cin.rdbuf(); //save old buf
    // std::cin.rdbuf(in.rdbuf()); //redirect std::cin to in.txt!
    
    // std::ofstream fout("output.txt");
    ofstream fout(getenv("OUTPUT_PATH"));

    string arr_count_temp;
    getline(cin, arr_count_temp);

    int arr_count = stoi(ltrim(rtrim(arr_count_temp)));

    string arr_temp_temp;
    getline(cin, arr_temp_temp);

    vector<string> arr_temp = split(rtrim(arr_temp_temp));

    vector<long> arr(arr_count);

    for (int i = 0; i < arr_count; i++) {
        long arr_item = stol(arr_temp[i]);

        arr[i] = arr_item;
    }

    long long result = solve(arr);

    fout << result << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}

vector<string> split(const string &str) {
    vector<string> tokens;

    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));

        start = end + 1;
    }

    tokens.push_back(str.substr(start));

    return tokens;
}
---Тайлбар--- 
![find-max-index](https://github.com/user-attachments/assets/d11ac028-633e-4e1a-a5b5-cb51816d4915)


# File: ./data_structure/medium/binary-tree/README.md

# Binary tree


---Асуулт---"english" :
For the purposes of this challenge, we define a binary tree to be a binary search tree with the following ordering requirements:

The  value of every node in a node's left subtree is less than the data value of that node.
The  value of every node in a node's right subtree is greater than the data value of that node.
Given the root node of a binary tree, can you determine if it's also a binary search tree?

Complete the function in your editor below, which has  parameter: a pointer to the root of a binary tree. It must return a boolean denoting whether or not the binary tree is a binary search tree. You may have to write one or more helper functions to complete this challenge.

Input Format

You are not responsible for reading any input from stdin. Hidden code stubs will assemble a binary tree and pass its root node to your function as an argument.

Constraints

Output Format

You are not responsible for printing any output to stdout. Your function must return true if the tree is a binary search tree; otherwise, it must return false. Hidden code stubs will print this result as a Yes or No answer on a new line.

Sample Input

tree

Sample Output

No

---Асуулт---"Монголоор" :
Сорилын зорилгоор бид хоёртын модыг дараах эрэмбэлэлтийн шаардлагатай хоёртын хайлтын мод (binary search tree) гэж тодорхойлно:

Аль ч зангилааны зүүн дэд модонд байгаа бүх зангилаануудын утга тухайн зангилааны утгаас бага байх ёстой.

Харин баруун дэд модонд байгаа бүх зангилаануудын утга тухайн зангилааны утгаас их байх ёстой.

Чи хоёртын модын үндсэн зангилааг (root) өгөгдсөн гэж үзвэл, тухайн мод нь хоёртын хайлтын мод мөн эсэхийг тодорхойлж чадах уу?

Доорх функцийн биеийг гүйцээ. Энэ функц 1 параметр авна: хоёртын модны үндсэн зангилаа руу заах заагч. Энэ нь тухайн мод хоёртын хайлтын мод мөн эсэхийг илэрхийлэх boolean (үнэн/худал) утга буцаах ёстой.

Энэ сорилын турш функцэд helper функц бичих шаардлагатай байж болох юм.

Оролтын формат:
Чи stdin-оос ямар ч оролт унших шаардлагагүй. Нууц код нь хоёртын модыг угсарч, үндсэн зангилааг функц руу дамжуулна.

Хязгаарлалт:
(Тодорхой хязгаарлалт өгөгдөөгүй байна, гэхдээ ямар нэг онцгой нөхцөл байж болно.)

Гаралтын формат:
Чи ямар ч гаралт хэвлэх шаардлагагүй. Таны функц true (үнэн) утга буцаавал, нууц код нь "Yes", харин false (худал) бол "No" гэж шугам дээр хэвлэнэ.

Жишээ оролт:
tree 
Жишээ гаралт:
No
---Код---"Python3"
""" Node is defined as
class node:
  def __init__(self, data):
      self.data = data
      self.left = None
      self.right = None
"""
def check_binary_search_tree_(root):
    def is_valid_bst(node, min_val, max_val):
        if node is None:
            return True
        if not (min_val < node.data < max_val):
            return False
        return (is_valid_bst(node.left, min_val, node.data) and
                is_valid_bst(node.right, node.data, max_val))

    return is_valid_bst(root, float('-inf'), float('inf'))

---Тайлбар--- 
Програм эхэндээ check_binary_search_tree_ нэртэй үндсэн функцтэй. Энэ функц нь модны үндсэн root нүдийг авч, туслах функц болох is_valid_bst-ийг дуудаж шалгалт хийдэг.

is_valid_bst туслах функцийн гол үүрэг:
Хэрэв тухайн нүд хоосон байвал (мөчир байхгүй бол), энэ нь BST-д саад болохгүй тул True гэж үзнэ.

Харин тухайн нүдний утга нь тодорхой заасан доод болон дээд хязгаарын хооронд байгаа эсэхийг шалгана. Хэрэв зөрчвөл буруу гэж үзээд False буцаана.

Хэрэв зөв бол тухайн нүдний зүүн хүүхдийн модыг дахин доод хязгаар болон энэ нүдний утга хоёрын хооронд байгааг шалгана.

Мөн баруун хүүхдийн модыг энэ нүдний утга болон дээд хязгаар хоёрын хооронд шалгана.

Ийнхүү бүх модыг дотор нь гүнзгий орж шалгаснаар BST-ийн нөхцөл зөрчигдөж байгаа эсэхийг тодорхойлдог.



# File: ./data_structure/medium/bodlogo6/README.md

# Encryption

Англи текстийг дараах нууцлалын аргаар шифрлэх хэрэгтэй. Эхлээд текстээс бүх зай (space)-г устгана. Дараа нь уг текстийн урт L гэж авъя. Энэ текстийн тэмдэгтүүдийг нэгэн хүснэгтэд бичих бөгөөд тухайн хүснэгтийн мөр ба баганын тоо дараах нөхцлийг хангасан байх ёстой:

 [sqrt] <_ row <_column<_[sqrtL], where[x] is floor function and [x] is ceil function

Таслалгүй бичвэрийн урт нь 54 тэмдэгт. √54 нь 7 ба 8-ын хооронд, тиймээс бичвэрийг 7 мөр ба 8 баганын сүлжээнд байрлуулна.
  ifmanwas
  
  meanttos
  
  tayonthe
  
  groundgo
  
  dwouldha
  
  vegivenu
  
  sroots

- rows × columns ≥ L нөхцөлийг хангасан байх ёстой (энд L нь тэмдэгтийн нийт тоо)
- Хэрвээ олон сүлжээ энэ нөхцөлийг хангаж байвал хамгийн бага талбайтай (rows × columns бага) сүлжээг сонгоно.

Кодчилсон мессежийг баганын дагуу тэмдэгтүүдийг уншиж, баганануудын хооронд зай тавьж гаргана. Дээрх сүлжээний кодчилсон мессеж дараах байдалтай байна:

  imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau

Функц үүсгэх даалгавар:
Функцийн тодорхойлолт:
Доорх encryption нэртэй функцийн кодыг гүйцээ.

encryption функц дараах параметртэй:
string s: кодлох тэмдэгт мөр

Буцаах утга:
string: кодлогдсон мессеж

Оролтын формат:
Нэг мөрөнд тэмдэгт мөр өгөгдөнө: s

Хязгаарлалт:
1<_lengch of s<_81

Оролт: haveaniceday
Гаралт: hae and via ecy

Үр дүн: ![Screenshot (360)](https://github.com/user-attachments/assets/d8463175-3c28-40bc-a30e-e0850b419193)

Бодлогын холбоос: https://www.hackerrank.com/challenges/encryption/problem














# File: ./data_structure/medium/bracket/README.md

# Bracket

---Асуулт---"english" :
A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.

Function Description

Complete the function isBalanced in the editor below.

isBalanced has the following parameter(s):

string s: a string of brackets
Returns

string: either YES or NO
Input Format

The first line contains a single integer , the number of strings.
Each of the next  lines contains a single string , a sequence of brackets.

Constraints

, where  is the length of the sequence.
All chracters in the sequences ∈ { {, }, (, ), [, ] }.
Output Format

For each string, return YES or NO.

Sample Input

STDIN           Function
-----           --------
3               n = 3
{[()]}          first s = '{[()]}'
{[(])}          second s = '{[(])}'
{{[[(())]]}}    third s ='{{[[(())]]}}'
Sample Output

YES
NO
YES
Explanation

The string {[()]} meets both criteria for being a balanced string.
The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
The string {{[[(())]]}} meets both criteria for being a balanced string.

---Асуулт---"Монголоор" :
Тасалгааны хаалтын тэмдэгт гэдэг нь дараах аль нэг тэмдэгтүүд байж болно: (, ), {, }, [, эсвэл ].

Хоёр тасалгааны хаалтын тэмдэгт нь таарч байгаа хос гэж үздэг бол нээлттэй тасалгааны хаалтын тэмдэгт ( (, [, { ) баруун талд яг адилхан хаалтын тэмдэгттэй ( ), ], } ) байгаа тохиолдол юм. Ийм таарч байгаа гурван төрлийн хос байна: [], {}, ().

Гэхдээ таарч байгаа хос тасалгааны хаалт бүрэн тэнцвэртэй гэж тооцогдохгүй, учир нь түүний доторх тасалгааны хаалт таарч байгаа эсэхийг ч мөн шалгана. Жишээ нь, {[(])} гэдэг нь тэнцвэргүй, учир нь дотор нь байгаа тасалгааны хаалтууд таарч, зөв дарааллаар байрлаагүй байна. Талын тасалгааны хаалт дотор нэг нээлттэй тасалгааны хаалт (() байна, мөн тасалгааны хаалтны дотор хаалттай тасалгааны хаалт (]) байна.

Иймээс тасалгааны хаалтын дараалал тэнцвэртэй байх нөхцөл нь:

Ямар ч таараагүй тасалгааны хаалт байхгүй байх.

Тэнцвэртэй байгаа хосын доторх тасалгааны хаалт бас тэнцвэртэй байх.

Тэгэхээр, n тооны тасалгааны хаалтын дараалал өгөгдсөн байхад тус бүрийн тэнцвэртэй эсэхийг шалгаад, тэнцвэртэй бол "YES", тэнцвэргүй бол "NO" гэж хэвлэнэ.

Функцийн тайлбар

isBalanced функцэд нэг параметр орно:

s — тасалгааны хаалтын тэмдэгтүүдийн дараалал.

Функц нь "YES" эсвэл "NO" гэсэн тэмдэгт буцаана.

Оролтын формат

Эхний мөрөнд n — дарааллуудын тоо байна.

Дараагийн n мөрөнд тасалгааны хаалтын дараалал өгөгдөнө.

Жишээ оролт

3
{[()]}
{[(])}
{{[[(())]]}}

Жишээ гаралт

YES
NO
YES

Энэ нь ямар учиртай вэ гэвэл:

{[()]} — бүх тасалгааны хаалтууд зөв хослоод, доторх тасалгаанууд нь ч мөн зөв тэнцвэртэй байна.

{[(])} — доторх тасалгааны хаалтууд таарахгүй байгаа тул тэнцвэргүй.

{{[[(())]]}} — бүгд зөв дарааллаар таарч тэнцвэртэй.
---Код---" "
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'isBalanced' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

string isBalanced(string s) {
    stack<char> st;
    for (char c : s) {
     
        if (c == '(' || c == '[' || c == '{') {
            st.push(c);
        } else {
            if (st.empty()) return "NO";
            
            char top = st.top();
            st.pop();
            if ((c == ')' && top != '(') ||
                (c == ']' && top != '[') ||
                (c == '}' && top != '{')) {
                return "NO";
            }
        }
    }
   
    return st.empty() ? "YES" : "NO";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string t_temp;
    getline(cin, t_temp);

    int t = stoi(ltrim(rtrim(t_temp)));

    for (int t_itr = 0; t_itr < t; t_itr++) {
        string s;
        getline(cin, s);

        string result = isBalanced(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}

---Тайлбар--- 
Стек (stack) ашигласан нь учиртай:
Тасалгааны хаалтууд нь хамгийн сүүлд нээгдсэн нь хамгийн түрүүнд хаагдах ёстой тул LIFO (Last-In-First-Out) буюу сүүлд орсон нь эхэнд гарна гэсэн шинж чанартай байдаг. Стек энэ зарчмыг яг тохирохуйц өгөгдлийн бүтэц юм.

for (char c : s) — мөрний бүх тэмдэгтийг нэг нэгээр нь авч шалгана.

Хэрвээ c нь нээлттэй хаалт байвал st.push(c) гэж стек дээр хадгална.

Харин хаалтын хаалт байвал:

Стек хоосон бол шууд буцаана (тэнцвэргүй).

Стекнээс хамгийн сүүлд хадгалсан нээлттэй хаалтыг авна.

Тохирох хаалт эсэхийг шалгана.

Тохирохгүй бол буцаана (тэнцвэргүй).

Эцэст нь стек хоосон байвал бүх тасалгааны хаалт таарсан байна, "YES" гэж буцаана. Үгүй бол "NO".

# File: ./data_structure/medium/simple-text-editor/README.md

# simple-text-editor

---asuult---"english" :

Implement a simple text editor. The editor initially contains an empty string, . Perform  operations of the following  types:
append - Append string  to the end of .
delete - Delete the last  characters of .
print - Print the  character of .
undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.
Example
operation
index   S       ops[index]  explanation
-----   ------  ----------  -----------
0       abcde   1 fg        append fg
1       abcdefg 3 6         print the 6th letter - f
2       abcdefg 2 5         delete the last 5 letters
3       ab      4           undo the last operation, index 2
4       abcdefg 3 7         print the 7th characgter - g
5       abcdefg 4           undo the last operation, index 0
6       abcde   3 4         print the 4th character - d
The results should be printed as:
f
g
d
Input Format
The first line contains an integer, , denoting the number of operations.
Each line  of the  subsequent lines (where ) defines an operation to be performed. Each operation starts with a single integer,  (where ), denoting a type of operation as defined in the Problem Statement above. If the operation requires an argument,  is followed by its space-separated argument. For example, if  and , line  will be 1 abcd.

Constraints
The sum of the lengths of all  in the input .
The sum of  over all delete operations .
All input characters are lowercase English letters.
It is guaranteed that the sequence of operations given as input is possible to perform.
Output Format

Each operation of type  must print the  character on a new line.

Sample Input

STDIN   Function
-----   --------
8       Q = 8
1 abc   ops[0] = '1 abc'
3 3     ops[1] = '3 3'
2 3     ...
1 xy
3 2
4 
4 
3 1
Sample Output
c
y
a
Explanation
Initially,  is empty. The following sequence of  operations are described below:
. We append  to , so .
Print the  character on a new line. Currently, the  character is c.
Delete the last  characters in  (), so .
Append  to , so .
Print the  character on a new line. Currently, the  character is y.
Undo the last update to , making  empty again (i.e., ).
Undo the next to last update to  (the deletion of the last  characters), making .
Print the  character on a new line. Currently, the  character is a.

---asuult---"mongoloor" :
Энгийн текст засварлагч хэрэгжүүл
Засварлагч нь анх хоосон тэмдэгт мөр ("") агуулсан байна. Дараах төрлийн Q тооны үйлдлийг гүйцэтгэнэ:

Үйлдлийн төрлүүд:
append s — Тэмдэгт мөр s-ийг одоо байгаа мөрийн төгсгөлд нэмнэ.
delete k — Одоо байгаа мөрийн төгсгөлийн k ширхэг тэмдэгтийг устгана.
print k — Одоо байгаа мөрийн k-дахь (1-ээс эхэлдэг) тэмдэгтийг хэвлэнэ.
undo — Өмнө нь хийсэн хамгийн сүүлийн (буюу өмнө нь "болих" хийгдээгүй) append эсвэл delete үйлдлийг буцааж, тухайн үеийн байдалд сэргээнэ.

Жишээ
index	Mөрийн утга	 Үйлдэл	Тайлбар
0	    abcde	     1 fg	fg-г нэмнэ
1	    abcdefg      3 6	6 дахь үсэг — f
2	    abcdefg	     2 5	Сүүлийн 5 үсгийг устгана
3	    ab	         4	    Сүүлчийн үйлдлийг болино
4	    abcdefg	     3 7	7 дахь үсэг — g
5	    abcdefg	     4	    Үйлдэл 0-ийг болино
6	    abcde	     3 4	4 дэх үсэг — d

Хэвлэгдэх үр дүн:
f  
g  
d
Оролтын формат:
Эхний мөрөнд Q — нийт үйлдлийн тоо.
Дараагийн Q мөрөнд тус бүрийн үйлдлийг оруулна.
Хэрэв 1 буюу append бол "1 s" — тэмдэгт мөр.
Хэрэв 2 буюу delete бол "2 k" — устгах тэмдэгтийн тоо.
Хэрэв 3 буюу print бол "3 k" — хэвлэх индекс.
Хэрэв 4 буюу undo бол "4" л байна.
Хязгаарлалт:
Бүх оролт зөв байна.
Оролтод орсон бүх тэмдэгтүүд жижиг латин үсэг байна.
s-ийн нийт урт нь 10⁶-аас хэтрэхгүй.
delete-д заагдсан нийт тэмдэгтийн тоо 10⁶-аас ихгүй.
Жишээ оролт:
8
1 abc
3 3
2 3
1 xy
3 2
4
4
3 1
Жишээ гаралт:
c  
y  
a

# File: ./data_structure/medium/waiter/README.md

# waiter

---Асуулт---"english" :
You are a waiter at a party. There is a pile of numbered plates. Create an empty  array. At each iteration, , remove each plate from the top of the stack in order. Determine if the number on the plate is evenly divisible by the  prime number. If it is, stack it in pile . Otherwise, stack it in stack . Store the values in  from top to bottom in . In the next iteration, do the same with the values in stack . Once the required number of iterations is complete, store the remaining values in  in , again from top to bottom. Return the  array.

Example
An abbreviated list of primes is . Stack the plates in reverse order.
Begin iterations. On the first iteration, check if items are divisible by .
Move  elements to .
On the second iteration, test if  elements are divisible by .
Move  elmements to .
And on the third iteration, test if  elements are divisible by .
Move  elmements to .
All iterations are complete, so move the remaining elements in , from top to bottom, to .
. Return this list.
Function Description
Complete the waiter function in the editor below.
waiter has the following parameters:
int number[n]: the numbers on the plates
int q: the number of iterations
Returns
int[n]: the numbers on the plates after processing
Input Format
The first line contains two space separated integers,  and .
The next line contains  space separated integers representing the initial pile of plates, i.e., .
Constraints
Sample Input 0
5 1
3 4 7 6 5
Sample Output 0
4
6
3
7
5
Explanation 
Initially:
 = [3, 4, 7, 6, 5]<-TOP

After 1 iteration (divide by 2, the 1st prime number):
 = [5, 7, 3]<-TOP
 = [6, 4]<-TOP
Move  elements to .
All iterations are complete, so move  elements to .
Sample Input 1
5 2
3 3 4 4 9
Sample Output 1
4
4
9
3
3
Explanation 1
Initially:
 = [3, 3, 4, 4, 9]<-TOP
After  iteration (divide by 2):
 = [9, 3, 3]<-TOP
 = [4, 4]<-TOP
Move  to .
After  iteration (divide by 3):
 = []<- TOP
 = [3, 3, 9]<-TOP
Move  elements to .
There are no values remaining in .
---Асуулт---"Монголоор" :
Нэг багц дугаарласан таваг байна. Эхлээд хоосон массив (list) үүсгэ.
Итерац бүрд дараах алхмуудыг хий:
stack-ийн орой талаас тавагнуудыг дарааллаар нь ав.
Таваган дээрх тоо нь тухайн үеийн i-дах анхны тоонд жигд хуваагдаж байгаа эсэхийг шалга.
Хэрвээ жигд хуваагддаг бол, B_i багц руу хий.
Үгүй бол A_i багц руу хий.
B_i багцын утгуудыг дээдээс нь доош result массив руу хадгал.
Дараагийн итерацид, A_i дээрээ яг энэ үйлдлүүдийг давтана.
q итерац дуусмагц, A багцад үлдсэн утгуудыг ч мөн адил дээд талаас нь доош result руу нэмнэ.
Анхны анхны тоонууд: [2, 3, 5, 7, 11, …]
Тавагнуудыг эсрэг дарааллаар жагсааж байрлуулна (хамгийн сүүлд бичигдсэн таваг хамгийн дээр байна).
Итерац эхэлнэ:
Эхний итерац: бүгдийг 2-т хуваагдаж байгаа эсэхийг шалгана
Хуваагдаж байвал → B1
Үгүй бол → A1
B1-г дээдээс доош result-д нэмнэ
Хоёр дахь итерац: A1-ээс авч, 3-т хуваагдах эсэхийг шалгана
Хуваагдаж байвал → B2
Үгүй бол → A2
B2-г result-д нэмнэ
Гурав дахь итерац: A2 дээр 5-т хуваагдах эсэхийг шалгана
Хуваагдвал → B3
Үгүй бол → A3
B3-г result-д нэмнэ
Ингээд бүх итерац дууссан бол, үлдсэн A3-ийн утгуудыг ч бас result-д нэмж дуусгана.
def waiter(number, q):
Оролт:
number[n]: Тавагнууд дээрх тоонууд (хамгийн сүүлд бичигдсэн нь дээр байрлана)
q: Итерацийн тоо (мөн q ширхэг анхны тоо ашиглана)
 Гаралт:
Боловсруулсан дарааллаар гарсан бүх тавагны дугаарууд (шинэ мөр бүрт нэг утга)
 Оролтын формат
Эхний мөр: n ба q гэсэн хоёр бүхэл тоо (таслалаар салгасан)
Хоёр дахь мөр: n ширхэг бүхэл тоо (анхны тавагнуудын дугаар)
Жишээ Оролт 1
5 1
3 4 7 6 5
Үйл явц:
Эхлээд:
A = [3, 4, 7, 6, 5] <- TOP
1-р итерац (анхны тоо 2):
Тавганд байгаа тоо	2-т хуваагдах уу Ямар багцад очих вэ
5	Үгүй	A1
6	Тийм	B1
7	Үгүй	A1
4	Тийм	B1
3	Үгүй	A1
B1 = [6, 4] <- TOP → [4, 6] → result руу орно
A1 = [3, 7, 5] <- TOP → [5, 7, 3] → мөн result руу орно
Гаралт:
4
6
3
7
5
 Жишээ Оролт 2
5 2
3 3 4 4 9
Эхлээд:
A = [3, 3, 4, 4, 9] <- TOP
Итерац 1 (анхны тоо: 2):
9 → A1
4 → B1
4 → B1
3 → A1
3 → A1
B1 = [4, 4] → result руу
A1 = [3, 3, 9]
Итерац 2 (анхны тоо: 3):
9 → B2
3 → B2
3 → B2
B2 = [3, 3, 9] → result руу
A2 = [] — юу ч үлдээгүй
Гаралт:
4
4
9
3
3
---Код---"c++"
#include <bits/stdc++.h>
using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

vector<int> waiter(vector<int> number, int q) {
    
    vector<int> v{};
    stack<int> snumber;
    vector<int> output;
    
    for(auto a : number)
    {
        cout<<a<<" ";
        snumber.push(a);
    }
    auto getprimes =[](int q){
            deque<int> primes{};
            int num = 2;
            while (static_cast<int>(primes.size()) < q) {
                bool is_prime = true;
                for (int i = 2; i <= std::sqrt(num); ++i) {
                    if (num % i == 0) {
                        is_prime = false;
                        break;
                    }
                }
                if (is_prime) {
                    primes.push_back(num);
                }
                num++;
            }
            return primes;
    };
    deque<int> nprimes = getprimes(q);
    while (!nprimes.empty()) {
        int prime = nprimes.front();
        nprimes.pop_front();
            stack<int> a;
            stack<int> b;
            while(!snumber.empty())
            {
               int top = snumber.top();
               snumber.pop();
               if(top%prime==0)
                    b.push(top);
               else
                    a.push(top);
            }
            while(!b.empty())
            {
                int top = b.top();
                b.pop();
                output.push_back(top);
            }
            snumber=a;
    }
    
    while(!snumber.empty())
    {
        int top = snumber.top();
        snumber.pop();
        output.push_back(top);
    
    }
    return output;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string first_multiple_input_temp;
    getline(cin, first_multiple_input_temp);

    vector<string> first_multiple_input = split(rtrim(first_multiple_input_temp));
    int n = stoi(first_multiple_input[0]);
    int q = stoi(first_multiple_input[1]);

    string number_temp_temp;
    getline(cin, number_temp_temp);

    vector<string> number_temp = split(rtrim(number_temp_temp));
    vector<int> number(n);

    for (int i = 0; i < n; i++) {
        number[i] = stoi(number_temp[i]);
    }

    vector<int> result = waiter(number, q);

    for (size_t i = 0; i < result.size(); i++) {
        fout << result[i];
        if (i != result.size() - 1) {
            fout << "\n";
        }
    }
    fout << "\n";
    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);
    s.erase(s.begin(), find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace))));
    return s;
}

string rtrim(const string &str) {
    string s(str);
    s.erase(find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(), s.end());
    return s;
}

vector<string> split(const string &str) {
    vector<string> tokens;
    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));
        start = end + 1;
    }

    tokens.push_back(str.substr(start));
    return tokens;
}


---Тайлбар--- 
Эхлээд number-ийн бүх элементийг snumber stack-д оруулна.

Prime тоог олж авна.

Prime бүрээр snumber дахь тоог шалгаж, prime-д хуваагдах тоонуудыг b stack-д, бусдыг a stack-д хадгална.

b stack-аас pop хийж гаралт руу нэмнэ.

a-г дараагийн гүйлтэнд зориулан snumber болгож өөрчилнө.

Давталтыг prime тоо бүрээр гүйцэтгэнэ.

Эцэст нь үлдсэн snumber-ийн бүх тоог гаралт руу нэмнэ.

