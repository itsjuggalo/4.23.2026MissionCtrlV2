package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public final class Q extends Q1.a {
    public static final Parcelable.Creator<Q> CREATOR = new S();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Account f11042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GoogleSignInAccount f11044d;

    public Q(int i7, Account account, int i8, GoogleSignInAccount googleSignInAccount) {
        this.f11041a = i7;
        this.f11042b = account;
        this.f11043c = i8;
        this.f11044d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f11041a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.C(parcel, 2, this.f11042b, i7, false);
        Q1.c.t(parcel, 3, this.f11043c);
        Q1.c.C(parcel, 4, this.f11044d, i7, false);
        Q1.c.b(parcel, iA);
    }

    public Q(Account account, int i7, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i7, googleSignInAccount);
    }
}
