package c3;

import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1294n;
import h3.C1871g;
import h3.C1875k;
import h3.C1877m;
import k3.AbstractC2279m;
import k3.AbstractC2280n;
import k3.C2274h;
import v3.C2860a;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G2.f f13369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h3.p f13370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1871g f13371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C2860a f13372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C1877m f13373e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f13373e.a0();
        }
    }

    public h(G2.f fVar, h3.p pVar, C1871g c1871g) {
        this.f13369a = fVar;
        this.f13370b = pVar;
        this.f13371c = c1871g;
    }

    public static h d(G2.f fVar) {
        String strD = fVar.r().d();
        if (strD == null) {
            if (fVar.r().g() == null) {
                throw new d("Failed to get FirebaseDatabase instance: Can't determine Firebase Database URL. Be sure to include a Project ID in your configuration.");
            }
            strD = "https://" + fVar.r().g() + "-default-rtdb.firebaseio.com";
        }
        return e(fVar, strD);
    }

    public static synchronized h e(G2.f fVar, String str) {
        i iVar;
        C2274h c2274hH;
        if (TextUtils.isEmpty(str)) {
            throw new d("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
        }
        AbstractC1294n.k(fVar, "Provided FirebaseApp must not be null.");
        iVar = (i) fVar.k(i.class);
        AbstractC1294n.k(iVar, "Firebase Database component is not present.");
        c2274hH = AbstractC2279m.h(str);
        if (!c2274hH.f20374b.isEmpty()) {
            throw new d("Specified Database URL '" + str + "' is invalid. It should point to the root of a Firebase Database but it includes a path: " + c2274hH.f20374b.toString());
        }
        return iVar.a(c2274hH.f20373a);
    }

    public static String g() {
        return "22.0.0";
    }

    public final void b(String str) {
        if (this.f13373e == null) {
            return;
        }
        throw new d("Calls to " + str + "() must be made before any other usage of FirebaseDatabase instance.");
    }

    public final synchronized void c() {
        if (this.f13373e == null) {
            this.f13370b.a(this.f13372d);
            this.f13373e = h3.q.b(this.f13371c, this.f13370b, this);
        }
    }

    public e f(String str) {
        c();
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
        }
        AbstractC2280n.i(str);
        return new e(this.f13373e, new C1875k(str));
    }

    public void h() {
        c();
        h3.q.c(this.f13373e);
    }

    public void i() {
        c();
        h3.q.d(this.f13373e);
    }

    public void j() {
        c();
        this.f13373e.i0(new a());
    }

    public synchronized void k(l lVar) {
        b("setLogLevel");
        this.f13371c.L(lVar);
    }

    public synchronized void l(long j8) {
        b("setPersistenceCacheSizeBytes");
        this.f13371c.M(j8);
    }

    public synchronized void m(boolean z7) {
        b("setPersistenceEnabled");
        this.f13371c.N(z7);
    }

    public void n(String str, int i8) {
        if (this.f13373e != null) {
            throw new IllegalStateException("Cannot call useEmulator() after instance has already been initialized.");
        }
        this.f13372d = new C2860a(str, i8);
    }
}
