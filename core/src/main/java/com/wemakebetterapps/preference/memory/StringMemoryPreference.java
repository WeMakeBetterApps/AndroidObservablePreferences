package com.wemakebetterapps.preference.memory;

import com.wemakebetterapps.preference.StringPreference;

public class StringMemoryPreference extends AbstractMemoryPreference<String> implements StringPreference {
  public StringMemoryPreference(String defaultValue) {
    super(defaultValue);
  }
}
