package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.InterfaceC0918w;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseExceptionMapper implements InterfaceC0918w {
    @Override // com.google.android.gms.common.api.internal.InterfaceC0918w
    public final Exception getException(Status status) {
        return status.k() == 8 ? new FirebaseException(status.zza()) : new FirebaseApiNotAvailableException(status.zza());
    }
}
