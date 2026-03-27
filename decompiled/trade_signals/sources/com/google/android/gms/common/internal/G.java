package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: loaded from: classes.dex */
public final class G extends T1.a {
    public static final Parcelable.Creator<G> CREATOR = new H();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Account f14926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GoogleSignInAccount f14928d;

    public G(int i8, Account account, int i9, GoogleSignInAccount googleSignInAccount) {
        this.f14925a = i8;
        this.f14926b = account;
        this.f14927c = i9;
        this.f14928d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = this.f14925a;
        int iA = T1.c.a(parcel);
        T1.c.j(parcel, 1, i9);
        T1.c.o(parcel, 2, this.f14926b, i8, false);
        T1.c.j(parcel, 3, this.f14927c);
        T1.c.o(parcel, 4, this.f14928d, i8, false);
        T1.c.b(parcel, iA);
    }

    public G(Account account, int i8, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i8, googleSignInAccount);
    }
}
