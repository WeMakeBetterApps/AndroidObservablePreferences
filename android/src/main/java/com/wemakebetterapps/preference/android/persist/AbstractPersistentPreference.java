package com.wemakebetterapps.preference.android.persist;

import android.content.SharedPreferences;

import com.wemakebetterapps.preference.Preference;

import rx.Observable;
import rx.subjects.BehaviorSubject;

public abstract class AbstractPersistentPreference<T> implements Preference<T> {
  private final SharedPreferences mPreferences;
  private final String mKey;
  private final T mDefaultValue;

  private boolean mIsLoaded = false;
  private T mCache;
  private BehaviorSubject<T> mSubject = null;

  public AbstractPersistentPreference(SharedPreferences preferences, String key, T defaultValue) {
    mPreferences = preferences;
    mKey = key;
    mDefaultValue = defaultValue;
  }

  protected abstract T getFromPreferences(SharedPreferences preferences, String key);
  protected abstract void saveInPreferences(SharedPreferences preferences, String key, T value);

  @Override public synchronized void set(T value) {
    T currentValue = get();
    if (currentValue == value || (currentValue != null && currentValue.equals(value))) {
      // Same as the current value.
      return;
    }

    if (value == null) {
      delete();
    } else {
      mCache = value;
      saveInPreferences(mPreferences, mKey, value);
      if (mSubject != null) {
        mSubject.onNext(get());
      }
    }
  }

  @Override public synchronized T get() {
    if (mIsLoaded) {
      if (mCache != null) {
        return mCache;
      } else {
        return mDefaultValue;
      }
    } else {
      mCache = getFromPreferences(mPreferences, mKey);
      mIsLoaded = true;
      return (mCache == null) ? mDefaultValue : mCache;
    }
  }

  @Override public synchronized boolean isSet() {
    if (!mIsLoaded) {
      get();
    }

    return mCache != null;
  }

  @Override public synchronized void delete() {
    if (!mIsLoaded) {
      get();
    }

    if (mCache != null) {
      mCache = null;
      mPreferences.edit().remove(mKey).apply();
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
