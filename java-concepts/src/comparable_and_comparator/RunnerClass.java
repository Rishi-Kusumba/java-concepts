package comparable_and_comparator;

import java.util.Arrays;
import java.util.Comparator;

public class RunnerClass {

    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[4];
        employeeArray[0] = new Employee(103, "Thor");
        employeeArray[1] = new Employee(102, "Odin");
        employeeArray[2] = new Employee(104, "Kratos");
        employeeArray[3] = new Employee(101, "Loki");
        System.out.println("Before sorting - " + Arrays.toString(employeeArray));
        // Sorting using comparable
        Arrays.sort(employeeArray);
        System.out.println("After sorting - " + Arrays.toString(employeeArray));
        // Sorting using comparator
        Arrays.sort(employeeArray, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Sorting on name using Comparator - " + Arrays.toString(employeeArray));

    }

}
