package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0924b;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0896b implements InterfaceC0918w {
    @Override // com.google.android.gms.common.api.internal.InterfaceC0918w
    public final Exception getException(Status status) {
        return AbstractC0924b.a(status);
    }
}
