package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import z1.C1986d;

/* JADX INFO: loaded from: classes.dex */
public final class p0 implements Parcelable.Creator {
    public static void a(C0929g c0929g, Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, c0929g.f9902a);
        A1.c.t(parcel, 2, c0929g.f9903b);
        A1.c.t(parcel, 3, c0929g.f9904c);
        A1.c.E(parcel, 4, c0929g.f9905d, false);
        A1.c.s(parcel, 5, c0929g.f9906e, false);
        A1.c.H(parcel, 6, c0929g.f9907f, i4, false);
        A1.c.j(parcel, 7, c0929g.f9908g, false);
        A1.c.C(parcel, 8, c0929g.f9909h, i4, false);
        A1.c.H(parcel, 10, c0929g.f9910i, i4, false);
        A1.c.H(parcel, 11, c0929g.f9911j, i4, false);
        A1.c.g(parcel, 12, c0929g.f9912k);
        A1.c.t(parcel, 13, c0929g.f9913l);
        A1.c.g(parcel, 14, c0929g.f9914m);
        A1.c.E(parcel, 15, c0929g.i(), false);
        A1.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        Scope[] scopeArr = C0929g.f9900o;
        Bundle bundle = new Bundle();
        C1986d[] c1986dArr = C0929g.f9901p;
        C1986d[] c1986dArr2 = c1986dArr;
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
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    iF = A1.b.F(parcel, iD);
                    break;
                case 2:
                    iF2 = A1.b.F(parcel, iD);
                    break;
                case 3:
                    iF3 = A1.b.F(parcel, iD);
                    break;
                case 4:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 5:
                    iBinderE = A1.b.E(parcel, iD);
                    break;
                case 6:
                    scopeArr = (Scope[]) A1.b.t(parcel, iD, Scope.CREATOR);
                    break;
                case 7:
                    bundle = A1.b.f(parcel, iD);
                    break;
                case 8:
                    account = (Account) A1.b.p(parcel, iD, Account.CREATOR);
                    break;
                case 9:
                default:
                    A1.b.L(parcel, iD);
                    break;
                case 10:
                    c1986dArr = (C1986d[]) A1.b.t(parcel, iD, C1986d.CREATOR);
                    break;
                case 11:
                    c1986dArr2 = (C1986d[]) A1.b.t(parcel, iD, C1986d.CREATOR);
                    break;
                case 12:
                    zX = A1.b.x(parcel, iD);
                    break;
                case 13:
                    iF4 = A1.b.F(parcel, iD);
                    break;
                case 14:
                    zX2 = A1.b.x(parcel, iD);
                    break;
                case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new C0929g(iF, iF2, iF3, strQ, iBinderE, scopeArr, bundle, account, c1986dArr, c1986dArr2, zX, iF4, zX2, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0929g[i4];
    }
}
