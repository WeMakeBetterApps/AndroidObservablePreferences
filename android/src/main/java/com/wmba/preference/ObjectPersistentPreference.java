package com.wmba.preference;

import android.content.SharedPreferences;

import java.lang.reflect.Type;

public class ObjectPersistentPreference<T> extends AbstractPersistentPreference<T> implements ObjectPreference<T> {
  private final PreferenceSerializer mSerializer;
  private final Type mType;

  public ObjectPersistentPreference(SharedPreferences preferences, String key,
      PreferenceSerializer serializer, Type type, T defaultValue) {
    super(preferences, key, defaultValue);
    mSerializer = serializer;
    mType = type;
  }

  @Override protected T getFromPreferences(SharedPreferences preferences, String key) {
    String serializedValue = preferences.getString(key, null);
    if (serializedValue == null) {
      return null;
    } else {
      //noinspection unchecked
      return (T) mSerializer.deserialize(serializedValue, mType);
    }
  }

  @Override protected void saveInPreferences(SharedPreferences preferences, String key, T value) {
    if (value == null) {
      preferences.edit().remove(key).apply();
    } else {
      String serializedValue = mSerializer.serialize(value);
      preferences.edit().putString(key, serializedValue).apply();
    }
  }

  @Override public synchronized void set(T value) {
    super.set((value == null) ? null : copy(value));
  }

  @Override public synchronized T get() {
    T value = super.get();
    return (value == null) ? null : copy(value);
  }

  /**
   * Default implementation does nothing.
   *
   * An optional method to override when not using immutable Objects. This method should perform a
   * deep copy of the item, including a copy of each item in a collection.
   */
  protected T copy(T value) {
    return value;
  }
}
