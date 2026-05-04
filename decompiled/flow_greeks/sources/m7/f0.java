package m7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import io.flutter.plugins.firebase.auth.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f0 extends h {
    public static final Parcelable.Creator<f0> CREATOR = new m1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16014b;

    public f0(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        if (str != null && str.length() == 0) {
            throw new IllegalArgumentException("idToken cannot be empty");
        }
        if (str2 != null && str2.length() == 0) {
            throw new IllegalArgumentException("accessToken cannot be empty");
        }
        this.f16013a = str;
        this.f16014b = str2;
    }

    public static zzajb U(f0 f0Var, String str) {
        com.google.android.gms.common.internal.s.k(f0Var);
        return new zzajb(f0Var.f16013a, f0Var.f16014b, f0Var.R(), null, null, null, str, null, null);
    }

    @Override // m7.h
    public String R() {
        return Constants.SIGN_IN_METHOD_GOOGLE;
    }

    @Override // m7.h
    public String S() {
        return Constants.SIGN_IN_METHOD_GOOGLE;
    }

    @Override // m7.h
    public final h T() {
        return new f0(this.f16013a, this.f16014b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, this.f16013a, false);
        n5.c.E(parcel, 2, this.f16014b, false);
        n5.c.b(parcel, iA);
    }
}
