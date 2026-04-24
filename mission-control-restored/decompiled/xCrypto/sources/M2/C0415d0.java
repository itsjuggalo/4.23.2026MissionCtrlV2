package M2;

import M2.InterfaceC0445t;
import e2.AbstractC1234f;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: M2.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0415d0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f2161l = TimeUnit.SECONDS.toNanos(10);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f2162m = TimeUnit.MILLISECONDS.toNanos(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f2163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Z1.p f2164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f2165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f2167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScheduledFuture f2168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f2169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f2170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Runnable f2171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f2172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f2173k;

    /* JADX INFO: renamed from: M2.d0$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z4;
            synchronized (C0415d0.this) {
                try {
                    e eVar = C0415d0.this.f2167e;
                    e eVar2 = e.DISCONNECTED;
                    if (eVar != eVar2) {
                        C0415d0.this.f2167e = eVar2;
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z4) {
                C0415d0.this.f2165c.a();
            }
        }
    }

    /* JADX INFO: renamed from: M2.d0$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z4;
            synchronized (C0415d0.this) {
                try {
                    C0415d0.this.f2169g = null;
                    e eVar = C0415d0.this.f2167e;
                    e eVar2 = e.PING_SCHEDULED;
                    if (eVar == eVar2) {
                        C0415d0.this.f2167e = e.PING_SENT;
                        C0415d0 c0415d0 = C0415d0.this;
                        c0415d0.f2168f = c0415d0.f2163a.schedule(C0415d0.this.f2170h, C0415d0.this.f2173k, TimeUnit.NANOSECONDS);
                        z4 = true;
                    } else {
                        if (C0415d0.this.f2167e == e.PING_DELAYED) {
                            C0415d0 c0415d02 = C0415d0.this;
                            ScheduledExecutorService scheduledExecutorService = c0415d02.f2163a;
                            Runnable runnable = C0415d0.this.f2171i;
                            long j4 = C0415d0.this.f2172j;
                            Z1.p pVar = C0415d0.this.f2164b;
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            c0415d02.f2169g = scheduledExecutorService.schedule(runnable, j4 - pVar.d(timeUnit), timeUnit);
                            C0415d0.this.f2167e = eVar2;
                        }
                        z4 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z4) {
                C0415d0.this.f2165c.b();
            }
        }
    }

    /* JADX INFO: renamed from: M2.d0$d */
    public interface d {
        void a();

        void b();
    }

    /* JADX INFO: renamed from: M2.d0$e */
    public enum e {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    public C0415d0(d dVar, ScheduledExecutorService scheduledExecutorService, long j4, long j5, boolean z4) {
        this(dVar, scheduledExecutorService, Z1.p.c(), j4, j5, z4);
    }

    public static long l(long j4) {
        return Math.max(j4, f2161l);
    }

    public synchronized void m() {
        try {
            this.f2164b.f().g();
            e eVar = this.f2167e;
            e eVar2 = e.PING_SCHEDULED;
            if (eVar == eVar2) {
                this.f2167e = e.PING_DELAYED;
            } else if (eVar == e.PING_SENT || eVar == e.IDLE_AND_PING_SENT) {
                ScheduledFuture scheduledFuture = this.f2168f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                if (this.f2167e == e.IDLE_AND_PING_SENT) {
                    this.f2167e = e.IDLE;
                } else {
                    this.f2167e = eVar2;
                    Z1.m.u(this.f2169g == null, "There should be no outstanding pingFuture");
                    this.f2169g = this.f2163a.schedule(this.f2171i, this.f2172j, TimeUnit.NANOSECONDS);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void n() {
        try {
            e eVar = this.f2167e;
            if (eVar == e.IDLE) {
                this.f2167e = e.PING_SCHEDULED;
                if (this.f2169g == null) {
                    ScheduledExecutorService scheduledExecutorService = this.f2163a;
                    Runnable runnable = this.f2171i;
                    long j4 = this.f2172j;
                    Z1.p pVar = this.f2164b;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    this.f2169g = scheduledExecutorService.schedule(runnable, j4 - pVar.d(timeUnit), timeUnit);
                }
            } else if (eVar == e.IDLE_AND_PING_SENT) {
                this.f2167e = e.PING_SENT;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void o() {
        try {
            if (this.f2166d) {
                return;
            }
            e eVar = this.f2167e;
            if (eVar == e.PING_SCHEDULED || eVar == e.PING_DELAYED) {
                this.f2167e = e.IDLE;
            }
            if (this.f2167e == e.PING_SENT) {
                this.f2167e = e.IDLE_AND_PING_SENT;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void p() {
        if (this.f2166d) {
            n();
        }
    }

    public synchronized void q() {
        try {
            e eVar = this.f2167e;
            e eVar2 = e.DISCONNECTED;
            if (eVar != eVar2) {
                this.f2167e = eVar2;
                ScheduledFuture scheduledFuture = this.f2168f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledFuture scheduledFuture2 = this.f2169g;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                    this.f2169g = null;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public C0415d0(d dVar, ScheduledExecutorService scheduledExecutorService, Z1.p pVar, long j4, long j5, boolean z4) {
        this.f2167e = e.IDLE;
        this.f2170h = new RunnableC0417e0(new a());
        this.f2171i = new RunnableC0417e0(new b());
        this.f2165c = (d) Z1.m.o(dVar, "keepAlivePinger");
        this.f2163a = (ScheduledExecutorService) Z1.m.o(scheduledExecutorService, "scheduler");
        this.f2164b = (Z1.p) Z1.m.o(pVar, "stopwatch");
        this.f2172j = j4;
        this.f2173k = j5;
        this.f2166d = z4;
        pVar.f().g();
    }

    /* JADX INFO: renamed from: M2.d0$c */
    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0451w f2176a;

        public c(InterfaceC0451w interfaceC0451w) {
            this.f2176a = interfaceC0451w;
        }

        @Override // M2.C0415d0.d
        public void a() {
            this.f2176a.b(K2.l0.f1230t.q("Keepalive failed. The connection is likely gone"));
        }

        @Override // M2.C0415d0.d
        public void b() {
            this.f2176a.f(new a(), AbstractC1234f.a());
        }

        /* JADX INFO: renamed from: M2.d0$c$a */
        public class a implements InterfaceC0445t.a {
            public a() {
            }

            @Override // M2.InterfaceC0445t.a
            public void a(Throwable th) {
                c.this.f2176a.b(K2.l0.f1230t.q("Keepalive failed. The connection is likely gone"));
            }

            @Override // M2.InterfaceC0445t.a
            public void b(long j4) {
            }
        }
    }
}
