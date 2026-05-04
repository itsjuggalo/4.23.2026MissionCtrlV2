package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzao extends n5.a {
    public static final Parcelable.Creator<zzao> CREATOR = new zzap();
    public final Bundle zza;

    public zzao(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        Bundle bundle = this.zza;
        int iA = n5.c.a(parcel);
        n5.c.j(parcel, 1, bundle, false);
        n5.c.b(parcel, iA);
    }
}
