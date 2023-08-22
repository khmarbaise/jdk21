package com.soebes.jdk21;

import org.junit.jupiter.api.Test;

import static com.soebes.jdk21.MONTHS.MAY;

class SwitchExpressionYieldTest {

  @Test
  void name() {
    int year = 2023;
    MONTHS month = MAY;
    int ndays = switch(month) {
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
