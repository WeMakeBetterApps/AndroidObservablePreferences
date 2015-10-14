package com.wemakebetterapps.preference.test;

import com.wemakebetterapps.preference.Preference;
import com.wemakebetterapps.preference.android.persist.FloatPersistentPreference;

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
