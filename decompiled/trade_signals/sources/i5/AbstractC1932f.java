package i5;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: i5.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1932f extends AtomicInteger implements x7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x7.c f18811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f18812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f18813c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f18814d = new AtomicLong();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicLong f18815e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f18816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18817g;

    public final void b() {
        if (getAndIncrement() != 0) {
            return;
        }
        f();
    }

    @Override // x7.c
    public void cancel() {
        if (this.f18816f) {
            return;
        }
        this.f18816f = true;
        b();
    }

    public final void f() {
        int iAddAndGet = 1;
        long jC = 0;
        x7.c cVar = null;
        do {
            x7.c cVar2 = (x7.c) this.f18813c.get();
            if (cVar2 != null) {
                cVar2 = (x7.c) this.f18813c.getAndSet(null);
            }
            long andSet = this.f18814d.get();
            if (andSet != 0) {
                andSet = this.f18814d.getAndSet(0L);
            }
            long andSet2 = this.f18815e.get();
            if (andSet2 != 0) {
                andSet2 = this.f18815e.getAndSet(0L);
            }
            x7.c cVar3 = this.f18811a;
            if (this.f18816f) {
                if (cVar3 != null) {
                    cVar3.cancel();
                    this.f18811a = null;
                }
                if (cVar2 != null) {
                    cVar2.cancel();
                }
            } else {
                long jC2 = this.f18812b;
                if (jC2 != Long.MAX_VALUE) {
                    jC2 = j5.d.c(jC2, andSet);
                    if (jC2 != Long.MAX_VALUE) {
                        jC2 -= andSet2;
                        if (jC2 < 0) {
                            EnumC1933g.k(jC2);
                            jC2 = 0;
                        }
                    }
                    this.f18812b = jC2;
                }
                if (cVar2 != null) {
                    if (cVar3 != null) {
                        cVar3.cancel();
                    }
                    this.f18811a = cVar2;
                    if (jC2 != 0) {
                        jC = j5.d.c(jC, jC2);
                        cVar = cVar2;
                    }
                } else if (cVar3 != null && andSet != 0) {
                    jC = j5.d.c(jC, andSet);
                    cVar = cVar3;
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
        if (jC != 0) {
            cVar.i(jC);
        }
    }

    public final boolean g() {
        return this.f18817g;
    }

    public final void h(long j8) {
        if (this.f18817g) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            j5.d.a(this.f18815e, j8);
            b();
            return;
        }
        long j9 = this.f18812b;
        if (j9 != Long.MAX_VALUE) {
            long j10 = j9 - j8;
            if (j10 < 0) {
                EnumC1933g.k(j10);
                j10 = 0;
            }
            this.f18812b = j10;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        f();
    }

    @Override // x7.c
    public final void i(long j8) {
        if (!EnumC1933g.n(j8) || this.f18817g) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            j5.d.a(this.f18814d, j8);
            b();
            return;
        }
        long j9 = this.f18812b;
        if (j9 != Long.MAX_VALUE) {
            long jC = j5.d.c(j9, j8);
            this.f18812b = jC;
            if (jC == Long.MAX_VALUE) {
                this.f18817g = true;
            }
        }
        x7.c cVar = this.f18811a;
        if (decrementAndGet() != 0) {
            f();
        }
        if (cVar != null) {
            cVar.i(j8);
        }
    }

    public final void j(x7.c cVar) {
        if (this.f18816f) {
            cVar.cancel();
            return;
        }
        X4.b.d(cVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            x7.c cVar2 = (x7.c) this.f18813c.getAndSet(cVar);
            if (cVar2 != null) {
                cVar2.cancel();
            }
            b();
            return;
        }
        x7.c cVar3 = this.f18811a;
        if (cVar3 != null) {
            cVar3.cancel();
        }
        this.f18811a = cVar;
        long j8 = this.f18812b;
        if (decrementAndGet() != 0) {
            f();
        }
        if (j8 != 0) {
            cVar.i(j8);
        }
    }
}
