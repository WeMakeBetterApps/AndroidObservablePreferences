package com.wemakebetterapps.preference.android.persist;

import android.content.SharedPreferences;

import com.wemakebetterapps.preference.BooleanPreference;

public class BooleanPersistentPreference extends AbstractPersistentPreference<Boolean>
    implements BooleanPreference {

  public BooleanPersistentPreference(SharedPreferences preferences, String key) {
    super(preferences, key, null);
  }

  public BooleanPersistentPreference(SharedPreferences preferences, String key, Boolean defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override protected Boolean getFromPreferences(SharedPreferences preferences, String key) {
    if (preferences.contains(key)) {
      return preferences.getBoolean(key, false);
    } else {
      return null;
    }
  }

  @Override
  protected void saveInPreferences(SharedPreferences preferences, String key, Boolean value) {
    preferences.edit().putBoolean(key, value).apply();
  }
}
