// package machine_coding.splitwise;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase{
  private List<User> users;

  public UserDatabase() {
    users = new ArrayList<>();
    users.add(new User("u1", "a", "a@gmail.com", "1"));
    users.add(new User("u2", "b", "b@gmail.com", "2"));
    users.add(new User("u3", "c", "c@gmail.com", "3"));
    users.add(new User("u4", "d", "d@gmail.com", "4"));
  }

  User getUserById(String userId) {
    for (User user : users) {
      if (user.userId.equals(userId)) {
        return user;
      }
    }
    return null;
  }
}