package exercise.generics;

import java.util.ArrayList;

public class StackDemo {

  public static void main(String[] args) {
    MyStack<String> stackStr = new MyStack<>();

    System.out.println("isEmpty: " + stackStr.isEmpty());

    System.out.println("add a, b, c");
    stackStr.push("a"); // 1
    stackStr.push("b"); // 2
    stackStr.push("c"); // 3

    System.out.println("isEmpty: " + stackStr.isEmpty());

    System.out.printf("printElements: ");
    stackStr.printElements();

    System.out.println("pop: " + stackStr.pop());
    System.out.println("peek: " + stackStr.peek());
    System.out.println("pop: " + stackStr.pop());
    System.out.println("pop: " + stackStr.pop());

    System.out.println("isEmpty: " + stackStr.isEmpty());
  }
}

class MyStack<T> {
  ArrayList<T> myStack = new ArrayList<>();

  boolean isEmpty() {
    return myStack.isEmpty();
  }

  void push(T t) {
    myStack.add(t);
  }

  T peek() {
    if (myStack.isEmpty()) {
      return null;
    }
    return  myStack.get(myStack.size() - 1);
  }

  T pop() {
    if (myStack.isEmpty()) {
      return null;
    }

    T top = peek();
    myStack.remove(myStack.size() - 1);
    return top;
  }

  void printElements() {
    for (T t : myStack) {
      System.out.print(t + " ");
    }
    System.out.println();
  }
}
