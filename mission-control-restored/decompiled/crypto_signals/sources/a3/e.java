package a3;

import N1.C0149z;
import Y2.k;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f4064d = TimeUnit.HOURS.toMillis(24);
    public static final long e = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f4065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4067c;

    public e() {
        if (C0149z.f1892r == null) {
            Pattern pattern = k.f3614c;
            C0149z.f1892r = new C0149z(20);
        }
        C0149z c0149z = C0149z.f1892r;
        if (k.f3615d == null) {
            k.f3615d = new k(c0149z);
        }
        this.f4065a = k.f3615d;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean a() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.f4067c     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1b
            Y2.k r0 = r4.f4065a     // Catch: java.lang.Throwable -> L19
            N1.z r0 = r0.f3616a     // Catch: java.lang.Throwable -> L19
            r0.getClass()     // Catch: java.lang.Throwable -> L19
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L19
            long r2 = r4.f4066b     // Catch: java.lang.Throwable -> L19
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L17
            goto L1b
        L17:
            r0 = 0
            goto L1c
        L19:
            r0 = move-exception
            goto L1e
        L1b:
            r0 = 1
        L1c:
            monitor-exit(r4)
            return r0
        L1e:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L19
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.e.a():boolean");
    }

    public final synchronized void b(int i) {
        long jMin;
        if ((i >= 200 && i < 300) || i == 401 || i == 404) {
            synchronized (this) {
                this.f4067c = 0;
            }
            return;
        }
        this.f4067c++;
        synchronized (this) {
            if (i == 429 || (i >= 500 && i < 600)) {
                double dPow = Math.pow(2.0d, this.f4067c);
                this.f4065a.getClass();
                jMin = (long) Math.min(dPow + ((long) (Math.random() * 1000.0d)), e);
            } else {
                jMin = f4064d;
            }
            this.f4065a.f3616a.getClass();
            this.f4066b = System.currentTimeMillis() + jMin;
        }
        return;
    }
}
