package exercise.throwEx;

import java.util.Scanner;

public class AgeCheck {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("나이가 어떻게 되세요? ");

      try {
        String inputLine = scanner.nextLine();
        int age = Integer.parseInt(inputLine);

        if (age < 0 || age > 125) {
          throw new InputBoundException("아 가라고요");
        }

        System.out.println(age + "살? ㅋㅋ 말 편하게 할게?");
        break;
      } catch (NumberFormatException e) {
        System.out.println("마 정신 똑띠 안차리나");
      } catch (InputBoundException e) {
        System.out.println(e.getMessage());
      }
    }

    scanner.close();
  }
}