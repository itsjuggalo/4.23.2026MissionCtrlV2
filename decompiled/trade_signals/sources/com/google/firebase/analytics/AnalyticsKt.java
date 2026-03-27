package com.google.firebase.analytics;

import B5.k;
import G2.c;
import G2.m;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
public final class AnalyticsKt {
    private static volatile FirebaseAnalytics zza;
    private static final Object zzb = new Object();

    public static final FirebaseAnalytics getANALYTICS() {
        return zza;
    }

    public static final FirebaseAnalytics getAnalytics(c cVar) {
        AbstractC2304t.f(cVar, "<this>");
        if (zza == null) {
            synchronized (zzb) {
                try {
                    if (zza == null) {
                        zza = FirebaseAnalytics.getInstance(m.a(c.f2164a).m());
                    }
                    C2470H c2470h = C2470H.f21956a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        FirebaseAnalytics firebaseAnalytics = zza;
        AbstractC2304t.c(firebaseAnalytics);
        return firebaseAnalytics;
    }

    public static final Object getLOCK() {
        return zzb;
    }

    public static final void logEvent(FirebaseAnalytics firebaseAnalytics, String name, k block) {
        AbstractC2304t.f(firebaseAnalytics, "<this>");
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(block, "block");
        ParametersBuilder parametersBuilder = new ParametersBuilder();
        block.invoke(parametersBuilder);
        firebaseAnalytics.logEvent(name, parametersBuilder.getBundle());
    }

    public static final void setANALYTICS(FirebaseAnalytics firebaseAnalytics) {
        zza = firebaseAnalytics;
    }

    public static final void setConsent(FirebaseAnalytics firebaseAnalytics, k block) {
        AbstractC2304t.f(firebaseAnalytics, "<this>");
        AbstractC2304t.f(block, "block");
        ConsentBuilder consentBuilder = new ConsentBuilder();
        block.invoke(consentBuilder);
        firebaseAnalytics.setConsent(consentBuilder.asMap());
    }
}
