package com.google.android.gms.common.internal;

import android.os.Bundle;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class l0 extends V {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractC0925c f9934g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(AbstractC0925c abstractC0925c, int i4, Bundle bundle) {
        super(abstractC0925c, i4, bundle);
        this.f9934g = abstractC0925c;
    }

    @Override // com.google.android.gms.common.internal.V
    public final void f(C1984b c1984b) {
        if (this.f9934g.enableLocalFallback() && AbstractC0925c.zzo(this.f9934g)) {
            AbstractC0925c.zzk(this.f9934g, 16);
        } else {
            this.f9934g.zzc.b(c1984b);
            this.f9934g.onConnectionFailed(c1984b);
        }
    }

    @Override // com.google.android.gms.common.internal.V
    public final boolean g() {
        this.f9934g.zzc.b(C1984b.f16081e);
        return true;
    }
}
