package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.InterfaceC1171h;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class BinderC1183u extends InterfaceC1171h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1168e f11006a;

    public BinderC1183u(InterfaceC1168e interfaceC1168e) {
        this.f11006a = interfaceC1168e;
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1171h
    public void onResult(Status status) {
        this.f11006a.setResult(status);
    }
}
