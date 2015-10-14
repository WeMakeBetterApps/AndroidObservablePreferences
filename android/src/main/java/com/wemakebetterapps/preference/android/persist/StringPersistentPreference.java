package com.wemakebetterapps.preference.android.persist;

import android.content.SharedPreferences;

import com.wemakebetterapps.preference.StringPreference;

public class StringPersistentPreference extends AbstractPersistentPreference<String>
    implements StringPreference {

  public StringPersistentPreference(SharedPreferences preferences, String key) {
    this(preferences, key, null);
  }

  public StringPersistentPreference(SharedPreferences preferences, String key, String defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override protected String getFromPreferences(SharedPreferences preferences, String key) {
    return preferences.getString(key, null);
  }

  @Override protected void saveInPreferences(SharedPreferences preferences, String key, String value) {
    preferences.edit().putString(key, value).apply();
  }
}
