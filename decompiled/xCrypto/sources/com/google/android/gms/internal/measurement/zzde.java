package com.google.android.gms.internal.measurement;

import A1.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzde implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        Bundle bundleF = null;
        String strQ = null;
        boolean zX = false;
        long jH = 0;
        long jH2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                jH = b.H(parcel, iD);
            } else if (iW == 2) {
                jH2 = b.H(parcel, iD);
            } else if (iW == 3) {
                zX = b.x(parcel, iD);
            } else if (iW == 7) {
                bundleF = b.f(parcel, iD);
            } else if (iW != 8) {
                b.L(parcel, iD);
            } else {
                strQ = b.q(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new zzdd(jH, jH2, zX, bundleF, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new zzdd[i4];
    }
}
