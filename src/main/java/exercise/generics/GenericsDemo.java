package exercise.generics;

import java.util.ArrayList;

public class GenericsDemo {

  public static void main(String[] args) {
    ArrayList<Car> cars = new ArrayList<>();

    K9 k9 = new K9();
    Arcana arcana = new Arcana();
    Trax trax = new Trax();

    cars.add(k9);
    cars.add(arcana);
    cars.add(trax);

    for (Car car: cars) {
      car.bbang();
    }


    // 2
    CarList<Car> carList = new CarList<>();
    carList.add(k9);
    carList.add(arcana);
    carList.add(trax);

  }
}

class CarList<T> {
  ArrayList<T> arrayList = new ArrayList<>();

  void add(T t) {
    arrayList.add(t);
  }
}

class Car {
  void bbang() {
    System.out.println("bbang");
  }
}

class K9 extends Car {
  void bbang() {
    System.out.println("kkkkkkkkk");
  }
}

class Arcana extends Car {
  void bbang() {
    System.out.println("arrrrrr");
  }
}

class Trax extends Car {
  void bbang() {
    System.out.println("traaaaaax");
  }
}
