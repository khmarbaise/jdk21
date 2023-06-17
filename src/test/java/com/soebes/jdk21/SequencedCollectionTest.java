package com.soebes.jdk21;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * JEP 431: Sequenced Collections
 * @see <a href="https://openjdk.org/jeps/431">JEP 431</a>
 */
class SequencedCollectionTest {

  @Test
  void sequencedMap() {
    var of = Map.of("1", 1);
    var objectObjectLinkedHashMap = new LinkedHashMap<>(of);
    var lhm = of.entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> v, LinkedHashMap::new));

    var integers = objectObjectLinkedHashMap.sequencedValues();
    var strings = objectObjectLinkedHashMap.sequencedKeySet();
    var entrySet = objectObjectLinkedHashMap.sequencedEntrySet();

  }

  @Test
  void name() {
    var tmpList = Arrays.asList(1, 2, 4, 5, 10, -1);
    SequencedCollection<Integer> integers = new ArrayList<>(tmpList);

//    integers.add(199);
//    integers.addLast(200);
    integers.addFirst(-5);
    integers.forEach(s -> System.out.println("s = " + s));

    System.out.println("-------------------------");
    var reversed = integers.reversed();
    reversed.forEach(r -> System.out.println("r = " + r));
  }

  @Test
  void large_lists() {
    var collect = IntStream.range(0, 10_000_000).boxed().parallel().collect(Collectors.toList());
    System.out.println("collect = " + collect.size());
    assertThat(true).isTrue();
  }
}