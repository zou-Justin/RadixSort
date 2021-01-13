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
  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0; i < buckets.length;i++){
      original.extend(buckets[i]);
    }
  }
  
  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[]buckets = new SortableLinkedList[10];
    SortableLinkedList temp = new SortableLinkedList();
    for (int i = 0; i < 10 ;i++){
      buckets[i] = new SortableLinkedList();
    }
    int maxLength = 0;
    for (int i = 0; i < data.size(); i++){
      if (maxLength < length(data.get(i))) {
        maxLength = length(data.get(i));
      }
    }
    for (int i = 0; i < maxLength;i++){
      for (int j = 0; j < data.size(); j++){
        buckets[nth(data.get(j),i)].add(data.get(j));
      }
      merge(temp,buckets);
      reset(temp);
    }
  }
  public static void reset(SortableLinkedList stuff){
    SortableLinkedList temp = new SortableLinkedList();
    temp.extend(stuff);
    
  }
  public static void main (String[]agrs){
    SortableLinkedList m = new SortableLinkedList();
    m.add(2);
    m.add(3);
    SortableLinkedList c = new SortableLinkedList();
    c.add(4);
    c.add(5);
    SortableLinkedList a = new SortableLinkedList();
    a.add(234);
    a.add(-213);
    SortableLinkedList[]b = new SortableLinkedList[]{c,a};
    merge(m,b);
    System.out.println(m);
    
    System.out.println(nth(123,4));
    System.out.println(nth(-123,1));
    System.out.println(nth(123,2)); 
    System.out.println(nth(-123,2));
    System.out.println(nth(123,1));
    System.out.println(length(-10));
  }

}