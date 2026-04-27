package com.google.android.gms.common.internal;

import P1.C0648b;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class l0 extends V {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractC1192c f11117g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(AbstractC1192c abstractC1192c, int i7, Bundle bundle) {
        super(abstractC1192c, i7, bundle);
        this.f11117g = abstractC1192c;
    }

    @Override // com.google.android.gms.common.internal.V
    public final void f(C0648b c0648b) {
        if (this.f11117g.enableLocalFallback() && AbstractC1192c.zzo(this.f11117g)) {
            AbstractC1192c.zzk(this.f11117g, 16);
        } else {
            this.f11117g.zzc.b(c0648b);
            this.f11117g.onConnectionFailed(c0648b);
        }
    }

    @Override // com.google.android.gms.common.internal.V
    public final boolean g() {
        this.f11117g.zzc.b(C0648b.f4284e);
        return true;
    }
}
