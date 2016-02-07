package com.wmba.preference.memory;

import com.wmba.preference.IntegerPreference;

public class IntegerMemoryPreference extends AbstractMemoryPreference<Integer> implements IntegerPreference {
  public IntegerMemoryPreference(Integer defaultValue) {
    super(defaultValue);
  }
}
