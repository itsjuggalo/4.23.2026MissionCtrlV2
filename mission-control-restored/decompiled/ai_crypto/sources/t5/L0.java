package t5;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class L0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final L0 f23483d = new L0(new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f23484a = new IdentityHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f23485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f23486c;

    public class a implements e {
        @Override // t5.L0.e
        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(S.j("grpc-shared-destroyer-%d", true));
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f23487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f23488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f23489c;

        public b(c cVar, d dVar, Object obj) {
            this.f23487a = cVar;
            this.f23488b = dVar;
            this.f23489c = obj;
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (L0.this) {
                try {
                    if (this.f23487a.f23492b == 0) {
                        try {
                            this.f23488b.b(this.f23489c);
                            L0.this.f23484a.remove(this.f23488b);
                            if (L0.this.f23484a.isEmpty()) {
                                L0.this.f23486c.shutdown();
                                L0.this.f23486c = null;
                            }
                        } catch (Throwable th) {
                            L0.this.f23484a.remove(this.f23488b);
                            if (L0.this.f23484a.isEmpty()) {
                                L0.this.f23486c.shutdown();
                                L0.this.f23486c = null;
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
        public final Object f23491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f23492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ScheduledFuture f23493c;

        public c(Object obj) {
            this.f23491a = obj;
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
        this.f23485b = eVar;
    }

    public static Object d(d dVar) {
        return f23483d.e(dVar);
    }

    public static Object f(d dVar, Object obj) {
        return f23483d.g(dVar, obj);
    }

    public synchronized Object e(d dVar) {
        c cVar;
        try {
            cVar = (c) this.f23484a.get(dVar);
            if (cVar == null) {
                cVar = new c(dVar.a());
                this.f23484a.put(dVar, cVar);
            }
            ScheduledFuture scheduledFuture = cVar.f23493c;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                cVar.f23493c = null;
            }
            cVar.f23492b++;
        } catch (Throwable th) {
            throw th;
        }
        return cVar.f23491a;
    }

    public synchronized Object g(d dVar, Object obj) {
        try {
            c cVar = (c) this.f23484a.get(dVar);
            if (cVar == null) {
                throw new IllegalArgumentException("No cached instance found for " + dVar);
            }
            H2.m.e(obj == cVar.f23491a, "Releasing the wrong instance");
            H2.m.u(cVar.f23492b > 0, "Refcount has already reached zero");
            int i7 = cVar.f23492b - 1;
            cVar.f23492b = i7;
            if (i7 == 0) {
                H2.m.u(cVar.f23493c == null, "Destroy task already scheduled");
                if (this.f23486c == null) {
                    this.f23486c = this.f23485b.a();
                }
                cVar.f23493c = this.f23486c.schedule(new RunnableC2672e0(new b(cVar, dVar, obj)), 1L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
        return null;
    }
}
