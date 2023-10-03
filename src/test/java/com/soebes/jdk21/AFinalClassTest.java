package com.soebes.jdk21;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * JEP 451: Prepare to Disallow the Dynamic Loading of Agents.
 *
 * @see <a href="https://openjdk.org/jeps/451">JEP 451</a>
 */
class AFinalClassTest {

  @Test
  void name() {
    var aFirstRecordMockedStatic = Mockito.mock(AFinalClass.class);
    when(aFirstRecordMockedStatic.name()).thenReturn("test");
    assertThat(aFirstRecordMockedStatic.name()).isEqualTo("test");
  }
}