package com.google.android.gms.common.internal;

import android.os.Bundle;
import u1.C1200b;

/* JADX INFO: loaded from: classes.dex */
public final class O extends C {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractC0428f f5208g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(AbstractC0428f abstractC0428f, int i, Bundle bundle) {
        super(abstractC0428f, i, bundle);
        this.f5208g = abstractC0428f;
    }

    @Override // com.google.android.gms.common.internal.C
    public final void a(C1200b c1200b) {
        AbstractC0428f abstractC0428f = this.f5208g;
        if (abstractC0428f.enableLocalFallback() && AbstractC0428f.zzo(abstractC0428f)) {
            AbstractC0428f.zzk(abstractC0428f, 16);
        } else {
            abstractC0428f.zzc.c(c1200b);
            abstractC0428f.onConnectionFailed(c1200b);
        }
    }

    @Override // com.google.android.gms.common.internal.C
    public final boolean b() {
        this.f5208g.zzc.c(C1200b.e);
        return true;
    }
}
