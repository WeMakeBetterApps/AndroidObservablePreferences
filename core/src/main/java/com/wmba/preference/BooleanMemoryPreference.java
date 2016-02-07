package com.wmba.preference;

public class BooleanMemoryPreference extends AbstractMemoryPreference<Boolean> implements BooleanPreference {
  public BooleanMemoryPreference(Boolean defaultValue) {
    super(defaultValue);
  }
}
