package genericsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] intArr = {5,3,7,2,8};
        Double[] doubleArr = {4.2,6.0,5.0,2.1,4.5};
        String[] stringArr = {"acds","2dsf","cds"};

        sort(intArr);
        sort(doubleArr);
        sort(stringArr);

        System.out.println("-------------------");
        listSort();
    }

    static <T extends Comparable<T>> void sort(T[] arr){
        Arrays.sort(arr);
        for(T value : arr){
            System.out.printf("%s ",value);
        }
        System.out.println();
    }

    static void listSort(){
        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();

        name.add("Icon");
        age.add(18);

        getData(name);
        getData(age);
        /*ERROR*/
//        getUperData(name);
        getUperData(age);
    }

    static void getData(List<?> data){
        System.out.println("data: " + data.get(0));
    }

    static void getUperData(List<? extends Number> data){
        System.out.println("data: " + data.get(0));
    }
}


