package com.google.android.gms.internal.measurement;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzcw extends zzbm implements zzcx {
    public zzcw() {
        super("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i6) {
        if (i != 2) {
            return false;
        }
        zze();
        return true;
    }
}
