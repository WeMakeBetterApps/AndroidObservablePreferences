package com.wmba.preference.memory;

import com.wmba.preference.LongPreference;

public class LongMemoryPreference extends AbstractMemoryPreference<Long> implements LongPreference {
  public LongMemoryPreference(Long defaultValue) {
    super(defaultValue);
  }
}
