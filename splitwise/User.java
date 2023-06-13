// package machine_coding.splitwise;

import java.util.HashMap;
import java.util.Map;

public class User{
  String userId;
  String name;
  String email;
  String mobileNumber;
  Map<String, Integer> owesTo = new HashMap<>();
  Map<String, Integer> owedBy = new HashMap<>();

  public User(String userId, String name, String email, String mobileNumber) {
    this.userId = userId;
    this.name = name;
    this.email = email;
    this.mobileNumber = mobileNumber;
  }
}