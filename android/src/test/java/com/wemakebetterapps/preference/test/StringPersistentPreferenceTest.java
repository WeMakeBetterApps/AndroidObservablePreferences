package com.wemakebetterapps.preference.test;

import com.wemakebetterapps.preference.Preference;
import com.wemakebetterapps.preference.android.persist.StringPersistentPreference;

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
