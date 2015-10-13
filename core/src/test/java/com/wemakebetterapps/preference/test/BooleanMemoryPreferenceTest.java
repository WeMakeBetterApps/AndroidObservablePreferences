package com.wemakebetterapps.preference.test;

import com.wemakebetterapps.preference.Preference;
import com.wemakebetterapps.preference.memory.BooleanMemoryPreference;

public class BooleanMemoryPreferenceTest extends AbstractPreferenceTest<Boolean> {
  @Override protected Boolean firstUniqueValue() {
    return true;
  }

  @Override protected Boolean secondUniqueValue() {
    return false;
  }

  @Override protected Preference<Boolean> createPreference(Boolean defaultValue) {
    return new BooleanMemoryPreference(defaultValue);
  }
}
