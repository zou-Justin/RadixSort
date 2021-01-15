import java.lang.*;

public class Radix{
  
  public static int nth(int n, int col){
    if (col == 0){
      n =  n % 10;
      return Math.abs(n);
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
  public static SortableLinkedList radixSort(SortableLinkedList data){
    int temp = 0;
    SortableLinkedList tempData = new SortableLinkedList();
    SortableLinkedList[]PosBuckets = new SortableLinkedList[10];
    SortableLinkedList[]NegBuckets = new SortableLinkedList[10];
    for (int i = 0; i < 10 ;i++){
      PosBuckets[i] = new SortableLinkedList();
    }
    for (int i = 0; i < 10;i++){
      NegBuckets[i] = new SortableLinkedList();
    }
    int maxLength = length(data.get(0));
    for (int i = 0; i < maxLength;i++){
      while (data.size() > 0){
        temp = data.get(0);
        if (temp >= 0){
            PosBuckets[nth(temp,i)].add(temp);  
        }
        else{
          NegBuckets[nth(temp,i)].add(temp);
        }
        if (length(temp) > maxLength){
          maxLength = length(temp);
        }
        data.remove(0);  
      }
      merge(data,PosBuckets);
      merge(data,NegBuckets);
      
    }
    
    int size = data.size()-1;
    for (int i = data.size(); i > 0;i--){
      int temp1 = data.get(size);
      if (temp1 < 0){
        data.add(temp1);
        data.remove(size);
        size--;
      }
    }
    int size2 = 0;
    for (int i = 0; i < data.size();i++){
      int temp2 = data.get(0);
        if (temp2 >= 0){
          data.add(temp2);
          data.remove(size2);
          size++;
        }
    }
    return data;
  }
  

}