public class Abstraction {
    public static void main(String args[]) {
        // Horse h = new Horse();
        // h.eat();
        // h.walk();

        // Mustang myHorse = new Mustang();
        


    }
}

// Abstract classes
abstract class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }
    
    void eat () {
        System.out.println("Eat anything");
    }

    abstract void walk();
}

class Horse extends Animal {
    Horse () {
        System.out.println("Horse constructor called");
    }

    void walk () {
        System.out.println("Walk on 4 legs");
    }
}

class Mustang extends Horse {
    Mustang () {
        System.out.println("Mustang constructor called");
    }
}