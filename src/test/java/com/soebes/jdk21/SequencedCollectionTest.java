package com.soebes.jdk21;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.stream.Collectors;

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
    SequencedCollection<Integer> integers = tmpList.stream().collect(Collectors.toList());

//    integers.add(199);
//    integers.addLast(200);
    integers.addFirst(-5);
    integers.forEach(s -> System.out.println("s = " + s));

    System.out.println("-------------------------");
    var reversed = integers.reversed();
    reversed.forEach(r -> System.out.println("r = " + r));
  }
}