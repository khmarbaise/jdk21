package com.soebes.jdk21.record.pattern;

import org.junit.jupiter.api.Test;

class RecordPattern16Test {

  record Point(int x, int y) {}
  enum Color { RED, GREEN, BLUE }
  record ColoredPoint(Point p, Color c) {}
  record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}

  // As of Java 21
  void printUpperLeftColoredPointJDK21(Rectangle r) {
    if (r instanceof Rectangle(ColoredPoint ul, ColoredPoint _)) {
      System.out.println("ul.c():" + ul.c());
    }
  }

  @Test
  void jdk21() {
    System.out.println("RecordPattern16Test.jdk21");
    var cp1_1 = new Point(1, 5);
    var cp1 = new ColoredPoint(cp1_1, Color.BLUE);
    var cp2 = new ColoredPoint(cp1_1, Color.GREEN);
    var ul = new Rectangle(cp1, cp2);
    printUpperLeftColoredPointJDK21(ul);
  }
}
