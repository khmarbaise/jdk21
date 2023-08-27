package com.soebes.jdk21;

import org.junit.jupiter.api.Test;

import java.util.List;

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
      case Long l -> String.format("long %d", l);
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

  interface Animmal {

  }

  record Dog() implements Animmal {
  }

  record Cat() implements Animmal {
  }

  record Snake() implements Animmal {
  }


  void switchWithAnimal(Animmal animmal) {
    switch (animmal) {
      case Dog d -> System.out.println("d = " + d);
      case Cat c -> System.out.println("c = " + c);
      case Snake s -> System.out.println("s = " + s);
      default -> throw new IllegalStateException("Unexpected value: " + animmal);
    }
  }

  @Test
  void DogCatSnake() {
    var animals = List.of(new Snake(), new Cat(), new Dog());

    animals.forEach(this::switchWithAnimal);
  }
}
