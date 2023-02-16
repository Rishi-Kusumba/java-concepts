package polymorphism.static_polymorphism;

public class MethodOverloading_Example {

    public static void add(int a, int b, int c) {
        System.out.println("Adding three numbers - " + (a + b + c));
    }

    public static void add(int a, double b) {
        System.out.println("Adding int and double numbers - " + (a + b));
    }

    public static void add(int a, long b) {
        System.out.println("Adding int and long numbers - " + (a + b));
    }

    public static void add(long a, int b) {
        System.out.println("Adding int and long numbers - " + (a + b));
    }

    public static void main(String[] args) {
        add(1, 1.5);
        add(1, 2, 3);
        //add(1, 2); // Ambiguous. add(long a, int b) & add(int a, long b) both satisfy
    }

}
