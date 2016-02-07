package com.wmba.preference.test;

import com.wmba.preference.Preference;
import com.wmba.preference.memory.LongMemoryPreference;

public class LongMemoryPreferenceTest extends AbstractPreferenceTest<Long> {
  @Override protected Long firstUniqueValue() {
    return 1L;
  }

  @Override protected Long secondUniqueValue() {
    return 2L;
  }

  @Override protected Preference<Long> createPreference(Long defaultValue) {
    return new LongMemoryPreference(defaultValue);
  }
}
