package com.wmba.preference.memory;

import com.wmba.preference.StringPreference;

public class StringMemoryPreference extends AbstractMemoryPreference<String> implements StringPreference {
  public StringMemoryPreference(String defaultValue) {
    super(defaultValue);
  }
}
