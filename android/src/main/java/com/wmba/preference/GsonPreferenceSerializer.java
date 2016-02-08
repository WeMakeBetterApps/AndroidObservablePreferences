package com.wmba.preference;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class GsonPreferenceSerializer implements PreferenceSerializer {
  private final Gson mGson;

  public GsonPreferenceSerializer(Gson gson) {
    mGson = gson;
  }

  @Override public String serialize(Object value) {
    return mGson.toJson(value);
  }

  @Override public Object deserialize(String serializedValue, Type type) {
    return mGson.fromJson(serializedValue, type);
  }
}
