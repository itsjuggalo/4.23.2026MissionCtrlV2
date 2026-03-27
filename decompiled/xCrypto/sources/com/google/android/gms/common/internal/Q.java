package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public final class Q extends A1.a {
    public static final Parcelable.Creator<Q> CREATOR = new S();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Account f9859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GoogleSignInAccount f9861d;

    public Q(int i4, Account account, int i5, GoogleSignInAccount googleSignInAccount) {
        this.f9858a = i4;
        this.f9859b = account;
        this.f9860c = i5;
        this.f9861d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f9858a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.C(parcel, 2, this.f9859b, i4, false);
        A1.c.t(parcel, 3, this.f9860c);
        A1.c.C(parcel, 4, this.f9861d, i4, false);
        A1.c.b(parcel, iA);
    }

    public Q(Account account, int i4, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i4, googleSignInAccount);
    }
}
