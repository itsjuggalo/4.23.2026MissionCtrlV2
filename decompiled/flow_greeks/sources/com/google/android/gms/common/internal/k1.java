package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k1 implements Parcelable.Creator {
    public static void a(g gVar, Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, gVar.f5706a);
        n5.c.t(parcel, 2, gVar.f5707b);
        n5.c.t(parcel, 3, gVar.f5708c);
        n5.c.E(parcel, 4, gVar.f5709d, false);
        n5.c.s(parcel, 5, gVar.f5710e, false);
        n5.c.H(parcel, 6, gVar.f5711f, i10, false);
        n5.c.j(parcel, 7, gVar.f5712g, false);
        n5.c.C(parcel, 8, gVar.f5713h, i10, false);
        n5.c.H(parcel, 10, gVar.f5714i, i10, false);
        n5.c.H(parcel, 11, gVar.f5715j, i10, false);
        n5.c.g(parcel, 12, gVar.f5716k);
        n5.c.t(parcel, 13, gVar.f5717l);
        n5.c.g(parcel, 14, gVar.f5718m);
        n5.c.E(parcel, 15, gVar.R(), false);
        n5.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        Scope[] scopeArr = g.f5704o;
        Bundle bundle = new Bundle();
        m5.d[] dVarArr = g.f5705p;
        m5.d[] dVarArr2 = dVarArr;
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
            int iD = n5.b.D(parcel);
            switch (n5.b.w(iD)) {
                case 1:
                    iF = n5.b.F(parcel, iD);
                    break;
                case 2:
                    iF2 = n5.b.F(parcel, iD);
                    break;
                case 3:
                    iF3 = n5.b.F(parcel, iD);
                    break;
                case 4:
                    strQ = n5.b.q(parcel, iD);
                    break;
                case 5:
                    iBinderE = n5.b.E(parcel, iD);
                    break;
                case 6:
                    scopeArr = (Scope[]) n5.b.t(parcel, iD, Scope.CREATOR);
                    break;
                case 7:
                    bundle = n5.b.f(parcel, iD);
                    break;
                case 8:
                    account = (Account) n5.b.p(parcel, iD, Account.CREATOR);
                    break;
                case 9:
                default:
                    n5.b.L(parcel, iD);
                    break;
                case 10:
                    dVarArr = (m5.d[]) n5.b.t(parcel, iD, m5.d.CREATOR);
                    break;
                case 11:
                    dVarArr2 = (m5.d[]) n5.b.t(parcel, iD, m5.d.CREATOR);
                    break;
                case 12:
                    zX = n5.b.x(parcel, iD);
                    break;
                case 13:
                    iF4 = n5.b.F(parcel, iD);
                    break;
                case 14:
                    zX2 = n5.b.x(parcel, iD);
                    break;
                case 15:
                    strQ2 = n5.b.q(parcel, iD);
                    break;
            }
        }
        n5.b.v(parcel, iM);
        return new g(iF, iF2, iF3, strQ, iBinderE, scopeArr, bundle, account, dVarArr, dVarArr2, zX, iF4, zX2, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new g[i10];
    }
}
