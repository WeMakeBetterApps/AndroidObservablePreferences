package com.wemakebetterapps.preference.memory;

import com.wemakebetterapps.preference.LongPreference;

public class LongMemoryPreference extends AbstractMemoryPreference<Long> implements LongPreference {
  public LongMemoryPreference(Long defaultValue) {
    super(defaultValue);
  }
}
