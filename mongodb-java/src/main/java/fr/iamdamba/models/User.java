package fr.iamdamba.models;

public class User {
  private String objectID;
  private String name;
  private String email;
  private String password;

  public User(String name, String email, String password, String... objectID) {
    this.name = name;
    this.email = email;
    this.password = password;

    if (objectID.length > 0) {
      this.objectID = objectID[0];
    }
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getObjectID() {
    return objectID;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  @Override
  public String toString() {
    return "{ \"name\": \"" + name + "\", \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
  }

}
