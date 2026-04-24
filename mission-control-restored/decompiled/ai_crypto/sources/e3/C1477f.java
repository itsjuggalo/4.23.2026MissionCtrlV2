package e3;

import android.content.Context;
import h3.AbstractC1695i;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: e3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1477f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f13599b = null;

    /* JADX INFO: renamed from: e3.f$b */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f13601b;

        public b() {
            int iP = AbstractC1695i.p(C1477f.this.f13598a, "com.google.firebase.crashlytics.unity_version", "string");
            if (iP == 0) {
                if (!C1477f.this.c("flutter_assets/NOTICES.Z")) {
                    this.f13600a = null;
                    this.f13601b = null;
                    return;
                } else {
                    this.f13600a = "Flutter";
                    this.f13601b = null;
                    C1478g.f().i("Development platform is: Flutter");
                    return;
                }
            }
            this.f13600a = "Unity";
            String string = C1477f.this.f13598a.getResources().getString(iP);
            this.f13601b = string;
            C1478g.f().i("Unity Editor version is: " + string);
        }
    }

    public C1477f(Context context) {
        this.f13598a = context;
    }

    public final boolean c(String str) {
        if (this.f13598a.getAssets() == null) {
            return false;
        }
        try {
            InputStream inputStreamOpen = this.f13598a.getAssets().open(str);
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
        return f().f13600a;
    }

    public String e() {
        return f().f13601b;
    }

    public final b f() {
        if (this.f13599b == null) {
            this.f13599b = new b();
        }
        return this.f13599b;
    }
}
