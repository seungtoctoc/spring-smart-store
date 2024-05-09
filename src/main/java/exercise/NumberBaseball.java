package exercise;

import java.util.Random;
import java.util.Scanner;

public class NumberBaseball {
  static Scanner scanner = new Scanner(System.in);
  static Random random = new Random();

  public static void main(String[] args) {
    String answer = getRandomAnswer();
    System.out.println(answer);

    int times = 1;

    while(times <= 10) {
      try {
        System.out.print("\n" + times + "번째 시도: ");
        String input = scanner.nextLine();

        // validate
        checkNumber(input);

        if (!hasCorrectLength(input)) {
          System.out.println("3자리 숫자를 입력하세요");
          continue;
        }

        times++;

        if (hasDuplicate(input)) {
          System.out.println("중복된 숫자가 있습니다.");

          continue;
        }

        if (compareInputAndGetIsAnswer(input, answer)) {
          break;
        }
      }
      catch (NumberFormatException e) {
        System.out.println("숫자를 입력하세요");
      }
    }
  }

  static String getRandomAnswer() {
    String answer = "";

    for(int i = 0 ; i < 3; i++) {
      int randomNumber = random.nextInt(10);

      while(answer.contains(Integer.toString(randomNumber))) {
        randomNumber = random.nextInt(10);
      }
      answer += Integer.toString(randomNumber);
    }

    return answer;
  }

  static void checkNumber(String str) throws NumberFormatException{
    Integer.parseInt(str);
  }

  static boolean hasCorrectLength(String str) {
    return str.length() <= 3;
  }

  static boolean hasDuplicate(String str) {
    for (int i = 0 ; i < str.length() ; i++) {
      for (int j = 0 ; j < str.length();j++) {
        if (i == j) {
          continue;
        }

        if (str.charAt(i) == str.charAt(j)) {
          return true;
        }
      }
    }

    return false;
  }

  static boolean compareInputAndGetIsAnswer(String input, String answer) {
    int strike = 0;
    int ball = 0;

    for (int i = 0 ; i < input.length() ; i++) {
      String current = String.valueOf(input.charAt(i));

      if (!answer.contains(current)) {
        continue;
      }

      if (current.charAt(0) == answer.charAt(i)) {
        strike++;
        continue;
      }

      ball++;
    }

    // return correct
    if (strike == 3) {
      System.out.println("correct!");
      return true;
    }

    // print strike, ball, out
    if (strike>0) {
      System.out.printf(strike + " strike, ");
    }

    if (ball > 0) {
      System.out.printf(ball + " ball, ");
    }

    int out = 3 - strike - ball;
    if (out > 0) {
      System.out.printf(out + " out ");
    }

    System.out.println();
    return false;
  }
}
