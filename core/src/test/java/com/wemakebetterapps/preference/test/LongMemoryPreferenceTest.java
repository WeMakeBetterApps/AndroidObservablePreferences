package com.wemakebetterapps.preference.test;

import com.wemakebetterapps.preference.Preference;
import com.wemakebetterapps.preference.memory.LongMemoryPreference;

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
