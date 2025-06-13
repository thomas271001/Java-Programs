public class StringBufferDemo {
	public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
         System.out.println("Original: " + sb);
        sb.append(" World");
        System.out.println("After append: " + sb);
         sb.insert(5, " Java");
        System.out.println("After insert: " + sb);
         sb.replace(6, 10, "Python");
        System.out.println("After replace: " + sb);
        sb.delete(6, 12);
        System.out.println("After delete: " + sb);
        sb.reverse();
        System.out.println("After reverse: " + sb);
        sb.setLength(5);
        System.out.println("After setting length: " + sb);
	}
}
