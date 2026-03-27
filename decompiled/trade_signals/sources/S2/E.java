package S2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import l2.AbstractC2328l;
import l2.C2329m;

/* JADX INFO: loaded from: classes.dex */
public class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f7473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G2.f f7474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f7475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C2329m f7476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f7479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C2329m f7480h;

    public E(G2.f fVar) {
        Object obj = new Object();
        this.f7475c = obj;
        this.f7476d = new C2329m();
        this.f7477e = false;
        this.f7478f = false;
        this.f7480h = new C2329m();
        Context contextM = fVar.m();
        this.f7474b = fVar;
        this.f7473a = AbstractC0903j.q(contextM);
        Boolean boolB = b();
        this.f7479g = boolB == null ? a(contextM) : boolB;
        synchronized (obj) {
            try {
                if (d()) {
                    this.f7476d.e(null);
                    this.f7477e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e8) {
            P2.g.f().e("Could not read data collection permission from manifest", e8);
            return null;
        }
    }

    public final Boolean a(Context context) {
        Boolean boolG = g(context);
        if (boolG == null) {
            this.f7478f = false;
            return null;
        }
        this.f7478f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(boolG));
    }

    public final Boolean b() {
        if (!this.f7473a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f7478f = false;
        return Boolean.valueOf(this.f7473a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    public void c(boolean z7) {
        if (!z7) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.f7480h.e(null);
    }

    public synchronized boolean d() {
        boolean zBooleanValue;
        try {
            Boolean bool = this.f7479g;
            zBooleanValue = bool != null ? bool.booleanValue() : e();
            f(zBooleanValue);
        } catch (Throwable th) {
            throw th;
        }
        return zBooleanValue;
    }

    public final boolean e() {
        try {
            return this.f7474b.x();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public final void f(boolean z7) {
        P2.g.f().b(String.format("Crashlytics automatic data collection %s by %s.", z7 ? "ENABLED" : "DISABLED", this.f7479g == null ? "global Firebase setting" : this.f7478f ? "firebase_crashlytics_collection_enabled manifest flag" : "API"));
    }

    public AbstractC2328l h() {
        AbstractC2328l abstractC2328lA;
        synchronized (this.f7475c) {
            abstractC2328lA = this.f7476d.a();
        }
        return abstractC2328lA;
    }

    public AbstractC2328l i() {
        return T2.b.c(this.f7480h.a(), h());
    }
}
