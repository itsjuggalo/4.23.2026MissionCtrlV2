package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzpm implements Parcelable.Creator {
    public static void zza(zzpl zzplVar, Parcel parcel, int i8) {
        int i9 = zzplVar.zza;
        int iA = T1.c.a(parcel);
        T1.c.j(parcel, 1, i9);
        T1.c.p(parcel, 2, zzplVar.zzb, false);
        T1.c.m(parcel, 3, zzplVar.zzc);
        T1.c.n(parcel, 4, zzplVar.zzd, false);
        T1.c.h(parcel, 5, null, false);
        T1.c.p(parcel, 6, zzplVar.zze, false);
        T1.c.p(parcel, 7, zzplVar.zzf, false);
        T1.c.g(parcel, 8, zzplVar.zzg, false);
        T1.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        String strF = null;
        Long lT = null;
        Float fO = null;
        String strF2 = null;
        String strF3 = null;
        Double dN = null;
        long jS = 0;
        int iR = 0;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            switch (T1.b.k(iP)) {
                case 1:
                    iR = T1.b.r(parcel, iP);
                    break;
                case 2:
                    strF = T1.b.f(parcel, iP);
                    break;
                case 3:
                    jS = T1.b.s(parcel, iP);
                    break;
                case 4:
                    lT = T1.b.t(parcel, iP);
                    break;
                case 5:
                    fO = T1.b.o(parcel, iP);
                    break;
                case 6:
                    strF2 = T1.b.f(parcel, iP);
                    break;
                case 7:
                    strF3 = T1.b.f(parcel, iP);
                    break;
                case 8:
                    dN = T1.b.n(parcel, iP);
                    break;
                default:
                    T1.b.v(parcel, iP);
                    break;
            }
        }
        T1.b.j(parcel, iW);
        return new zzpl(iR, strF, jS, lT, fO, strF2, strF3, dN);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new zzpl[i8];
    }
}
