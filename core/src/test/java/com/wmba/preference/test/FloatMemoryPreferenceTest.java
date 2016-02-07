package com.wmba.preference.test;

import com.wmba.preference.Preference;
import com.wmba.preference.FloatMemoryPreference;

public class FloatMemoryPreferenceTest extends AbstractPreferenceTest<Float> {
  @Override protected Float firstUniqueValue() {
    return 1.0f;
  }

  @Override protected Float secondUniqueValue() {
    return 1.1f;
  }

  @Override protected Preference<Float> createPreference(Float defaultValue) {
    return new FloatMemoryPreference(defaultValue);
  }
}
