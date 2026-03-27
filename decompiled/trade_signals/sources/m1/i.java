package m1;

import m1.d;

/* JADX INFO: loaded from: classes.dex */
public class i implements d, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f21327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f21328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile c f21329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f21330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d.a f21331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d.a f21332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21333g;

    public i(Object obj, d dVar) {
        d.a aVar = d.a.CLEARED;
        this.f21331e = aVar;
        this.f21332f = aVar;
        this.f21328b = obj;
        this.f21327a = dVar;
    }

    private boolean l() {
        d dVar = this.f21327a;
        return dVar == null || dVar.f(this);
    }

    private boolean m() {
        d dVar = this.f21327a;
        return dVar == null || dVar.h(this);
    }

    private boolean n() {
        d dVar = this.f21327a;
        return dVar == null || dVar.e(this);
    }

    @Override // m1.d, m1.c
    public boolean a() {
        boolean z7;
        synchronized (this.f21328b) {
            try {
                z7 = this.f21330d.a() || this.f21329c.a();
            } finally {
            }
        }
        return z7;
    }

    @Override // m1.d
    public void b(c cVar) {
        synchronized (this.f21328b) {
            try {
                if (cVar.equals(this.f21330d)) {
                    this.f21332f = d.a.SUCCESS;
                    return;
                }
                this.f21331e = d.a.SUCCESS;
                d dVar = this.f21327a;
                if (dVar != null) {
                    dVar.b(this);
                }
                if (!this.f21332f.b()) {
                    this.f21330d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // m1.d
    public d c() {
        d dVarC;
        synchronized (this.f21328b) {
            try {
                d dVar = this.f21327a;
                dVarC = dVar != null ? dVar.c() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVarC;
    }

    @Override // m1.c
    public void clear() {
        synchronized (this.f21328b) {
            this.f21333g = false;
            d.a aVar = d.a.CLEARED;
            this.f21331e = aVar;
            this.f21332f = aVar;
            this.f21330d.clear();
            this.f21329c.clear();
        }
    }

    @Override // m1.c
    public boolean d(c cVar) {
        if (!(cVar instanceof i)) {
            return false;
        }
        i iVar = (i) cVar;
        if (this.f21329c == null) {
            if (iVar.f21329c != null) {
                return false;
            }
        } else if (!this.f21329c.d(iVar.f21329c)) {
            return false;
        }
        if (this.f21330d == null) {
            if (iVar.f21330d != null) {
                return false;
            }
        } else if (!this.f21330d.d(iVar.f21330d)) {
            return false;
        }
        return true;
    }

    @Override // m1.d
    public boolean e(c cVar) {
        boolean z7;
        synchronized (this.f21328b) {
            try {
                z7 = n() && (cVar.equals(this.f21329c) || this.f21331e != d.a.SUCCESS);
            } finally {
            }
        }
        return z7;
    }

    @Override // m1.d
    public boolean f(c cVar) {
        boolean z7;
        synchronized (this.f21328b) {
            try {
                z7 = l() && cVar.equals(this.f21329c) && this.f21331e != d.a.PAUSED;
            } finally {
            }
        }
        return z7;
    }

    @Override // m1.c
    public boolean g() {
        boolean z7;
        synchronized (this.f21328b) {
            z7 = this.f21331e == d.a.CLEARED;
        }
        return z7;
    }

    @Override // m1.d
    public boolean h(c cVar) {
        boolean z7;
        synchronized (this.f21328b) {
            try {
                z7 = m() && cVar.equals(this.f21329c) && !a();
            } finally {
            }
        }
        return z7;
    }

    @Override // m1.c
    public void i() {
        synchronized (this.f21328b) {
            try {
                this.f21333g = true;
                try {
                    if (this.f21331e != d.a.SUCCESS) {
                        d.a aVar = this.f21332f;
                        d.a aVar2 = d.a.RUNNING;
                        if (aVar != aVar2) {
                            this.f21332f = aVar2;
                            this.f21330d.i();
                        }
                    }
                    if (this.f21333g) {
                        d.a aVar3 = this.f21331e;
                        d.a aVar4 = d.a.RUNNING;
                        if (aVar3 != aVar4) {
                            this.f21331e = aVar4;
                            this.f21329c.i();
                        }
                    }
                    this.f21333g = false;
                } catch (Throwable th) {
                    this.f21333g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // m1.c
    public boolean isRunning() {
        boolean z7;
        synchronized (this.f21328b) {
            z7 = this.f21331e == d.a.RUNNING;
        }
        return z7;
    }

    @Override // m1.c
    public boolean j() {
        boolean z7;
        synchronized (this.f21328b) {
            z7 = this.f21331e == d.a.SUCCESS;
        }
        return z7;
    }

    @Override // m1.d
    public void k(c cVar) {
        synchronized (this.f21328b) {
            try {
                if (!cVar.equals(this.f21329c)) {
                    this.f21332f = d.a.FAILED;
                    return;
                }
                this.f21331e = d.a.FAILED;
                d dVar = this.f21327a;
                if (dVar != null) {
                    dVar.k(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o(c cVar, c cVar2) {
        this.f21329c = cVar;
        this.f21330d = cVar2;
    }

    @Override // m1.c
    public void pause() {
        synchronized (this.f21328b) {
            try {
                if (!this.f21332f.b()) {
                    this.f21332f = d.a.PAUSED;
                    this.f21330d.pause();
                }
                if (!this.f21331e.b()) {
                    this.f21331e = d.a.PAUSED;
                    this.f21329c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
