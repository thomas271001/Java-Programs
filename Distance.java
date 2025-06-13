import java.io.*;


class Distance implements Cloneable{
int feet;
double inches;

Distance(int f,double i){
     this.feet=f;
     this.inches=i;
}
void display(){
 System.out.println("Distance: " +feet+ "feet" +inches+ "inches");
}

public Object clone() throws CloneNotSupportedException {
     return super.clone();
}
public static void main(String args[]){
try{
   Distance d1=new Distance(5,9.5);
   Distance  d2=(Distance)d1.clone();
   d1.display();
   d2.display();
}catch(CloneNotSupportedException e){
     System.out.println("Cloning not supported.");
}
}
}
