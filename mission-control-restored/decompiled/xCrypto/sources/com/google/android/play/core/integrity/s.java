package com.google.android.play.core.integrity;

import X1.C0750k;
import X1.C0752m;
import X1.InterfaceC0751l;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f10181a = this;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final X1.o f10182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final X1.o f10183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final X1.o f10184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final X1.o f10185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final X1.o f10186f;

    public /* synthetic */ s(Context context, r rVar) {
        InterfaceC0751l interfaceC0751lB = C0752m.b(context);
        this.f10182b = interfaceC0751lB;
        X1.o oVarB = C0750k.b(ac.f10072a);
        this.f10183c = oVarB;
        au auVar = new au(interfaceC0751lB, l.f10174a);
        this.f10184d = auVar;
        X1.o oVarB2 = C0750k.b(new al(interfaceC0751lB, oVarB, auVar, l.f10174a));
        this.f10185e = oVarB2;
        this.f10186f = C0750k.b(new ab(oVarB2));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f10186f.a();
    }
}
