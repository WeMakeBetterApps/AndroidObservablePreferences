package com.wmba.preference.test;

import com.wmba.preference.Preference;
import com.wmba.preference.android.persist.IntegerPersistentPreference;

public class IntegerPersistentPreferenceTest extends AbstractPersistentPreferenceTest<Integer> {
  @Override protected Integer firstUniqueValue() {
    return 1;
  }

  @Override protected Integer secondUniqueValue() {
    return 2;
  }

  @Override protected Preference<Integer> createPreference(String key, Integer defaultValue) {
    return new IntegerPersistentPreference(new MockSharedPreferences(), key, defaultValue);
  }
}
