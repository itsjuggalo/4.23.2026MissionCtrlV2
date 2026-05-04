package y3;

import y3.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f25209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f25210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile c f25211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f25212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d.a f25213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d.a f25214f;

    public b(Object obj, d dVar) {
        d.a aVar = d.a.CLEARED;
        this.f25213e = aVar;
        this.f25214f = aVar;
        this.f25209a = obj;
        this.f25210b = dVar;
    }

    @Override // y3.d
    public void a(c cVar) {
        synchronized (this.f25209a) {
            try {
                if (cVar.equals(this.f25212d)) {
                    this.f25214f = d.a.FAILED;
                    d dVar = this.f25210b;
                    if (dVar != null) {
                        dVar.a(this);
                    }
                    return;
                }
                this.f25213e = d.a.FAILED;
                d.a aVar = this.f25214f;
                d.a aVar2 = d.a.RUNNING;
                if (aVar != aVar2) {
                    this.f25214f = aVar2;
                    this.f25212d.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y3.d, y3.c
    public boolean b() {
        boolean z10;
        synchronized (this.f25209a) {
            try {
                z10 = this.f25211c.b() || this.f25212d.b();
            } finally {
            }
        }
        return z10;
    }

    @Override // y3.d
    public boolean c(c cVar) {
        boolean z10;
        synchronized (this.f25209a) {
            try {
                z10 = l() && cVar.equals(this.f25211c);
            } finally {
            }
        }
        return z10;
    }

    @Override // y3.c
    public void clear() {
        synchronized (this.f25209a) {
            try {
                d.a aVar = d.a.CLEARED;
                this.f25213e = aVar;
                this.f25211c.clear();
                if (this.f25214f != aVar) {
                    this.f25214f = aVar;
                    this.f25212d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y3.c
    public boolean d(c cVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            if (this.f25211c.d(bVar.f25211c) && this.f25212d.d(bVar.f25212d)) {
                return true;
            }
        }
        return false;
    }

    @Override // y3.d
    public boolean e(c cVar) {
        boolean zN;
        synchronized (this.f25209a) {
            zN = n();
        }
        return zN;
    }

    @Override // y3.d
    public boolean f(c cVar) {
        boolean z10;
        synchronized (this.f25209a) {
            try {
                z10 = m() && k(cVar);
            } finally {
            }
        }
        return z10;
    }

    @Override // y3.c
    public boolean g() {
        boolean z10;
        synchronized (this.f25209a) {
            try {
                d.a aVar = this.f25213e;
                d.a aVar2 = d.a.CLEARED;
                z10 = aVar == aVar2 && this.f25214f == aVar2;
            } finally {
            }
        }
        return z10;
    }

    @Override // y3.d
    public d getRoot() {
        d root;
        synchronized (this.f25209a) {
            try {
                d dVar = this.f25210b;
                root = dVar != null ? dVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // y3.c
    public void h() {
        synchronized (this.f25209a) {
            try {
                d.a aVar = this.f25213e;
                d.a aVar2 = d.a.RUNNING;
                if (aVar != aVar2) {
                    this.f25213e = aVar2;
                    this.f25211c.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y3.c
    public boolean i() {
        boolean z10;
        synchronized (this.f25209a) {
            try {
                d.a aVar = this.f25213e;
                d.a aVar2 = d.a.SUCCESS;
                z10 = aVar == aVar2 || this.f25214f == aVar2;
            } finally {
            }
        }
        return z10;
    }

    @Override // y3.c
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f25209a) {
            try {
                d.a aVar = this.f25213e;
                d.a aVar2 = d.a.RUNNING;
                z10 = aVar == aVar2 || this.f25214f == aVar2;
            } finally {
            }
        }
        return z10;
    }

    @Override // y3.d
    public void j(c cVar) {
        synchronized (this.f25209a) {
            try {
                if (cVar.equals(this.f25211c)) {
                    this.f25213e = d.a.SUCCESS;
                } else if (cVar.equals(this.f25212d)) {
                    this.f25214f = d.a.SUCCESS;
                }
                d dVar = this.f25210b;
                if (dVar != null) {
                    dVar.j(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean k(c cVar) {
        d.a aVar = this.f25213e;
        d.a aVar2 = d.a.FAILED;
        if (aVar != aVar2) {
            return cVar.equals(this.f25211c);
        }
        if (!cVar.equals(this.f25212d)) {
            return false;
        }
        d.a aVar3 = this.f25214f;
        return aVar3 == d.a.SUCCESS || aVar3 == aVar2;
    }

    public final boolean l() {
        d dVar = this.f25210b;
        return dVar == null || dVar.c(this);
    }

    public final boolean m() {
        d dVar = this.f25210b;
        return dVar == null || dVar.f(this);
    }

    public final boolean n() {
        d dVar = this.f25210b;
        return dVar == null || dVar.e(this);
    }

    public void o(c cVar, c cVar2) {
        this.f25211c = cVar;
        this.f25212d = cVar2;
    }

    @Override // y3.c
    public void pause() {
        synchronized (this.f25209a) {
            try {
                d.a aVar = this.f25213e;
                d.a aVar2 = d.a.RUNNING;
                if (aVar == aVar2) {
                    this.f25213e = d.a.PAUSED;
                    this.f25211c.pause();
                }
                if (this.f25214f == aVar2) {
                    this.f25214f = d.a.PAUSED;
                    this.f25212d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
