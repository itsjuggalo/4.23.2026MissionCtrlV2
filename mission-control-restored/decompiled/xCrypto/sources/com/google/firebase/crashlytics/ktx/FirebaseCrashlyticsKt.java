package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.ktx.Firebase;
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

    public static final void setCustomKeys(FirebaseCrashlytics firebaseCrashlytics, k init) {
        r.f(firebaseCrashlytics, "<this>");
        r.f(init, "init");
        init.invoke(new KeyValueBuilder(firebaseCrashlytics));
    }
}
