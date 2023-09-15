package javaeetutorials.validation.groups;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

public class InnItem {


  @Type(groups = NewType.class)
  public String type;
  @NotNull
  public String value;
  @Type(groups = OldType.class)
  public String legacyType;

  @NotNull
  @Size(min = 2)
  public String createInnByCountry(@NotNull @Size(max = 2) String country) {
    if (Objects.equals(country, "UA")) {
      return "333";
    } else {
      return "111";
    }
  }
}