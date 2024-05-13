package exercise.throwEx;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MBTI {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.println(test(scanner));
    } catch (InputMismatchException e) {
      System.out.println("wrong input");
    } finally {
      scanner.close();
      System.out.println("닫");
    }
  }

  static String test(Scanner scanner) {
    String result = "";

    printQuestion("취미 생활을 시작할 때 어떤 편이야?",
        "혼자할 수 있는 취미생활을 즐김",
        "동호회에 가입해서 사람들과 어울림");
    result += getInput(scanner, "I", "E");

    printQuestion("노래들을 때 뭐가 중요해?",
        "가사가 너무 중요해~ 가사까지 맘에 들어야 최애곡!",
        "가사가 너무 중요해~ 가사까지 맘에 들어야 최애곡!");
    result += getInput(scanner, "N", "S");

    printQuestion("차에 뭐 놓고왔네 어쩌지?",
        "같이가자! 혼자가면 외로워.",
        "나 혼자 다녀올게! 너 할거 하고있어.");
    result += getInput(scanner, "F", "T");

    printQuestion("요리할 때",
        "레시피랑 계량대로 잘 만드는게 중요함.",
        "음식은 손맛이쥐. 감으로 하는겨~");
    result += getInput(scanner, "J", "P");

    return result;
  }

  static void printQuestion(String problem, String answer1, String answer2) {
    System.out.println("=================================================");
    System.out.println(problem);
    System.out.println("1. " + answer1);
    System.out.println("2. " + answer2);
    System.out.println("=================================================");
  }

  static String getInput(Scanner scanner, String type1, String type2) {
    while (true) {
      try {
        System.out.print("choose 1 or 2 : ");
        String inputLine = scanner.nextLine();
        int input = Integer.parseInt(inputLine);

        if (input == 1) {
          return type1;
        }
        if (input == 2) {
          return type2;
        }
        throw new NumberFormatException();
      } catch (NumberFormatException e) {
        System.out.print("(wrong input) ");
      }
    }
  }
}
