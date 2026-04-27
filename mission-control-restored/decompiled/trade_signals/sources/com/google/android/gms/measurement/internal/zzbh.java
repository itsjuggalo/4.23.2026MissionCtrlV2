package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbh implements Parcelable.Creator {
    public static void zza(zzbg zzbgVar, Parcel parcel, int i8) {
        String str = zzbgVar.zza;
        int iA = T1.c.a(parcel);
        T1.c.p(parcel, 2, str, false);
        T1.c.o(parcel, 3, zzbgVar.zzb, i8, false);
        T1.c.p(parcel, 4, zzbgVar.zzc, false);
        T1.c.m(parcel, 5, zzbgVar.zzd);
        T1.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        long jS = 0;
        String strF = null;
        zzbe zzbeVar = null;
        String strF2 = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 2) {
                strF = T1.b.f(parcel, iP);
            } else if (iK == 3) {
                zzbeVar = (zzbe) T1.b.e(parcel, iP, zzbe.CREATOR);
            } else if (iK == 4) {
                strF2 = T1.b.f(parcel, iP);
            } else if (iK != 5) {
                T1.b.v(parcel, iP);
            } else {
                jS = T1.b.s(parcel, iP);
            }
        }
        T1.b.j(parcel, iW);
        return new zzbg(strF, zzbeVar, strF2, jS);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new zzbg[i8];
    }
}
