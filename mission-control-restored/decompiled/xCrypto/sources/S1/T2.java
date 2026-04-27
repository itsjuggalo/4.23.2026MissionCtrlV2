package S1;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* JADX INFO: loaded from: classes.dex */
public final class T2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0658q3 f4244a;

    public T2(b7 b7Var) {
        this.f4244a = b7Var.f0();
    }

    public final boolean a() {
        try {
            C0658q3 c0658q3 = this.f4244a;
            I1.e eVarA = I1.f.a(c0658q3.e());
            if (eVarA != null) {
                return eVarA.e("com.android.vending", UserMetadata.MAX_ROLLOUT_ASSIGNMENTS).versionCode >= 80837300;
            }
            c0658q3.a().w().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e4) {
            this.f4244a.a().w().b("Failed to retrieve Play Store version for Install Referrer", e4);
            return false;
        }
    }
}
