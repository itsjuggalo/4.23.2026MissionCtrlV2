package com.google.android.gms.auth.api.signin.internal;

import A1.a;
import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.ReflectedParcelable;
import v1.C1884b;
import v1.y;

/* JADX INFO: loaded from: classes.dex */
public final class SignInConfiguration extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleSignInOptions f9641b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.f9640a = AbstractC0940s.e(str);
        this.f9641b = googleSignInOptions;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f9640a.equals(signInConfiguration.f9640a)) {
            GoogleSignInOptions googleSignInOptions = this.f9641b;
            GoogleSignInOptions googleSignInOptions2 = signInConfiguration.f9641b;
            if (googleSignInOptions == null) {
                if (googleSignInOptions2 == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(googleSignInOptions2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new C1884b().a(this.f9640a).a(this.f9641b).b();
    }

    public final GoogleSignInOptions i() {
        return this.f9641b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        String str = this.f9640a;
        int iA = c.a(parcel);
        c.E(parcel, 2, str, false);
        c.C(parcel, 5, this.f9641b, i4, false);
        c.b(parcel, iA);
    }
}
