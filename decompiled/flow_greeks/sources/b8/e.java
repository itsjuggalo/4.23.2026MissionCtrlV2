package b8;

import android.os.SystemClock;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import i4.f;
import i4.i;
import i4.k;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l4.l;
import r7.g;
import u7.m0;
import u7.u0;
import u7.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f3019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f3020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BlockingQueue f3024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f3025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f3026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m0 f3027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f3029k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f3030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TaskCompletionSource f3031b;

        @Override // java.lang.Runnable
        public void run() {
            e.this.n(this.f3030a, this.f3031b);
            e.this.f3027i.c();
            double dG = e.this.g();
            g.f().b("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(dG / 1000.0d)) + " s for report: " + this.f3030a.d());
            e.o(dG);
        }

        public b(z zVar, TaskCompletionSource taskCompletionSource) {
            this.f3030a = zVar;
            this.f3031b = taskCompletionSource;
        }
    }

    public e(i iVar, c8.d dVar, m0 m0Var) {
        this(dVar.f3716f, dVar.f3717g, ((long) dVar.f3718h) * 1000, iVar, m0Var);
    }

    public static /* synthetic */ void a(e eVar, TaskCompletionSource taskCompletionSource, boolean z10, z zVar, Exception exc) {
        eVar.getClass();
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
            return;
        }
        if (z10) {
            eVar.j();
        }
        taskCompletionSource.trySetResult(zVar);
    }

    public static /* synthetic */ void b(e eVar, CountDownLatch countDownLatch) {
        eVar.getClass();
        try {
            l.a(eVar.f3026h, f.HIGHEST);
        } catch (Exception unused) {
        }
        countDownLatch.countDown();
    }

    public static void o(double d10) {
        try {
            Thread.sleep((long) d10);
        } catch (InterruptedException unused) {
        }
    }

    public final double g() {
        return Math.min(3600000.0d, (60000.0d / this.f3019a) * Math.pow(this.f3020b, h()));
    }

    public final int h() {
        if (this.f3029k == 0) {
            this.f3029k = m();
        }
        int iM = (int) ((m() - this.f3029k) / this.f3021c);
        int iMin = l() ? Math.min(100, this.f3028j + iM) : Math.max(0, this.f3028j - iM);
        if (this.f3028j != iMin) {
            this.f3028j = iMin;
            this.f3029k = m();
        }
        return iMin;
    }

    public TaskCompletionSource i(z zVar, boolean z10) {
        synchronized (this.f3024f) {
            try {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                if (!z10) {
                    n(zVar, taskCompletionSource);
                    return taskCompletionSource;
                }
                this.f3027i.b();
                if (!k()) {
                    h();
                    g.f().b("Dropping report due to queue being full: " + zVar.d());
                    this.f3027i.a();
                    taskCompletionSource.trySetResult(zVar);
                    return taskCompletionSource;
                }
                g.f().b("Enqueueing report: " + zVar.d());
                g.f().b("Queue size: " + this.f3024f.size());
                this.f3025g.execute(new b(zVar, taskCompletionSource));
                g.f().b("Closing task for report: " + zVar.d());
                taskCompletionSource.trySetResult(zVar);
                return taskCompletionSource;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: b8.d
            @Override // java.lang.Runnable
            public final void run() {
                e.b(this.f3017a, countDownLatch);
            }
        }).start();
        u0.c(countDownLatch, 2L, TimeUnit.SECONDS);
    }

    public final boolean k() {
        return this.f3024f.size() < this.f3023e;
    }

    public final boolean l() {
        return this.f3024f.size() == this.f3023e;
    }

    public final long m() {
        return System.currentTimeMillis();
    }

    public final void n(final z zVar, final TaskCompletionSource taskCompletionSource) {
        g.f().b("Sending report through Google DataTransport: " + zVar.d());
        final boolean z10 = SystemClock.elapsedRealtime() - this.f3022d < HTTPTimeoutManager.REDUCED_TIMEOUT_MS;
        this.f3026h.b(i4.d.h(zVar.b()), new k() { // from class: b8.c
            @Override // i4.k
            public final void a(Exception exc) {
                e.a(this.f3013a, taskCompletionSource, z10, zVar, exc);
            }
        });
    }

    public e(double d10, double d11, long j10, i iVar, m0 m0Var) {
        this.f3019a = d10;
        this.f3020b = d11;
        this.f3021c = j10;
        this.f3026h = iVar;
        this.f3027i = m0Var;
        this.f3022d = SystemClock.elapsedRealtime();
        int i10 = (int) d10;
        this.f3023e = i10;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i10);
        this.f3024f = arrayBlockingQueue;
        this.f3025g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f3028j = 0;
        this.f3029k = 0L;
    }
}
