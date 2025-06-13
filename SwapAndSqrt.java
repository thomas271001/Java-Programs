import java.io.*;

public class SwapAndSqrt{
            static void swap(float a,float b){
            System.out.println("Before swap(Inside function): a=" +a+ ",b =" +b);
            float temp =a;
            a=b;
            b=temp;
            System.out.println("After swap(Inside function) :a= " +a+ ",b =" +b);
}


public static void main(String args[]){
float x=5.5f,y=10.2f;
System.out.println("Before Function call: x= " +x+ ",y=" +y);
swap(x,y);
System.out.println("After Function call :x= " +x+ ",y="+y);
}
}
