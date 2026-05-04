package r7;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f19374b = null;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f19376b;

        public b() {
            int iP = u7.i.p(f.this.f19373a, "com.google.firebase.crashlytics.unity_version", "string");
            if (iP == 0) {
                if (!f.this.c("flutter_assets/NOTICES.Z")) {
                    this.f19375a = null;
                    this.f19376b = null;
                    return;
                } else {
                    this.f19375a = "Flutter";
                    this.f19376b = null;
                    g.f().i("Development platform is: Flutter");
                    return;
                }
            }
            this.f19375a = "Unity";
            String string = f.this.f19373a.getResources().getString(iP);
            this.f19376b = string;
            g.f().i("Unity Editor version is: " + string);
        }
    }

    public f(Context context) {
        this.f19373a = context;
    }

    public final boolean c(String str) {
        if (this.f19373a.getAssets() == null) {
            return false;
        }
        try {
            InputStream inputStreamOpen = this.f19373a.getAssets().open(str);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public String d() {
        return f().f19375a;
    }

    public String e() {
        return f().f19376b;
    }

    public final b f() {
        if (this.f19374b == null) {
            this.f19374b = new b();
        }
        return this.f19374b;
    }
}
