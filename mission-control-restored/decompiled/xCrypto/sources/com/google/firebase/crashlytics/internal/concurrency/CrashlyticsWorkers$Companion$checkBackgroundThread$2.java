package com.google.firebase.crashlytics.internal.concurrency;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class CrashlyticsWorkers$Companion$checkBackgroundThread$2 extends s implements Function0 {
    public static final CrashlyticsWorkers$Companion$checkBackgroundThread$2 INSTANCE = new CrashlyticsWorkers$Companion$checkBackgroundThread$2();

    public CrashlyticsWorkers$Companion$checkBackgroundThread$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "Must be called on a background thread, was called on " + CrashlyticsWorkers.Companion.getThreadName() + com.amazon.a.a.o.c.a.b.f8816a;
    }
}
