package com.wmba.preference.test;

import com.wmba.preference.Preference;
import com.wmba.preference.StringPersistentPreference;

public class StringPersistentPreferenceTest extends AbstractPersistentPreferenceTest<String> {
  @Override protected String firstUniqueValue() {
    return "unique1";
  }

  @Override protected String secondUniqueValue() {
    return "unique2";
  }

  @Override protected Preference<String> createPreference(String key, String defaultValue) {
    return new StringPersistentPreference(new MockSharedPreferences(), key, defaultValue);
  }
}
