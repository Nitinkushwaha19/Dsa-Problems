public class Oops {

    public static void main(String args[]) {
        // Pen p1 = new Pen(); // created an object p1 of class Pen
        // p1.setcolor("red");
        // System.out.println(p1.getColor());

        // p1.setTip(5);
        // System.out.println(p1.getTip());

        Student s1 = new Student();
        s1.name = "Nitin";
        s1.roll = 101;
        s1.password = "xyz";
        s1.marks[0] = 90;
        s1.marks[1] = 80;
        s1.marks[2] = 70;

        Student s2 = new Student(s1);
        s2.password = "kush";

        s1.marks[0] = 100;

        for(int i=0;i<3;i++) {
            System.out.println(s2.marks[i]);
        }


    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[];

    Student() {
        marks = new int[3];
        System.out.println("Constructor is called.");
    }

    Student(int roll) {
        marks = new int[3];
        this.roll = roll;
        System.out.println(this.roll);
    }

    Student(String name) {
        marks = new int[3];
        this.name = name;
        System.out.println(this.name);
    }

    // Shallow Copy constructor
    // Student(Student s1){
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     this.marks = s1.marks;
    // }


    // Deep Copy constructor
    Student(Student s1) {
            marks = new int[3];
            this.name = s1.name;
            this.roll = s1.roll;

            for(int i=0;i<marks.length;i++) {
                this.marks[i] = s1.marks[i];
            }
    }
}


class Pen {
    private String color;
    private int tip;

    Pen() {
        System.out.println("Constructor is called..");
    }

    void setcolor(String newColor) {
        this.color = newColor;
    }

    void setTip(int newTip) {
        this.tip = newTip;
    }

    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }
}