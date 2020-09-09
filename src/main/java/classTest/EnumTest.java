package classTest;

public class EnumTest {
    public static void main(String[] args) {
        Color red = Color.RED;
        System.out.println(red);
        System.out.println(red.GREEN);
        System.out.println(red.RED);
        System.out.println(red.YELLOW);
    }
}


enum Color{
    RED,GREEN,YELLOW,
}

