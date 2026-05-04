package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        int iF = -1;
        int iF2 = 0;
        int iF3 = 0;
        int iF4 = 0;
        int iF5 = 0;
        String strQ = null;
        String strQ2 = null;
        long jH = 0;
        long jH2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    iF2 = n5.b.F(parcel, iD);
                    break;
                case 2:
                    iF3 = n5.b.F(parcel, iD);
                    break;
                case 3:
                    iF4 = n5.b.F(parcel, iD);
                    break;
                case 4:
                    jH = n5.b.H(parcel, iD);
                    break;
                case 5:
                    jH2 = n5.b.H(parcel, iD);
                    break;
                case 6:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 7:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 8:
                    iF5 = n5.b.F(parcel, iD);
                    break;
                case 9:
                    iF = n5.b.F(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new p(iF2, iF3, iF4, jH, jH2, strQ, strQ2, iF5, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new p[i10];
    }
}
