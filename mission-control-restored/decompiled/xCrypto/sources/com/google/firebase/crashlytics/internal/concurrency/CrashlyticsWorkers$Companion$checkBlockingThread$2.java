package com.google.firebase.crashlytics.internal.concurrency;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class CrashlyticsWorkers$Companion$checkBlockingThread$2 extends s implements Function0 {
    public static final CrashlyticsWorkers$Companion$checkBlockingThread$2 INSTANCE = new CrashlyticsWorkers$Companion$checkBlockingThread$2();

    public CrashlyticsWorkers$Companion$checkBlockingThread$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "Must be called on a blocking thread, was called on " + CrashlyticsWorkers.Companion.getThreadName() + com.amazon.a.a.o.c.a.b.f8816a;
    }
}
