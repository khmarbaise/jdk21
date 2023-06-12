package com.soebes.jdk21;

import java.util.Objects;

public final class AFinalClass {
  private final String name;

  public AFinalClass(String name) {
    this.name = name;
  }

  public String name() {
    return name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (AFinalClass) obj;
    return Objects.equals(this.name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "AFirstRecord[" +
           "name=" + name + ']';
  }

}
