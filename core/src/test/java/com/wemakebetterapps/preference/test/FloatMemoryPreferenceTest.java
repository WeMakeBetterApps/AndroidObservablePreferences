package com.wemakebetterapps.preference.test;

import com.wemakebetterapps.preference.Preference;
import com.wemakebetterapps.preference.memory.FloatMemoryPreference;

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
