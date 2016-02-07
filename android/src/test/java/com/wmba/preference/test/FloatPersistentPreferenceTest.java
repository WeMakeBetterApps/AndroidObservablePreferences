package com.wmba.preference.test;

import com.wmba.preference.Preference;
import com.wmba.preference.android.persist.FloatPersistentPreference;

public class FloatPersistentPreferenceTest extends AbstractPersistentPreferenceTest<Float> {
  @Override protected Float firstUniqueValue() {
    return 1f;
  }

  @Override protected Float secondUniqueValue() {
    return 2f;
  }

  @Override protected Preference<Float> createPreference(String key, Float defaultValue) {
    return new FloatPersistentPreference(new MockSharedPreferences(), key, defaultValue);
  }
}
