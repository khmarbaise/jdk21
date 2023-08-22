package com.soebes.jdk21.record.pattern;

import org.junit.jupiter.api.Test;

class RecordPatternTest {
  record Point(int x, int y) {
  }


  static void printSumJDK17(Object obj) {
    if (obj instanceof Point(int x, int y)) {
      System.out.println(x+y);
    }
  }
  static void printSumJDK16(Object obj) {
    if (obj instanceof Point p) {
      int x = p.x();
      int y = p.y();
      System.out.println(x + y);
    }
  }

  @Test
  void jdk17() {
    System.out.println("RecordPatternTest.jdk17");
    var point = new Point(1, 4);
    printSumJDK16(point);
  }

  @Test
  void jdk21() {
    System.out.println("RecordPatternTest.jdk21");
    var point = new Point(1, 4);
    printSumJDK17(point);
  }
}
