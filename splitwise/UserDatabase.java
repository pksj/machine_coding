// package machine_coding.splitwise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDatabase{
  private List<User> users;

  public UserDatabase() {
    users = new ArrayList<>();
    users.add(new User("u1", "a", "a@gmail.com", "1"));
    users.add(new User("u2", "b", "b@gmail.com", "2"));
    users.add(new User("u3", "c", "c@gmail.com", "3"));
    users.add(new User("u4", "d", "d@gmail.com", "4"));
  }

  public User getUserById(String userId) {
    for (User user : users) {
      if (user.userId.equals(userId)) {
        return user;
      }
    }
    return null;
  }

  public void show() {
    Set<String> set = new HashSet<>();
    for (User user : users) {
      set.addAll(user.show());
    }
    if (set.isEmpty() == true) {
      System.out.println("No balances");
    } else {
      for (String s : set) {
        System.out.println(s);
      }
    }
  }

  public void show(String userId) {
    User user = getUserById(userId);
    Set<String> set = user.show();
    if (set.isEmpty() == true) {
      System.out.println("No balances");
    } else {
      for (String s : set) {
        System.out.println(s);
      }
    }
  }

}