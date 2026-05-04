package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzai implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        zzpl zzplVar = null;
        String strQ3 = null;
        zzbg zzbgVar = null;
        zzbg zzbgVar2 = null;
        zzbg zzbgVar3 = null;
        long jH = 0;
        long jH2 = 0;
        long jH3 = 0;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 2:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 4:
                    zzplVar = (zzpl) n5.b.p(parcel, iD, zzpl.CREATOR);
                    break;
                case 5:
                    jH = n5.b.H(parcel, iD);
                    break;
                case 6:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 7:
                    strQ3 = n5.b.q(parcel, iD);
                    break;
                case 8:
                    zzbgVar = (zzbg) n5.b.p(parcel, iD, zzbg.CREATOR);
                    break;
                case 9:
                    jH2 = n5.b.H(parcel, iD);
                    break;
                case 10:
                    zzbgVar2 = (zzbg) n5.b.p(parcel, iD, zzbg.CREATOR);
                    break;
                case 11:
                    jH3 = n5.b.H(parcel, iD);
                    break;
                case 12:
                    zzbgVar3 = (zzbg) n5.b.p(parcel, iD, zzbg.CREATOR);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new zzah(strQ, strQ2, zzplVar, jH, zX, strQ3, zzbgVar, jH2, zzbgVar2, jH3, zzbgVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzah[i10];
    }
}
