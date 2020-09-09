package structsTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class StructFrameworkTest {
    public static void main(String[] args) {

    }
}


class LinkedListTest{
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        for(int i = 0 ; i < 10 ; i++){
            list.add("test" + i);
        }
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        System.out.println(list.contains("test2"));
        System.out.println(list.get(2));
        System.out.println(list.hashCode());
        System.out.println(list.subList(2,5));
        list.add(5,"addedItem");
        LinkedList<String> list2 = new LinkedList<String>();
        list2.add("addddd1");
        list2.add("23");
        System.out.println(list);
        list.addAll(3,list2);
        System.out.println(list);
    }
}

class ArrayListTest{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            list.add("test" + 10);
        }
        list.remove(3);
        list.set(5,"changed5");
    }
}

class HashMapTest{
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        String[] weeks = {"WEN","TUE","THR","FOR","FRI","SAT","SUN","SUN"};
        for(String value : weeks){
            map.put(value.hashCode(),value);
        }
        map.put(null,"NULL");
        System.out.println(map);
    }
}