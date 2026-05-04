package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzon implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        byte[] bArrG = null;
        String strQ = null;
        Bundle bundleF = null;
        String strQ2 = null;
        long jH = 0;
        long jH2 = 0;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    jH = n5.b.H(parcel, iD);
                    break;
                case 2:
                    bArrG = n5.b.g(parcel, iD);
                    break;
                case 3:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 4:
                    bundleF = n5.b.f(parcel, iD);
                    break;
                case 5:
                    iF = n5.b.F(parcel, iD);
                    break;
                case 6:
                    jH2 = n5.b.H(parcel, iD);
                    break;
                case 7:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new zzom(jH, bArrG, strQ, bundleF, iF, jH2, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzom[i10];
    }
}
