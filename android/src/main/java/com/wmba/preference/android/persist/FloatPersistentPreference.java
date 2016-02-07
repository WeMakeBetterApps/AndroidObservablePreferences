package com.wmba.preference.android.persist;

import android.content.SharedPreferences;

import com.wmba.preference.FloatPreference;

public class FloatPersistentPreference extends AbstractPersistentPreference<Float>
    implements FloatPreference {

  public FloatPersistentPreference(SharedPreferences preferences, String key) {
    super(preferences, key, null);
  }

  public FloatPersistentPreference(SharedPreferences preferences, String key, Float defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override protected Float getFromPreferences(SharedPreferences preferences, String key) {
    if (preferences.contains(key)) {
      return preferences.getFloat(key, 0f);
    } else {
      return null;
    }
  }

  @Override
  protected void saveInPreferences(SharedPreferences preferences, String key, Float value) {
    preferences.edit().putFloat(key, value).apply();
  }
}
