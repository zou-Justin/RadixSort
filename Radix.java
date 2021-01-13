import java.lang.*;

public class Radix{
  public static int nth(int n, int col){
    if (col == 0){
      return n % 10;
    }
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
  // public static void merge(MyLinkedList original,MyLinkedList[]buckets){
  //   for (int i = 0; i < buckets.length;i++){
  //     original.extend(buckets[i]);
  //   }
  // }
  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0; i < buckets.length;i++){
      original.extend(buckets[i]);
    }
  }
  
  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[]buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10 ;i++){
      buckets[i] = new SortableLinkedList();
    }
    int maxLength = data.get(0);
    for (int i = 0; i < maxLength;i++){
      while (data.size() > 0){
        if ()
        
        data.remove(0);
      }
    }
     merge(data,buckets);
  }
  public static void reset(SortableLinkedList stuff){
    SortableLinkedList temp = new SortableLinkedList();
    temp.extend(stuff);
  }
  public static void radixSort(SortableLinkedList data){
    SortableLinkedList[]PosBuckets = new SortableLinkedList[10];
    SortableLinkedList[]NegBuckets = new SortableLinkedList[10];
    for (int i = 0; i < 10 ;i++){
      PosBuckets[i] = new SortableLinkedList();
    }
    for (int i = 9; i >= 0;i--){
      NegBuckets[i] = new SortableLinkedList();
    }
    int maxLength = 0;
    for (int i = 0; i < data.size(); i++){
      if (maxLength < length(data.get(i))) {
        maxLength = length(data.get(i));
      }
    }
    for (int i = 0; i < maxLength;i++){
      for (int j = 0;j < data.size();j++){
        if (data.get(j) >= 0){
          PosBuckets[nth(data.get(j),i)].add(data.get(j));  
        }
        else{
          NegBuckets[nth(data.get(j),i)].add(data.get(data.get(j)));
        }
        reset(data);
        merge(data,NegBuckets);
        merge(data,PosBuckets);
      }
    }
  }
  

}