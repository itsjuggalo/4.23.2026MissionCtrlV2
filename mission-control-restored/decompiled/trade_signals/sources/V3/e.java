package V3;

import T3.p;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f8940d = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f8941e = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f8942a = p.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8944c;

    public static boolean c(int i8) {
        return i8 == 429 || (i8 >= 500 && i8 < 600);
    }

    public static boolean d(int i8) {
        return (i8 >= 200 && i8 < 300) || i8 == 401 || i8 == 404;
    }

    public final synchronized long a(int i8) {
        if (c(i8)) {
            return (long) Math.min(Math.pow(2.0d, this.f8944c) + this.f8942a.e(), f8941e);
        }
        return f8940d;
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
            int r0 = r4.f8944c     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L16
            T3.p r0 = r4.f8942a     // Catch: java.lang.Throwable -> L14
            long r0 = r0.a()     // Catch: java.lang.Throwable -> L14
            long r2 = r4.f8943b     // Catch: java.lang.Throwable -> L14
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
        throw new UnsupportedOperationException("Method not decompiled: V3.e.b():boolean");
    }

    public final synchronized void e() {
        this.f8944c = 0;
    }

    public synchronized void f(int i8) {
        if (d(i8)) {
            e();
            return;
        }
        this.f8944c++;
        this.f8943b = this.f8942a.a() + a(i8);
    }
}
