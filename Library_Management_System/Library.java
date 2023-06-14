package Library_Management_System;

import java.util.List;

public class Library {
  int id;
  int numberOfRacks;
  List<Rack> racks;
  List<User> users;

  public Library(int id, int numberOfRacks) {
    this.id = id;
    this.numberOfRacks = numberOfRacks;
  }

  public void addRack(Rack rack) {
    racks.add(rack);
  }
  
  public void addUser(User user){
    users.add(user);
  }  
}
