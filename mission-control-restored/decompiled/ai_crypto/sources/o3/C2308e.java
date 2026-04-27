package o3;

import android.os.SystemClock;
import com.google.android.gms.tasks.TaskCompletionSource;
import e3.C1478g;
import h3.AbstractC1675F;
import h3.T;
import h3.k0;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import o1.AbstractC2292d;
import o1.EnumC2294f;
import o1.InterfaceC2297i;
import o1.InterfaceC2299k;
import p3.C2375d;
import r1.l;

/* JADX INFO: renamed from: o3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2308e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f20043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f20044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f20046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f20047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BlockingQueue f20048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f20049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InterfaceC2297i f20050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final T f20051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f20053k;

    /* JADX INFO: renamed from: o3.e$b */
    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC1675F f20054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TaskCompletionSource f20055b;

        @Override // java.lang.Runnable
        public void run() {
            C2308e.this.p(this.f20054a, this.f20055b);
            C2308e.this.f20051i.e();
            double dG = C2308e.this.g();
            C1478g.f().b("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(dG / 1000.0d)) + " s for report: " + this.f20054a.d());
            C2308e.q(dG);
        }

        public b(AbstractC1675F abstractC1675F, TaskCompletionSource taskCompletionSource) {
            this.f20054a = abstractC1675F;
            this.f20055b = taskCompletionSource;
        }
    }

    public C2308e(InterfaceC2297i interfaceC2297i, C2375d c2375d, T t7) {
        this(c2375d.f21505f, c2375d.f21506g, ((long) c2375d.f21507h) * 1000, interfaceC2297i, t7);
    }

    public static void q(double d7) {
        try {
            Thread.sleep((long) d7);
        } catch (InterruptedException unused) {
        }
    }

    public final double g() {
        return Math.min(3600000.0d, (60000.0d / this.f20043a) * Math.pow(this.f20044b, h()));
    }

    public final int h() {
        if (this.f20053k == 0) {
            this.f20053k = o();
        }
        int iO = (int) ((o() - this.f20053k) / this.f20045c);
        int iMin = l() ? Math.min(100, this.f20052j + iO) : Math.max(0, this.f20052j - iO);
        if (this.f20052j != iMin) {
            this.f20052j = iMin;
            this.f20053k = o();
        }
        return iMin;
    }

    public TaskCompletionSource i(AbstractC1675F abstractC1675F, boolean z7) {
        synchronized (this.f20048f) {
            try {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                if (!z7) {
                    p(abstractC1675F, taskCompletionSource);
                    return taskCompletionSource;
                }
                this.f20051i.d();
                if (!k()) {
                    h();
                    C1478g.f().b("Dropping report due to queue being full: " + abstractC1675F.d());
                    this.f20051i.c();
                    taskCompletionSource.trySetResult(abstractC1675F);
                    return taskCompletionSource;
                }
                C1478g.f().b("Enqueueing report: " + abstractC1675F.d());
                C1478g.f().b("Queue size: " + this.f20048f.size());
                this.f20049g.execute(new b(abstractC1675F, taskCompletionSource));
                C1478g.f().b("Closing task for report: " + abstractC1675F.d());
                taskCompletionSource.trySetResult(abstractC1675F);
                return taskCompletionSource;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: o3.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f20041a.m(countDownLatch);
            }
        }).start();
        k0.c(countDownLatch, 2L, TimeUnit.SECONDS);
    }

    public final boolean k() {
        return this.f20048f.size() < this.f20047e;
    }

    public final boolean l() {
        return this.f20048f.size() == this.f20047e;
    }

    public final /* synthetic */ void m(CountDownLatch countDownLatch) {
        try {
            l.a(this.f20050h, EnumC2294f.HIGHEST);
        } catch (Exception unused) {
        }
        countDownLatch.countDown();
    }

    public final /* synthetic */ void n(TaskCompletionSource taskCompletionSource, boolean z7, AbstractC1675F abstractC1675F, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
            return;
        }
        if (z7) {
            j();
        }
        taskCompletionSource.trySetResult(abstractC1675F);
    }

    public final long o() {
        return System.currentTimeMillis();
    }

    public final void p(final AbstractC1675F abstractC1675F, final TaskCompletionSource taskCompletionSource) {
        C1478g.f().b("Sending report through Google DataTransport: " + abstractC1675F.d());
        final boolean z7 = SystemClock.elapsedRealtime() - this.f20046d < 2000;
        this.f20050h.b(AbstractC2292d.h(abstractC1675F.b()), new InterfaceC2299k() { // from class: o3.c
            @Override // o1.InterfaceC2299k
            public final void a(Exception exc) {
                this.f20037a.n(taskCompletionSource, z7, abstractC1675F, exc);
            }
        });
    }

    public C2308e(double d7, double d8, long j7, InterfaceC2297i interfaceC2297i, T t7) {
        this.f20043a = d7;
        this.f20044b = d8;
        this.f20045c = j7;
        this.f20050h = interfaceC2297i;
        this.f20051i = t7;
        this.f20046d = SystemClock.elapsedRealtime();
        int i7 = (int) d7;
        this.f20047e = i7;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i7);
        this.f20048f = arrayBlockingQueue;
        this.f20049g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f20052j = 0;
        this.f20053k = 0L;
    }
}
