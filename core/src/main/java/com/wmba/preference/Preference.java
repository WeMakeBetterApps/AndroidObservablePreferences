package com.wmba.preference;

import rx.Observable;

public interface Preference<T> {
  /**
   * Set the value of the preference. If the provided value equals() the current value then no-op.
   *
   * @param value The value to save
   */
  void set(T value);

  /**
   * @return The current value of the preference.
   */
  T get();

  /**
   * @return true if the key has a value saved for it, otherwise false.
   */
  boolean isSet();

  /**
   * Delete the stored value of the preference and set as the default value.
   */
  void delete();

  /**
   * @return An Observable that emits on preference value change. Also emits the current value
   * on subscribe.
   */
  Observable<T> asObservable();
}
