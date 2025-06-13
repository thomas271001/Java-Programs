import java.util.Scanner;

class GenericClass<T,U>{
   private T first;
   private U second;
   public GenericClass(T first, U second){
   this.first=first;
   this.second=second;
}
 public void showType(){
 System.out.println("First: " +first+ "(Type" + first.getClass().getSimpleName()+")");
  System.out.println("second:  " +second+ "(Type" +second.getClass().getSimpleName()+")");
}
}
public class Genericlass{
public static void main(String args[]){
GenericClass<Integer,String> obj1=new GenericClass<>(10,"hello");
GenericClass<Double,Character> obj2=new GenericClass<>(10.5,'l');
obj1.showType();
obj2.showType();
}
}
