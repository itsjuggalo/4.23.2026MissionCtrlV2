package e8;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f8488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j8.q f8489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j8.h f8490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x8.a f8491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j8.n f8492e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f8492e.c0();
        }
    }

    public h(a7.g gVar, j8.q qVar, j8.h hVar) {
        this.f8488a = gVar;
        this.f8489b = qVar;
        this.f8490c = hVar;
    }

    public static h d(a7.g gVar) {
        String strD = gVar.r().d();
        if (strD == null) {
            if (gVar.r().g() == null) {
                throw new d("Failed to get FirebaseDatabase instance: Can't determine Firebase Database URL. Be sure to include a Project ID in your configuration.");
            }
            strD = "https://" + gVar.r().g() + "-default-rtdb.firebaseio.com";
        }
        return e(gVar, strD);
    }

    public static synchronized h e(a7.g gVar, String str) {
        i iVar;
        m8.h hVarH;
        if (TextUtils.isEmpty(str)) {
            throw new d("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
        }
        com.google.android.gms.common.internal.s.l(gVar, "Provided FirebaseApp must not be null.");
        iVar = (i) gVar.k(i.class);
        com.google.android.gms.common.internal.s.l(iVar, "Firebase Database component is not present.");
        hVarH = m8.m.h(str);
        if (!hVarH.f16099b.isEmpty()) {
            throw new d("Specified Database URL '" + str + "' is invalid. It should point to the root of a Firebase Database but it includes a path: " + hVarH.f16099b.toString());
        }
        return iVar.a(hVarH.f16098a);
    }

    public static String i() {
        return "22.0.1";
    }

    public final void b(String str) {
        if (this.f8492e == null) {
            return;
        }
        throw new d("Calls to " + str + "() must be made before any other usage of FirebaseDatabase instance.");
    }

    public final synchronized void c() {
        if (this.f8492e == null) {
            this.f8489b.a(this.f8491d);
            this.f8492e = j8.r.b(this.f8490c, this.f8489b, this);
        }
    }

    public e f() {
        c();
        return new e(this.f8492e, j8.l.G());
    }

    public e g(String str) {
        c();
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
        }
        m8.n.i(str);
        return new e(this.f8492e, new j8.l(str));
    }

    public e h(String str) {
        c();
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'url' in FirebaseDatabase.getReferenceFromUrl()");
        }
        m8.h hVarH = m8.m.h(str);
        hVarH.f16098a.a(this.f8491d);
        if (hVarH.f16098a.f14135a.equals(this.f8492e.O().f14135a)) {
            return new e(this.f8492e, hVarH.f16099b);
        }
        throw new d("Invalid URL (" + str + ") passed to getReference().  URL was expected to match configured Database URL: " + f());
    }

    public void j() {
        c();
        j8.r.c(this.f8492e);
    }

    public void k() {
        c();
        j8.r.d(this.f8492e);
    }

    public void l() {
        c();
        this.f8492e.k0(new a());
    }

    public synchronized void m(l lVar) {
        b("setLogLevel");
        this.f8490c.K(lVar);
    }

    public synchronized void n(long j10) {
        b("setPersistenceCacheSizeBytes");
        this.f8490c.L(j10);
    }

    public synchronized void o(boolean z10) {
        b("setPersistenceEnabled");
        this.f8490c.M(z10);
    }

    public void p(String str, int i10) {
        if (this.f8492e != null) {
            throw new IllegalStateException("Cannot call useEmulator() after instance has already been initialized.");
        }
        this.f8491d = new x8.a(str, i10);
    }
}
