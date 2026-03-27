package com.google.android.play.core.integrity;

import X1.C0750k;
import X1.C0752m;
import X1.InterfaceC0751l;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class w implements aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f10188a = this;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final X1.o f10189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final X1.o f10190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final X1.o f10191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final X1.o f10192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final X1.o f10193f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final X1.o f10194g;

    public /* synthetic */ w(Context context, v vVar) {
        InterfaceC0751l interfaceC0751lB = C0752m.b(context);
        this.f10189b = interfaceC0751lB;
        X1.o oVarB = C0750k.b(bb.f10125a);
        this.f10190c = oVarB;
        au auVar = new au(interfaceC0751lB, n.f10179a);
        this.f10191d = auVar;
        X1.o oVarB2 = C0750k.b(new bp(interfaceC0751lB, oVarB, auVar, n.f10179a));
        this.f10192e = oVarB2;
        X1.o oVarB3 = C0750k.b(new bu(oVarB2));
        this.f10193f = oVarB3;
        this.f10194g = C0750k.b(new ba(oVarB2, oVarB3));
    }

    @Override // com.google.android.play.core.integrity.aw
    public final StandardIntegrityManager a() {
        return (StandardIntegrityManager) this.f10194g.a();
    }
}
