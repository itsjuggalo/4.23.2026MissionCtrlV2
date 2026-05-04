package wc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends AtomicInteger implements kh.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kh.c f23891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f23892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f23893c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f23894d = new AtomicLong();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicLong f23895e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f23896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f23897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f23898h;

    public f(boolean z10) {
        this.f23896f = z10;
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        c();
    }

    public final void c() {
        int iAddAndGet = 1;
        long jC = 0;
        kh.c cVar = null;
        do {
            kh.c cVar2 = (kh.c) this.f23893c.get();
            if (cVar2 != null) {
                cVar2 = (kh.c) this.f23893c.getAndSet(null);
            }
            long andSet = this.f23894d.get();
            if (andSet != 0) {
                andSet = this.f23894d.getAndSet(0L);
            }
            long andSet2 = this.f23895e.get();
            if (andSet2 != 0) {
                andSet2 = this.f23895e.getAndSet(0L);
            }
            kh.c cVar3 = this.f23891a;
            if (this.f23897g) {
                if (cVar3 != null) {
                    cVar3.cancel();
                    this.f23891a = null;
                }
                if (cVar2 != null) {
                    cVar2.cancel();
                }
            } else {
                long jC2 = this.f23892b;
                if (jC2 != Long.MAX_VALUE) {
                    jC2 = xc.d.c(jC2, andSet);
                    if (jC2 != Long.MAX_VALUE) {
                        jC2 -= andSet2;
                        if (jC2 < 0) {
                            g.h(jC2);
                            jC2 = 0;
                        }
                    }
                    this.f23892b = jC2;
                }
                if (cVar2 != null) {
                    if (cVar3 != null && this.f23896f) {
                        cVar3.cancel();
                    }
                    this.f23891a = cVar2;
                    if (jC2 != 0) {
                        jC = xc.d.c(jC, jC2);
                        cVar = cVar2;
                    }
                } else if (cVar3 != null && andSet != 0) {
                    jC = xc.d.c(jC, andSet);
                    cVar = cVar3;
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
        if (jC != 0) {
            cVar.request(jC);
        }
    }

    @Override // kh.c
    public void cancel() {
        if (this.f23897g) {
            return;
        }
        this.f23897g = true;
        a();
    }

    public final boolean e() {
        return this.f23898h;
    }

    public final void f(long j10) {
        if (this.f23898h) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            xc.d.a(this.f23895e, j10);
            a();
            return;
        }
        long j11 = this.f23892b;
        if (j11 != Long.MAX_VALUE) {
            long j12 = j11 - j10;
            if (j12 < 0) {
                g.h(j12);
                j12 = 0;
            }
            this.f23892b = j12;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        c();
    }

    public final void g(kh.c cVar) {
        if (this.f23897g) {
            cVar.cancel();
            return;
        }
        kc.b.d(cVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            kh.c cVar2 = (kh.c) this.f23893c.getAndSet(cVar);
            if (cVar2 != null && this.f23896f) {
                cVar2.cancel();
            }
            a();
            return;
        }
        kh.c cVar3 = this.f23891a;
        if (cVar3 != null && this.f23896f) {
            cVar3.cancel();
        }
        this.f23891a = cVar;
        long j10 = this.f23892b;
        if (decrementAndGet() != 0) {
            c();
        }
        if (j10 != 0) {
            cVar.request(j10);
        }
    }

    @Override // kh.c
    public final void request(long j10) {
        if (!g.l(j10) || this.f23898h) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            xc.d.a(this.f23894d, j10);
            a();
            return;
        }
        long j11 = this.f23892b;
        if (j11 != Long.MAX_VALUE) {
            long jC = xc.d.c(j11, j10);
            this.f23892b = jC;
            if (jC == Long.MAX_VALUE) {
                this.f23898h = true;
            }
        }
        kh.c cVar = this.f23891a;
        if (decrementAndGet() != 0) {
            c();
        }
        if (cVar != null) {
            cVar.request(j10);
        }
    }
}
