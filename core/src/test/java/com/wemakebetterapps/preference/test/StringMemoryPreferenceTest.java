package com.wemakebetterapps.preference.test;

import com.wemakebetterapps.preference.Preference;
import com.wemakebetterapps.preference.memory.StringMemoryPreference;

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
