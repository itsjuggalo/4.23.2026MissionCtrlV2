package n7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g2 implements m7.g {
    public static final Parcelable.Creator<g2> CREATOR = new f2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f16772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16773d;

    public g2(boolean z10) {
        this.f16773d = z10;
        this.f16771b = null;
        this.f16770a = null;
        this.f16772c = null;
    }

    @Override // m7.g
    public final boolean L() {
        return this.f16773d;
    }

    @Override // m7.g
    public final String c() {
        return this.f16770a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // m7.g
    public final Map getProfile() {
        return this.f16772c;
    }

    @Override // m7.g
    public final String s() {
        if (Constants.SIGN_IN_METHOD_GITHUB.equals(this.f16770a)) {
            return (String) this.f16772c.get(FirebaseAnalytics.Event.LOGIN);
        }
        if (Constants.SIGN_IN_METHOD_TWITTER.equals(this.f16770a)) {
            return (String) this.f16772c.get(FirebaseAnalytics.Param.SCREEN_NAME);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, c(), false);
        n5.c.E(parcel, 2, this.f16771b, false);
        n5.c.g(parcel, 3, L());
        n5.c.b(parcel, iA);
    }

    public g2(String str, String str2, boolean z10) {
        com.google.android.gms.common.internal.s.e(str);
        com.google.android.gms.common.internal.s.e(str2);
        this.f16770a = str;
        this.f16771b = str2;
        this.f16772c = l0.d(str2);
        this.f16773d = z10;
    }
}
