package com.wmba.preference.test;

import com.wmba.preference.ObjectMemoryPreference;
import com.wmba.preference.Preference;

public class ImmutableObjectMemoryPreferenceTest extends AbstractPreferenceTest<ImmutableObjectMemoryPreferenceTest.TestObject> {
  @Override protected TestObject firstUniqueValue() {
    return new TestObject("value1", 1);
  }

  @Override protected TestObject secondUniqueValue() {
    return new TestObject("value2", 2);
  }

  @Override protected Preference<TestObject> createPreference(TestObject defaultValue) {
    return new ObjectMemoryPreference<TestObject>(defaultValue);
  }

  public static class TestObject {
    private final String stringValue;
    private final int intValue;

    public TestObject(String stringValue, int intValue) {
      this.stringValue = stringValue;
      this.intValue = intValue;
    }

    public String getStringValue() {
      return stringValue;
    }

    public int getIntValue() {
      return intValue;
    }
  }
}
