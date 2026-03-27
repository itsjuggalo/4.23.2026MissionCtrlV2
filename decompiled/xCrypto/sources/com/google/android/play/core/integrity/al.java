package com.google.android.play.core.integrity;

import X1.G;
import X1.InterfaceC0751l;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class al implements InterfaceC0751l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final X1.o f10094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final X1.o f10095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final X1.o f10096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final X1.o f10097d;

    public al(X1.o oVar, X1.o oVar2, X1.o oVar3, X1.o oVar4) {
        this.f10094a = oVar;
        this.f10095b = oVar2;
        this.f10096c = oVar3;
        this.f10097d = oVar4;
    }

    @Override // X1.o
    public final /* bridge */ /* synthetic */ Object a() {
        return new aj((Context) this.f10094a.a(), (G) this.f10095b.a(), ((au) this.f10096c).a(), new i());
    }
}
