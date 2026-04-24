package com.google.android.gms.measurement.internal;

import D3.m;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzai implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        String strF = null;
        String strF2 = null;
        zzpl zzplVar = null;
        String strF3 = null;
        zzbg zzbgVar = null;
        zzbg zzbgVar2 = null;
        zzbg zzbgVar3 = null;
        long jS = 0;
        long jS2 = 0;
        long jS3 = 0;
        boolean zL = false;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            switch (T1.b.k(iP)) {
                case 2:
                    strF = T1.b.f(parcel, iP);
                    break;
                case 3:
                    strF2 = T1.b.f(parcel, iP);
                    break;
                case 4:
                    zzplVar = (zzpl) T1.b.e(parcel, iP, zzpl.CREATOR);
                    break;
                case 5:
                    jS = T1.b.s(parcel, iP);
                    break;
                case 6:
                    zL = T1.b.l(parcel, iP);
                    break;
                case 7:
                    strF3 = T1.b.f(parcel, iP);
                    break;
                case 8:
                    zzbgVar = (zzbg) T1.b.e(parcel, iP, zzbg.CREATOR);
                    break;
                case 9:
                    jS2 = T1.b.s(parcel, iP);
                    break;
                case 10:
                    zzbgVar2 = (zzbg) T1.b.e(parcel, iP, zzbg.CREATOR);
                    break;
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    jS3 = T1.b.s(parcel, iP);
                    break;
                case 12:
                    zzbgVar3 = (zzbg) T1.b.e(parcel, iP, zzbg.CREATOR);
                    break;
                default:
                    T1.b.v(parcel, iP);
                    break;
            }
        }
        T1.b.j(parcel, iW);
        return new zzah(strF, strF2, zzplVar, jS, zL, strF3, zzbgVar, jS2, zzbgVar2, jS3, zzbgVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new zzah[i8];
    }
}
