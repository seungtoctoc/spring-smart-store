package exercise.prev;

public class ArithmeticEx {

  public static void main(String[] args) {
    try {
      int result = divide(10,0);
    }
    catch (ArithmeticException e) {
      System.out.println("수학적 에러가 발생했삼");
    }
  }

  static int divide(int x, int y) throws ArithmeticException {
    return x/y;
  }
}
