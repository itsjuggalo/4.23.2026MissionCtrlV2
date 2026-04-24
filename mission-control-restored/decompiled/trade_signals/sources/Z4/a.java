package Z4;

import P4.q;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements q, Y4.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f9760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public S4.b f9761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Y4.e f9762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9764e;

    public a(q qVar) {
        this.f9760a = qVar;
    }

    @Override // P4.q
    public void a() {
        if (this.f9763d) {
            return;
        }
        this.f9763d = true;
        this.f9760a.a();
    }

    @Override // P4.q
    public final void b(S4.b bVar) {
        if (W4.b.n(this.f9761b, bVar)) {
            this.f9761b = bVar;
            if (bVar instanceof Y4.e) {
                this.f9762c = (Y4.e) bVar;
            }
            if (e()) {
                this.f9760a.b(this);
                d();
            }
        }
    }

    @Override // Y4.j
    public void clear() {
        this.f9762c.clear();
    }

    @Override // S4.b
    public void dispose() {
        this.f9761b.dispose();
    }

    public boolean e() {
        return true;
    }

    public final void f(Throwable th) {
        T4.b.b(th);
        this.f9761b.dispose();
        onError(th);
    }

    @Override // S4.b
    public boolean g() {
        return this.f9761b.g();
    }

    public final int h(int i8) {
        Y4.e eVar = this.f9762c;
        if (eVar == null || (i8 & 4) != 0) {
            return 0;
        }
        int iK = eVar.k(i8);
        if (iK != 0) {
            this.f9764e = iK;
        }
        return iK;
    }

    @Override // Y4.j
    public boolean isEmpty() {
        return this.f9762c.isEmpty();
    }

    @Override // Y4.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // P4.q
    public void onError(Throwable th) {
        if (this.f9763d) {
            AbstractC2283a.q(th);
        } else {
            this.f9763d = true;
            this.f9760a.onError(th);
        }
    }

    public void d() {
    }
}
