import java.io.*;
class vehicle implements Serializable{
       private static final long serialVersionUID=1L;
	String brand;
        int speed;
        public vehicle(String brand,int speed){
        this.brand=brand;
        this.speed=speed;
        
} 
}
class MarutiCar extends vehicle {
    private static final long serialVersionUID = 1L;
    String model;
    int mileage;
public MarutiCar(String brand,int speed,String model,int mileage){
super(brand,speed);
this.model=model;
this.mileage=mileage;
}
  public void display() {
        System.out.println("Brand: " + brand + ", Speed: " + speed + " km/h, Model: " + model + ", Mileage: " + mileage + " km/l");
    }
}
public class MarutiSerialization {
public static void main(String args[]){
MarutiCar car = new MarutiCar("Maruti Suzuki", 120, "Swift", 18);
        String filename = "car.ser";
try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(car);
            System.out.println("MarutiCar object serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }
try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            MarutiCar deserializedCar = (MarutiCar) in.readObject();
            System.out.println("Deserialized MarutiCar object:");
            deserializedCar.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
}
}
