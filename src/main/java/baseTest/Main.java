package baseTest;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Integer a = 10;
    int b = 10;
    System.out.println(a == b);
  }
}

class StringTest {
  public static void main(String[] args) {
    String a = "abcde";
    String b = "abcde121212";
    System.out.println(b);
    b += "2323";
    System.out.println(b);


    System.out.println(a == b);
    System.out.println(a.equals(b));

    System.out.println(a.hashCode());
    System.out.println(b.hashCode());
  }
}

class StringBufferTest {
  static int times = 1000000;

  public static void main(String[] args) {
        /*stringBufferTest();
        stringBuilderTest();
        stringTest();*/
  }

  public static void stringBufferTest() {
    String s = "abcde";
    StringBuffer sb = new StringBuffer();
    long start = new Date().getTime();
    for (int i = 0; i < times; i++) {
      sb.append(s);
    }
    long duration = new Date().getTime() - start;
    System.out.printf("stringBuffer %d\n", duration);
  }

  public static void stringBuilderTest() {
    String s = "abcde";
    StringBuilder sb = new StringBuilder();
    long start = new Date().getTime();
    for (int i = 0; i < times; i++) {
      sb.append(s);
    }
    long duration = new Date().getTime() - start;
    System.out.printf("stringBuilder %d\n", duration);
  }

  public static void stringTest() {
    String source = "";
    String s = "abcde";
    long start = new Date().getTime();
    for (int i = 0; i < times; i++) {
      source += s;
    }
    long duration = new Date().getTime() - start;
    System.out.printf("string %d\n", duration);
  }

}

class ArrayTest {
  public static void main(String[] args) {
    int[] arr1 = new int[10];
    for (int i = 0; i < arr1.length; i += 2) {
      arr1[i] = i;
    }
    ;

    int[] arr2 = new int[10];
    for (int i = 0; i < arr2.length; i += 2) {
      arr2[i] = i + 1;
    }
    ;

    System.out.println(Arrays.equals(arr1, arr2));
    Arrays.fill(arr1, 5);
    System.out.println(Arrays.toString(arr1));
    System.out.println(getSum(arr1));
  }

  static int getSum(int[] arr) {
    int total = 0;
    for (int i = 0; i < arr.length; i += 2) {
      total += arr[i];
    }
    return total;
  }
}

class CharTest {
  public static void main(String[] args) {
    char[] arr = {'a', 'b', 'c', 'd', 'e'};
    System.out.println(arr);
    String arr2 = "abcde";
    System.out.println(arr2.equals(arr));

    Character ch = 'a';
    char c = ch;
    System.out.println(Character.MIN_VALUE);
    System.out.println(Character.MAX_VALUE);
    System.out.println(Character.MAX_VALUE);
  }
}

class StringDemo {
  public static void main(String[] args) {
    String str = "abcdecde";
    str = remove(str, 2);
    System.out.println(str);
    System.out.println(new StringBuffer(str).reverse().toString());
    String[] arr = str.split("c");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "---");
    }
    System.out.println();

    intern(str);
  }

  static String remove(String str, int index) {
    return str.substring(0, index) + str.substring(index + 1);
  }

  static void intern(String str) {
    System.out.println(str.intern());
  }
}

class ArrayDemo{
  public static void main(String[] args) {
    String[] arr1 = {"a","b","c"};
    String[] arr2 = {"1","2","3"};
    String[] result = concat(arr1,arr2);
    for (String str : result){
      System.out.println(str);
    }
  }

  static <E> E[] concat(E[] arr1, E[] arr2){
    List<E> list = new ArrayList(Arrays.asList(arr1));
    list.addAll(Arrays.asList(arr2));
    return  list.toArray(arr1);
  }
}


class CalendarTest{
  public static void main(String[] args) {
    Calendar c = Calendar.getInstance();
    int day = c.get(Calendar.DATE);
    System.out.println(day);
    System.out.println(c.get(Calendar.DAY_OF_YEAR));
  }
}


class TimeTest{
  public static void main(String[] args) {
    Long timeStamp = System.currentTimeMillis();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    String sd = sdf.format(Long.parseLong(String.valueOf(timeStamp)));
    String sd = sdf.format(timeStamp);

    String sd2 = sdf.format(new Date(timeStamp));
    System.out.println(sd);
    System.out.println(sd2);
  }
}

/**
 * 汉诺塔
 */
class HanTower{
  static Stack<Integer> a = new Stack<Integer>();
  static Stack<Integer> b = new Stack<Integer>();
  static Stack<Integer> c = new Stack<Integer>();
  static int disks = 9;

  public static void main(String[] args) {
    for(int i = disks ; i >= 1 ; i--){
      a.push(i);
    }
    move(disks,a,b,c);
  }

  static void move(int step,Stack<Integer> from,Stack<Integer> inter,Stack<Integer> to){
    if(step == 1){
      to.push(from.pop());
      printAllStacks();
    }else{
      move(step - 1, from,to,inter);
      to.push(from.pop());
      printAllStacks();
      move(step - 1,inter,from,to);
    }
  }

  static void printAllStacks(){
    System.out.print(a);
    System.out.print(b);
    System.out.print(c);
    System.out.println();
    for(int i = disks-1 ; i >= 0 ; i--){
      printItem(a,i);
      printItem(b,i);
      printItem(c,i);
      System.out.println();
    }
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  static void printItem(Stack<Integer> s, int level){
    System.out.print("|");
    if(s.size() > level){
      for(int j = 0 ; j < disks - s.get(level); j++){
        System.out.print(" ");
      }
      for(int j = 0 ; j < s.get(level)*2 + 1 ; j++){
        System.out.print("-️");
      }
      for(int j = 0 ; j < disks - s.get(level); j++){
        System.out.print(" ");
      }
    }else{
      for(int j = 0 ; j < disks * 2 + 1; j++){
        System.out.print(" ");
      }
    }
  }
}

/*斐波那契数列*/
class Feb{
  static ArrayList<Integer> result = new ArrayList<Integer>();
  static int max = 8000;
  private static int current = 1;
  public static void main(String[] args) {
    result.add(1);
    result.add(1);
    add();
    System.out.println(result);
  }
  static void add(){
    if(current < max){
      int size = result.size();
      current = result.get(size - 2) + result.get(size-1);
      result.add(current);
      add();
    }
  }
}

/*可变参数测试*/
class Varargs{
  public static void main(String[] args) {
    System.out.println(sum(1,3,4,5,6));
  }

  static int sum(int... numbers){
    int sum = 0;
    for(int i = 0 ; i < numbers.length ; i++){
      sum += numbers[i];
    }
    return sum;
  }
}