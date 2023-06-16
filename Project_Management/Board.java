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
 
  public Board(String name, String url, Map<String, User> members, Map<String, List> lists) {
    this(name, PRIVACY.PUBLIC, url, members, lists);
  }
  public Board(String name, PRIVACY privacy,String url, Map<String, User> members, Map<String, List> lists) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.privacy = privacy;
    this.url = url;
    this.members = members;
    this.lists = lists;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public PRIVACY getPrivacy() {
    return privacy;
  }
  public void setPrivacy(PRIVACY privacy) {
    this.privacy = privacy;
  }
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  public Map<String, List> getLists() {
    return lists;
  }
  public void setLists(Map<String, List> lists) {
    this.lists = lists;
  }
  public Map<String, User> getMembers() {
    return members;
  }
  public void setMembers(Map<String, User> members) {
    this.members = members;
  }
}
