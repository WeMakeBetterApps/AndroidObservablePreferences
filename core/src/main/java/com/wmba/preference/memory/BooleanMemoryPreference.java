package com.wmba.preference.memory;

import com.wmba.preference.BooleanPreference;

public class BooleanMemoryPreference extends AbstractMemoryPreference<Boolean> implements BooleanPreference {
  public BooleanMemoryPreference(Boolean defaultValue) {
    super(defaultValue);
  }
}
