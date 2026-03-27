package com.google.android.gms.common.internal;

import Q1.C0790b;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class b0 extends K {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractC1283c f14953g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(AbstractC1283c abstractC1283c, int i8, Bundle bundle) {
        super(abstractC1283c, i8, bundle);
        this.f14953g = abstractC1283c;
    }

    @Override // com.google.android.gms.common.internal.K
    public final void f(C0790b c0790b) {
        if (this.f14953g.enableLocalFallback() && AbstractC1283c.zzo(this.f14953g)) {
            AbstractC1283c.zzk(this.f14953g, 16);
        } else {
            this.f14953g.zzc.a(c0790b);
            this.f14953g.onConnectionFailed(c0790b);
        }
    }

    @Override // com.google.android.gms.common.internal.K
    public final boolean g() {
        this.f14953g.zzc.a(C0790b.f6678e);
        return true;
    }
}
