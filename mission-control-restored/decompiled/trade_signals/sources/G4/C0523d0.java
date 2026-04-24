package G4;

import G4.InterfaceC0553t;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import v2.AbstractC2848n;
import v2.C2851q;

/* JADX INFO: renamed from: G4.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0523d0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f2749l = TimeUnit.SECONDS.toNanos(10);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f2750m = TimeUnit.MILLISECONDS.toNanos(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f2751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2851q f2752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f2753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f2755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScheduledFuture f2756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f2757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f2758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Runnable f2759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f2760j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f2761k;

    /* JADX INFO: renamed from: G4.d0$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z7;
            synchronized (C0523d0.this) {
                try {
                    e eVar = C0523d0.this.f2755e;
                    e eVar2 = e.DISCONNECTED;
                    if (eVar != eVar2) {
                        C0523d0.this.f2755e = eVar2;
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z7) {
                C0523d0.this.f2753c.a();
            }
        }
    }

    /* JADX INFO: renamed from: G4.d0$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z7;
            synchronized (C0523d0.this) {
                try {
                    C0523d0.this.f2757g = null;
                    e eVar = C0523d0.this.f2755e;
                    e eVar2 = e.PING_SCHEDULED;
                    if (eVar == eVar2) {
                        C0523d0.this.f2755e = e.PING_SENT;
                        C0523d0 c0523d0 = C0523d0.this;
                        c0523d0.f2756f = c0523d0.f2751a.schedule(C0523d0.this.f2758h, C0523d0.this.f2761k, TimeUnit.NANOSECONDS);
                        z7 = true;
                    } else {
                        if (C0523d0.this.f2755e == e.PING_DELAYED) {
                            C0523d0 c0523d02 = C0523d0.this;
                            ScheduledExecutorService scheduledExecutorService = c0523d02.f2751a;
                            Runnable runnable = C0523d0.this.f2759i;
                            long j8 = C0523d0.this.f2760j;
                            C2851q c2851q = C0523d0.this.f2752b;
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            c0523d02.f2757g = scheduledExecutorService.schedule(runnable, j8 - c2851q.d(timeUnit), timeUnit);
                            C0523d0.this.f2755e = eVar2;
                        }
                        z7 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z7) {
                C0523d0.this.f2753c.b();
            }
        }
    }

    /* JADX INFO: renamed from: G4.d0$d */
    public interface d {
        void a();

        void b();
    }

    /* JADX INFO: renamed from: G4.d0$e */
    public enum e {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    public C0523d0(d dVar, ScheduledExecutorService scheduledExecutorService, long j8, long j9, boolean z7) {
        this(dVar, scheduledExecutorService, C2851q.c(), j8, j9, z7);
    }

    public synchronized void l() {
        try {
            this.f2752b.f().g();
            e eVar = this.f2755e;
            e eVar2 = e.PING_SCHEDULED;
            if (eVar == eVar2) {
                this.f2755e = e.PING_DELAYED;
            } else if (eVar == e.PING_SENT || eVar == e.IDLE_AND_PING_SENT) {
                ScheduledFuture scheduledFuture = this.f2756f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                if (this.f2755e == e.IDLE_AND_PING_SENT) {
                    this.f2755e = e.IDLE;
                } else {
                    this.f2755e = eVar2;
                    AbstractC2848n.u(this.f2757g == null, "There should be no outstanding pingFuture");
                    this.f2757g = this.f2751a.schedule(this.f2759i, this.f2760j, TimeUnit.NANOSECONDS);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void m() {
        try {
            e eVar = this.f2755e;
            if (eVar == e.IDLE) {
                this.f2755e = e.PING_SCHEDULED;
                if (this.f2757g == null) {
                    ScheduledExecutorService scheduledExecutorService = this.f2751a;
                    Runnable runnable = this.f2759i;
                    long j8 = this.f2760j;
                    C2851q c2851q = this.f2752b;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    this.f2757g = scheduledExecutorService.schedule(runnable, j8 - c2851q.d(timeUnit), timeUnit);
                }
            } else if (eVar == e.IDLE_AND_PING_SENT) {
                this.f2755e = e.PING_SENT;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void n() {
        try {
            if (this.f2754d) {
                return;
            }
            e eVar = this.f2755e;
            if (eVar == e.PING_SCHEDULED || eVar == e.PING_DELAYED) {
                this.f2755e = e.IDLE;
            }
            if (this.f2755e == e.PING_SENT) {
                this.f2755e = e.IDLE_AND_PING_SENT;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void o() {
        if (this.f2754d) {
            m();
        }
    }

    public synchronized void p() {
        try {
            e eVar = this.f2755e;
            e eVar2 = e.DISCONNECTED;
            if (eVar != eVar2) {
                this.f2755e = eVar2;
                ScheduledFuture scheduledFuture = this.f2756f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledFuture scheduledFuture2 = this.f2757g;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                    this.f2757g = null;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public C0523d0(d dVar, ScheduledExecutorService scheduledExecutorService, C2851q c2851q, long j8, long j9, boolean z7) {
        this.f2755e = e.IDLE;
        this.f2758h = new RunnableC0525e0(new a());
        this.f2759i = new RunnableC0525e0(new b());
        this.f2753c = (d) AbstractC2848n.o(dVar, "keepAlivePinger");
        this.f2751a = (ScheduledExecutorService) AbstractC2848n.o(scheduledExecutorService, "scheduler");
        this.f2752b = (C2851q) AbstractC2848n.o(c2851q, "stopwatch");
        this.f2760j = j8;
        this.f2761k = j9;
        this.f2754d = z7;
        c2851q.f().g();
    }

    /* JADX INFO: renamed from: G4.d0$c */
    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0559w f2764a;

        public c(InterfaceC0559w interfaceC0559w) {
            this.f2764a = interfaceC0559w;
        }

        @Override // G4.C0523d0.d
        public void a() {
            this.f2764a.f(F4.j0.f1812t.r("Keepalive failed. The connection is likely gone"));
        }

        @Override // G4.C0523d0.d
        public void b() {
            this.f2764a.d(new a(), A2.g.a());
        }

        /* JADX INFO: renamed from: G4.d0$c$a */
        public class a implements InterfaceC0553t.a {
            public a() {
            }

            @Override // G4.InterfaceC0553t.a
            public void onFailure(Throwable th) {
                c.this.f2764a.f(F4.j0.f1812t.r("Keepalive failed. The connection is likely gone"));
            }

            @Override // G4.InterfaceC0553t.a
            public void a(long j8) {
            }
        }
    }
}
