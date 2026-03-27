package com.google.android.gms.auth.api.signin;

import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.ReflectedParcelable;
import u1.k;

/* JADX INFO: loaded from: classes.dex */
public class SignInAccount extends A1.a implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f9638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9639c;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f9638b = googleSignInAccount;
        this.f9637a = AbstractC0940s.f(str, "8.3 and 8.4 SDKs require non-null email");
        this.f9639c = AbstractC0940s.f(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount i() {
        return this.f9638b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        String str = this.f9637a;
        int iA = c.a(parcel);
        c.E(parcel, 4, str, false);
        c.C(parcel, 7, this.f9638b, i4, false);
        c.E(parcel, 8, this.f9639c, false);
        c.b(parcel, iA);
    }
}
