package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.c;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f5563a;

    public g0(h0 h0Var) {
        Objects.requireNonNull(h0Var);
        this.f5563a = h0Var;
    }

    @Override // com.google.android.gms.common.internal.c.e
    public final void a() {
        this.f5563a.f5577o.g().post(new f0(this));
    }
}
