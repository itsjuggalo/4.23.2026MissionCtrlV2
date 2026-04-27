package com.google.android.gms.auth.api.signin.internal;

import M1.b;
import M1.y;
import Q1.a;
import Q1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class SignInConfiguration extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleSignInOptions f10826b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.f10825a = AbstractC1207s.e(str);
        this.f10826b = googleSignInOptions;
    }

    public final GoogleSignInOptions A() {
        return this.f10826b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f10825a.equals(signInConfiguration.f10825a)) {
            GoogleSignInOptions googleSignInOptions = this.f10826b;
            GoogleSignInOptions googleSignInOptions2 = signInConfiguration.f10826b;
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
        return new b().a(this.f10825a).a(this.f10826b).b();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        String str = this.f10825a;
        int iA = c.a(parcel);
        c.E(parcel, 2, str, false);
        c.C(parcel, 5, this.f10826b, i7, false);
        c.b(parcel, iA);
    }
}
