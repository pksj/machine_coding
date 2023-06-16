package Project_Management;

import java.util.Map;
import java.util.UUID;
enum PRIVACY {
  PRIVATE,
  PUBLIC,
}
public class Board {
  private String id;
  private String name;
  private PRIVACY privacy;
  private String url;
  private Map<String, User> members;
  private Map<String, List> lists;
 
  public Board(String name) {
    this(name, PRIVACY.PUBLIC);
  }
  public Board(String name, PRIVACY privacy) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.privacy = privacy;
    this.url = "mycompany.com/boards/" + this.id;
    this.members = null;
    this.lists = null;
    System.out.println("Created Board with id: " + this.id);
  }

  public String getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public PRIVACY getPrivacy() {
    return privacy;
  }
  public String getUrl() {
    return url;
  }
  public Map<String, List> getLists() {
    return lists;
  }
  public Map<String, User> getMembers() {
    return members;
  }

  public void addMember(User user) {
    this.members.put(user.getid(), user);
  }

  public void removeMember(User user) {
    this.members.remove(user.getid());
  }

  public void addList(List list) {
    this.lists.put(list.getId(), list);
  }

  public void removeList(List list) {
    this.lists.remove(list.getId());
  }
}
