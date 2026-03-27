package com.google.android.gms.common.api.internal;

import P1.C0650d;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.AbstractC1186x;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class g0 extends AbstractC1186x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC1186x.a f10973d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(AbstractC1186x.a aVar, C0650d[] c0650dArr, boolean z7, int i7) {
        super(c0650dArr, z7, i7);
        this.f10973d = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC1186x
    public final void b(a.b bVar, TaskCompletionSource taskCompletionSource) {
        this.f10973d.f11012a.accept(bVar, taskCompletionSource);
    }
}
