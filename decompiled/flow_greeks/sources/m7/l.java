package m7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import io.flutter.plugins.firebase.auth.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l extends h {
    public static final Parcelable.Creator<l> CREATOR = new b2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16038a;

    public l(String str) {
        this.f16038a = com.google.android.gms.common.internal.s.e(str);
    }

    public static zzajb U(l lVar, String str) {
        com.google.android.gms.common.internal.s.k(lVar);
        return new zzajb(null, lVar.f16038a, lVar.R(), null, null, null, str, null, null);
    }

    @Override // m7.h
    public String R() {
        return Constants.SIGN_IN_METHOD_FACEBOOK;
    }

    @Override // m7.h
    public String S() {
        return Constants.SIGN_IN_METHOD_FACEBOOK;
    }

    @Override // m7.h
    public final h T() {
        return new l(this.f16038a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, this.f16038a, false);
        n5.c.b(parcel, iA);
    }
}
