package com.wmba.preference.test;

import com.wmba.preference.ObjectMemoryPreference;
import com.wmba.preference.Preference;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MutableObjectMemoryPreferenceTest extends AbstractPreferenceTest<MutableObjectMemoryPreferenceTest.TestObject> {
  @Override protected TestObject firstUniqueValue() {
    return new TestObject("value1", 1);
  }

  @Override protected TestObject secondUniqueValue() {
    return new TestObject("value2", 2);
  }

  @Override protected Preference<TestObject> createPreference(TestObject defaultValue) {
    return new ObjectMemoryPreference<TestObject>(defaultValue) {
      @Override protected TestObject copy(TestObject value) {
        return new TestObject(value.getStringValue(), value.getIntValue());
      }
    };
  }

  @Test public void copyTest() {
    Preference<TestObject> preference = createPreference(mValue1);
    TestObject testObject1 = preference.get();
    assertEquals(mValue1, testObject1);
    assertFalse(mValue1 == testObject1);

    testObject1.setStringValue("newStringValue");
    testObject1.setIntValue(testObject1.getIntValue() + 1);
    assertNotEquals(mValue1, testObject1);

    preference.set(testObject1);
    TestObject testObject2 = preference.get();
    assertEquals(testObject1, testObject2);
    assertFalse(mValue1 == testObject2);

    testObject2.setStringValue("newStringValue2");
    testObject2.setIntValue(testObject2.getIntValue() + 1);
    assertNotEquals(testObject1, testObject2);
  }

  public static class TestObject {
    private String stringValue;
    private int intValue;

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

    public void setStringValue(String stringValue) {
      this.stringValue = stringValue;
    }

    public void setIntValue(int intValue) {
      this.intValue = intValue;
    }

    @Override public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      TestObject that = (TestObject) o;

      if (intValue != that.intValue) return false;
      return stringValue != null ? stringValue.equals(that.stringValue) : that.stringValue == null;

    }

    @Override public int hashCode() {
      int result = stringValue != null ? stringValue.hashCode() : 0;
      result = 31 * result + intValue;
      return result;
    }
  }
}
