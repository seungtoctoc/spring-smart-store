package exercise.prev;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiCatchEx {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] cards = {11, 22, 33, 44, 55};

    System.out.println("카드 하나 뽑아보실래요? 5장이 있답니다");

    try{
      int cardIdx = scanner.nextInt();

      System.out.println(cardIdx + "번째 카드는..." + cards[cardIdx-1] + "에요");
    }
    catch(InputMismatchException e) {
      System.out.println("대답 똑바로 해");
    }
    catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("5장이란거 못들었어?");
    }
    catch(Exception e) {
      System.out.println("이 자식봐라?");
    }
}
}
