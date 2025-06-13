class Buffer {
private int data;
private boolean hasData = false;

public synchronized void produce(int value){
while (hasData) {
try{
wait();
}
catch(InterruptedException e){
System.out.println("Producer interrupted.");
}
}
data=value;
hasData=true;
System.out.println("produced" +data);
notify();
}
public synchronized void consume(){
while(!hasData){
try{
wait();
}catch (InterruptedException e) {
System.out.println("Consumer interrupted.");
 }
}
System.out.println("consumed." +data);
hasData=false;
notify();
}
}
class Producer extends Thread{
public Buffer buffer;
public Producer(Buffer buffer){
this.buffer=buffer;
}
public void run(){
for(int i=0;i<5;i++){
buffer.produce(i);
try{
Thread.sleep(1000); 
} catch (InterruptedException e) {
System.out.println("Producer sleep interrupted.");
            }
}
}
}

class Consumer extends Thread{
public Buffer buffer;
public Consumer(Buffer buffer){
this.buffer=buffer;
}
public void run(){
for(int i=0;i<5;i++){
buffer.consume();
try{
Thread.sleep(1500);
}catch(InterruptedException e){
System.out.println("consumer sleep interrupted.");
}
}
}
}
public class ProducerConsumer{
    public static void main(String[] args) {
      Buffer buffer=new Buffer();
      Producer producer= new Producer(buffer);
      Consumer consumer=new Consumer(buffer);
      producer.start();
      consumer.start();
}
}
