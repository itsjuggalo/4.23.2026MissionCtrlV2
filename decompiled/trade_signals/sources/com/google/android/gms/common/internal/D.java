package com.google.android.gms.common.internal;

import Q1.C0790b;
import S1.InterfaceC0879k;
import com.google.android.gms.common.internal.AbstractC1283c;

/* JADX INFO: loaded from: classes.dex */
public final class D implements AbstractC1283c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0879k f14922a;

    public D(InterfaceC0879k interfaceC0879k) {
        this.f14922a = interfaceC0879k;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1283c.b
    public final void onConnectionFailed(C0790b c0790b) {
        this.f14922a.onConnectionFailed(c0790b);
    }
}
