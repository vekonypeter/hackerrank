package hackerrank.vp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SolutionForJavaMd5 {

  public static void main(String[] args) throws NoSuchAlgorithmException {
      Scanner scanner = new Scanner(System.in);
      String text = scanner.next();
      scanner.close();

      MessageDigest algo = MessageDigest.getInstance("md5");
      byte[] hash = algo.digest(text.getBytes());
      for (byte b : hash) {
          System.out.printf("%02x", b);
      }
  }
}
