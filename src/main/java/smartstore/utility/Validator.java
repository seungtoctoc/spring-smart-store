package smartstore.utility;

import java.util.regex.Pattern;

public class Validator {
  public static boolean isEnglish(String str) {
    return Pattern.matches("^[a-zA-Z]*$", str);
  }

  public static boolean isNumber(Integer num) {
    return Pattern.matches("^[0-9]*$", Integer.toString(num));
  }
}
