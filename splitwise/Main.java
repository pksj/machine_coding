
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
      String userId = usersInvolved.get(i).userId;
      if (!userId.equals(paidBy.userId)) {
        Integer x = paidBy.owedBy.get(userId);
        int share = 0;
        if (x != null) {
          share += x;
        }

        if (splitStrategy.equals("EQUAL")) {
          paidBy.owedBy.put(userId, share + paidAmount / totalUsersInvolved);
        } else if (splitStrategy.equals("EXACT")) {
          paidBy.owedBy.put(userId, share + Integer.parseInt(inputs[4 + totalUsersInvolved + 1 + i]));
        } else if (splitStrategy.equals("PERCENT")) {
          paidBy.owedBy.put(userId,
              share + (Integer.parseInt(inputs[4 + totalUsersInvolved + 1 + i]) * paidAmount) / 100);
        } else {

        }

        Integer y = userDatabase.getUserById(userId).owesTo.get(paidBy.userId);
        share = 0;
        if (y != null) {
          share += y;
        }

        if (splitStrategy.equals("EQUAL")) {
          userDatabase.getUserById(userId).owesTo.put(paidBy.userId, share + paidAmount / totalUsersInvolved);
        } else if (splitStrategy.equals("EXACT")) {
          userDatabase.getUserById(userId).owesTo.put(paidBy.userId,
              share + Integer.parseInt(inputs[4 + totalUsersInvolved + 1 + i]));
        } else if (splitStrategy.equals("PERCENT")) {
          userDatabase.getUserById(userId).owesTo.put(paidBy.userId,
              share + (Integer.parseInt(inputs[4 + totalUsersInvolved + 1 + i]) * paidAmount) / 100);
        } else {

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