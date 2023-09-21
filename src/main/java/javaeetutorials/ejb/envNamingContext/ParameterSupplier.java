package javaeetutorials.ejb.envNamingContext;


import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;

@Stateless
public class ParameterSupplier {

  @Resource(name = "currency")
  private String currency;

  @Resource(name = "rate")
  private Float rate;

  public String getCurrency() {
    return currency;
  }

  public Float getRate() {
    return rate;
  }
}