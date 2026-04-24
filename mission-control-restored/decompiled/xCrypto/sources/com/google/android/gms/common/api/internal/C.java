package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;

/* JADX INFO: loaded from: classes.dex */
public final class C implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BasePendingResult f9697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E f9698b;

    public C(E e4, BasePendingResult basePendingResult) {
        this.f9698b = e4;
        this.f9697a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.h.a
    public final void a(Status status) {
        this.f9698b.f9703a.remove(this.f9697a);
    }
}
