package com.wmba.preference.android.persist;

import android.content.SharedPreferences;

import com.wmba.preference.IntegerPreference;

public class IntegerPersistentPreference extends AbstractPersistentPreference<Integer>
    implements IntegerPreference {

  public IntegerPersistentPreference(SharedPreferences preferences, String key) {
    super(preferences, key, null);
  }

  public IntegerPersistentPreference(SharedPreferences preferences, String key, Integer defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override protected Integer getFromPreferences(SharedPreferences preferences, String key) {
    if (preferences.contains(key)) {
      return preferences.getInt(key, 0);
    } else {
      return null;
    }
  }

  @Override
  protected void saveInPreferences(SharedPreferences preferences, String key, Integer value) {
    preferences.edit().putFloat(key, value).apply();
  }
}
