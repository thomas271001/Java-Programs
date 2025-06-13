class AverageCalculator<T extends Number>{
private T[] numbers;
public AverageCalculator(T[] numbers){
this.numbers=numbers;
}
public double getAverage(){
double sum=0;
for(T num:numbers){
sum+=num.doubleValue();
}
return sum/numbers.length;
}
public Boolean Averagecompare(AverageCalculator<?> other){
return Math.abs(this.getAverage()-other.getAverage())<0.0001;
}
}
public class BoundedGeneric{
public static void main(String args[]){
Integer[] intarray={1,2,3,4,5};
Double[] doublearray={1.1,2.2,3.3,4.4};
AverageCalculator<Integer> intavg= new AverageCalculator<>(intarray);
AverageCalculator<Double> doubleavg=new AverageCalculator<>(doublearray);
System.out.println("Integer Array Average" +intavg.getAverage());
System.out.println("Double Array Average" +doubleavg.getAverage());
if(intavg.Averagecompare(doubleavg)){
System.out.println("Both arrays have the same average.");
}
else{
System.out.println("Averages are different.");
}
}
}
