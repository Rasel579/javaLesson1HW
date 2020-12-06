package lesson5;

public class Employee {
    private  String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private double salary;
    private int age;

    public Employee(String name, String position, String email, String phoneNumber, double salary, int age) {
        this.fullName = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String toString() {
        return "Employee{" +
                "name='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", salary=" + "$" +salary +
                ", age=" + age +
                '}';
    }

    public void printInfo(){
        System.out.println(this.toString());
    }

    public int getAge() {
        return age;
    }
}