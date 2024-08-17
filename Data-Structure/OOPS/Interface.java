public class Interface {
    public static void main(String args[]) {
        // Human h = new Human();
        // h.eats();

        // Student s1 = new Student();
        // s1.schoolName = "Raisoni";
        // System.out.println(s1.schoolName);

        // Student s2 = new Student();
        // s2.schoolName = "Dharampeth";
        // System.out.println(s2.schoolName);

        // Student s3 = new Student();
        // System.out.println(s3.schoolName);


        Dog d1 = new Dog();
        // d1.color = "black";
        System.out.println(d1.color);
    }
}


class Animal {
    Animal () {
        System.out.println("Animal constructor called");
    }
    String color;
}

class Dog extends Animal {
    Dog() {
        super.color = "black";
        System.out.println("Dog constructor called");
    }
}

class Student {

    String name;
    int roll;

    // Static Keyword
    static String schoolName;

    void setName(String name) {
        this.name = name;
    }

    void getName() {
        System.out.println(this.name);
    }
}

// Interface and concept of multiple inheritance
interface Herbivore {
    void eats();
}

interface Carnivore {
    void eats();
}

class Human implements Herbivore, Carnivore {
    public void eats() {
        System.out.println("Eats both vegetable and meat");
    }
}
