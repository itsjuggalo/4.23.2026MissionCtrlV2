package m7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import io.flutter.plugins.firebase.auth.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class s0 extends h {
    public static final Parcelable.Creator<s0> CREATOR = new t1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16061a;

    public s0(String str) {
        this.f16061a = com.google.android.gms.common.internal.s.e(str);
    }

    public static zzajb U(s0 s0Var, String str) {
        com.google.android.gms.common.internal.s.k(s0Var);
        return new zzajb(null, null, s0Var.R(), null, null, s0Var.f16061a, str, null, null);
    }

    @Override // m7.h
    public String R() {
        return Constants.SIGN_IN_METHOD_PLAY_GAMES;
    }

    @Override // m7.h
    public String S() {
        return Constants.SIGN_IN_METHOD_PLAY_GAMES;
    }

    @Override // m7.h
    public final h T() {
        return new s0(this.f16061a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, this.f16061a, false);
        n5.c.b(parcel, iA);
    }
}
