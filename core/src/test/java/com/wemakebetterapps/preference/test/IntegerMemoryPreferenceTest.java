package com.wemakebetterapps.preference.test;

import com.wemakebetterapps.preference.Preference;
import com.wemakebetterapps.preference.memory.IntegerMemoryPreference;

public class IntegerMemoryPreferenceTest extends AbstractPreferenceTest<Integer> {
  @Override protected Integer firstUniqueValue() {
    return 1;
  }

  @Override protected Integer secondUniqueValue() {
    return 2;
  }

  @Override protected Preference<Integer> createPreference(Integer defaultValue) {
    return new IntegerMemoryPreference(defaultValue);
  }
}
