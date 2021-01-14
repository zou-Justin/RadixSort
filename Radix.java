import java.lang.*;

public class Radix{
  
  public static int nth(int n, int col){
    if (col == 0){
      return n % 10;
    }
    int amountTodivide = (int) Math.pow(10,col);
    n = (int) n / amountTodivide;
    n = n % 10;
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
    int temp = 0;
    SortableLinkedList[]buckets = new SortableLinkedList[10];
    for (int i = 0; i < 10 ;i++){
      buckets[i] = new SortableLinkedList();
    }
    int maxLength = length(data.get(0));
    for (int i = 0; i < maxLength;i++){
      while (data.size() > 0){
        temp = data.get(0);
        buckets[nth(temp,i)].add(temp);
        if (length(temp) > maxLength){
          maxLength = length(temp);
        }
        data.remove(0);
      }
       merge(data,buckets);
    }
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
        //reset(data);
        merge(data,NegBuckets);
        merge(data,PosBuckets);
      }
    }
  }
  

}