package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static com.google.android.gms.common.api.b a(Status status) {
        return status.U() ? new com.google.android.gms.common.api.j(status) : new com.google.android.gms.common.api.b(status);
    }
}
