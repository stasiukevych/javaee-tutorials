package javaeetutorials.ejb.singelton;

import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.util.HashMap;

@Singleton
@Startup
public class Cache {

  private final HashMap<String, Object> prop = new HashMap<>();

  public void putValue(String key, Object value) {
    prop.put(key, value);
  }

  public Object getValueByKey(String key) {
    return prop.get(key);
  }

  public boolean contains(String key) {
    return prop.containsKey(key);
  }

  public HashMap<String, Object> getProp() {
    return prop;
  }
}