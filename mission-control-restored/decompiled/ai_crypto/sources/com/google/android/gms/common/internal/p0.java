package com.google.android.gms.common.internal;

import P1.C0650d;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public final class p0 implements Parcelable.Creator {
    public static void a(C1196g c1196g, Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, c1196g.f11085a);
        Q1.c.t(parcel, 2, c1196g.f11086b);
        Q1.c.t(parcel, 3, c1196g.f11087c);
        Q1.c.E(parcel, 4, c1196g.f11088d, false);
        Q1.c.s(parcel, 5, c1196g.f11089e, false);
        Q1.c.H(parcel, 6, c1196g.f11090f, i7, false);
        Q1.c.j(parcel, 7, c1196g.f11091g, false);
        Q1.c.C(parcel, 8, c1196g.f11092h, i7, false);
        Q1.c.H(parcel, 10, c1196g.f11093i, i7, false);
        Q1.c.H(parcel, 11, c1196g.f11094j, i7, false);
        Q1.c.g(parcel, 12, c1196g.f11095k);
        Q1.c.t(parcel, 13, c1196g.f11096l);
        Q1.c.g(parcel, 14, c1196g.f11097m);
        Q1.c.E(parcel, 15, c1196g.A(), false);
        Q1.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        Scope[] scopeArr = C1196g.f11083o;
        Bundle bundle = new Bundle();
        C0650d[] c0650dArr = C1196g.f11084p;
        C0650d[] c0650dArr2 = c0650dArr;
        String strQ = null;
        IBinder iBinderE = null;
        Account account = null;
        String strQ2 = null;
        int iF = 0;
        int iF2 = 0;
        int iF3 = 0;
        boolean zX = false;
        int iF4 = 0;
        boolean zX2 = false;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    iF = Q1.b.F(parcel, iD);
                    break;
                case 2:
                    iF2 = Q1.b.F(parcel, iD);
                    break;
                case 3:
                    iF3 = Q1.b.F(parcel, iD);
                    break;
                case 4:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 5:
                    iBinderE = Q1.b.E(parcel, iD);
                    break;
                case 6:
                    scopeArr = (Scope[]) Q1.b.t(parcel, iD, Scope.CREATOR);
                    break;
                case 7:
                    bundle = Q1.b.f(parcel, iD);
                    break;
                case 8:
                    account = (Account) Q1.b.p(parcel, iD, Account.CREATOR);
                    break;
                case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                default:
                    Q1.b.L(parcel, iD);
                    break;
                case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    c0650dArr = (C0650d[]) Q1.b.t(parcel, iD, C0650d.CREATOR);
                    break;
                case 11:
                    c0650dArr2 = (C0650d[]) Q1.b.t(parcel, iD, C0650d.CREATOR);
                    break;
                case 12:
                    zX = Q1.b.x(parcel, iD);
                    break;
                case 13:
                    iF4 = Q1.b.F(parcel, iD);
                    break;
                case 14:
                    zX2 = Q1.b.x(parcel, iD);
                    break;
                case 15:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new C1196g(iF, iF2, iF3, strQ, iBinderE, scopeArr, bundle, account, c0650dArr, c0650dArr2, zX, iF4, zX2, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new C1196g[i7];
    }
}
