package classTest;

interface PeopleInterface {
    void speak();
    void setAge();
    void setName();
    int getAge();
    String getName();
}

public interface StudentInterface extends PeopleInterface{
    void hasClass();
}
