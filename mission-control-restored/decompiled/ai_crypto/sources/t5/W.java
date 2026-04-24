package t5;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import t5.InterfaceC2700t;

/* JADX INFO: loaded from: classes2.dex */
public class W {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f23601g = Logger.getLogger(W.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f23602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H2.p f23603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f23604c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f23605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f23606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f23607f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2700t.a f23608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f23609b;

        public a(InterfaceC2700t.a aVar, long j7) {
            this.f23608a = aVar;
            this.f23609b = j7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f23608a.b(this.f23609b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2700t.a f23610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f23611b;

        public b(InterfaceC2700t.a aVar, Throwable th) {
            this.f23610a = aVar;
            this.f23611b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f23610a.a(this.f23611b);
        }
    }

    public W(long j7, H2.p pVar) {
        this.f23602a = j7;
        this.f23603b = pVar;
    }

    public static Runnable b(InterfaceC2700t.a aVar, long j7) {
        return new a(aVar, j7);
    }

    public static Runnable c(InterfaceC2700t.a aVar, Throwable th) {
        return new b(aVar, th);
    }

    public static void e(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            f23601g.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    public static void g(InterfaceC2700t.a aVar, Executor executor, Throwable th) {
        e(executor, c(aVar, th));
    }

    public void a(InterfaceC2700t.a aVar, Executor executor) {
        synchronized (this) {
            try {
                if (!this.f23605d) {
                    this.f23604c.put(aVar, executor);
                } else {
                    Throwable th = this.f23606e;
                    e(executor, th != null ? c(aVar, th) : b(aVar, this.f23607f));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean d() {
        synchronized (this) {
            try {
                if (this.f23605d) {
                    return false;
                }
                this.f23605d = true;
                long jD = this.f23603b.d(TimeUnit.NANOSECONDS);
                this.f23607f = jD;
                Map map = this.f23604c;
                this.f23604c = null;
                for (Map.Entry entry : map.entrySet()) {
                    e((Executor) entry.getValue(), b((InterfaceC2700t.a) entry.getKey(), jD));
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
                if (this.f23605d) {
                    return;
                }
                this.f23605d = true;
                this.f23606e = th;
                Map map = this.f23604c;
                this.f23604c = null;
                for (Map.Entry entry : map.entrySet()) {
                    g((InterfaceC2700t.a) entry.getKey(), (Executor) entry.getValue(), th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public long h() {
        return this.f23602a;
    }
}
