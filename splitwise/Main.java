
// Problem statement: https://workat.tech/machine-coding/practice/splitwise-problem-0kp2yneec2q2

import java.util.ArrayList;
import java.util.List;

public class Main {
  static UserDatabase userDatabase;

  public static void main(String[] args) {
    userDatabase = new UserDatabase();
    show();
    show("u1");
    expense("EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL");
    show("u4");
    show("u1");
    expense("EXPENSE u1 1250 2 u2 u3 EXACT 370 880");
    show();
    expense("EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20");
    show("u1");
    show();
  }

  static void expense(String expenseInfo) {
    String[] inputs = expenseInfo.split(" ");
    User paidBy = userDatabase.getUserById(inputs[1]);
    if (paidBy == null) {
      System.out.println(inputs[1] + " is invalid user.");
    }
    int paidAmount = Integer.parseInt(inputs[2]);
    int totalUsersInvolved = Integer.parseInt(inputs[3]);
    List<User> usersInvolved = new ArrayList<>();
    for (int i = 0; i < totalUsersInvolved; i++) {
      usersInvolved.add(userDatabase.getUserById(inputs[4 + i]));
    }
    String splitStrategy = inputs[4 + totalUsersInvolved];
    for (int i = 0; i < totalUsersInvolved; i++) {
      User friend = usersInvolved.get(i);
      if (!friend.userId.equals(paidBy.userId)) {
        int friendsShare = 0;
        if (splitStrategy.equals("EQUAL")) {
          friendsShare = paidAmount / totalUsersInvolved;
        } else if (splitStrategy.equals("EXACT")) {
          friendsShare = Integer.parseInt(inputs[4 + totalUsersInvolved + 1 + i]);
        } else if (splitStrategy.equals("PERCENT")) {
          friendsShare = (Integer.parseInt(inputs[4 + totalUsersInvolved + 1 + i]) * paidAmount) / 100;
        } else {
          System.out.println("Incorrect split strategy.");
          return;
        }

        Integer friendOwesUser = paidBy.owedBy.get(friend.userId);
        Integer userOwesFriend = paidBy.owesTo.get(friend.userId);

        if (friendOwesUser != null) {
          paidBy.owedBy.put(friend.userId, friendOwesUser + friendsShare);
          friend.owesTo.put(paidBy.userId, friendOwesUser + friendsShare);
        } else if (userOwesFriend != null) {
          if (friendsShare > userOwesFriend) {
            paidBy.owedBy.put(friend.userId, friendsShare - userOwesFriend);
            friend.owesTo.put(paidBy.userId, friendsShare - userOwesFriend);

            paidBy.owesTo.remove(friend.userId);
            friend.owedBy.remove(paidBy.userId);
          } else if (friendsShare < userOwesFriend) {
            paidBy.owesTo.put(friend.userId, userOwesFriend - friendsShare);
            friend.owedBy.put(paidBy.userId, userOwesFriend - friendsShare);

            paidBy.owedBy.remove(friend.userId);
            friend.owesTo.remove(paidBy.userId);
          } else {
            paidBy.owedBy.remove(friend.userId);
            friend.owesTo.remove(paidBy.userId);
          }
        } else {
          paidBy.owedBy.put(friend.userId, friendsShare);
          friend.owesTo.put(paidBy.userId, friendsShare);
        }
      }
    }
  }

  static void show() {
    userDatabase.show();
  }

  static void show(String userId) {
    userDatabase.show(userId);
  }
}
