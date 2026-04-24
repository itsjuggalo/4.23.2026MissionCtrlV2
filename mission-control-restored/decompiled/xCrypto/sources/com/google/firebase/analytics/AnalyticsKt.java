package com.google.firebase.analytics;

import W2.E;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import i3.k;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class AnalyticsKt {
    private static volatile FirebaseAnalytics zza;
    private static final Object zzb = new Object();

    public static final FirebaseAnalytics getANALYTICS() {
        return zza;
    }

    public static final FirebaseAnalytics getAnalytics(Firebase firebase) {
        r.f(firebase, "<this>");
        if (zza == null) {
            synchronized (zzb) {
                try {
                    if (zza == null) {
                        zza = FirebaseAnalytics.getInstance(FirebaseKt.getApp(Firebase.INSTANCE).getApplicationContext());
                    }
                    E e4 = E.f5463a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        FirebaseAnalytics firebaseAnalytics = zza;
        r.c(firebaseAnalytics);
        return firebaseAnalytics;
    }

    public static final Object getLOCK() {
        return zzb;
    }

    public static final void logEvent(FirebaseAnalytics firebaseAnalytics, String name, k block) {
        r.f(firebaseAnalytics, "<this>");
        r.f(name, "name");
        r.f(block, "block");
        ParametersBuilder parametersBuilder = new ParametersBuilder();
        block.invoke(parametersBuilder);
        firebaseAnalytics.logEvent(name, parametersBuilder.getBundle());
    }

    public static final void setANALYTICS(FirebaseAnalytics firebaseAnalytics) {
        zza = firebaseAnalytics;
    }

    public static final void setConsent(FirebaseAnalytics firebaseAnalytics, k block) {
        r.f(firebaseAnalytics, "<this>");
        r.f(block, "block");
        ConsentBuilder consentBuilder = new ConsentBuilder();
        block.invoke(consentBuilder);
        firebaseAnalytics.setConsent(consentBuilder.asMap());
    }
}
