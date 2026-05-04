package tb;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k2 f21457d = new k2(new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f21458a = new IdentityHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f21459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f21460c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements e {
        @Override // tb.k2.e
        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(r0.j("grpc-shared-destroyer-%d", true));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f21461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f21462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f21463c;

        public b(c cVar, d dVar, Object obj) {
            this.f21461a = cVar;
            this.f21462b = dVar;
            this.f21463c = obj;
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (k2.this) {
                try {
                    if (this.f21461a.f21466b == 0) {
                        try {
                            this.f21462b.b(this.f21463c);
                            k2.this.f21458a.remove(this.f21462b);
                            if (k2.this.f21458a.isEmpty()) {
                                k2.this.f21460c.shutdown();
                                k2.this.f21460c = null;
                            }
                        } catch (Throwable th) {
                            k2.this.f21458a.remove(this.f21462b);
                            if (k2.this.f21458a.isEmpty()) {
                                k2.this.f21460c.shutdown();
                                k2.this.f21460c = null;
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f21465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ScheduledFuture f21467c;

        public c(Object obj) {
            this.f21465a = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        Object a();

        void b(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface e {
        ScheduledExecutorService a();
    }

    public k2(e eVar) {
        this.f21459b = eVar;
    }

    public static Object d(d dVar) {
        return f21457d.e(dVar);
    }

    public static Object f(d dVar, Object obj) {
        return f21457d.g(dVar, obj);
    }

    public synchronized Object e(d dVar) {
        c cVar;
        try {
            cVar = (c) this.f21458a.get(dVar);
            if (cVar == null) {
                cVar = new c(dVar.a());
                this.f21458a.put(dVar, cVar);
            }
            ScheduledFuture scheduledFuture = cVar.f21467c;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                cVar.f21467c = null;
            }
            cVar.f21466b++;
        } catch (Throwable th) {
            throw th;
        }
        return cVar.f21465a;
    }

    public synchronized Object g(d dVar, Object obj) {
        try {
            c cVar = (c) this.f21458a.get(dVar);
            if (cVar == null) {
                throw new IllegalArgumentException("No cached instance found for " + dVar);
            }
            p6.n.e(obj == cVar.f21465a, "Releasing the wrong instance");
            p6.n.u(cVar.f21466b > 0, "Refcount has already reached zero");
            int i10 = cVar.f21466b - 1;
            cVar.f21466b = i10;
            if (i10 == 0) {
                p6.n.u(cVar.f21467c == null, "Destroy task already scheduled");
                if (this.f21460c == null) {
                    this.f21460c = this.f21459b.a();
                }
                cVar.f21467c = this.f21460c.schedule(new d1(new b(cVar, dVar, obj)), 1L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
        return null;
    }
}
