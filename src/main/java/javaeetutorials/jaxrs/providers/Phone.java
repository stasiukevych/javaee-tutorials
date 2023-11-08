package javaeetutorials.jaxrs.providers;

import java.io.Serializable;

public class Phone implements Serializable {

  private String type;

  private String owner;

  private String serial;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  @Override
  public String toString() {
    return "Phone{" +
        "type='" + type + '\'' +
        ", owner='" + owner + '\'' +
        ", serial='" + serial + '\'' +
        '}';
  }
}