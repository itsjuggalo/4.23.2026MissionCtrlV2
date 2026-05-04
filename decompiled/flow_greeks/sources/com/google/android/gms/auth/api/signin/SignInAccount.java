package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.s;
import f5.h;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class SignInAccount extends n5.a implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f5440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5441c;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f5440b = googleSignInAccount;
        this.f5439a = s.f(str, "8.3 and 8.4 SDKs require non-null email");
        this.f5441c = s.f(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount R() {
        return this.f5440b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.f5439a;
        int iA = c.a(parcel);
        c.E(parcel, 4, str, false);
        c.C(parcel, 7, this.f5440b, i10, false);
        c.E(parcel, 8, this.f5441c, false);
        c.b(parcel, iA);
    }
}
