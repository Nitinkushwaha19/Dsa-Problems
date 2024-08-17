public class Polymorphism {
    public static void main(String args[]) {

        // Calculator calc = new Calculator();
        // System.out.println(calc.sum(4, 5));
        // System.out.println(calc.sum((float) 4.5, 5));
        // System.out.println(calc.sum(4, 5, 6));


        Deer d1 = new Deer();
        d1.eats();
        
    }
}

class Animal {
    void eats () {
        System.out.println("Eats Anything");
    }
}

class Deer {
    void eats () {
        System.out.println("Eats Grass");
    }
}


class Calculator {
    // Method overloading
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}