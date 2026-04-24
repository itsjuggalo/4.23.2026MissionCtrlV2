package g5;

import P4.r;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f18294b = new k();

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f18295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f18296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f18297c;

        public a(Runnable runnable, c cVar, long j8) {
            this.f18295a = runnable;
            this.f18296b = cVar;
            this.f18297c = j8;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f18296b.f18305d) {
                return;
            }
            long jA = this.f18296b.a(TimeUnit.MILLISECONDS);
            long j8 = this.f18297c;
            if (j8 > jA) {
                try {
                    Thread.sleep(j8 - jA);
                } catch (InterruptedException e8) {
                    Thread.currentThread().interrupt();
                    AbstractC2283a.q(e8);
                    return;
                }
            }
            if (this.f18296b.f18305d) {
                return;
            }
            this.f18295a.run();
        }
    }

    public static final class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f18298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f18299b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f18300c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f18301d;

        public b(Runnable runnable, Long l8, int i8) {
            this.f18298a = runnable;
            this.f18299b = l8.longValue();
            this.f18300c = i8;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iB = X4.b.b(this.f18299b, bVar.f18299b);
            return iB == 0 ? X4.b.a(this.f18300c, bVar.f18300c) : iB;
        }
    }

    public static final class c extends r.b implements S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PriorityBlockingQueue f18302a = new PriorityBlockingQueue();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f18303b = new AtomicInteger();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f18304c = new AtomicInteger();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f18305d;

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f18306a;

            public a(b bVar) {
                this.f18306a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f18306a.f18301d = true;
                c.this.f18302a.remove(this.f18306a);
            }
        }

        @Override // P4.r.b
        public S4.b b(Runnable runnable) {
            return d(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // P4.r.b
        public S4.b c(Runnable runnable, long j8, TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j8);
            return d(new a(runnable, this, jA), jA);
        }

        public S4.b d(Runnable runnable, long j8) {
            if (this.f18305d) {
                return W4.c.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j8), this.f18304c.incrementAndGet());
            this.f18302a.add(bVar);
            if (this.f18303b.getAndIncrement() != 0) {
                return S4.c.c(new a(bVar));
            }
            int iAddAndGet = 1;
            while (!this.f18305d) {
                b bVar2 = (b) this.f18302a.poll();
                if (bVar2 == null) {
                    iAddAndGet = this.f18303b.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return W4.c.INSTANCE;
                    }
                } else if (!bVar2.f18301d) {
                    bVar2.f18298a.run();
                }
            }
            this.f18302a.clear();
            return W4.c.INSTANCE;
        }

        @Override // S4.b
        public void dispose() {
            this.f18305d = true;
        }

        @Override // S4.b
        public boolean g() {
            return this.f18305d;
        }
    }

    public static k d() {
        return f18294b;
    }

    @Override // P4.r
    public r.b a() {
        return new c();
    }

    @Override // P4.r
    public S4.b b(Runnable runnable) {
        AbstractC2283a.s(runnable).run();
        return W4.c.INSTANCE;
    }

    @Override // P4.r
    public S4.b c(Runnable runnable, long j8, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j8);
            AbstractC2283a.s(runnable).run();
        } catch (InterruptedException e8) {
            Thread.currentThread().interrupt();
            AbstractC2283a.q(e8);
        }
        return W4.c.INSTANCE;
    }
}
