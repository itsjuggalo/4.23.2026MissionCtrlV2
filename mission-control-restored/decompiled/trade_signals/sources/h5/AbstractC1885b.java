package h5;

import P4.i;
import Y4.g;
import i5.EnumC1933g;
import k5.AbstractC2283a;

/* JADX INFO: renamed from: h5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1885b implements i, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x7.b f18695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x7.c f18696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f18697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18699e;

    public AbstractC1885b(x7.b bVar) {
        this.f18695a = bVar;
    }

    @Override // x7.b
    public void a() {
        if (this.f18698d) {
            return;
        }
        this.f18698d = true;
        this.f18695a.a();
    }

    @Override // x7.c
    public void cancel() {
        this.f18696b.cancel();
    }

    @Override // Y4.j
    public void clear() {
        this.f18697c.clear();
    }

    @Override // P4.i, x7.b
    public final void d(x7.c cVar) {
        if (EnumC1933g.q(this.f18696b, cVar)) {
            this.f18696b = cVar;
            if (cVar instanceof g) {
                this.f18697c = (g) cVar;
            }
            if (f()) {
                this.f18695a.d(this);
                b();
            }
        }
    }

    public boolean f() {
        return true;
    }

    public final void g(Throwable th) {
        T4.b.b(th);
        this.f18696b.cancel();
        onError(th);
    }

    public final int h(int i8) {
        g gVar = this.f18697c;
        if (gVar == null || (i8 & 4) != 0) {
            return 0;
        }
        int iK = gVar.k(i8);
        if (iK != 0) {
            this.f18699e = iK;
        }
        return iK;
    }

    @Override // x7.c
    public void i(long j8) {
        this.f18696b.i(j8);
    }

    @Override // Y4.j
    public boolean isEmpty() {
        return this.f18697c.isEmpty();
    }

    @Override // Y4.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // x7.b
    public void onError(Throwable th) {
        if (this.f18698d) {
            AbstractC2283a.q(th);
        } else {
            this.f18698d = true;
            this.f18695a.onError(th);
        }
    }

    public void b() {
    }
}
