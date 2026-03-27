package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzao extends T1.a {
    public static final Parcelable.Creator<zzao> CREATOR = new zzap();
    public final Bundle zza;

    public zzao(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Bundle bundle = this.zza;
        int iA = T1.c.a(parcel);
        T1.c.e(parcel, 1, bundle, false);
        T1.c.b(parcel, iA);
    }
}
