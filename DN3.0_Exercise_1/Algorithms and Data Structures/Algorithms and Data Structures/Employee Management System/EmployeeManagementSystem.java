import java.util.Scanner;

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
        } else {
            System.out.println("Employee array is full!");
        }
    }

    // Method to search an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Method to traverse and display all employees
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Method to delete an employee by ID
    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[--count] = null;
        } else {
            System.out.println("Employee not found!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem(100);

        // Adding Employees
        System.out.print("Enter number of employees to add: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        for (int i = 0; i < numEmployees; i++) {
            System.out.print("\nEnter employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();

            System.out.print("Enter employee position: ");
            String position = scanner.nextLine();

            System.out.print("Enter employee salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();  // Consume the newline

            Employee employee = new Employee(employeeId, name, position, salary);
            ems.addEmployee(employee);
        }

        // Traversing Employees
        System.out.println("\nAll Employees:");
        ems.traverseEmployees();

        // Searching for an Employee
        System.out.print("\nEnter employee ID to search: ");
        int searchId = scanner.nextInt();
        Employee foundEmployee = ems.searchEmployee(searchId);
        System.out.println("Search Result: " + (foundEmployee != null ? foundEmployee : "Employee not found"));

        // Deleting an Employee
        System.out.print("\nEnter employee ID to delete: ");
        int deleteId = scanner.nextInt();
        ems.deleteEmployee(deleteId);

        // Traversing Employees after Deletion
        System.out.println("\nAll Employees after deletion:");
        ems.traverseEmployees();
    }
}
