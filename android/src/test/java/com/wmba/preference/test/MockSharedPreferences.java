package com.wmba.preference.test;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MockSharedPreferences implements SharedPreferences {
  private final Map<String, Object> mPreferencesMap = new HashMap<String, Object>();

  @Override public Map<String, ?> getAll() {
    return new HashMap<String, Object>(mPreferencesMap);
  }

  @Override public String getString(String key, String defValue) {
    return getValue(key, defValue);
  }

  @Override public Set<String> getStringSet(String key, Set<String> defValues) {
    //noinspection unchecked
    return getValue(key, defValues);
  }

  @Override public int getInt(String key, int defValue) {
    return getValue(key, defValue);
  }

  @Override public long getLong(String key, long defValue) {
    return getValue(key, defValue);
  }

  @Override public float getFloat(String key, float defValue) {
    return getValue(key, defValue);
  }

  @Override public boolean getBoolean(String key, boolean defValue) {
    return getValue(key, defValue);
  }

  @Override public boolean contains(String key) {
    synchronized (mPreferencesMap) {
      return mPreferencesMap.containsKey(key);
    }
  }

  @Override public Editor edit() {
    return new MockEditor(mPreferencesMap);
  }

  @Override
  public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
    throw new UnsupportedOperationException();
  }

  private <T> T getValue(String key, T defaultValue) {
    synchronized (mPreferencesMap) {
      //noinspection unchecked
      return (mPreferencesMap.containsKey(key)) ? (T) mPreferencesMap.get(key) : defaultValue;
    }
  }


  private static class MockEditor implements SharedPreferences.Editor {
    private final Map<String, Object> mPreferenceMap;
    private final List<EditPreferenceAction> mPreferenceEdits = new ArrayList<EditPreferenceAction>();

    public MockEditor(Map<String, Object> preferenceMap) {
      mPreferenceMap = preferenceMap;
    }

    @Override public SharedPreferences.Editor putString(String key, String value) {
      synchronized (mPreferenceEdits) {
        mPreferenceEdits.add(new PutPreferenceAction(key, value));
        return this;
      }
    }

    @Override public SharedPreferences.Editor putStringSet(String key, Set<String> values) {
      synchronized (mPreferenceEdits) {
        mPreferenceEdits.add(new PutPreferenceAction(key, values));
        return this;
      }
    }

    @Override public SharedPreferences.Editor putInt(String key, int value) {
      synchronized (mPreferenceEdits) {
        mPreferenceEdits.add(new PutPreferenceAction(key, value));
        return this;
      }
    }

    @Override public SharedPreferences.Editor putLong(String key, long value) {
      synchronized (mPreferenceEdits) {
        mPreferenceEdits.add(new PutPreferenceAction(key, value));
        return this;
      }
    }

    @Override public SharedPreferences.Editor putFloat(String key, float value) {
      synchronized (mPreferenceEdits) {
        mPreferenceEdits.add(new PutPreferenceAction(key, value));
        return this;
      }
    }

    @Override public SharedPreferences.Editor putBoolean(String key, boolean value) {
      synchronized (mPreferenceEdits) {
        mPreferenceEdits.add(new PutPreferenceAction(key, value));
        return this;
      }
    }

    @Override public SharedPreferences.Editor remove(String key) {
      synchronized (mPreferenceEdits) {
        mPreferenceEdits.add(new RemovePreferenceAction(key));
        return this;
      }
    }

    @Override public SharedPreferences.Editor clear() {
      synchronized (mPreferenceEdits) {
        mPreferenceEdits.add(new ClearPreferencesAction());
        return this;
      }
    }

    @Override public boolean commit() {
      apply();
      return true;
    }

    @Override public void apply() {
      synchronized (mPreferenceEdits) {
        synchronized (mPreferenceMap) {
          for (EditPreferenceAction action : mPreferenceEdits) {
            action.execute(mPreferenceMap);
          }
        }
        mPreferenceEdits.clear();
      }
    }

    private interface EditPreferenceAction {
      void execute(Map<String, Object> preferenceMap);
    }

    private static class PutPreferenceAction implements EditPreferenceAction {
      private final String mKey;
      private final Object mValue;

      public PutPreferenceAction(String key, Object value) {
        mKey = key;
        mValue = value;
      }

      @Override public void execute(Map<String, Object> preferenceMap) {
        if (mValue == null) {
          preferenceMap.remove(mKey);
        } else {
          preferenceMap.put(mKey, mValue);
        }
      }
    }

    private static class RemovePreferenceAction implements EditPreferenceAction {
      private final String mKey;

      public RemovePreferenceAction(String key) {
        mKey = key;
      }

      @Override public void execute(Map<String, Object> preferenceMap) {
        preferenceMap.remove(mKey);
      }
    }

    private static class ClearPreferencesAction implements EditPreferenceAction {
      @Override public void execute(Map<String, Object> preferenceMap) {
        preferenceMap.clear();
      }
    }
  }
}
