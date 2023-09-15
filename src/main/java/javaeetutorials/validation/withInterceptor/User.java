package javaeetutorials.validation.withInterceptor;

import jakarta.interceptor.Interceptors;
import jakarta.validation.constraints.NotBlank;

public class User {

  public String name;
  public String userName;

  @Interceptors(MethodInterceptor.class)
  @NotBlank
  public String getName() {
    return name;
  }
}