package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.InterfaceC0905i;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class BinderC0917v extends InterfaceC0905i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0902f f9825a;

    public BinderC0917v(InterfaceC0902f interfaceC0902f) {
        this.f9825a = interfaceC0902f;
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0905i
    public void onResult(Status status) {
        this.f9825a.setResult(status);
    }
}
