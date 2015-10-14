package com.wemakebetterapps.preference.android.persist;

import android.content.SharedPreferences;

import com.wemakebetterapps.preference.LongPreference;

public class LongPersistentPreference extends AbstractPersistentPreference<Long>
    implements LongPreference {

  public LongPersistentPreference(SharedPreferences preferences, String key) {
    super(preferences, key, null);
  }

  public LongPersistentPreference(SharedPreferences preferences, String key, Long defaultValue) {
    super(preferences, key, defaultValue);
  }

  @Override protected Long getFromPreferences(SharedPreferences preferences, String key) {
    if (preferences.contains(key)) {
      return preferences.getLong(key, 0L);
    } else {
      return null;
    }
  }

  @Override
  protected void saveInPreferences(SharedPreferences preferences, String key, Long value) {
    preferences.edit().putFloat(key, value).apply();
  }
}
