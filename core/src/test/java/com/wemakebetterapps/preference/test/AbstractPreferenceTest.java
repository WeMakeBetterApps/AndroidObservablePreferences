package com.wemakebetterapps.preference.test;

import com.wemakebetterapps.preference.Preference;

import org.junit.Before;
import org.junit.Test;

import rx.observers.TestSubscriber;
import sun.plugin.dom.exception.InvalidStateException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("unchecked")
public abstract class AbstractPreferenceTest<T> {
  private T mValue1;
  private T mValue2;

  protected abstract T firstUniqueValue();
  protected abstract T secondUniqueValue();
  protected abstract Preference<T> createPreference(T defaultValue);

  @Before public void beforeTest() {
    mValue1 = firstUniqueValue();
    mValue2 = secondUniqueValue();

    if (mValue1 == null || mValue2 == null) {
      throw new InvalidStateException("Unique values cannot be null.");
    } else if (mValue1.equals(mValue2) || mValue2.equals(mValue1)) {
      throw new InvalidStateException("Unique values cannot be equal.");
    }
  }

  @Test public void getSetTest() {
    Preference<T> preference = createPreference(null);

    assertEquals(null, preference.get());
    preference.set(mValue1);
    assertEquals(mValue1, preference.get());
  }

  @Test public void defaultNullDeleteTest() {
    Preference<T> preference = createPreference(null);

    assertFalse(preference.isSet());
    assertEquals(null, preference.get());

    preference.set(mValue1);

    assertTrue(preference.isSet());
    assertEquals(mValue1, preference.get());

    preference.delete();

    assertFalse(preference.isSet());
    assertEquals(null, preference.get());
  }

  @Test public void defaultNotNullDeleteTest() {
    Preference<T> preference = createPreference(mValue2);

    assertFalse(preference.isSet());
    assertEquals(mValue2, preference.get());

    preference.set(mValue1);

    assertTrue(preference.isSet());
    assertEquals(mValue1, preference.get());

    preference.delete();

    assertFalse(preference.isSet());
    assertEquals(mValue2, preference.get());
  }

  @Test public void defaultNullIsSetTest() {
    Preference<T> preference = createPreference(null);
    assertFalse(preference.isSet());
    preference.set(mValue1);
    assertTrue(preference.isSet());
    preference.delete();
    assertFalse(preference.isSet());
  }

  @Test public void defaultNotNullIsSetTest() {
    Preference<T> preference = createPreference(mValue2);
    assertFalse(preference.isSet());
    preference.set(mValue1);
    assertTrue(preference.isSet());
    preference.delete();
    assertFalse(preference.isSet());
  }

  @Test public void nullDefaultValueTest() {
    Preference<T> preference = createPreference(null);

    TestSubscriber<T> testSubscriber = new TestSubscriber<T>();
    preference.asObservable().subscribe(testSubscriber);

    preference.set(mValue1);
    preference.delete();

    testSubscriber.assertValues(null, mValue1, null);
  }

  @Test public void defaultValueTest() {
    Preference<T> preference = createPreference(mValue1);

    TestSubscriber<T> testSubscriber = new TestSubscriber<T>();
    preference.asObservable().subscribe(testSubscriber);

    preference.set(mValue2);
    preference.set(null);
    preference.delete();

    testSubscriber.assertValues(mValue1, mValue2, mValue1);
  }

  @Test public void setNullDeletes() {
    Preference<T> preference = createPreference(mValue2);

    preference.set(mValue1);
    assertTrue(preference.isSet());
    preference.set(null);
    assertFalse(preference.isSet());
  }

  @Test public void setDefaultValueIsNotSet() {
    Preference<T> preference = createPreference(mValue1);

    assertFalse(preference.isSet());
    preference.set(mValue1);
    assertFalse(preference.isSet());
  }

  @Test public void multipleDeletesWithDefaultValueTest() {
    Preference<T> preference = createPreference(mValue1);

    TestSubscriber<T> testSubscriber = new TestSubscriber<T>();
    preference.asObservable().subscribe(testSubscriber);

    preference.set(mValue2);
    preference.delete();
    preference.delete();
    preference.set(null);
    preference.set(mValue2);
    preference.set(mValue1);
    preference.set(mValue2);

    testSubscriber.assertValues(mValue1, mValue2, mValue1, mValue2, mValue1, mValue2);
  }
}
