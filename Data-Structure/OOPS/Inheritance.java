public class Inheritance {
    public static void main(String args[]) {
    // Mammal 
       Dog d1 = new Dog();
       d1.walk();
       d1.eat();

    //Fish
       Shark s1 = new Shark();
       s1.swim();
       s1.teeth();

    // Bird
    Peacock p1 = new Peacock();
    p1.fly();
    }
}

class Animal {
    String color;
    void eat() {
        System.out.println("Eats");
    }
    void breathe() {
        System.out.println("Breathe");
    }
}

class Mammal extends Animal {
     void walk() {
        System.out.println("Walk");
     }
}

class Dog extends Mammal {
    void bark () {
        System.out.println("Bark");
    }
}

class Fish extends Animal {
    void swim () {
        System.out.println("Swim");
    }
}

class Tuna extends Fish{
    void size () {
        System.out.println("size is small");
    }
}

class Shark extends Fish {
    void teeth () {
        System.out.println("Sharp teeth");
    }
}


class Bird extends Animal {
    void fly () {
        System.out.println("Fly");
    }
}

class Peacock extends Bird {
    void look () {
        System.out.println("Looks beautiful");
    }
} 

