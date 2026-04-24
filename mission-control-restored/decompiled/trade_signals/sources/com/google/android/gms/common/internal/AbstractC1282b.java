package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1282b {
    public static R1.b a(Status status) {
        return status.f() ? new R1.g(status) : new R1.b(status);
    }
}
