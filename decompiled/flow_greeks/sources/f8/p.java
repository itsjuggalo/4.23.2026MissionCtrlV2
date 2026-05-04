package f8;

import a7.g;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import h8.h;
import j8.s;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import q8.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p implements j8.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f9389b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a7.g f9390c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends m8.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q8.c f9391b;

        /* JADX INFO: renamed from: f8.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class RunnableC0173a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f9393a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Throwable f9394b;

            public RunnableC0173a(String str, Throwable th) {
                this.f9393a = str;
                this.f9394b = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new RuntimeException(this.f9393a, this.f9394b);
            }
        }

        public a(q8.c cVar) {
            this.f9391b = cVar;
        }

        @Override // m8.c
        public void g(Throwable th) {
            String strH = m8.c.h(th);
            this.f9391b.c(strH, th);
            new Handler(p.this.f9388a.getMainLooper()).post(new RunnableC0173a(strH, th));
            d().shutdownNow();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h8.h f9396a;

        public b(h8.h hVar) {
            this.f9396a = hVar;
        }

        @Override // a7.g.a
        public void a(boolean z10) {
            if (z10) {
                this.f9396a.f("app_in_background");
            } else {
                this.f9396a.h("app_in_background");
            }
        }
    }

    public p(a7.g gVar) {
        this.f9390c = gVar;
        if (gVar != null) {
            this.f9388a = gVar.m();
            return;
        }
        Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Log.e("FirebaseDatabase", "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
        Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
    }

    @Override // j8.m
    public j8.k a(j8.g gVar) {
        return new o();
    }

    @Override // j8.m
    public File b() {
        return this.f9388a.getApplicationContext().getDir("sslcache", 0);
    }

    @Override // j8.m
    public h8.h c(j8.g gVar, h8.c cVar, h8.f fVar, h.a aVar) {
        h8.n nVar = new h8.n(cVar, fVar, aVar);
        this.f9390c.g(new b(nVar));
        return nVar;
    }

    @Override // j8.m
    public l8.e d(j8.g gVar, String str) {
        String strX = gVar.x();
        String str2 = str + "_" + strX;
        if (!this.f9389b.contains(str2)) {
            this.f9389b.add(str2);
            return new l8.b(gVar, new q(this.f9388a, gVar, str2), new l8.c(gVar.s()));
        }
        throw new e8.d("SessionPersistenceKey '" + strX + "' has already been used.");
    }

    @Override // j8.m
    public s e(j8.g gVar) {
        return new a(gVar.q("RunLoop"));
    }

    @Override // j8.m
    public String f(j8.g gVar) {
        return Build.VERSION.SDK_INT + "/Android";
    }

    @Override // j8.m
    public q8.d g(j8.g gVar, d.a aVar, List list) {
        return new q8.a(aVar, list);
    }
}
