package com.google.android.gms.internal.measurement;

import T1.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzde implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = b.w(parcel);
        Bundle bundleA = null;
        String strF = null;
        boolean zL = false;
        long jS = 0;
        long jS2 = 0;
        while (parcel.dataPosition() < iW) {
            int iP = b.p(parcel);
            int iK = b.k(iP);
            if (iK == 1) {
                jS = b.s(parcel, iP);
            } else if (iK == 2) {
                jS2 = b.s(parcel, iP);
            } else if (iK == 3) {
                zL = b.l(parcel, iP);
            } else if (iK == 7) {
                bundleA = b.a(parcel, iP);
            } else if (iK != 8) {
                b.v(parcel, iP);
            } else {
                strF = b.f(parcel, iP);
            }
        }
        b.j(parcel, iW);
        return new zzdd(jS, jS2, zL, bundleA, strF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new zzdd[i8];
    }
}
