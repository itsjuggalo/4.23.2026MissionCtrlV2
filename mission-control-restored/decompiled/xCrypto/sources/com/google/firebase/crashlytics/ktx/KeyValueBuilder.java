package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class KeyValueBuilder {
    private final FirebaseCrashlytics crashlytics;

    public KeyValueBuilder(FirebaseCrashlytics crashlytics) {
        r.f(crashlytics, "crashlytics");
        this.crashlytics = crashlytics;
    }

    public final void key(String key, boolean z4) {
        r.f(key, "key");
        this.crashlytics.setCustomKey(key, z4);
    }

    public final void key(String key, double d4) {
        r.f(key, "key");
        this.crashlytics.setCustomKey(key, d4);
    }

    public final void key(String key, float f4) {
        r.f(key, "key");
        this.crashlytics.setCustomKey(key, f4);
    }

    public final void key(String key, int i4) {
        r.f(key, "key");
        this.crashlytics.setCustomKey(key, i4);
    }

    public final void key(String key, long j4) {
        r.f(key, "key");
        this.crashlytics.setCustomKey(key, j4);
    }

    public final void key(String key, String value) {
        r.f(key, "key");
        r.f(value, "value");
        this.crashlytics.setCustomKey(key, value);
    }
}
