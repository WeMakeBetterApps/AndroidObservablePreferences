package com.wemakebetterapps.preference.test;

import com.wemakebetterapps.preference.Preference;
import com.wemakebetterapps.preference.android.persist.IntegerPersistentPreference;

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
