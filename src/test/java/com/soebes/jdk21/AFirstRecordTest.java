package com.soebes.jdk21;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class AFirstRecordTest {

  @Test
  void name() {
    var aFirstRecordMockedStatic = Mockito.mock(AFirstRecord.class);
    when(aFirstRecordMockedStatic.name()).thenReturn("test");
    Assertions.assertThat(aFirstRecordMockedStatic.name()).isEqualTo("test");
  }
}