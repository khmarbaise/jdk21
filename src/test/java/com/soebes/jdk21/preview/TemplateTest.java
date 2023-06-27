package com.soebes.jdk21.preview;

import org.junit.jupiter.api.Test;

import static java.lang.StringTemplate.STR;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * JEP 430: String Templates (Preview)
 *
 * @see <a href="https://openjdk.org/jeps/430">JEP 430</a>
 */
class TemplateTest {
  @Test
  void name() {
    String name = "Jon";
    String info = STR."My name is \{name}";
    assertThat(info).isEqualTo("My name is Jon");
  }

}
