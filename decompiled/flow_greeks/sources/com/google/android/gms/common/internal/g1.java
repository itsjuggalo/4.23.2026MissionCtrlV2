package com.google.android.gms.common.internal;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends s0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c f5721g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g1(c cVar, int i10, Bundle bundle) {
        super(cVar, i10, bundle);
        Objects.requireNonNull(cVar);
        this.f5721g = cVar;
    }

    @Override // com.google.android.gms.common.internal.s0
    public final boolean e() {
        this.f5721g.zzc.d(m5.b.f15883e);
        return true;
    }

    @Override // com.google.android.gms.common.internal.s0
    public final void f(m5.b bVar) {
        c cVar = this.f5721g;
        if (cVar.enableLocalFallback() && cVar.zzg()) {
            cVar.zzf(16);
        } else {
            cVar.zzc.d(bVar);
            cVar.onConnectionFailed(bVar);
        }
    }
}
