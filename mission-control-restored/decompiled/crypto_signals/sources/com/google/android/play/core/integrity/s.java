package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f5428a = this;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final S1.j f5429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final S1.j f5430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final S1.j f5431d;
    private final S1.j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final S1.j f5432f;

    public s(Context context, r rVar) {
        if (context == null) {
            throw new NullPointerException("instance cannot be null");
        }
        I0.a aVar = new I0.a(context, false);
        this.f5429b = aVar;
        S1.h hVarB = S1.h.b(ac.f5327a);
        this.f5430c = hVarB;
        au auVar = new au(aVar, l.f5421a);
        this.f5431d = auVar;
        S1.h hVarB2 = S1.h.b(new al(aVar, hVarB, auVar, l.f5421a));
        this.e = hVarB2;
        this.f5432f = S1.h.b(new ab(hVarB2));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f5432f.a();
    }
}
