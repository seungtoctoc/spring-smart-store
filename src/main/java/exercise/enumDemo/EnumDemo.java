package exercise.enumDemo;

public enum EnumDemo {
  AMERICANO(0, "americano"),
  LATTE(1, "lattte");

  final int menuNumber;
  final String menuName;

  EnumDemo(int menuNum, String menuName) {
    this.menuName = menuName;
    this.menuNumber = menuNum;
  }
}