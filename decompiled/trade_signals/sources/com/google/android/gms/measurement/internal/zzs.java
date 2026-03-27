package com.google.android.gms.measurement.internal;

import D3.m;
import android.os.Parcel;
import android.os.Parcelable;
import io.flutter.Build;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzs implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        boolean zL = false;
        int iR = 0;
        boolean zL2 = false;
        boolean zL3 = false;
        int iR2 = 0;
        int iR3 = 0;
        long jS = 0;
        long jS2 = 0;
        long jS3 = 0;
        long jS4 = 0;
        long jS5 = 0;
        long jS6 = 0;
        long jS7 = 0;
        String strF = "";
        String strF2 = strF;
        String strF3 = strF2;
        String strF4 = strF3;
        String strF5 = null;
        String strF6 = null;
        String strF7 = null;
        String strF8 = null;
        String strF9 = null;
        String strF10 = null;
        Boolean boolM = null;
        ArrayList arrayListG = null;
        String strF11 = null;
        String strF12 = null;
        int iR4 = 100;
        boolean zL4 = true;
        boolean zL5 = true;
        long jS8 = -2147483648L;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            switch (T1.b.k(iP)) {
                case 2:
                    strF5 = T1.b.f(parcel, iP);
                    break;
                case 3:
                    strF6 = T1.b.f(parcel, iP);
                    break;
                case 4:
                    strF7 = T1.b.f(parcel, iP);
                    break;
                case 5:
                    strF8 = T1.b.f(parcel, iP);
                    break;
                case 6:
                    jS = T1.b.s(parcel, iP);
                    break;
                case 7:
                    jS2 = T1.b.s(parcel, iP);
                    break;
                case 8:
                    strF9 = T1.b.f(parcel, iP);
                    break;
                case 9:
                    zL4 = T1.b.l(parcel, iP);
                    break;
                case 10:
                    zL = T1.b.l(parcel, iP);
                    break;
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    jS8 = T1.b.s(parcel, iP);
                    break;
                case 12:
                    strF10 = T1.b.f(parcel, iP);
                    break;
                case 13:
                case 17:
                case 19:
                case 20:
                case Build.API_LEVELS.API_24 /* 24 */:
                case Build.API_LEVELS.API_33 /* 33 */:
                default:
                    T1.b.v(parcel, iP);
                    break;
                case 14:
                    jS3 = T1.b.s(parcel, iP);
                    break;
                case 15:
                    iR = T1.b.r(parcel, iP);
                    break;
                case com.amazon.c.a.a.c.f14230g /* 16 */:
                    zL5 = T1.b.l(parcel, iP);
                    break;
                case 18:
                    zL2 = T1.b.l(parcel, iP);
                    break;
                case 21:
                    boolM = T1.b.m(parcel, iP);
                    break;
                case Build.API_LEVELS.API_22 /* 22 */:
                    jS4 = T1.b.s(parcel, iP);
                    break;
                case Build.API_LEVELS.API_23 /* 23 */:
                    arrayListG = T1.b.g(parcel, iP);
                    break;
                case Build.API_LEVELS.API_25 /* 25 */:
                    strF = T1.b.f(parcel, iP);
                    break;
                case Build.API_LEVELS.API_26 /* 26 */:
                    strF2 = T1.b.f(parcel, iP);
                    break;
                case Build.API_LEVELS.API_27 /* 27 */:
                    strF11 = T1.b.f(parcel, iP);
                    break;
                case Build.API_LEVELS.API_28 /* 28 */:
                    zL3 = T1.b.l(parcel, iP);
                    break;
                case Build.API_LEVELS.API_29 /* 29 */:
                    jS5 = T1.b.s(parcel, iP);
                    break;
                case Build.API_LEVELS.API_30 /* 30 */:
                    iR4 = T1.b.r(parcel, iP);
                    break;
                case Build.API_LEVELS.API_31 /* 31 */:
                    strF3 = T1.b.f(parcel, iP);
                    break;
                case 32:
                    iR2 = T1.b.r(parcel, iP);
                    break;
                case Build.API_LEVELS.API_34 /* 34 */:
                    jS6 = T1.b.s(parcel, iP);
                    break;
                case Build.API_LEVELS.API_35 /* 35 */:
                    strF12 = T1.b.f(parcel, iP);
                    break;
                case Build.API_LEVELS.API_36 /* 36 */:
                    strF4 = T1.b.f(parcel, iP);
                    break;
                case 37:
                    jS7 = T1.b.s(parcel, iP);
                    break;
                case 38:
                    iR3 = T1.b.r(parcel, iP);
                    break;
            }
        }
        T1.b.j(parcel, iW);
        return new zzr(strF5, strF6, strF7, strF8, jS, jS2, strF9, zL4, zL, jS8, strF10, jS3, iR, zL5, zL2, boolM, jS4, arrayListG, strF, strF2, strF11, zL3, jS5, iR4, strF3, iR2, jS6, strF12, strF4, jS7, iR3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new zzr[i8];
    }
}
