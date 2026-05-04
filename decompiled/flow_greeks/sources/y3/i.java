package y3;

import y3.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f25255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f25256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile c f25257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f25258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d.a f25259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d.a f25260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25261g;

    public i(Object obj, d dVar) {
        d.a aVar = d.a.CLEARED;
        this.f25259e = aVar;
        this.f25260f = aVar;
        this.f25256b = obj;
        this.f25255a = dVar;
    }

    private boolean k() {
        d dVar = this.f25255a;
        return dVar == null || dVar.c(this);
    }

    private boolean l() {
        d dVar = this.f25255a;
        return dVar == null || dVar.f(this);
    }

    private boolean m() {
        d dVar = this.f25255a;
        return dVar == null || dVar.e(this);
    }

    @Override // y3.d
    public void a(c cVar) {
        synchronized (this.f25256b) {
            try {
                if (!cVar.equals(this.f25257c)) {
                    this.f25260f = d.a.FAILED;
                    return;
                }
                this.f25259e = d.a.FAILED;
                d dVar = this.f25255a;
                if (dVar != null) {
                    dVar.a(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y3.d, y3.c
    public boolean b() {
        boolean z10;
        synchronized (this.f25256b) {
            try {
                z10 = this.f25258d.b() || this.f25257c.b();
            } finally {
            }
        }
        return z10;
    }

    @Override // y3.d
    public boolean c(c cVar) {
        boolean z10;
        synchronized (this.f25256b) {
            try {
                z10 = k() && cVar.equals(this.f25257c) && this.f25259e != d.a.PAUSED;
            } finally {
            }
        }
        return z10;
    }

    @Override // y3.c
    public void clear() {
        synchronized (this.f25256b) {
            this.f25261g = false;
            d.a aVar = d.a.CLEARED;
            this.f25259e = aVar;
            this.f25260f = aVar;
            this.f25258d.clear();
            this.f25257c.clear();
        }
    }

    @Override // y3.c
    public boolean d(c cVar) {
        if (cVar instanceof i) {
            i iVar = (i) cVar;
            if (this.f25257c != null ? this.f25257c.d(iVar.f25257c) : iVar.f25257c == null) {
                if (this.f25258d == null) {
                    if (iVar.f25258d == null) {
                        return true;
                    }
                } else if (this.f25258d.d(iVar.f25258d)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // y3.d
    public boolean e(c cVar) {
        boolean z10;
        synchronized (this.f25256b) {
            try {
                z10 = m() && (cVar.equals(this.f25257c) || this.f25259e != d.a.SUCCESS);
            } finally {
            }
        }
        return z10;
    }

    @Override // y3.d
    public boolean f(c cVar) {
        boolean z10;
        synchronized (this.f25256b) {
            try {
                z10 = l() && cVar.equals(this.f25257c) && !b();
            } finally {
            }
        }
        return z10;
    }

    @Override // y3.c
    public boolean g() {
        boolean z10;
        synchronized (this.f25256b) {
            z10 = this.f25259e == d.a.CLEARED;
        }
        return z10;
    }

    @Override // y3.d
    public d getRoot() {
        d root;
        synchronized (this.f25256b) {
            try {
                d dVar = this.f25255a;
                root = dVar != null ? dVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // y3.c
    public void h() {
        synchronized (this.f25256b) {
            try {
                this.f25261g = true;
                try {
                    if (this.f25259e != d.a.SUCCESS) {
                        d.a aVar = this.f25260f;
                        d.a aVar2 = d.a.RUNNING;
                        if (aVar != aVar2) {
                            this.f25260f = aVar2;
                            this.f25258d.h();
                        }
                    }
                    if (this.f25261g) {
                        d.a aVar3 = this.f25259e;
                        d.a aVar4 = d.a.RUNNING;
                        if (aVar3 != aVar4) {
                            this.f25259e = aVar4;
                            this.f25257c.h();
                        }
                    }
                    this.f25261g = false;
                } catch (Throwable th) {
                    this.f25261g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // y3.c
    public boolean i() {
        boolean z10;
        synchronized (this.f25256b) {
            z10 = this.f25259e == d.a.SUCCESS;
        }
        return z10;
    }

    @Override // y3.c
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f25256b) {
            z10 = this.f25259e == d.a.RUNNING;
        }
        return z10;
    }

    @Override // y3.d
    public void j(c cVar) {
        synchronized (this.f25256b) {
            try {
                if (cVar.equals(this.f25258d)) {
                    this.f25260f = d.a.SUCCESS;
                    return;
                }
                this.f25259e = d.a.SUCCESS;
                d dVar = this.f25255a;
                if (dVar != null) {
                    dVar.j(this);
                }
                if (!this.f25260f.b()) {
                    this.f25258d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n(c cVar, c cVar2) {
        this.f25257c = cVar;
        this.f25258d = cVar2;
    }

    @Override // y3.c
    public void pause() {
        synchronized (this.f25256b) {
            try {
                if (!this.f25260f.b()) {
                    this.f25260f = d.a.PAUSED;
                    this.f25258d.pause();
                }
                if (!this.f25259e.b()) {
                    this.f25259e = d.a.PAUSED;
                    this.f25257c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
