package com.google.android.play.core.integrity;

import F2.C0473k;
import F2.C0475m;
import F2.InterfaceC0474l;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f11964a = this;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final F2.o f11965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final F2.o f11966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final F2.o f11967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final F2.o f11968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final F2.o f11969f;

    public /* synthetic */ s(Context context, r rVar) {
        InterfaceC0474l interfaceC0474lB = C0475m.b(context);
        this.f11965b = interfaceC0474lB;
        F2.o oVarB = C0473k.b(ac.f11855a);
        this.f11966c = oVarB;
        au auVar = new au(interfaceC0474lB, l.f11957a);
        this.f11967d = auVar;
        F2.o oVarB2 = C0473k.b(new al(interfaceC0474lB, oVarB, auVar, l.f11957a));
        this.f11968e = oVarB2;
        this.f11969f = C0473k.b(new ab(oVarB2));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f11969f.a();
    }
}
