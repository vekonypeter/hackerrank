package hackerrank.vp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation {
  boolean check(int a);
}

class MyMath {
  public static boolean checker(PerformOperation p, int num) {
    return p.check(num);
  }

  public PerformOperation isOdd() {
    return num -> num % 2 == 1;
  }

  public PerformOperation isPrime() {
    return num -> {
      if (num <= 1) {
        return false;
      }
      for (int i = 2; i <= Math.sqrt(num); i++) {
        if (num % i == 0) {
          return false;
        }
      }
      return true;
    };
  }

  public PerformOperation isPalindrome() {
    return num -> {
      String str = Integer.toString(num);
      for (int i = 0; i < str.length() / 2; i++) {
        if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
          return false;
        }
      }
      return true;
    };
  }
}

public class SolutionForJavaLambdaExpressions {

  public static void main(String[] args) throws IOException {
    MyMath ob = new MyMath();
    int T = 5;
    PerformOperation op;
    boolean ret = false;
    String ans = null;

    String[] testCases = new String[] {"1 4", "2 5", "3 898", "1 3", "2 12"};

    int i = 0;
    while (T-- > 0) {
      String s = testCases[i];
      i++;
      StringTokenizer st = new StringTokenizer(s);
      int ch = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      if (ch == 1) {
        op = ob.isOdd();
        ret = ob.checker(op, num);
        ans = (ret) ? "ODD" : "EVEN";
      } else if (ch == 2) {
        op = ob.isPrime();
        ret = ob.checker(op, num);
        ans = (ret) ? "PRIME" : "COMPOSITE";
      } else if (ch == 3) {
        op = ob.isPalindrome();
        ret = ob.checker(op, num);
        ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
      }
      System.out.println(ans);
    }
  }
}
