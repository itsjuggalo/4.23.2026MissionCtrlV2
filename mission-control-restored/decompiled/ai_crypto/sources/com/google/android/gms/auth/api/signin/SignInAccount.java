package com.google.android.gms.auth.api.signin;

import L1.k;
import Q1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public class SignInAccount extends Q1.a implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f10823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10824c;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f10823b = googleSignInAccount;
        this.f10822a = AbstractC1207s.f(str, "8.3 and 8.4 SDKs require non-null email");
        this.f10824c = AbstractC1207s.f(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount A() {
        return this.f10823b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        String str = this.f10822a;
        int iA = c.a(parcel);
        c.E(parcel, 4, str, false);
        c.C(parcel, 7, this.f10823b, i7, false);
        c.E(parcel, 8, this.f10824c, false);
        c.b(parcel, iA);
    }
}
