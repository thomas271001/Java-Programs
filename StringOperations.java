import java.util.Scanner;

public class StringOperations{
     public static void main(String args[]){
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter a string");
     char[] str=sc.nextLine().toCharArray();
     
    while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Length of string");
            System.out.println("2. Compare for equality");
            System.out.println("3. Extract substring");
            System.out.println("4. Convert to uppercase");
            System.out.println("5. Convert to lowercase");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice=sc.nextInt();
            sc.nextLine();
            
           if(choice ==1){
               int length =0;
               for(char c: str){
                  length++;
                }
                
              System.out.println("Length: " + length);}
            else if(choice ==2){
               System.out.print("Enter another string: ");
               char[] str2=sc.nextLine().toCharArray();
               boolean isEqual=true;
                int len1=0,len2=0;
                 for(char c:str)len1++;
                 for(char c: str2) len2++;
                 if(len1!=len2){
                  isEqual=false;
                   }else{
                   for(int i=0;i<len1;i++){
                    if (str[i]!=str[i]){
                     isEqual=false;
                      break;           
             }
           }
          }
           System.out.println(isEqual ? "Strings are equal." : "Strings are not equal.");
}
else if(choice==3){
System.out.print("Enter start and end index: ");
int start=sc.nextInt(),end=sc.nextInt();
sc.nextLine();

if(start>=0 && end<= str.length && start<end){
System.out.print("Substring: ");
for(int i=start;i<end;i++){
System.out.print(str[i]);
}
System.out.println();
}else{
System.out.println("Invalid indices.");
}
}

else if(choice==4){
System.out.print("Uppercase: ");
for(int i=0;i<str.length;i++){
if(str[i]>='a' && str[i]<='z'){
System.out.print((char) (str[i] - 32));
}else{
System.out.print(str[i]);
}
}
System.out.println();
}
else if(choice ==5){
System.out.print("Lowercase");
for(int i=0;i<str.length;i++){
if(str[i]>='A' && str[i]<='Z'){
System.out.print((char) (str[i] + 32));
}else{
System.out.print(str[i]);
}
}
 System.out.println();
}
 else if (choice == 6) {  
                break;} 
else { System.out.println("Invalid option.");
      }
}
sc.close();
}
}
