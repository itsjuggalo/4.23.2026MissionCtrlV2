package Q3;

import O3.p;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f4548d = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f4549e = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f4550a = p.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4552c;

    public static boolean c(int i7) {
        return i7 == 429 || (i7 >= 500 && i7 < 600);
    }

    public static boolean d(int i7) {
        return (i7 >= 200 && i7 < 300) || i7 == 401 || i7 == 404;
    }

    public final synchronized long a(int i7) {
        if (c(i7)) {
            return (long) Math.min(Math.pow(2.0d, this.f4552c) + this.f4550a.e(), f4549e);
        }
        return f4548d;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean b() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.f4552c     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L16
            O3.p r0 = r4.f4550a     // Catch: java.lang.Throwable -> L14
            long r0 = r0.a()     // Catch: java.lang.Throwable -> L14
            long r2 = r4.f4551b     // Catch: java.lang.Throwable -> L14
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L12
            goto L16
        L12:
            r0 = 0
            goto L17
        L14:
            r0 = move-exception
            goto L19
        L16:
            r0 = 1
        L17:
            monitor-exit(r4)
            return r0
        L19:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L14
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Q3.e.b():boolean");
    }

    public final synchronized void e() {
        this.f4552c = 0;
    }

    public synchronized void f(int i7) {
        if (d(i7)) {
            e();
            return;
        }
        this.f4552c++;
        this.f4551b = this.f4550a.a() + a(i7);
    }
}
