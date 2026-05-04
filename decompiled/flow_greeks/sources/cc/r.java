package cc;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3826a = Boolean.getBoolean("rx2.scheduler.use-nanotime");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f3827b = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements fc.b, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f3828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f3829b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Thread f3830c;

        public a(Runnable runnable, b bVar) {
            this.f3828a = runnable;
            this.f3829b = bVar;
        }

        @Override // fc.b
        public boolean c() {
            return this.f3829b.c();
        }

        @Override // fc.b
        public void dispose() {
            if (this.f3830c == Thread.currentThread()) {
                b bVar = this.f3829b;
                if (bVar instanceof uc.e) {
                    ((uc.e) bVar).g();
                    return;
                }
            }
            this.f3829b.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3830c = Thread.currentThread();
            try {
                this.f3828a.run();
            } finally {
                dispose();
                this.f3830c = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b implements fc.b {
        public long a(TimeUnit timeUnit) {
            return r.a(timeUnit);
        }

        public fc.b b(Runnable runnable) {
            return d(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract fc.b d(Runnable runnable, long j10, TimeUnit timeUnit);
    }

    public static long a(TimeUnit timeUnit) {
        return !f3826a ? timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS) : timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public abstract b b();

    public fc.b c(Runnable runnable) {
        return d(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public fc.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        b bVarB = b();
        a aVar = new a(yc.a.s(runnable), bVarB);
        bVarB.d(aVar, j10, timeUnit);
        return aVar;
    }
}
