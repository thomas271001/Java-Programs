class MyRunnable implements Runnable {
    public String threadName;
    
   public MyRunnable(String name){
   this.threadName=name;
}
public void run(){
   for(int i=0;i<5;i++){
   System.out.println(threadName+ "is running" +i);
   try{
    Thread.sleep(1000);
    }
   catch(InterruptedException e){
   System.out.println(threadName + " was interrupted.");
   }
   }
   System.out.println(threadName + " has finished execution.");   
}
}
public class RunnableExample{
 public static void main(String args[]){
MyRunnable  r1=new MyRunnable("Thread 1");
MyRunnable  r2=new MyRunnable("Thread 2");
MyRunnable  r3=new MyRunnable("Thread 3");

Thread t1 = new Thread(r1);
Thread t2=new Thread(r2);
Thread t3=new Thread(r3);

t1.start();
t2.start();
t3.start();
System.out.println("Main thread execution finished.");
}
}
