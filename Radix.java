import java.lang.*;

public class Radix{
  public static int nth(int n, int col){
    int amountTodivide = (int) Math.floor(Math.pow(10,col));
    n /= amountTodivide;
    n = n % amountTodivide;
    return Math.abs(n);
  }
  public static int length(int n){
    if (n < 0){
      n *= -1;
    }
    int tens = (int) Math.floor(Math.log10(n));
    return tens + 1;
  }
  public static void merge(MyLinkedList original,MyLinkedList[]buckets){
    for (int i = 0; i < buckets.length;i++){
      original.extend(buckets[i]);
    }
  }
  public static void main (String[]agrs){
    MyLinkedList m = new MyLinkedList();
    m.add("hello1");
    m.add("bob1");
    MyLinkedList c = new MyLinkedList();
    c.add("hello2");
    c.add("bob2");
    MyLinkedList a = new MyLinkedList();
    a.add("hello3");
    a.add("bob3");
    MyLinkedList[]b = new MyLinkedList[]{c,a};
    merge(m,b);
    System.out.println(m);
    
    System.out.println(nth(123,1));
    System.out.println(nth(-123,1));
    System.out.println(nth(123,2)); 
    System.out.println(nth(-123,2));
    System.out.println(nth(123,1));
    System.out.println(length(-10));
  }

}