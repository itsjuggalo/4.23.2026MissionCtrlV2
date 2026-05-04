package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ v.a f5523d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(v.a aVar, m5.d[] dVarArr, boolean z10, int i10) {
        super(dVarArr, z10, i10);
        Objects.requireNonNull(aVar);
        this.f5523d = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void b(a.b bVar, TaskCompletionSource taskCompletionSource) {
        this.f5523d.f().accept(bVar, taskCompletionSource);
    }
}
