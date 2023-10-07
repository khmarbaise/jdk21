package com.soebes.jdk21.incubator;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;
import org.junit.jupiter.api.Test;

/**
 * JEP 448: Vector API (Sixth Incubator)
 *
 * @see <a href="https://openjdk.org/jeps/448">JEP 448</a>
 */
class VectorTest {

  static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_256;

  void vectorComputation(float[] a, float[] b, float[] c) {

    for (int i = 0; i < a.length; i += SPECIES.length()) {
      var m = SPECIES.indexInRange(i, a.length);
      // FloatVector va, vb, vc;
      var va = FloatVector.fromArray(SPECIES, a, i, m);
      var vb = FloatVector.fromArray(SPECIES, b, i, m);
      var vc = va.mul(va).
          add(vb.mul(vb)).
          neg();
      vc.intoArray(c, i, m);
    }
  }

  @Test
  void name() {
    float[] a = {1.0f, 2.0f, 3.0f, 4.0f};
    float[] b = {1.0f, 2.0f, 3.0f, 4.0f};
    float[] c = {1.0f, 2.0f, 3.0f, 4.0f};

    vectorComputation(a, b, c);
  }

  @Test
  void calculateInteger() {
    int[] v1 = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] v2 = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] result = {0, 0, 0, 0, 0, 0, 0, 0};
    var species = IntVector.SPECIES_256;

    System.out.println("species.elementSize() = " + species.elementSize() * 8);
    var V1 = IntVector.fromArray(species, v1, 0);
    var V2 = IntVector.fromArray(species, v2, 0);

    var RESULT = V1.add(V2);

    RESULT.intoArray(result, 0);
    for (int i = 0; i < result.length; i++) {
      System.out.printf("[%d]=%-5d", i, result[i]);
    }
    System.out.println();
  }
}
