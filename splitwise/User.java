// package machine_coding.splitwise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

  public Set<String> show() {
    Set<String> set = new HashSet<>();
    for (Map.Entry<String, Integer> entry : owedBy.entrySet()) {
      set.add(entry.getKey() + " owes " + userId + " : " + entry.getValue());
    }
    for (Map.Entry<String, Integer> entry : owesTo.entrySet()) {
      set.add(userId + " owes " + entry.getKey() + " : " + entry.getValue());
    }
    return set;
  }
}