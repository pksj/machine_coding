

import java.util.ArrayList;
import java.util.List;

public class Main {
  static UserDatabase userDatabase;

  public static void main(String[] args) {
    userDatabase = new UserDatabase();
    expense("EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL");
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
    for(int i = 0; i < totalUsersInvolved; i++){
      usersInvolved.add(userDatabase.getUserById(inputs[4+i]));
    }
    String splitStrategy = inputs[4+totalUsersInvolved];
    if(splitStrategy.equals("EQUAL")){
      for (int i = 0; i < totalUsersInvolved; i++) {
        // String userId = inputs[4 + totalUsersInvolved + 1 + i];
        String userId = usersInvolved.get(i).userId;
        if (!userId.equals(paidBy.userId)) {
          Integer x = paidBy.owedBy.get(userId);
          if(x == null){
            paidBy.owedBy.put(userId, paidAmount/totalUsersInvolved);
          } else{
            paidBy.owedBy.put(userId, x + (paidAmount/totalUsersInvolved));
          }
          Integer y = userDatabase.getUserById(userId).owesTo.get(paidBy.userId);
          if(x == null){
            userDatabase.getUserById(userId).owesTo.put(paidBy.userId,  paidAmount/totalUsersInvolved);
          }else{
            userDatabase.getUserById(userId).owesTo.put(paidBy.userId, y + (paidAmount / totalUsersInvolved));
          }
        }
      }
    }
  }
}