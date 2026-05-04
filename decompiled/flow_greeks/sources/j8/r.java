package j8;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f14139b = new r();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f14140a = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f14141a;

        public a(n nVar) {
            this.f14141a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14141a.R();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f14142a;

        public b(n nVar) {
            this.f14142a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14142a.h0();
        }
    }

    public static n b(g gVar, q qVar, e8.h hVar) {
        return f14139b.a(gVar, qVar, hVar);
    }

    public static void c(n nVar) {
        nVar.k0(new a(nVar));
    }

    public static void d(n nVar) {
        nVar.k0(new b(nVar));
    }

    public final n a(g gVar, q qVar, e8.h hVar) {
        n nVar;
        gVar.k();
        String str = "https://" + qVar.f14135a + "/" + qVar.f14137c;
        synchronized (this.f14140a) {
            try {
                if (!this.f14140a.containsKey(gVar)) {
                    this.f14140a.put(gVar, new HashMap());
                }
                Map map = (Map) this.f14140a.get(gVar);
                if (map.containsKey(str)) {
                    throw new IllegalStateException("createLocalRepo() called for existing repo.");
                }
                nVar = new n(qVar, gVar, hVar);
                map.put(str, nVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }
}
