package uc;

import cc.r;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f22969c = new k();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f22970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f22971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f22972c;

        public a(Runnable runnable, c cVar, long j10) {
            this.f22970a = runnable;
            this.f22971b = cVar;
            this.f22972c = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f22971b.f22980d) {
                return;
            }
            long jA = this.f22971b.a(TimeUnit.MILLISECONDS);
            long j10 = this.f22972c;
            if (j10 > jA) {
                try {
                    Thread.sleep(j10 - jA);
                } catch (InterruptedException e10) {
                    Thread.currentThread().interrupt();
                    yc.a.q(e10);
                    return;
                }
            }
            if (this.f22971b.f22980d) {
                return;
            }
            this.f22970a.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f22973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f22974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f22975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f22976d;

        public b(Runnable runnable, Long l10, int i10) {
            this.f22973a = runnable;
            this.f22974b = l10.longValue();
            this.f22975c = i10;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iB = kc.b.b(this.f22974b, bVar.f22974b);
            return iB == 0 ? kc.b.a(this.f22975c, bVar.f22975c) : iB;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends r.b implements fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PriorityBlockingQueue f22977a = new PriorityBlockingQueue();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f22978b = new AtomicInteger();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f22979c = new AtomicInteger();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f22980d;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f22981a;

            public a(b bVar) {
                this.f22981a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f22981a.f22976d = true;
                c.this.f22977a.remove(this.f22981a);
            }
        }

        @Override // cc.r.b
        public fc.b b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // fc.b
        public boolean c() {
            return this.f22980d;
        }

        @Override // cc.r.b
        public fc.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j10);
            return e(new a(runnable, this, jA), jA);
        }

        @Override // fc.b
        public void dispose() {
            this.f22980d = true;
        }

        public fc.b e(Runnable runnable, long j10) {
            if (this.f22980d) {
                return jc.c.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j10), this.f22979c.incrementAndGet());
            this.f22977a.add(bVar);
            if (this.f22978b.getAndIncrement() != 0) {
                return fc.c.c(new a(bVar));
            }
            int iAddAndGet = 1;
            while (!this.f22980d) {
                b bVar2 = (b) this.f22977a.poll();
                if (bVar2 == null) {
                    iAddAndGet = this.f22978b.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return jc.c.INSTANCE;
                    }
                } else if (!bVar2.f22976d) {
                    bVar2.f22973a.run();
                }
            }
            this.f22977a.clear();
            return jc.c.INSTANCE;
        }
    }

    public static k e() {
        return f22969c;
    }

    @Override // cc.r
    public r.b b() {
        return new c();
    }

    @Override // cc.r
    public fc.b c(Runnable runnable) {
        yc.a.s(runnable).run();
        return jc.c.INSTANCE;
    }

    @Override // cc.r
    public fc.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j10);
            yc.a.s(runnable).run();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            yc.a.q(e10);
        }
        return jc.c.INSTANCE;
    }
}
