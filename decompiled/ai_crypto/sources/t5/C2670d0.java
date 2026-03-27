package t5;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import t5.InterfaceC2700t;

/* JADX INFO: renamed from: t5.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2670d0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f23712l = TimeUnit.SECONDS.toNanos(10);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f23713m = TimeUnit.MILLISECONDS.toNanos(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f23714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H2.p f23715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f23716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f23717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f23718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScheduledFuture f23719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f23720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f23721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Runnable f23722i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f23723j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f23724k;

    /* JADX INFO: renamed from: t5.d0$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z7;
            synchronized (C2670d0.this) {
                try {
                    e eVar = C2670d0.this.f23718e;
                    e eVar2 = e.DISCONNECTED;
                    if (eVar != eVar2) {
                        C2670d0.this.f23718e = eVar2;
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z7) {
                C2670d0.this.f23716c.a();
            }
        }
    }

    /* JADX INFO: renamed from: t5.d0$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z7;
            synchronized (C2670d0.this) {
                try {
                    C2670d0.this.f23720g = null;
                    e eVar = C2670d0.this.f23718e;
                    e eVar2 = e.PING_SCHEDULED;
                    if (eVar == eVar2) {
                        C2670d0.this.f23718e = e.PING_SENT;
                        C2670d0 c2670d0 = C2670d0.this;
                        c2670d0.f23719f = c2670d0.f23714a.schedule(C2670d0.this.f23721h, C2670d0.this.f23724k, TimeUnit.NANOSECONDS);
                        z7 = true;
                    } else {
                        if (C2670d0.this.f23718e == e.PING_DELAYED) {
                            C2670d0 c2670d02 = C2670d0.this;
                            ScheduledExecutorService scheduledExecutorService = c2670d02.f23714a;
                            Runnable runnable = C2670d0.this.f23722i;
                            long j7 = C2670d0.this.f23723j;
                            H2.p pVar = C2670d0.this.f23715b;
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            c2670d02.f23720g = scheduledExecutorService.schedule(runnable, j7 - pVar.d(timeUnit), timeUnit);
                            C2670d0.this.f23718e = eVar2;
                        }
                        z7 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z7) {
                C2670d0.this.f23716c.b();
            }
        }
    }

    /* JADX INFO: renamed from: t5.d0$d */
    public interface d {
        void a();

        void b();
    }

    /* JADX INFO: renamed from: t5.d0$e */
    public enum e {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    public C2670d0(d dVar, ScheduledExecutorService scheduledExecutorService, long j7, long j8, boolean z7) {
        this(dVar, scheduledExecutorService, H2.p.c(), j7, j8, z7);
    }

    public static long l(long j7) {
        return Math.max(j7, f23712l);
    }

    public synchronized void m() {
        try {
            this.f23715b.f().g();
            e eVar = this.f23718e;
            e eVar2 = e.PING_SCHEDULED;
            if (eVar == eVar2) {
                this.f23718e = e.PING_DELAYED;
            } else if (eVar == e.PING_SENT || eVar == e.IDLE_AND_PING_SENT) {
                ScheduledFuture scheduledFuture = this.f23719f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                if (this.f23718e == e.IDLE_AND_PING_SENT) {
                    this.f23718e = e.IDLE;
                } else {
                    this.f23718e = eVar2;
                    H2.m.u(this.f23720g == null, "There should be no outstanding pingFuture");
                    this.f23720g = this.f23714a.schedule(this.f23722i, this.f23723j, TimeUnit.NANOSECONDS);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void n() {
        try {
            e eVar = this.f23718e;
            if (eVar == e.IDLE) {
                this.f23718e = e.PING_SCHEDULED;
                if (this.f23720g == null) {
                    ScheduledExecutorService scheduledExecutorService = this.f23714a;
                    Runnable runnable = this.f23722i;
                    long j7 = this.f23723j;
                    H2.p pVar = this.f23715b;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    this.f23720g = scheduledExecutorService.schedule(runnable, j7 - pVar.d(timeUnit), timeUnit);
                }
            } else if (eVar == e.IDLE_AND_PING_SENT) {
                this.f23718e = e.PING_SENT;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void o() {
        try {
            if (this.f23717d) {
                return;
            }
            e eVar = this.f23718e;
            if (eVar == e.PING_SCHEDULED || eVar == e.PING_DELAYED) {
                this.f23718e = e.IDLE;
            }
            if (this.f23718e == e.PING_SENT) {
                this.f23718e = e.IDLE_AND_PING_SENT;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void p() {
        if (this.f23717d) {
            n();
        }
    }

    public synchronized void q() {
        try {
            e eVar = this.f23718e;
            e eVar2 = e.DISCONNECTED;
            if (eVar != eVar2) {
                this.f23718e = eVar2;
                ScheduledFuture scheduledFuture = this.f23719f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledFuture scheduledFuture2 = this.f23720g;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                    this.f23720g = null;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public C2670d0(d dVar, ScheduledExecutorService scheduledExecutorService, H2.p pVar, long j7, long j8, boolean z7) {
        this.f23718e = e.IDLE;
        this.f23721h = new RunnableC2672e0(new a());
        this.f23722i = new RunnableC2672e0(new b());
        this.f23716c = (d) H2.m.o(dVar, "keepAlivePinger");
        this.f23714a = (ScheduledExecutorService) H2.m.o(scheduledExecutorService, "scheduler");
        this.f23715b = (H2.p) H2.m.o(pVar, "stopwatch");
        this.f23723j = j7;
        this.f23724k = j8;
        this.f23717d = z7;
        pVar.f().g();
    }

    /* JADX INFO: renamed from: t5.d0$c */
    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC2706w f23727a;

        public c(InterfaceC2706w interfaceC2706w) {
            this.f23727a = interfaceC2706w;
        }

        @Override // t5.C2670d0.d
        public void a() {
            this.f23727a.d(r5.l0.f22720t.q("Keepalive failed. The connection is likely gone"));
        }

        @Override // t5.C2670d0.d
        public void b() {
            this.f23727a.b(new a(), M2.f.a());
        }

        /* JADX INFO: renamed from: t5.d0$c$a */
        public class a implements InterfaceC2700t.a {
            public a() {
            }

            @Override // t5.InterfaceC2700t.a
            public void a(Throwable th) {
                c.this.f23727a.d(r5.l0.f22720t.q("Keepalive failed. The connection is likely gone"));
            }

            @Override // t5.InterfaceC2700t.a
            public void b(long j7) {
            }
        }
    }
}
