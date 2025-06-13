class MyThread extends Thread{
    public String threadName;

   public MyThread(String name){
   this.threadName=name;
}
public void run(){
  for(int i=0;i<5;i++){
   System.out.println(threadName + "is running:" +i);
}
   try{
   Thread.sleep(1000);
   }
   catch(InterruptedException e){
   System.out.println(threadName+ "was interrupted");
}
}
}
public class MultiThreadExample{
   public static void main(String args[]){
   MyThread t1=new MyThread("Thread 1");
   MyThread t2=new MyThread("Thread 2");
   MyThread t3=new MyThread("Thread 3");
   t1.start();
   t2.start();
   t3.start();
   System.out.println("Main thread execution finished.");
}}
