package com.google.android.gms.common.internal;

import Q1.C0792d;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Parcelable.Creator {
    public static void a(C1286f c1286f, Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.j(parcel, 1, c1286f.f14982a);
        T1.c.j(parcel, 2, c1286f.f14983b);
        T1.c.j(parcel, 3, c1286f.f14984c);
        T1.c.p(parcel, 4, c1286f.f14985d, false);
        T1.c.i(parcel, 5, c1286f.f14986e, false);
        T1.c.r(parcel, 6, c1286f.f14987f, i8, false);
        T1.c.e(parcel, 7, c1286f.f14988g, false);
        T1.c.o(parcel, 8, c1286f.f14989h, i8, false);
        T1.c.r(parcel, 10, c1286f.f14990i, i8, false);
        T1.c.r(parcel, 11, c1286f.f14991j, i8, false);
        T1.c.c(parcel, 12, c1286f.f14992k);
        T1.c.j(parcel, 13, c1286f.f14993l);
        T1.c.c(parcel, 14, c1286f.f14994m);
        T1.c.p(parcel, 15, c1286f.a(), false);
        T1.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        Scope[] scopeArr = C1286f.f14980o;
        Bundle bundle = new Bundle();
        C0792d[] c0792dArr = C1286f.f14981p;
        C0792d[] c0792dArr2 = c0792dArr;
        String strF = null;
        IBinder iBinderQ = null;
        Account account = null;
        String strF2 = null;
        int iR = 0;
        int iR2 = 0;
        int iR3 = 0;
        boolean zL = false;
        int iR4 = 0;
        boolean zL2 = false;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            switch (T1.b.k(iP)) {
                case 1:
                    iR = T1.b.r(parcel, iP);
                    break;
                case 2:
                    iR2 = T1.b.r(parcel, iP);
                    break;
                case 3:
                    iR3 = T1.b.r(parcel, iP);
                    break;
                case 4:
                    strF = T1.b.f(parcel, iP);
                    break;
                case 5:
                    iBinderQ = T1.b.q(parcel, iP);
                    break;
                case 6:
                    scopeArr = (Scope[]) T1.b.h(parcel, iP, Scope.CREATOR);
                    break;
                case 7:
                    bundle = T1.b.a(parcel, iP);
                    break;
                case 8:
                    account = (Account) T1.b.e(parcel, iP, Account.CREATOR);
                    break;
                case 9:
                default:
                    T1.b.v(parcel, iP);
                    break;
                case 10:
                    c0792dArr = (C0792d[]) T1.b.h(parcel, iP, C0792d.CREATOR);
                    break;
                case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    c0792dArr2 = (C0792d[]) T1.b.h(parcel, iP, C0792d.CREATOR);
                    break;
                case 12:
                    zL = T1.b.l(parcel, iP);
                    break;
                case 13:
                    iR4 = T1.b.r(parcel, iP);
                    break;
                case 14:
                    zL2 = T1.b.l(parcel, iP);
                    break;
                case 15:
                    strF2 = T1.b.f(parcel, iP);
                    break;
            }
        }
        T1.b.j(parcel, iW);
        return new C1286f(iR, iR2, iR3, strF, iBinderQ, scopeArr, bundle, account, c0792dArr, c0792dArr2, zL, iR4, zL2, strF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new C1286f[i8];
    }
}
