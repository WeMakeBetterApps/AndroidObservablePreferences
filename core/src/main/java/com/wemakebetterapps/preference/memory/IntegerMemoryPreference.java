package com.wemakebetterapps.preference.memory;

import com.wemakebetterapps.preference.IntegerPreference;

public class IntegerMemoryPreference extends AbstractMemoryPreference<Integer> implements IntegerPreference {
  public IntegerMemoryPreference(Integer defaultValue) {
    super(defaultValue);
  }
}
