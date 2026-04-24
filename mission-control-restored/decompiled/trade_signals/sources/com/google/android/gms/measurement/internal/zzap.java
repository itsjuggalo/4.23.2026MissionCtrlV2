package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzap implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        Bundle bundleA = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            if (T1.b.k(iP) != 1) {
                T1.b.v(parcel, iP);
            } else {
                bundleA = T1.b.a(parcel, iP);
            }
        }
        T1.b.j(parcel, iW);
        return new zzao(bundleA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new zzao[i8];
    }
}
