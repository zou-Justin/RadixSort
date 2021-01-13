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
    
  }
  public static void main (String[]agrs){
    System.out.println(nth(123,1));
    System.out.println(nth(-123,1));
    System.out.println(nth(123,2)); 
    System.out.println(nth(-123,2));
    System.out.println(nth(123,1));
    System.out.println(length(-10));
  }

}