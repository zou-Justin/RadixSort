
import java.util.*;
import java.io.*;
public class Tester {
  public static void main (String[]agrs){
    SortableLinkedList m = new SortableLinkedList();
    m.add(2);
    m.add(3);
    SortableLinkedList c = new SortableLinkedList();
    c.add(24);
    c.add(5);
    SortableLinkedList a = new SortableLinkedList();
    a.add(224);
    a.add(13);
    a.add(-11);
    a.add(22);
    a.add(31);
    a.add(1);
    Radix.radixSort(a);
    System.out.println(a);
    // SortableLinkedList[]b = new SortableLinkedList[]{c,a};
    // merge(m,b);
    // System.out.println(m);
    
    System.out.println(Radix.nth(123,0));
    System.out.println(Radix.nth(-123,1));
    System.out.println(Radix.nth(123,2)); 
    System.out.println(Radix.nth(-123,2));
    System.out.println(Radix.nth(123,1));
    System.out.println(Radix.length(-10));
  }
}
