package com.wmba.preference.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wmba.preference.ObjectPersistentPreference;
import com.wmba.preference.Preference;
import com.wmba.preference.PreferenceSerializer;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;

public class MutableObjectPersistentPreferenceTest extends MutableObjectMemoryPreferenceTest {
  private MockSharedPreferences mPreferences = null;

  @Before public void beforeMutableTest() {
    mPreferences = new MockSharedPreferences();
  }

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

    MockSharedPreferences preferences = (mPreferences == null) ? new MockSharedPreferences() : mPreferences;

    return new ObjectPersistentPreference<TestObject>(preferences, "test_key",
        preferenceSerializer, new TypeToken<TestObject>(){}.getType(), defaultValue) {
      @Override protected TestObject copy(TestObject value) {
        return new TestObject(value.getStringValue(), value.getIntValue());
      }
    };
  }

  @Test public void persistentTest() {
    createPreference(null).set(mValue1);
    assertEquals(mValue1, createPreference(null).get());
  }
}
