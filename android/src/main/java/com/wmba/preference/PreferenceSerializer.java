package com.wmba.preference;

import java.lang.reflect.Type;

public interface PreferenceSerializer {
  String serialize(Object value);
  Object deserialize(String serializedValue, Type type);
}
