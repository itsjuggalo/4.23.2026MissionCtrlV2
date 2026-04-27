package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzon implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        byte[] bArrB = null;
        String strF = null;
        Bundle bundleA = null;
        String strF2 = null;
        long jS = 0;
        long jS2 = 0;
        int iR = 0;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            switch (T1.b.k(iP)) {
                case 1:
                    jS = T1.b.s(parcel, iP);
                    break;
                case 2:
                    bArrB = T1.b.b(parcel, iP);
                    break;
                case 3:
                    strF = T1.b.f(parcel, iP);
                    break;
                case 4:
                    bundleA = T1.b.a(parcel, iP);
                    break;
                case 5:
                    iR = T1.b.r(parcel, iP);
                    break;
                case 6:
                    jS2 = T1.b.s(parcel, iP);
                    break;
                case 7:
                    strF2 = T1.b.f(parcel, iP);
                    break;
                default:
                    T1.b.v(parcel, iP);
                    break;
            }
        }
        T1.b.j(parcel, iW);
        return new zzom(jS, bArrB, strF, bundleA, iR, jS2, strF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new zzom[i8];
    }
}
