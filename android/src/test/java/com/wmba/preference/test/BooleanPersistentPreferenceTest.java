package com.wmba.preference.test;

import com.wmba.preference.Preference;
import com.wmba.preference.android.persist.BooleanPersistentPreference;

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
