import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student Ankur = new Student("Ankur Ray", 06, 98, "12th");
        Student Priye = new Student("Priya Yadav", 29, 100, "11th");
        System.out.println(Ankur.name);
        Ankur.setName("Ankur Kumar Ray");
        System.out.println(Ankur.name);
        System.out.println("Ankur's class is : " + Ankur.getClassNumber() + " and he scored : " + Ankur.getScore());
        System.out.println(Priye.getName());
        System.out.println(Priye.getScore());
    }



}

class Student {

    String name;
    int rollNumber;
    int score;
    String classNumber;

    public Student(String name, int rollNumber, int score, String classNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.score = score;
        this.classNumber = classNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }
}
