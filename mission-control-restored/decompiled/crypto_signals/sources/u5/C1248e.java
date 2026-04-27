package u5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: u5.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1248e extends G {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReentrantLock f10518h;
    public static final Condition i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f10519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f10520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static C1248e f10521l;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C1248e f10522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f10523g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f10518h = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.j.d(conditionNewCondition, "lock.newCondition()");
        i = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f10519j = millis;
        f10520k = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void f() {
        C1248e c1248e;
        long j4 = this.f10507c;
        boolean z6 = this.f10505a;
        if (j4 != 0 || z6) {
            ReentrantLock reentrantLock = f10518h;
            reentrantLock.lock();
            try {
                if (this.e) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.e = true;
                if (f10521l == null) {
                    f10521l = new C1248e();
                    F1.g gVar = new F1.g("Okio Watchdog");
                    gVar.setDaemon(true);
                    gVar.start();
                }
                long jNanoTime = System.nanoTime();
                if (j4 != 0 && z6) {
                    this.f10523g = Math.min(j4, c() - jNanoTime) + jNanoTime;
                } else if (j4 != 0) {
                    this.f10523g = j4 + jNanoTime;
                } else {
                    if (!z6) {
                        throw new AssertionError();
                    }
                    this.f10523g = c();
                }
                long j6 = this.f10523g - jNanoTime;
                C1248e c1248e2 = f10521l;
                kotlin.jvm.internal.j.b(c1248e2);
                while (true) {
                    c1248e = c1248e2.f10522f;
                    if (c1248e == null || j6 < c1248e.f10523g - jNanoTime) {
                        break;
                    } else {
                        c1248e2 = c1248e;
                    }
                }
                this.f10522f = c1248e;
                c1248e2.f10522f = this;
                if (c1248e2 == f10521l) {
                    i.signal();
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean g() {
        ReentrantLock reentrantLock = f10518h;
        reentrantLock.lock();
        try {
            if (!this.e) {
                return false;
            }
            this.e = false;
            C1248e c1248e = f10521l;
            while (c1248e != null) {
                C1248e c1248e2 = c1248e.f10522f;
                if (c1248e2 == this) {
                    c1248e.f10522f = this.f10522f;
                    this.f10522f = null;
                    return false;
                }
                c1248e = c1248e2;
            }
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void h() {
    }
}
