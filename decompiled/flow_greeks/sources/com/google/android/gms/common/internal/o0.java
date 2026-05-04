package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 extends n5.a {
    public static final Parcelable.Creator<o0> CREATOR = new p0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Account f5758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GoogleSignInAccount f5760d;

    public o0(int i10, Account account, int i11, GoogleSignInAccount googleSignInAccount) {
        this.f5757a = i10;
        this.f5758b = account;
        this.f5759c = i11;
        this.f5760d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f5757a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.C(parcel, 2, this.f5758b, i10, false);
        n5.c.t(parcel, 3, this.f5759c);
        n5.c.C(parcel, 4, this.f5760d, i10, false);
        n5.c.b(parcel, iA);
    }

    public o0(Account account, int i10, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i10, googleSignInAccount);
    }
}
