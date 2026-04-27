package G4;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public final class L0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final L0 f2520d = new L0(new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f2521a = new IdentityHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f2522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f2523c;

    public class a implements e {
        @Override // G4.L0.e
        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(S.j("grpc-shared-destroyer-%d", true));
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f2524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f2525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f2526c;

        public b(c cVar, d dVar, Object obj) {
            this.f2524a = cVar;
            this.f2525b = dVar;
            this.f2526c = obj;
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (L0.this) {
                try {
                    if (this.f2524a.f2529b == 0) {
                        try {
                            this.f2525b.b(this.f2526c);
                            L0.this.f2521a.remove(this.f2525b);
                            if (L0.this.f2521a.isEmpty()) {
                                L0.this.f2523c.shutdown();
                                L0.this.f2523c = null;
                            }
                        } catch (Throwable th) {
                            L0.this.f2521a.remove(this.f2525b);
                            if (L0.this.f2521a.isEmpty()) {
                                L0.this.f2523c.shutdown();
                                L0.this.f2523c = null;
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
        public final Object f2528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2529b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ScheduledFuture f2530c;

        public c(Object obj) {
            this.f2528a = obj;
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
        this.f2522b = eVar;
    }

    public static Object d(d dVar) {
        return f2520d.e(dVar);
    }

    public static Object f(d dVar, Object obj) {
        return f2520d.g(dVar, obj);
    }

    public synchronized Object e(d dVar) {
        c cVar;
        try {
            cVar = (c) this.f2521a.get(dVar);
            if (cVar == null) {
                cVar = new c(dVar.a());
                this.f2521a.put(dVar, cVar);
            }
            ScheduledFuture scheduledFuture = cVar.f2530c;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                cVar.f2530c = null;
            }
            cVar.f2529b++;
        } catch (Throwable th) {
            throw th;
        }
        return cVar.f2528a;
    }

    public synchronized Object g(d dVar, Object obj) {
        try {
            c cVar = (c) this.f2521a.get(dVar);
            if (cVar == null) {
                throw new IllegalArgumentException("No cached instance found for " + dVar);
            }
            AbstractC2848n.e(obj == cVar.f2528a, "Releasing the wrong instance");
            AbstractC2848n.u(cVar.f2529b > 0, "Refcount has already reached zero");
            int i8 = cVar.f2529b - 1;
            cVar.f2529b = i8;
            if (i8 == 0) {
                AbstractC2848n.u(cVar.f2530c == null, "Destroy task already scheduled");
                if (this.f2523c == null) {
                    this.f2523c = this.f2522b.a();
                }
                cVar.f2530c = this.f2523c.schedule(new RunnableC0525e0(new b(cVar, dVar, obj)), 1L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
        return null;
    }
}
