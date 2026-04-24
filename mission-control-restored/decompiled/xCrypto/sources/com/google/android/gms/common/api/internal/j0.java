package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.AbstractC0920y;
import com.google.android.gms.tasks.TaskCompletionSource;
import z1.C1986d;

/* JADX INFO: loaded from: classes.dex */
public final class j0 extends AbstractC0920y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0920y.a f9799d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(AbstractC0920y.a aVar, C1986d[] c1986dArr, boolean z4, int i4) {
        super(c1986dArr, z4, i4);
        this.f9799d = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0920y
    public final void b(a.b bVar, TaskCompletionSource taskCompletionSource) {
        this.f9799d.f9835a.accept(bVar, taskCompletionSource);
    }
}
