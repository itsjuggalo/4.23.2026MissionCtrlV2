package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0421y implements com.google.android.gms.common.api.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BasePendingResult f5172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A f5173b;

    public C0421y(A a6, BasePendingResult basePendingResult) {
        this.f5173b = a6;
        this.f5172a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.p
    public final void a(Status status) {
        ((Map) this.f5173b.f5069a).remove(this.f5172a);
    }
}
