package com.google.android.play.core.integrity;

import F2.C0473k;
import F2.C0475m;
import F2.InterfaceC0474l;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class w implements aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f11971a = this;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final F2.o f11972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final F2.o f11973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final F2.o f11974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final F2.o f11975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final F2.o f11976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final F2.o f11977g;

    public /* synthetic */ w(Context context, v vVar) {
        InterfaceC0474l interfaceC0474lB = C0475m.b(context);
        this.f11972b = interfaceC0474lB;
        F2.o oVarB = C0473k.b(bb.f11908a);
        this.f11973c = oVarB;
        au auVar = new au(interfaceC0474lB, n.f11962a);
        this.f11974d = auVar;
        F2.o oVarB2 = C0473k.b(new bp(interfaceC0474lB, oVarB, auVar, n.f11962a));
        this.f11975e = oVarB2;
        F2.o oVarB3 = C0473k.b(new bu(oVarB2));
        this.f11976f = oVarB3;
        this.f11977g = C0473k.b(new ba(oVarB2, oVarB3));
    }

    @Override // com.google.android.play.core.integrity.aw
    public final StandardIntegrityManager a() {
        return (StandardIntegrityManager) this.f11977g.a();
    }
}
