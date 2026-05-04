package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpm implements Parcelable.Creator {
    public static void zza(zzpl zzplVar, Parcel parcel, int i10) {
        int i11 = zzplVar.zza;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.E(parcel, 2, zzplVar.zzb, false);
        n5.c.x(parcel, 3, zzplVar.zzc);
        n5.c.z(parcel, 4, zzplVar.zzd, false);
        n5.c.r(parcel, 5, null, false);
        n5.c.E(parcel, 6, zzplVar.zze, false);
        n5.c.E(parcel, 7, zzplVar.zzf, false);
        n5.c.o(parcel, 8, zzplVar.zzg, false);
        n5.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        String strQ = null;
        Long lI = null;
        Float fC = null;
        String strQ2 = null;
        String strQ3 = null;
        Double dA = null;
        long jH = 0;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    iF = n5.b.F(parcel, iD);
                    break;
                case 2:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 3:
                    jH = n5.b.H(parcel, iD);
                    break;
                case 4:
                    lI = n5.b.I(parcel, iD);
                    break;
                case 5:
                    fC = n5.b.C(parcel, iD);
                    break;
                case 6:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
                case 7:
                    strQ3 = n5.b.q(parcel, iD);
                    break;
                case 8:
                    dA = n5.b.A(parcel, iD);
                    break;
                default:
                    n5.b.L(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new zzpl(iF, strQ, jH, lI, fC, strQ2, strQ3, dA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzpl[i10];
    }
}
