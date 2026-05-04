package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.s;
import g5.b;
import g5.w;
import n5.a;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class SignInConfiguration extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new w();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleSignInOptions f5443b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.f5442a = s.e(str);
        this.f5443b = googleSignInOptions;
    }

    public final GoogleSignInOptions R() {
        return this.f5443b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f5442a.equals(signInConfiguration.f5442a)) {
            GoogleSignInOptions googleSignInOptions = this.f5443b;
            GoogleSignInOptions googleSignInOptions2 = signInConfiguration.f5443b;
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
        return new b().a(this.f5442a).a(this.f5443b).b();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.f5442a;
        int iA = c.a(parcel);
        c.E(parcel, 2, str, false);
        c.C(parcel, 5, this.f5443b, i10, false);
        c.b(parcel, iA);
    }
}
