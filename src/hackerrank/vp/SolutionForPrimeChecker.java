package hackerrank.vp;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

class Prime {
  public void checkPrime(int... nums) {
    StringBuilder output = new StringBuilder();
    for (int num : nums) {
      if (isPrime(num)) {
        output.append(num).append(" ");
      }
    }
    System.out.println(output);
  }

  private boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}

public class SolutionForPrimeChecker {
  public static void main(String[] args) {

    try {
      int n1 = 2;
      int n2 = 1;
      int n3 = 3;
      int n4 = 4;
      int n5 = 5;
      Prime ob = new Prime();
      ob.checkPrime(n1);
      ob.checkPrime(n1, n2);
      ob.checkPrime(n1, n2, n3);
      ob.checkPrime(n1, n2, n3, n4, n5);
      Method[] methods = Prime.class.getDeclaredMethods();
      Set<String> set = new HashSet<>();
      boolean overload = false;
      for (int i = 0; i < methods.length; i++) {
        if (set.contains(methods[i].getName())) {
          overload = true;
          break;
        }
        set.add(methods[i].getName());
      }
      if (overload) {
        throw new Exception("Overloading not allowed");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
