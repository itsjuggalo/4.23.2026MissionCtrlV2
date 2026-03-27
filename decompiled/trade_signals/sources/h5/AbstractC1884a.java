package h5;

import Y4.g;
import i5.EnumC1933g;
import k5.AbstractC2283a;

/* JADX INFO: renamed from: h5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1884a implements Y4.a, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Y4.a f18690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x7.c f18691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f18692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18694e;

    public AbstractC1884a(Y4.a aVar) {
        this.f18690a = aVar;
    }

    @Override // x7.b
    public void a() {
        if (this.f18693d) {
            return;
        }
        this.f18693d = true;
        this.f18690a.a();
    }

    @Override // x7.c
    public void cancel() {
        this.f18691b.cancel();
    }

    @Override // Y4.j
    public void clear() {
        this.f18692c.clear();
    }

    @Override // P4.i, x7.b
    public final void d(x7.c cVar) {
        if (EnumC1933g.q(this.f18691b, cVar)) {
            this.f18691b = cVar;
            if (cVar instanceof g) {
                this.f18692c = (g) cVar;
            }
            if (f()) {
                this.f18690a.d(this);
                b();
            }
        }
    }

    public boolean f() {
        return true;
    }

    public final void g(Throwable th) {
        T4.b.b(th);
        this.f18691b.cancel();
        onError(th);
    }

    public final int h(int i8) {
        g gVar = this.f18692c;
        if (gVar == null || (i8 & 4) != 0) {
            return 0;
        }
        int iK = gVar.k(i8);
        if (iK != 0) {
            this.f18694e = iK;
        }
        return iK;
    }

    @Override // x7.c
    public void i(long j8) {
        this.f18691b.i(j8);
    }

    @Override // Y4.j
    public boolean isEmpty() {
        return this.f18692c.isEmpty();
    }

    @Override // Y4.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // x7.b
    public void onError(Throwable th) {
        if (this.f18693d) {
            AbstractC2283a.q(th);
        } else {
            this.f18693d = true;
            this.f18690a.onError(th);
        }
    }

    public void b() {
    }
}
