package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class bp implements S1.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final S1.j f5405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final S1.j f5406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final S1.j f5407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final S1.j f5408d;

    public bp(S1.j jVar, S1.j jVar2, S1.j jVar3, S1.j jVar4) {
        this.f5405a = jVar;
        this.f5406b = jVar2;
        this.f5407c = jVar3;
        this.f5408d = jVar4;
    }

    @Override // S1.j
    public final /* bridge */ /* synthetic */ Object a() {
        return new bn((Context) this.f5405a.a(), (S1.z) this.f5406b.a(), ((au) this.f5407c).a(), new j());
    }
}
