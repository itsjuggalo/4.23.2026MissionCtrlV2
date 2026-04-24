package com.google.firebase.crashlytics;

import com.google.firebase.Firebase;
import i3.k;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseCrashlyticsKt {
    public static final FirebaseCrashlytics getCrashlytics(Firebase firebase) {
        r.f(firebase, "<this>");
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        r.e(firebaseCrashlytics, "getInstance()");
        return firebaseCrashlytics;
    }

    public static final void recordException(FirebaseCrashlytics firebaseCrashlytics, Throwable throwable, k init) {
        r.f(firebaseCrashlytics, "<this>");
        r.f(throwable, "throwable");
        r.f(init, "init");
        KeyValueBuilder keyValueBuilder = new KeyValueBuilder();
        init.invoke(keyValueBuilder);
        firebaseCrashlytics.recordException(throwable, keyValueBuilder.build$com_google_firebase_firebase_crashlytics());
    }

    public static final void setCustomKeys(FirebaseCrashlytics firebaseCrashlytics, k init) {
        r.f(firebaseCrashlytics, "<this>");
        r.f(init, "init");
        KeyValueBuilder keyValueBuilder = new KeyValueBuilder();
        init.invoke(keyValueBuilder);
        firebaseCrashlytics.setCustomKeys(keyValueBuilder.build$com_google_firebase_firebase_crashlytics());
    }
}
