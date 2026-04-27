package M2;

import M2.InterfaceC0445t;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class W {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f2050g = Logger.getLogger(W.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Z1.p f2052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f2053c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f2055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2056f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0445t.a f2057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f2058b;

        public a(InterfaceC0445t.a aVar, long j4) {
            this.f2057a = aVar;
            this.f2058b = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2057a.b(this.f2058b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0445t.a f2059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f2060b;

        public b(InterfaceC0445t.a aVar, Throwable th) {
            this.f2059a = aVar;
            this.f2060b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2059a.a(this.f2060b);
        }
    }

    public W(long j4, Z1.p pVar) {
        this.f2051a = j4;
        this.f2052b = pVar;
    }

    public static Runnable b(InterfaceC0445t.a aVar, long j4) {
        return new a(aVar, j4);
    }

    public static Runnable c(InterfaceC0445t.a aVar, Throwable th) {
        return new b(aVar, th);
    }

    public static void e(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            f2050g.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    public static void g(InterfaceC0445t.a aVar, Executor executor, Throwable th) {
        e(executor, c(aVar, th));
    }

    public void a(InterfaceC0445t.a aVar, Executor executor) {
        synchronized (this) {
            try {
                if (!this.f2054d) {
                    this.f2053c.put(aVar, executor);
                } else {
                    Throwable th = this.f2055e;
                    e(executor, th != null ? c(aVar, th) : b(aVar, this.f2056f));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean d() {
        synchronized (this) {
            try {
                if (this.f2054d) {
                    return false;
                }
                this.f2054d = true;
                long jD = this.f2052b.d(TimeUnit.NANOSECONDS);
                this.f2056f = jD;
                Map map = this.f2053c;
                this.f2053c = null;
                for (Map.Entry entry : map.entrySet()) {
                    e((Executor) entry.getValue(), b((InterfaceC0445t.a) entry.getKey(), jD));
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
                if (this.f2054d) {
                    return;
                }
                this.f2054d = true;
                this.f2055e = th;
                Map map = this.f2053c;
                this.f2053c = null;
                for (Map.Entry entry : map.entrySet()) {
                    g((InterfaceC0445t.a) entry.getKey(), (Executor) entry.getValue(), th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public long h() {
        return this.f2051a;
    }
}
