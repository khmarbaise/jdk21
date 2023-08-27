package com.soebes.jdk21.factory;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

class FactoryMethodsTest {

  @Test
  void hashMapWithDefinedSizeOfEntries() {
    var hashMap = HashMap.newHashMap(150);
  }

  @Test
  void hashSetWithDefinedSizeOfEntries() {
    var hashSet = HashSet.newHashSet(150);
  }

  @Test
  void linkedHashMapWithDefinedSizeOfEntries() {
    var linkedHashMap = LinkedHashMap.newLinkedHashMap(150);
  }

  @Test
  void linkedHashSetWithDefinedSizeOfEntries() {
    var linkedHashSet = LinkedHashSet.newLinkedHashSet(150);
  }

  /**
   * {@link DateTimeFormatter#ofLocalizedPattern(String)} has been added with JDK19!
   * {@link DateTimeFormatterBuilder#appendLocalized(String)} has been added with JDK19
   */
  @Test
  void dateTimeFormatter() {
    var formatter = DateTimeFormatter.ofLocalizedPattern("");
    var builder = new DateTimeFormatterBuilder().appendLocalized("");
  }
}
