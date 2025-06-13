import java.io.*;
import java.util.Scanner;

public class RandomFileAcessMethod{
   private static final String file_name="data.txt";
   public static void main(String args[]){
   Scanner scanner = new Scanner(System.in);
   int choice;
   while(true){
           System.out.println("\nMenu:");
           System.out.println("1. Create File");
           System.out.println("2. Delete File");
           System.out.println("3. Write to File");
           System.out.println("4. Append to File");
           System.out.println("5. Read from File");
           System.out.println("6. Exit");
           System.out.print("Enter your choice: ");
           choice =scanner.nextInt();
     switch(choice){
       case 1:
         createFile();
         break;
       case 2:
         deleteFile();
         break;
      case 3:
         writeFile();
         break;
      case 4:
          appendFile();
          break;
     case 5:
           readFile();
           break;
    case 6:
          System.out.println("Exiting...");
          scanner.close();
          return;
   default:
          System.out.println("Invalid choice! Try again.");


}  
}
}
private static void createFile(){
try{
File file=new File(file_name);
if(file.createNewFile()){
       System.out.println("File created successfully.");

}else{
     System.out.println("File already exists.");
}
}catch(IOException e){
       System.out.println("Error creating file: " + e.getMessage());

}
}
private static void deleteFile(){
File file = new File(file_name);
if(file.exists() && file.delete()){
         System.out.println("File deleted successfully.");
}else{
         System.out.println("File not found.");

}
}
private static void writeFile(){
try(RandomAccessFile raf=new RandomAccessFile(file_name,"rw")){
Scanner scanner=new Scanner(System.in);
System.out.println("Enter text to write");
String text=scanner.nextLine();
raf.writeUTF(text);
System.out.println("Data written successfully.");
}catch(IOException e){
    System.out.println("Error writing file: " + e.getMessage());
}
}
private static void appendFile(){
try(RandomAccessFile raf= new RandomAccessFile(file_name,"rw")){
Scanner scanner=new Scanner(System.in);
raf.seek(raf.length());
System.out.println("Enter text to append: ");
String text=scanner.nextLine();
raf.writeUTF(text);
System.out.println("Data appended successfully.");
}catch(IOException e){
      System.out.println("Error appending file: " + e.getMessage());
}
}
private static void readFile(){
try(RandomAccessFile raf=new RandomAccessFile(file_name,"r")){
         System.out.println("Reading from file:");
         while(raf.getFilePointer()<raf.length()){
                 System.out.println(raf.readUTF());    
}
}catch(IOException e){
         System.out.println("Error reading file: " + e.getMessage());
}
}
}
