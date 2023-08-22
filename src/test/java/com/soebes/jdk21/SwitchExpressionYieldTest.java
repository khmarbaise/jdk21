package com.soebes.jdk21;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class SwitchExpressionYieldTest {

  @ParameterizedTest
  @EnumSource(MONTHS.class)
  void name(MONTHS currentMonth) {
    System.out.println("currentMonth = " + currentMonth);
    int year = 2023;
    int ndays = switch(currentMonth) {
      case JAN, MAR, MAY, JUL, AUG, OCT, DEC -> 31;
      case APR, JUN, SEP, NOV -> 30;
      case FEB -> {
        if (year % 400 == 0) yield 29;
        else if (year % 100 == 0) yield 28;
        else if (year % 4 == 0) yield 29;
        else yield 28; }
    };
    System.out.println("ndays = " + ndays);
  }
}
