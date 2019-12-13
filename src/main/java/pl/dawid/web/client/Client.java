package pl.dawid.web.client;

public class Client {
    private String name;
    private String surname;
    private int age;
    private String region;
    private String sex;

    Client(){
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getSurname() {
        return surname;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    String getRegion() {
        return region;
    }

    void setRegion(String region) {
        this.region = region;
    }

    String getSex() {
        return sex;
    }

    void setSex(String sex) {
        this.sex = sex;
    }
}
