package com.wmba.preference;

import com.wmba.preference.Preference;

import rx.Observable;
import rx.subjects.BehaviorSubject;

public class AbstractMemoryPreference<T> implements Preference<T> {
  private final T mDefaultValue;

  private T mValue = null;
  private BehaviorSubject<T> mSubject = null;

  public AbstractMemoryPreference(T defaultValue) {
    mDefaultValue = defaultValue;
  }

  @Override public synchronized void set(T value) {
    T currentValue = get();
    if (currentValue == value || (currentValue != null && currentValue.equals(value))) {
      // Same as the current value.
      return;
    }

    if (value == null) {
      delete();
    } else {
      mValue = value;
      if (mSubject != null) {
        mSubject.onNext(get());
      }
    }
  }

  @Override public synchronized T get() {
    if (mValue != null) {
      return mValue;
    } else {
      return mDefaultValue;
    }
  }

  @Override public synchronized boolean isSet() {
    return mValue != null;
  }

  @Override public synchronized void delete() {
    if (mValue != null) {
      mValue = null;
      if (mSubject != null) {
        mSubject.onNext(get());
      }
    }
  }

  @Override public synchronized Observable<T> asObservable() {
    if (mSubject == null) {
      mSubject = BehaviorSubject.create(get());
    }
    return mSubject.asObservable();
  }
}
