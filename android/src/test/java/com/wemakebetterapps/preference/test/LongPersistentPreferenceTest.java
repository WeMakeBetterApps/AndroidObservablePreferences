package com.wemakebetterapps.preference.test;

import com.wemakebetterapps.preference.Preference;
import com.wemakebetterapps.preference.android.persist.LongPersistentPreference;

public class LongPersistentPreferenceTest extends AbstractPersistentPreferenceTest<Long> {
  @Override protected Long firstUniqueValue() {
    return 1L;
  }

  @Override protected Long secondUniqueValue() {
    return 2L;
  }

  @Override protected Preference<Long> createPreference(String key, Long defaultValue) {
    return new LongPersistentPreference(new MockSharedPreferences(), key, defaultValue);
  }
}
