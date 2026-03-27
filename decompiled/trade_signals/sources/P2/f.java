package P2;

import S2.AbstractC0903j;
import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f6356b = null;

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f6358b;

        public b() {
            int iP = AbstractC0903j.p(f.this.f6355a, "com.google.firebase.crashlytics.unity_version", "string");
            if (iP == 0) {
                if (!f.this.c("flutter_assets/NOTICES.Z")) {
                    this.f6357a = null;
                    this.f6358b = null;
                    return;
                } else {
                    this.f6357a = "Flutter";
                    this.f6358b = null;
                    g.f().i("Development platform is: Flutter");
                    return;
                }
            }
            this.f6357a = "Unity";
            String string = f.this.f6355a.getResources().getString(iP);
            this.f6358b = string;
            g.f().i("Unity Editor version is: " + string);
        }
    }

    public f(Context context) {
        this.f6355a = context;
    }

    public final boolean c(String str) {
        if (this.f6355a.getAssets() == null) {
            return false;
        }
        try {
            InputStream inputStreamOpen = this.f6355a.getAssets().open(str);
            if (inputStreamOpen == null) {
                return true;
            }
            inputStreamOpen.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public String d() {
        return f().f6357a;
    }

    public String e() {
        return f().f6358b;
    }

    public final b f() {
        if (this.f6356b == null) {
            this.f6356b = new b();
        }
        return this.f6356b;
    }
}
