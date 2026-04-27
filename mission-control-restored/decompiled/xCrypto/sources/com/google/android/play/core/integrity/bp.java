package com.google.android.play.core.integrity;

import X1.G;
import X1.InterfaceC0751l;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class bp implements InterfaceC0751l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final X1.o f10158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final X1.o f10159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final X1.o f10160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final X1.o f10161d;

    public bp(X1.o oVar, X1.o oVar2, X1.o oVar3, X1.o oVar4) {
        this.f10158a = oVar;
        this.f10159b = oVar2;
        this.f10160c = oVar3;
        this.f10161d = oVar4;
    }

    @Override // X1.o
    public final /* bridge */ /* synthetic */ Object a() {
        return new bn((Context) this.f10158a.a(), (G) this.f10159b.a(), ((au) this.f10160c).a(), new j());
    }
}
