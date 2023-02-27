package hashcode_and_equals_contract;

public class RunnerClass {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Rambo");

        Employee e2 = new Employee();
        e2.setId(1);
        e2.setName("Rambo");
        System.out.println("Shallow comparison = " + (e1 == e2));
        System.out.println("Deep comparison = " + e1.equals(e2));
    }
}
