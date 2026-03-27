package m1;

import m1.d;

/* JADX INFO: loaded from: classes.dex */
public final class b implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f21277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile c f21278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f21279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d.a f21280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d.a f21281f;

    public b(Object obj, d dVar) {
        d.a aVar = d.a.CLEARED;
        this.f21280e = aVar;
        this.f21281f = aVar;
        this.f21276a = obj;
        this.f21277b = dVar;
    }

    @Override // m1.d, m1.c
    public boolean a() {
        boolean z7;
        synchronized (this.f21276a) {
            try {
                z7 = this.f21278c.a() || this.f21279d.a();
            } finally {
            }
        }
        return z7;
    }

    @Override // m1.d
    public void b(c cVar) {
        synchronized (this.f21276a) {
            try {
                if (cVar.equals(this.f21278c)) {
                    this.f21280e = d.a.SUCCESS;
                } else if (cVar.equals(this.f21279d)) {
                    this.f21281f = d.a.SUCCESS;
                }
                d dVar = this.f21277b;
                if (dVar != null) {
                    dVar.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // m1.d
    public d c() {
        d dVarC;
        synchronized (this.f21276a) {
            try {
                d dVar = this.f21277b;
                dVarC = dVar != null ? dVar.c() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVarC;
    }

    @Override // m1.c
    public void clear() {
        synchronized (this.f21276a) {
            try {
                d.a aVar = d.a.CLEARED;
                this.f21280e = aVar;
                this.f21278c.clear();
                if (this.f21281f != aVar) {
                    this.f21281f = aVar;
                    this.f21279d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // m1.c
    public boolean d(c cVar) {
        if (!(cVar instanceof b)) {
            return false;
        }
        b bVar = (b) cVar;
        return this.f21278c.d(bVar.f21278c) && this.f21279d.d(bVar.f21279d);
    }

    @Override // m1.d
    public boolean e(c cVar) {
        boolean zO;
        synchronized (this.f21276a) {
            zO = o();
        }
        return zO;
    }

    @Override // m1.d
    public boolean f(c cVar) {
        boolean z7;
        synchronized (this.f21276a) {
            try {
                z7 = m() && cVar.equals(this.f21278c);
            } finally {
            }
        }
        return z7;
    }

    @Override // m1.c
    public boolean g() {
        boolean z7;
        synchronized (this.f21276a) {
            try {
                d.a aVar = this.f21280e;
                d.a aVar2 = d.a.CLEARED;
                z7 = aVar == aVar2 && this.f21281f == aVar2;
            } finally {
            }
        }
        return z7;
    }

    @Override // m1.d
    public boolean h(c cVar) {
        boolean z7;
        synchronized (this.f21276a) {
            try {
                z7 = n() && l(cVar);
            } finally {
            }
        }
        return z7;
    }

    @Override // m1.c
    public void i() {
        synchronized (this.f21276a) {
            try {
                d.a aVar = this.f21280e;
                d.a aVar2 = d.a.RUNNING;
                if (aVar != aVar2) {
                    this.f21280e = aVar2;
                    this.f21278c.i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // m1.c
    public boolean isRunning() {
        boolean z7;
        synchronized (this.f21276a) {
            try {
                d.a aVar = this.f21280e;
                d.a aVar2 = d.a.RUNNING;
                z7 = aVar == aVar2 || this.f21281f == aVar2;
            } finally {
            }
        }
        return z7;
    }

    @Override // m1.c
    public boolean j() {
        boolean z7;
        synchronized (this.f21276a) {
            try {
                d.a aVar = this.f21280e;
                d.a aVar2 = d.a.SUCCESS;
                z7 = aVar == aVar2 || this.f21281f == aVar2;
            } finally {
            }
        }
        return z7;
    }

    @Override // m1.d
    public void k(c cVar) {
        synchronized (this.f21276a) {
            try {
                if (cVar.equals(this.f21279d)) {
                    this.f21281f = d.a.FAILED;
                    d dVar = this.f21277b;
                    if (dVar != null) {
                        dVar.k(this);
                    }
                    return;
                }
                this.f21280e = d.a.FAILED;
                d.a aVar = this.f21281f;
                d.a aVar2 = d.a.RUNNING;
                if (aVar != aVar2) {
                    this.f21281f = aVar2;
                    this.f21279d.i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean l(c cVar) {
        d.a aVar;
        d.a aVar2 = this.f21280e;
        d.a aVar3 = d.a.FAILED;
        return aVar2 != aVar3 ? cVar.equals(this.f21278c) : cVar.equals(this.f21279d) && ((aVar = this.f21281f) == d.a.SUCCESS || aVar == aVar3);
    }

    public final boolean m() {
        d dVar = this.f21277b;
        return dVar == null || dVar.f(this);
    }

    public final boolean n() {
        d dVar = this.f21277b;
        return dVar == null || dVar.h(this);
    }

    public final boolean o() {
        d dVar = this.f21277b;
        return dVar == null || dVar.e(this);
    }

    public void p(c cVar, c cVar2) {
        this.f21278c = cVar;
        this.f21279d = cVar2;
    }

    @Override // m1.c
    public void pause() {
        synchronized (this.f21276a) {
            try {
                d.a aVar = this.f21280e;
                d.a aVar2 = d.a.RUNNING;
                if (aVar == aVar2) {
                    this.f21280e = d.a.PAUSED;
                    this.f21278c.pause();
                }
                if (this.f21281f == aVar2) {
                    this.f21281f = d.a.PAUSED;
                    this.f21279d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
