package com.google.android.play.core.integrity;

import android.content.Context;
import n6.a0;
import n6.d0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class w implements aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d0 f6004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d0 f6005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d0 f6006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d0 f6007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d0 f6008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d0 f6009f;

    public /* synthetic */ w(Context context, v vVar) {
        n6.z zVarB = a0.b(context);
        this.f6004a = zVarB;
        d0 d0VarB = n6.y.b(bb.f5942a);
        this.f6005b = d0VarB;
        au auVar = new au(zVarB, n.f5996a);
        this.f6006c = auVar;
        d0 d0VarB2 = n6.y.b(new bp(zVarB, d0VarB, auVar, n.f5996a));
        this.f6007d = d0VarB2;
        d0 d0VarB3 = n6.y.b(new bu(d0VarB2));
        this.f6008e = d0VarB3;
        this.f6009f = n6.y.b(new ba(d0VarB2, d0VarB3));
    }

    @Override // com.google.android.play.core.integrity.aw
    public final StandardIntegrityManager a() {
        return (StandardIntegrityManager) this.f6009f.a();
    }
}
