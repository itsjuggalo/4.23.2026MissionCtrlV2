package G4;

import G4.InterfaceC0553t;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import v2.C2851q;

/* JADX INFO: loaded from: classes2.dex */
public class W {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f2638g = Logger.getLogger(W.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2851q f2640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f2641c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f2643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2644f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0553t.a f2645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f2646b;

        public a(InterfaceC0553t.a aVar, long j8) {
            this.f2645a = aVar;
            this.f2646b = j8;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2645a.a(this.f2646b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0553t.a f2647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f2648b;

        public b(InterfaceC0553t.a aVar, Throwable th) {
            this.f2647a = aVar;
            this.f2648b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2647a.onFailure(this.f2648b);
        }
    }

    public W(long j8, C2851q c2851q) {
        this.f2639a = j8;
        this.f2640b = c2851q;
    }

    public static Runnable b(InterfaceC0553t.a aVar, long j8) {
        return new a(aVar, j8);
    }

    public static Runnable c(InterfaceC0553t.a aVar, Throwable th) {
        return new b(aVar, th);
    }

    public static void e(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            f2638g.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    public static void g(InterfaceC0553t.a aVar, Executor executor, Throwable th) {
        e(executor, c(aVar, th));
    }

    public void a(InterfaceC0553t.a aVar, Executor executor) {
        synchronized (this) {
            try {
                if (!this.f2642d) {
                    this.f2641c.put(aVar, executor);
                } else {
                    Throwable th = this.f2643e;
                    e(executor, th != null ? c(aVar, th) : b(aVar, this.f2644f));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean d() {
        synchronized (this) {
            try {
                if (this.f2642d) {
                    return false;
                }
                this.f2642d = true;
                long jD = this.f2640b.d(TimeUnit.NANOSECONDS);
                this.f2644f = jD;
                Map map = this.f2641c;
                this.f2641c = null;
                for (Map.Entry entry : map.entrySet()) {
                    e((Executor) entry.getValue(), b((InterfaceC0553t.a) entry.getKey(), jD));
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(Throwable th) {
        synchronized (this) {
            try {
                if (this.f2642d) {
                    return;
                }
                this.f2642d = true;
                this.f2643e = th;
                Map map = this.f2641c;
                this.f2641c = null;
                for (Map.Entry entry : map.entrySet()) {
                    g((InterfaceC0553t.a) entry.getKey(), (Executor) entry.getValue(), th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public long h() {
        return this.f2639a;
    }
}
