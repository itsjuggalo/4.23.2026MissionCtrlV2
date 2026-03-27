package com.google.android.play.core.integrity;

import F2.G;
import F2.InterfaceC0474l;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class bp implements InterfaceC0474l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final F2.o f11941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final F2.o f11942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final F2.o f11943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final F2.o f11944d;

    public bp(F2.o oVar, F2.o oVar2, F2.o oVar3, F2.o oVar4) {
        this.f11941a = oVar;
        this.f11942b = oVar2;
        this.f11943c = oVar3;
        this.f11944d = oVar4;
    }

    @Override // F2.o
    public final /* bridge */ /* synthetic */ Object a() {
        return new bn((Context) this.f11941a.a(), (G) this.f11942b.a(), ((au) this.f11943c).a(), new j());
    }
}
