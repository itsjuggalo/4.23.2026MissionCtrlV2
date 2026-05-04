package m7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import io.flutter.plugins.firebase.auth.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d0 extends h {
    public static final Parcelable.Creator<d0> CREATOR = new l1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15980a;

    public d0(String str) {
        this.f15980a = com.google.android.gms.common.internal.s.e(str);
    }

    public static zzajb U(d0 d0Var, String str) {
        com.google.android.gms.common.internal.s.k(d0Var);
        return new zzajb(null, d0Var.f15980a, d0Var.R(), null, null, null, str, null, null);
    }

    @Override // m7.h
    public String R() {
        return Constants.SIGN_IN_METHOD_GITHUB;
    }

    @Override // m7.h
    public String S() {
        return Constants.SIGN_IN_METHOD_GITHUB;
    }

    @Override // m7.h
    public final h T() {
        return new d0(this.f15980a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, this.f15980a, false);
        n5.c.b(parcel, iA);
    }
}
