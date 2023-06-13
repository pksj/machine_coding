
import java.util.ArrayList;
import java.util.List;

public class Main {
  static UserDatabase userDatabase;

  public static void main(String[] args) {
    userDatabase = new UserDatabase();
    show();
    System.out.println("----------------");
    show("u1"); System.out.println("----------------");
    expense("EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL"); System.out.println("----------------");
    show("u4"); System.out.println("----------------");
    show("u1"); System.out.println("----------------");
    expense("EXPENSE u1 1250 2 u2 u3 EXACT 370 880"); System.out.println("----------------");
    show(); System.out.println("----------------");
    expense("EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20"); System.out.println("----------------");
    show("u1"); System.out.println("----------------");
    show(); System.out.println("----------------");
    System.out.println("dfvdsdscdvdsvd");
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
        Integer friendOwesUser = paidBy.owedBy.get(friend.userId);
        Integer userOwesFriend = friend.owesTo.get(paidBy.userId);
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

        if (friendOwesUser != null && userOwesFriend != null) {
          if (friendOwesUser + friendsShare > userOwesFriend) {
            paidBy.owesTo.put(friend.userId, friendOwesUser + friendsShare - userOwesFriend);
            friend.owedBy.put(paidBy.userId, friendOwesUser + friendsShare - userOwesFriend);
          }else if (friendOwesUser + friendsShare < userOwesFriend){
            paidBy.owedBy.put(friend.userId, friendOwesUser + friendsShare - userOwesFriend);
            friend.owesTo.put(paidBy.userId, friendOwesUser + friendsShare - userOwesFriend);
          }else{
            paidBy.owesTo.remove(friend.userId);
            friend.owedBy.remove(paidBy.userId);
          }
        } else if (friendOwesUser == null && userOwesFriend == null) {
          paidBy.owedBy.put(friend.userId, friendsShare);
          friend.owesTo.put(paidBy.userId, friendsShare);
        } else if (friendOwesUser != null) {
          System.out.println("Dcsdf");
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