package tb;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import tb.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class v0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f21779g = Logger.getLogger(v0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6.q f21781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f21782c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f21784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f21785f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t.a f21786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f21787b;

        public a(t.a aVar, long j10) {
            this.f21786a = aVar;
            this.f21787b = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21786a.a(this.f21787b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t.a f21788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f21789b;

        public b(t.a aVar, Throwable th) {
            this.f21788a = aVar;
            this.f21789b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21788a.onFailure(this.f21789b);
        }
    }

    public v0(long j10, p6.q qVar) {
        this.f21780a = j10;
        this.f21781b = qVar;
    }

    public static Runnable b(t.a aVar, long j10) {
        return new a(aVar, j10);
    }

    public static Runnable c(t.a aVar, Throwable th) {
        return new b(aVar, th);
    }

    public static void e(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            f21779g.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    public static void g(t.a aVar, Executor executor, Throwable th) {
        e(executor, c(aVar, th));
    }

    public void a(t.a aVar, Executor executor) {
        synchronized (this) {
            try {
                if (!this.f21783d) {
                    this.f21782c.put(aVar, executor);
                } else {
                    Throwable th = this.f21784e;
                    e(executor, th != null ? c(aVar, th) : b(aVar, this.f21785f));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean d() {
        synchronized (this) {
            try {
                if (this.f21783d) {
                    return false;
                }
                this.f21783d = true;
                long jD = this.f21781b.d(TimeUnit.NANOSECONDS);
                this.f21785f = jD;
                Map map = this.f21782c;
                this.f21782c = null;
                for (Map.Entry entry : map.entrySet()) {
                    e((Executor) entry.getValue(), b((t.a) entry.getKey(), jD));
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
                if (this.f21783d) {
                    return;
                }
                this.f21783d = true;
                this.f21784e = th;
                Map map = this.f21782c;
                this.f21782c = null;
                for (Map.Entry entry : map.entrySet()) {
                    g((t.a) entry.getKey(), (Executor) entry.getValue(), th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public long h() {
        return this.f21780a;
    }
}
