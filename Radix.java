public class Radix{
  public static int nth(int n, int col){
    int amountTodivide = Math.pow(10,col);
    n /= amountTodivide;
    n = n % amountTodivide;
    return n;
  }
  
  
}