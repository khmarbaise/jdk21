package com.soebes.jdk21.classfile.api;

import jdk.internal.classfile.ClassModel;
import jdk.internal.classfile.Classfile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

class FirstClassFileAPITest {

  @Test
  void analyseAFinalClass() throws IOException {
    ClassModel cm = Classfile.parse(Path.of("target/classes/com/soebes/jdk21/AFinalClass.class"), Classfile.Option.processLineNumbers(true));

    System.out.println("cm.isModuleInfo() = " + cm.isModuleInfo());
    System.out.printf("cm.majorVersion(): %d(%d) %n", cm.majorVersion(), cm.minorVersion());
    cm.fields().forEach(s -> {
      var classDesc = s.fieldTypeSymbol();
      System.out.println("classDesc = " + classDesc);
      System.out.printf("fieldName: %s (Class:%s)%n", s.fieldName(), s.getClass().getName());
      s.attributes().forEach(at -> System.out.printf("attributeName: %s (Class:%s)%n", at.attributeName(), at.getClass().getName()));
      s.elementList().forEach(fe -> {
        System.out.println("fe = " + fe.getClass().getName());
      });
    });
    cm.methods().forEach(s -> {
      System.out.printf("methodName: %s%n", s.methodName());
      s.attributes().forEach(at -> System.out.println("at = " + at.attributeName()));
    });
    cm.interfaces().forEach(s -> System.out.printf("interfaces: %s%n", s.name()));
    cm.superclass().ifPresent(s -> System.out.printf("superclass: %s%n", s.name()));
  }
}
