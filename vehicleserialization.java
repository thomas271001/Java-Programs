import java.io.*;
class  Engine implements Serializable{
private static final long serialVersionUID=1L;
int power;
String type;

public Engine(int power,String type){
this.power=power;
this.type=type;
}
}

class Vehicle implements Serializable{
private static final long serialVersionUID=1L;
String name;
transient Engine engine;

public Vehicle(String name,Engine engine){
this.name=name;
this.engine=engine;
}
public void display(){
System.out.println("Vehicle Name: " + name);
if(engine!=null){
     System.out.println("Engine Power: " + engine.power + " HP, Type: " + engine.type);
}
else{
System.out.println("Engine:  not serialized");
}
}
}
public class vehicleserialization{
public static void main(String args[]){
Engine engine =new Engine(120, "Petrol");
Vehicle vehicle= new Vehicle("Honda City", engine);
String filename="vehicle.ser";
try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(filename))){
out.writeObject(vehicle);
System.out.println("Vehicle object serialized.");
} catch (IOException e) {
  e.printStackTrace();
 }
 try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
 Vehicle deserializedVehicle = (Vehicle) in.readObject();
System.out.println("Deserialized Vehicle object:");
deserializedVehicle.display();
} catch (IOException | ClassNotFoundException e) {
e.printStackTrace();
}
}
}
