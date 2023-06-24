package com.soebes.jdk21;

import org.junit.jupiter.api.Test;

import static java.lang.StringTemplate.STR;
import static org.assertj.core.api.Assertions.assertThat;

class TemplateTest {
  @Test
  void name() {
    String name = "Jon";
    String info = STR."My name is \{name}";
    assertThat(info).isEqualTo("My name is Jon");
  }

}
