import java.util.Scanner;

class Cstring{
  private String str;
   
  Cstring(){
  this.str="";
 }
 
void read(){
 Scanner sc = new Scanner(System.in);
 System.out.print("enter a string");
  str=sc.nextLine();
}

void display(){
System.out.println("String:" +str);
}

Boolean compare(Cstring other){
 return this.str.equals(other.str);
}

void add(String newStr){
    this.str+=newStr;
}

Cstring concatenate(Cstring other){
Cstring result=new Cstring();
result.str =this.str+other.str;
return result;
}

public static void main(String args[]){
Cstring s1=new Cstring();
Cstring s2=new Cstring();
s1.read();
s2.read();
System.out.println("Comparing strings: " +s1.compare(s2));
s1.add("world");
s1.display();

Cstring s3=s1.concatenate(s2);
s3.display();
}
}
