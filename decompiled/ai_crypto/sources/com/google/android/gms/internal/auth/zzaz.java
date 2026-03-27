package com.google.android.gms.internal.auth;

import Q1.a;
import Q1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class zzaz extends a {
    public static final Parcelable.Creator<zzaz> CREATOR = new zzba();
    final int zza;
    public final String zzb;
    public final byte[] zzc;

    public zzaz(int i7, String str, byte[] bArr) {
        this.zza = 1;
        this.zzb = (String) AbstractC1207s.k(str);
        this.zzc = (byte[]) AbstractC1207s.k(bArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.t(parcel, 1, this.zza);
        c.E(parcel, 2, this.zzb, false);
        c.k(parcel, 3, this.zzc, false);
        c.b(parcel, iA);
    }

    public zzaz(String str, byte[] bArr) {
        this(1, str, bArr);
    }
}
