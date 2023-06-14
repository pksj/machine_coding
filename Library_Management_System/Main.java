package Library_Management_System;

public class Main {
  public static void main(String[] args) {
    Library library = new Library(1);
    for(int i = 1; i <= 5; i++){
      library.addUser(new User("user"+i,i,5));
    }
    for (int i = 1; i <= 5; i++) {
      Rack rack = new Rack(i, 5);
      for (int j = 1; j <= 5; j++) {
        rack.addBookToRack(new Book(j, "title" + 1, "authors" + i, "publishers" + i));
      }
      library.addRack(rack);
    }
    
    
  }
}
