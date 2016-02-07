package com.wmba.preference.test;

import com.wmba.preference.Preference;
import com.wmba.preference.memory.StringMemoryPreference;

public class StringMemoryPreferenceTest extends AbstractPreferenceTest<String> {
  @Override protected String firstUniqueValue() {
    return "unique1";
  }

  @Override protected String secondUniqueValue() {
    return "unique2";
  }

  @Override protected Preference<String> createPreference(String defaultValue) {
    return new StringMemoryPreference(defaultValue);
  }
}
