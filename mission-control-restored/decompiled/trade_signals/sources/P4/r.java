package P4;

import java.util.concurrent.TimeUnit;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f6440a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public static final class a implements S4.b, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f6441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f6442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Thread f6443c;

        public a(Runnable runnable, b bVar) {
            this.f6441a = runnable;
            this.f6442b = bVar;
        }

        @Override // S4.b
        public void dispose() {
            if (this.f6443c == Thread.currentThread()) {
                b bVar = this.f6442b;
                if (bVar instanceof g5.e) {
                    ((g5.e) bVar).f();
                    return;
                }
            }
            this.f6442b.dispose();
        }

        @Override // S4.b
        public boolean g() {
            return this.f6442b.g();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6443c = Thread.currentThread();
            try {
                this.f6441a.run();
            } finally {
                dispose();
                this.f6443c = null;
            }
        }
    }

    public static abstract class b implements S4.b {
        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public S4.b b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract S4.b c(Runnable runnable, long j8, TimeUnit timeUnit);
    }

    public abstract b a();

    public S4.b b(Runnable runnable) {
        return c(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public S4.b c(Runnable runnable, long j8, TimeUnit timeUnit) {
        b bVarA = a();
        a aVar = new a(AbstractC2283a.s(runnable), bVarA);
        bVarA.c(aVar, j8, timeUnit);
        return aVar;
    }
}
