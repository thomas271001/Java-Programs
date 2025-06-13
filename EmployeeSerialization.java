import java.io.*;
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int id;
    private double salary;
    transient String password; 

    public Employee(String name, int id, double salary, String password) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.password = password;
    }

    public void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Password: " + password);
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        Employee emp = new Employee("luna", 101, 75000.50, "SecurePass123");
        String filename = "employee.ser";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(emp);
            System.out.println("Employee object serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Employee deserializedEmp = (Employee) in.readObject();
            System.out.println("\nDeserialized Employee object:");
            deserializedEmp.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
