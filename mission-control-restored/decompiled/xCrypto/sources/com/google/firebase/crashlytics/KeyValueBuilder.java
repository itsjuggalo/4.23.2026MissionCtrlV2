package com.google.firebase.crashlytics;

import W2.E;
import com.google.firebase.crashlytics.CustomKeysAndValues;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class KeyValueBuilder {
    private final CustomKeysAndValues.Builder builder;
    private final FirebaseCrashlytics crashlytics;

    private KeyValueBuilder(FirebaseCrashlytics firebaseCrashlytics, CustomKeysAndValues.Builder builder) {
        this.crashlytics = firebaseCrashlytics;
        this.builder = builder;
    }

    public final CustomKeysAndValues build$com_google_firebase_firebase_crashlytics() {
        CustomKeysAndValues customKeysAndValuesBuild = this.builder.build();
        r.e(customKeysAndValuesBuild, "builder.build()");
        return customKeysAndValuesBuild;
    }

    public final void key(String key, boolean z4) {
        r.f(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics == null) {
            r.e(this.builder.putBoolean(key, z4), "builder.putBoolean(key, value)");
        } else {
            firebaseCrashlytics.setCustomKey(key, z4);
            E e4 = E.f5463a;
        }
    }

    public final void key(String key, double d4) {
        r.f(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics == null) {
            r.e(this.builder.putDouble(key, d4), "builder.putDouble(key, value)");
        } else {
            firebaseCrashlytics.setCustomKey(key, d4);
            E e4 = E.f5463a;
        }
    }

    public final void key(String key, float f4) {
        r.f(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics == null) {
            r.e(this.builder.putFloat(key, f4), "builder.putFloat(key, value)");
        } else {
            firebaseCrashlytics.setCustomKey(key, f4);
            E e4 = E.f5463a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KeyValueBuilder(FirebaseCrashlytics crashlytics) {
        this(crashlytics, new CustomKeysAndValues.Builder());
        r.f(crashlytics, "crashlytics");
    }

    public final void key(String key, int i4) {
        r.f(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics == null) {
            r.e(this.builder.putInt(key, i4), "builder.putInt(key, value)");
        } else {
            firebaseCrashlytics.setCustomKey(key, i4);
            E e4 = E.f5463a;
        }
    }

    public KeyValueBuilder() {
        this(null, new CustomKeysAndValues.Builder());
    }

    public final void key(String key, long j4) {
        r.f(key, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics == null) {
            r.e(this.builder.putLong(key, j4), "builder.putLong(key, value)");
        } else {
            firebaseCrashlytics.setCustomKey(key, j4);
            E e4 = E.f5463a;
        }
    }

    public final void key(String key, String value) {
        r.f(key, "key");
        r.f(value, "value");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics == null) {
            r.e(this.builder.putString(key, value), "builder.putString(key, value)");
        } else {
            firebaseCrashlytics.setCustomKey(key, value);
            E e4 = E.f5463a;
        }
    }
}
