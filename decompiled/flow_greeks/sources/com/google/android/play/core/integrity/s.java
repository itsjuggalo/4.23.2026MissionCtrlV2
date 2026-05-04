package com.google.android.play.core.integrity;

import android.content.Context;
import n6.a0;
import n6.d0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d0 f5998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d0 f5999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d0 f6000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d0 f6001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d0 f6002e;

    public /* synthetic */ s(Context context, r rVar) {
        n6.z zVarB = a0.b(context);
        this.f5998a = zVarB;
        d0 d0VarB = n6.y.b(ac.f5889a);
        this.f5999b = d0VarB;
        au auVar = new au(zVarB, l.f5991a);
        this.f6000c = auVar;
        d0 d0VarB2 = n6.y.b(new al(zVarB, d0VarB, auVar, l.f5991a));
        this.f6001d = d0VarB2;
        this.f6002e = n6.y.b(new ab(d0VarB2));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f6002e.a();
    }
}
