package classTest;

public class AbstactTest {
    public static void main(String[] args) {
        Boy boy = new Boy();
        boy.setGender("male").setName("Martin").setAge(27).speak();
        boy.doSomething();

        People people = new People() {
            @Override
            public void doSomething() {
                System.out.println("I dont want to do anything");
            }
        };

        System.out.println();

        people.setAge(23).setName("Maria").speak();
        people.doSomething();

    }
}

abstract class People{
    private String name;
    private int age;

    public void speak(){
        System.out.println("I am " + this.name + ", " + this.age + "years old");
    }

    public abstract void doSomething();

    public People setName(String name) {
        this.name = name;
        return this;
    }

    public People setAge(int age) {
        this.age = age;
        return this;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class Boy extends People{
    String gender = "male";

    public People setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public void doSomething() {
        System.out.println("I play ball");
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println("Oh, I am a boy, means " + this.gender);
    }
}