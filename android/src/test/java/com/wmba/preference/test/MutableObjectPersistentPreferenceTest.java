package com.wmba.preference.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wmba.preference.ObjectPersistentPreference;
import com.wmba.preference.Preference;
import com.wmba.preference.PreferenceSerializer;

import java.lang.reflect.Type;

public class MutableObjectPersistentPreferenceTest extends MutableObjectMemoryPreferenceTest {
  @Override protected Preference<TestObject> createPreference(TestObject defaultValue) {
    final Gson gson = new Gson();
    PreferenceSerializer preferenceSerializer = new PreferenceSerializer() {
      @Override public String serialize(Object value) {
        return gson.toJson(value);
      }

      @Override public Object deserialize(String serializedValue, Type type) {
        return gson.fromJson(serializedValue, type);
      }
    };
    return new ObjectPersistentPreference<TestObject>(new MockSharedPreferences(), "test_key",
        preferenceSerializer, new TypeToken<TestObject>() {}.getType(), defaultValue) {
      @Override protected TestObject copy(TestObject value) {
        return new TestObject(value.getStringValue(), value.getIntValue());
      }
    };
  }
}
