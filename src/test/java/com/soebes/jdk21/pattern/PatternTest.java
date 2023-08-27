package com.soebes.jdk21.pattern;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class PatternTest {

  @Test
  void patterns() {
    System.out.println("PatternTest.patterns");
    String line = "1;New York; 8 336 817";
    var pattern = Pattern.compile("""
        (?<index>\\d+);\
        (?<city>[ a-zA-Z]+);\
        (?<population>[ \\d]+)$""");

    var matcher = pattern.matcher(line);
    if (matcher.matches()) {
      var index = matcher.group("index");
      var city = matcher.group("city");
      var population = matcher.group("population");
      System.out.println("index = " + index);
      System.out.println("city = " + city);
      System.out.println("population = " + population);
    }
  }
}
