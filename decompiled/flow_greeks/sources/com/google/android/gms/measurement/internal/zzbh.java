package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbh implements Parcelable.Creator {
    public static void zza(zzbg zzbgVar, Parcel parcel, int i10) {
        String str = zzbgVar.zza;
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 2, str, false);
        n5.c.C(parcel, 3, zzbgVar.zzb, i10, false);
        n5.c.E(parcel, 4, zzbgVar.zzc, false);
        n5.c.x(parcel, 5, zzbgVar.zzd);
        n5.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        long jH = 0;
        String strQ = null;
        zzbe zzbeVar = null;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 2) {
                strQ = n5.b.q(parcel, iD);
            } else if (iW == 3) {
                zzbeVar = (zzbe) n5.b.p(parcel, iD, zzbe.CREATOR);
            } else if (iW == 4) {
                strQ2 = n5.b.q(parcel, iD);
            } else if (iW != 5) {
                n5.b.L(parcel, iD);
            } else {
                jH = n5.b.H(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new zzbg(strQ, zzbeVar, strQ2, jH);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzbg[i10];
    }
}
