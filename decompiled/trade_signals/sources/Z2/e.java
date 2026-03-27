package Z2;

import P2.g;
import S2.B;
import S2.O;
import S2.g0;
import a3.C1067d;
import android.os.SystemClock;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l2.C2329m;
import w1.AbstractC2901d;
import w1.EnumC2903f;
import w1.InterfaceC2906i;
import w1.InterfaceC2908k;
import z1.l;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f9741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f9742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BlockingQueue f9746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f9747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InterfaceC2906i f9748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final O f9749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f9751k;

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final B f9752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C2329m f9753b;

        public b(B b8, C2329m c2329m) {
            this.f9752a = b8;
            this.f9753b = c2329m;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.p(this.f9752a, this.f9753b);
            e.this.f9749i.c();
            double dG = e.this.g();
            g.f().b("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(dG / 1000.0d)) + " s for report: " + this.f9752a.d());
            e.q(dG);
        }
    }

    public e(double d8, double d9, long j8, InterfaceC2906i interfaceC2906i, O o8) {
        this.f9741a = d8;
        this.f9742b = d9;
        this.f9743c = j8;
        this.f9748h = interfaceC2906i;
        this.f9749i = o8;
        this.f9744d = SystemClock.elapsedRealtime();
        int i8 = (int) d8;
        this.f9745e = i8;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i8);
        this.f9746f = arrayBlockingQueue;
        this.f9747g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f9750j = 0;
        this.f9751k = 0L;
    }

    public static void q(double d8) {
        try {
            Thread.sleep((long) d8);
        } catch (InterruptedException unused) {
        }
    }

    public final double g() {
        return Math.min(3600000.0d, (60000.0d / this.f9741a) * Math.pow(this.f9742b, h()));
    }

    public final int h() {
        if (this.f9751k == 0) {
            this.f9751k = o();
        }
        int iO = (int) ((o() - this.f9751k) / this.f9743c);
        int iMin = l() ? Math.min(100, this.f9750j + iO) : Math.max(0, this.f9750j - iO);
        if (this.f9750j != iMin) {
            this.f9750j = iMin;
            this.f9751k = o();
        }
        return iMin;
    }

    public C2329m i(B b8, boolean z7) {
        synchronized (this.f9746f) {
            try {
                C2329m c2329m = new C2329m();
                if (!z7) {
                    p(b8, c2329m);
                    return c2329m;
                }
                this.f9749i.b();
                if (!k()) {
                    h();
                    g.f().b("Dropping report due to queue being full: " + b8.d());
                    this.f9749i.a();
                    c2329m.e(b8);
                    return c2329m;
                }
                g.f().b("Enqueueing report: " + b8.d());
                g.f().b("Queue size: " + this.f9746f.size());
                this.f9747g.execute(new b(b8, c2329m));
                g.f().b("Closing task for report: " + b8.d());
                c2329m.e(b8);
                return c2329m;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: Z2.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f9739a.m(countDownLatch);
            }
        }).start();
        g0.c(countDownLatch, 2L, TimeUnit.SECONDS);
    }

    public final boolean k() {
        return this.f9746f.size() < this.f9745e;
    }

    public final boolean l() {
        return this.f9746f.size() == this.f9745e;
    }

    public final /* synthetic */ void m(CountDownLatch countDownLatch) {
        try {
            l.a(this.f9748h, EnumC2903f.HIGHEST);
        } catch (Exception unused) {
        }
        countDownLatch.countDown();
    }

    public final /* synthetic */ void n(C2329m c2329m, boolean z7, B b8, Exception exc) {
        if (exc != null) {
            c2329m.d(exc);
            return;
        }
        if (z7) {
            j();
        }
        c2329m.e(b8);
    }

    public final long o() {
        return System.currentTimeMillis();
    }

    public final void p(final B b8, final C2329m c2329m) {
        g.f().b("Sending report through Google DataTransport: " + b8.d());
        final boolean z7 = SystemClock.elapsedRealtime() - this.f9744d < 2000;
        this.f9748h.a(AbstractC2901d.h(b8.b()), new InterfaceC2908k() { // from class: Z2.c
            @Override // w1.InterfaceC2908k
            public final void a(Exception exc) {
                this.f9735a.n(c2329m, z7, b8, exc);
            }
        });
    }

    public e(InterfaceC2906i interfaceC2906i, C1067d c1067d, O o8) {
        this(c1067d.f9923f, c1067d.f9924g, ((long) c1067d.f9925h) * 1000, interfaceC2906i, o8);
    }
}
