package com.soebes.jdk21;

import static com.soebes.jdk21.SwitchExpressionTest.Coin.HEADS;
import static com.soebes.jdk21.SwitchExpressionTest.Coin.TAILS;

/**
 * JEP 441: Pattern Matching for switch.
 *
 * @see <a href="https://openjdk.org/jeps/441">JEP 441</a>
 */
class SwitchExpressionTest {

  sealed interface Currency permits Coin {
  }

  enum Coin implements Currency {HEADS, TAILS}

  static void goodEnumSwitch1(Currency c) {
    switch (c) {
      case HEADS -> System.out.println("Heads");
      case TAILS -> System.out.println("Tails");
    }
  }

  static void goodEnumSwitch2(Coin c) {
    switch (c) {
      case HEADS -> System.out.println("Heads");
      case TAILS -> {    // Unnecessary qualification but allowed
        System.out.println("Tails");
      }
    }
  }

  static void badEnumSwitch(Currency c) {
    switch (c) {
      case HEADS -> System.out.println("Heads");
      case TAILS -> System.out.println("Tails");
      default -> System.out.println("Some currency");
    }
  }

  static void patternSwitchTest(Object obj) {
    String formatted = switch (obj) {
      case Integer i -> String.format("int %d", i);
      case Long _ -> "Unknown";
      case Double d -> String.format("double %f", d);
      case String s -> String.format("String %s", s);
      default -> obj.toString();
    };
    System.out.println("formatted = " + formatted);
  }

  static void patternWithWhen(Object obj) {
    String formatted = switch (obj) {
      case Integer i -> String.format("int %d", i);
      case Long l -> String.format("long %d", l);
      case Double d -> String.format("double %f", d);
      case String s when s.length() > 5 -> String.format("String %s", s);
      case String s -> String.format("String %s", s);
      default -> obj.toString();
    };
    System.out.println("formatted = " + formatted);

  }

}
