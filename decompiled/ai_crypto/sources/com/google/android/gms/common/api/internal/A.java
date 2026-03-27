package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;

/* JADX INFO: loaded from: classes.dex */
public final class A implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BasePendingResult f10875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C f10876b;

    public A(C c7, BasePendingResult basePendingResult) {
        this.f10876b = c7;
        this.f10875a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.h.a
    public final void a(Status status) {
        this.f10876b.f10879a.remove(this.f10875a);
    }
}
