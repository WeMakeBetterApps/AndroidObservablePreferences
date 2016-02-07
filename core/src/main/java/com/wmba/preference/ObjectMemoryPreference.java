package com.wmba.preference;

/**
 * A Preference for storing Objects in Memory. It's recommended that Immutable items are used
 */
public class ObjectMemoryPreference<T> extends AbstractMemoryPreference<T> implements ObjectPreference<T> {
  public ObjectMemoryPreference(T defaultValue) {
    super(defaultValue);
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
