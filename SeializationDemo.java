import java.io.*;

class Student implements Serializable{
private static final long serialVersionUID = 1L;
String name;
int rollno;
transient int age;
public  Student(String name,int rollno,int age){
this.name=name;
this.rollno=rollno;
this.age=age;
}

  public void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollno + ", Age: " + age);
    }
}
public class SeializationDemo{
public static void main(String[] args) {
        Student s1 = new Student("abcd", 101, 20);
        String filename = "student.ser";
try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(s1);
            System.out.println("Object Serialized Successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Student deserializedStudent = (Student) in.readObject();
            System.out.println("Object De-Serialized:");
            deserializedStudent.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
 }
}
