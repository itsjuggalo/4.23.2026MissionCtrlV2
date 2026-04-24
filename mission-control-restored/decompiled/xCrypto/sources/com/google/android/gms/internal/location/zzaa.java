package com.google.android.gms.internal.location;

import A1.a;
import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k;

/* JADX INFO: loaded from: classes.dex */
public final class zzaa extends a implements k {
    private final Status zzb;
    public static final zzaa zza = new zzaa(Status.f9653f);
    public static final Parcelable.Creator<zzaa> CREATOR = new zzab();

    public zzaa(Status status) {
        this.zzb = status;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.C(parcel, 1, this.zzb, i4, false);
        c.b(parcel, iA);
    }
}
