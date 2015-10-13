package com.wemakebetterapps.preference.memory;

import com.wemakebetterapps.preference.BooleanPreference;

public class BooleanMemoryPreference extends AbstractMemoryPreference<Boolean> implements BooleanPreference {
  public BooleanMemoryPreference(Boolean defaultValue) {
    super(defaultValue);
  }
}
