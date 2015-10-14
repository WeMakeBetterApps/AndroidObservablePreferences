package com.wemakebetterapps.preference.test;

import com.wemakebetterapps.preference.Preference;
import com.wemakebetterapps.preference.android.persist.BooleanPersistentPreference;

public class BooleanPersistentPreferenceTest extends AbstractPersistentPreferenceTest<Boolean> {
  @Override protected Boolean firstUniqueValue() {
    return true;
  }

  @Override protected Boolean secondUniqueValue() {
    return false;
  }

  @Override protected Preference<Boolean> createPreference(String key, Boolean defaultValue) {
    return new BooleanPersistentPreference(new MockSharedPreferences(), key, defaultValue);
  }
}
