package m7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import io.flutter.plugins.firebase.auth.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class z0 extends h {
    public static final Parcelable.Creator<z0> CREATOR = new v1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16074b;

    public z0(String str, String str2) {
        this.f16073a = com.google.android.gms.common.internal.s.e(str);
        this.f16074b = com.google.android.gms.common.internal.s.e(str2);
    }

    public static zzajb U(z0 z0Var, String str) {
        com.google.android.gms.common.internal.s.k(z0Var);
        return new zzajb(null, z0Var.f16073a, z0Var.R(), null, z0Var.f16074b, null, str, null, null);
    }

    @Override // m7.h
    public String R() {
        return Constants.SIGN_IN_METHOD_TWITTER;
    }

    @Override // m7.h
    public String S() {
        return Constants.SIGN_IN_METHOD_TWITTER;
    }

    @Override // m7.h
    public final h T() {
        return new z0(this.f16073a, this.f16074b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, this.f16073a, false);
        n5.c.E(parcel, 2, this.f16074b, false);
        n5.c.b(parcel, iA);
    }
}
