package javaeetutorials.ejb.singelton;

import jakarta.ejb.AccessTimeout;
import jakarta.ejb.Singleton;
import java.util.HashMap;

@Singleton
//@Lock(LockType.WRITE)
//@AccessTimeout(value = 5, unit = TimeUnit.SECONDS)
public class Cache {

  private final HashMap<String, Object> prop = new HashMap<>();

  @AccessTimeout(0)
  public void putValue(String key, Object value) throws InterruptedException {
    if (!prop.isEmpty()) { // for testing lock mechanism
      Thread.sleep(20000);
    }
    prop.put(key, value);
  }

  public Object getValueByKey(String key) {
    return prop.get(key);
  }

  public boolean contains(String key) {
    return prop.containsKey(key);
  }

  //  @Lock(LockType.READ)
  public HashMap<String, Object> getProp() {
    return prop;
  }
}