package com.google.firebase.analytics.ktxtesting;

import com.google.firebase.analytics.AnalyticsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
public final class TestingKt {
    public static final void withAnalyticsForTest(FirebaseAnalytics analytics, Function0 block) {
        AbstractC2304t.f(analytics, "analytics");
        AbstractC2304t.f(block, "block");
        synchronized (AnalyticsKt.getLOCK()) {
            FirebaseAnalytics analytics2 = AnalyticsKt.getANALYTICS();
            AnalyticsKt.setANALYTICS(analytics);
            try {
                block.invoke();
                AnalyticsKt.setANALYTICS(analytics2);
                C2470H c2470h = C2470H.f21956a;
            } catch (Throwable th) {
                AnalyticsKt.setANALYTICS(analytics2);
                throw th;
            }
        }
    }
}
