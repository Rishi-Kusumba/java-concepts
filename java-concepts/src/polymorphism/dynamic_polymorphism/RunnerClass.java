package polymorphism.dynamic_polymorphism;

public class RunnerClass {

    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
        parentClass.features();

        ChildClass childClass = new ChildClass();
        childClass.features();

        ParentClass parentClass1 = new ChildClass(); // Upcasting - parent class reference allocated memory of child class
        parentClass1.features(); // method is called to which memory is created

//        ChildClass childClass1 = new ParentClass(); // compile time error
//        childClass1.features();

        // Dynamic polymorphism is not possible with variables.

    }

}
