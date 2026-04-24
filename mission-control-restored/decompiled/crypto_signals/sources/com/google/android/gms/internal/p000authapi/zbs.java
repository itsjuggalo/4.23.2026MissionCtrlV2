package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import o1.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class zbs extends zbb implements zbt {
    public zbs() {
        super("com.google.android.gms.auth.api.identity.internal.ISaveAccountLinkingTokenCallback");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i6) {
        if (i != 1) {
            return false;
        }
        Status status = (Status) zbc.zba(parcel, Status.CREATOR);
        k kVar = (k) zbc.zba(parcel, k.CREATOR);
        zbc.zbb(parcel);
        zbb(status, kVar);
        return true;
    }
}
