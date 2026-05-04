package tb;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import tb.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class c1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f21127l = TimeUnit.SECONDS.toNanos(10);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f21128m = TimeUnit.MILLISECONDS.toNanos(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f21129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6.q f21130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f21131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f21132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f21133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScheduledFuture f21134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f21135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f21136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Runnable f21137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f21138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f21139k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            synchronized (c1.this) {
                try {
                    e eVar = c1.this.f21133e;
                    e eVar2 = e.DISCONNECTED;
                    if (eVar != eVar2) {
                        c1.this.f21133e = eVar2;
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z10) {
                c1.this.f21131c.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            synchronized (c1.this) {
                try {
                    c1.this.f21135g = null;
                    e eVar = c1.this.f21133e;
                    e eVar2 = e.PING_SCHEDULED;
                    if (eVar == eVar2) {
                        c1.this.f21133e = e.PING_SENT;
                        c1 c1Var = c1.this;
                        c1Var.f21134f = c1Var.f21129a.schedule(c1.this.f21136h, c1.this.f21139k, TimeUnit.NANOSECONDS);
                        z10 = true;
                    } else {
                        if (c1.this.f21133e == e.PING_DELAYED) {
                            c1 c1Var2 = c1.this;
                            ScheduledExecutorService scheduledExecutorService = c1Var2.f21129a;
                            Runnable runnable = c1.this.f21137i;
                            long j10 = c1.this.f21138j;
                            p6.q qVar = c1.this.f21130b;
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            c1Var2.f21135g = scheduledExecutorService.schedule(runnable, j10 - qVar.d(timeUnit), timeUnit);
                            c1.this.f21133e = eVar2;
                        }
                        z10 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z10) {
                c1.this.f21131c.b();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum e {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    public c1(d dVar, ScheduledExecutorService scheduledExecutorService, long j10, long j11, boolean z10) {
        this(dVar, scheduledExecutorService, p6.q.c(), j10, j11, z10);
    }

    public static long l(long j10) {
        return Math.max(j10, f21127l);
    }

    public synchronized void m() {
        try {
            this.f21130b.f().g();
            e eVar = this.f21133e;
            e eVar2 = e.PING_SCHEDULED;
            if (eVar == eVar2) {
                this.f21133e = e.PING_DELAYED;
            } else if (eVar == e.PING_SENT || eVar == e.IDLE_AND_PING_SENT) {
                ScheduledFuture scheduledFuture = this.f21134f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                if (this.f21133e == e.IDLE_AND_PING_SENT) {
                    this.f21133e = e.IDLE;
                } else {
                    this.f21133e = eVar2;
                    p6.n.u(this.f21135g == null, "There should be no outstanding pingFuture");
                    this.f21135g = this.f21129a.schedule(this.f21137i, this.f21138j, TimeUnit.NANOSECONDS);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void n() {
        try {
            e eVar = this.f21133e;
            if (eVar == e.IDLE) {
                this.f21133e = e.PING_SCHEDULED;
                if (this.f21135g == null) {
                    ScheduledExecutorService scheduledExecutorService = this.f21129a;
                    Runnable runnable = this.f21137i;
                    long j10 = this.f21138j;
                    p6.q qVar = this.f21130b;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    this.f21135g = scheduledExecutorService.schedule(runnable, j10 - qVar.d(timeUnit), timeUnit);
                }
            } else if (eVar == e.IDLE_AND_PING_SENT) {
                this.f21133e = e.PING_SENT;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void o() {
        try {
            if (this.f21132d) {
                return;
            }
            e eVar = this.f21133e;
            if (eVar == e.PING_SCHEDULED || eVar == e.PING_DELAYED) {
                this.f21133e = e.IDLE;
            }
            if (this.f21133e == e.PING_SENT) {
                this.f21133e = e.IDLE_AND_PING_SENT;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void p() {
        if (this.f21132d) {
            n();
        }
    }

    public synchronized void q() {
        try {
            e eVar = this.f21133e;
            e eVar2 = e.DISCONNECTED;
            if (eVar != eVar2) {
                this.f21133e = eVar2;
                ScheduledFuture scheduledFuture = this.f21134f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledFuture scheduledFuture2 = this.f21135g;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                    this.f21135g = null;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public c1(d dVar, ScheduledExecutorService scheduledExecutorService, p6.q qVar, long j10, long j11, boolean z10) {
        this.f21133e = e.IDLE;
        this.f21136h = new d1(new a());
        this.f21137i = new d1(new b());
        this.f21131c = (d) p6.n.o(dVar, "keepAlivePinger");
        this.f21129a = (ScheduledExecutorService) p6.n.o(scheduledExecutorService, "scheduler");
        this.f21130b = (p6.q) p6.n.o(qVar, "stopwatch");
        this.f21138j = j10;
        this.f21139k = j11;
        this.f21132d = z10;
        qVar.f().g();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f21142a;

        public c(w wVar) {
            this.f21142a = wVar;
        }

        @Override // tb.c1.d
        public void a() {
            this.f21142a.h(rb.k1.f19607t.r("Keepalive failed. The connection is likely gone"));
        }

        @Override // tb.c1.d
        public void b() {
            this.f21142a.b(new a(), u6.g.a());
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements t.a {
            public a() {
            }

            @Override // tb.t.a
            public void onFailure(Throwable th) {
                c.this.f21142a.h(rb.k1.f19607t.r("Keepalive failed. The connection is likely gone"));
            }

            @Override // tb.t.a
            public void a(long j10) {
            }
        }
    }
}
