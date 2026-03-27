package M2;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class L0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final L0 f1932d = new L0(new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f1933a = new IdentityHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f1934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f1935c;

    public class a implements e {
        @Override // M2.L0.e
        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(S.j("grpc-shared-destroyer-%d", true));
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f1936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f1937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f1938c;

        public b(c cVar, d dVar, Object obj) {
            this.f1936a = cVar;
            this.f1937b = dVar;
            this.f1938c = obj;
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (L0.this) {
                try {
                    if (this.f1936a.f1941b == 0) {
                        try {
                            this.f1937b.b(this.f1938c);
                            L0.this.f1933a.remove(this.f1937b);
                            if (L0.this.f1933a.isEmpty()) {
                                L0.this.f1935c.shutdown();
                                L0.this.f1935c = null;
                            }
                        } catch (Throwable th) {
                            L0.this.f1933a.remove(this.f1937b);
                            if (L0.this.f1933a.isEmpty()) {
                                L0.this.f1935c.shutdown();
                                L0.this.f1935c = null;
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

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f1940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ScheduledFuture f1942c;

        public c(Object obj) {
            this.f1940a = obj;
        }
    }

    public interface d {
        Object a();

        void b(Object obj);
    }

    public interface e {
        ScheduledExecutorService a();
    }

    public L0(e eVar) {
        this.f1934b = eVar;
    }

    public static Object d(d dVar) {
        return f1932d.e(dVar);
    }

    public static Object f(d dVar, Object obj) {
        return f1932d.g(dVar, obj);
    }

    public synchronized Object e(d dVar) {
        c cVar;
        try {
            cVar = (c) this.f1933a.get(dVar);
            if (cVar == null) {
                cVar = new c(dVar.a());
                this.f1933a.put(dVar, cVar);
            }
            ScheduledFuture scheduledFuture = cVar.f1942c;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                cVar.f1942c = null;
            }
            cVar.f1941b++;
        } catch (Throwable th) {
            throw th;
        }
        return cVar.f1940a;
    }

    public synchronized Object g(d dVar, Object obj) {
        try {
            c cVar = (c) this.f1933a.get(dVar);
            if (cVar == null) {
                throw new IllegalArgumentException("No cached instance found for " + dVar);
            }
            Z1.m.e(obj == cVar.f1940a, "Releasing the wrong instance");
            Z1.m.u(cVar.f1941b > 0, "Refcount has already reached zero");
            int i4 = cVar.f1941b - 1;
            cVar.f1941b = i4;
            if (i4 == 0) {
                Z1.m.u(cVar.f1942c == null, "Destroy task already scheduled");
                if (this.f1935c == null) {
                    this.f1935c = this.f1934b.a();
                }
                cVar.f1942c = this.f1935c.schedule(new RunnableC0417e0(new b(cVar, dVar, obj)), 1L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
        return null;
    }
}
