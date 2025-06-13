import java.util.Scanner;
class Employee {
    private int eno;
    private String ename;
    private double esal;
    public Employee(int eno, String ename, double esal) {
        this.eno = eno;
        this.ename = ename;
        this.esal = esal;
    }
    public void display() {
        System.out.println("Employee No: " + eno + ", Name: " + ename + ", Salary: " + esal);
    }
    public int getEno() {
        return eno;
    }
}
public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            System.out.print("Employee Number: ");
            int eno = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Employee Name: ");
            String ename = sc.nextLine();
            System.out.print("Employee Salary: ");
            double esal = sc.nextDouble();
            employees[i] = new Employee(eno, ename, esal);
        }
        System.out.println("\nEmployee Details:");
        for (Employee emp : employees) {
            emp.display();
        }
        System.out.print("\nEnter Employee Number to search: ");
        int searchEno = sc.nextInt();
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getEno() == searchEno) {
                System.out.println("\nEmployee Found:");
                emp.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        }
        sc.close();
    }
}
