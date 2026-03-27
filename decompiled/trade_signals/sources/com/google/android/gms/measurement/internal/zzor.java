package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzor implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        ArrayList arrayListI = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            if (T1.b.k(iP) != 1) {
                T1.b.v(parcel, iP);
            } else {
                arrayListI = T1.b.i(parcel, iP, zzom.CREATOR);
            }
        }
        T1.b.j(parcel, iW);
        return new zzoq(arrayListI);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new zzoq[i8];
    }
}
