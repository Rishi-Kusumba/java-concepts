package streams;

import java.util.*;
import java.util.stream.Collectors;

public class RunnerClass {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        System.out.println("How many male and female employees are there in the organization?");
        Map<String, Long> q1 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(q1);
        System.out.println("----------");

        System.out.println("Print the name of all departments in the organization?");
        List<String> q2 = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(q2);
        System.out.println("----------");

        System.out.println("What is the average age of male and female employees?");
        Map<String, Double> q3 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(q3);
        System.out.println("----------");

        System.out.println("Get the details of highest paid employee in the organization?");
        Optional<Employee> q4 = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println(q4.get());
        System.out.println("----------");

        System.out.println("Get the names of all employees who have joined after 2015?");
        List<String> q5 = employeeList.stream()
                .filter(employee -> employee.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(q5);
        System.out.println("----------");

        System.out.println("Count the number of employees in each department?");
        Map<String, Long> q6 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(q6);
        System.out.println("----------");

        System.out.println("What is the average salary of each department?");
        Map<String, Double> q7 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(q7);
        System.out.println("----------");

        System.out.println("Get the details of youngest male employee in the product development department?");
        Optional<Employee> q8 = employeeList.stream()
                .filter(employee -> employee.getGender().equals("Male") && employee.getDepartment().equals("Product Development"))
                .min(Comparator.comparing(Employee::getAge));
        System.out.println(q8.get());
        System.out.println("----------");

        System.out.println("Who has the most working experience in the organization?");
        Optional<Employee> q9 = employeeList.stream()
                .min(Comparator.comparing(Employee::getYearOfJoining));
        System.out.println(q9.get());
        System.out.println("----------");

        System.out.println("How many male and female employees are there in the sales and  marketing team?");
        Map<String, Long> q10 = employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(q10);
        System.out.println("----------");

        System.out.println("What is the average salary of male and female employees?");
        Map<String, Double> q11 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(q11);
        System.out.println("----------");

        System.out.println("List down the names of all employees in each department?");
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)).entrySet().forEach(entry -> {
                    System.out.print(entry.getKey() + " - ");
                    entry.getValue().forEach(value -> {
                        System.out.print(value.getName() + " | ");
                    });
                    System.out.println();
                });
        System.out.println("----------");

        System.out.println("What is the average salary and total salary of the whole");
        DoubleSummaryStatistics salaryStats = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
        System.out.println("Average salary - " + salaryStats.getAverage());
        System.out.println("Total salary - " + salaryStats.getSum());
        System.out.println("----------");

        System.out.println("Separate the employees who are younger or equal to 25 years from");
        employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getAge() <= 25)).entrySet().forEach(entry -> {
                    if (entry.getKey())
                        System.out.println("Employees less than or equal to 25 years - ");
                    else
                        System.out.println("Employees older than 25 years - ");
                    entry.getValue().stream()
                            .sorted(Comparator.comparing(Employee::getAge))
                            .forEach(System.out::println);
                });
        System.out.println("----------");

        System.out.println("Who is the oldest employee in the organization?");
        Optional<Employee> q12 = employeeList.stream()
                .max(Comparator.comparing(Employee::getAge));
        System.out.println(q12.get());

    }
}
