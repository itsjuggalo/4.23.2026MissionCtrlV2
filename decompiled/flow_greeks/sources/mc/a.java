package mc;

import cc.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements q, lc.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f16417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fc.b f16418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public lc.d f16419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16421e;

    public a(q qVar) {
        this.f16417a = qVar;
    }

    @Override // cc.q
    public final void a(fc.b bVar) {
        if (jc.b.m(this.f16418b, bVar)) {
            this.f16418b = bVar;
            if (bVar instanceof lc.d) {
                this.f16419c = (lc.d) bVar;
            }
            if (d()) {
                this.f16417a.a(this);
                b();
            }
        }
    }

    @Override // fc.b
    public boolean c() {
        return this.f16418b.c();
    }

    @Override // lc.i
    public void clear() {
        this.f16419c.clear();
    }

    public boolean d() {
        return true;
    }

    @Override // fc.b
    public void dispose() {
        this.f16418b.dispose();
    }

    public final void e(Throwable th) {
        gc.b.b(th);
        this.f16418b.dispose();
        onError(th);
    }

    @Override // lc.i
    public boolean isEmpty() {
        return this.f16419c.isEmpty();
    }

    @Override // lc.i
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // cc.q
    public void onComplete() {
        if (this.f16420d) {
            return;
        }
        this.f16420d = true;
        this.f16417a.onComplete();
    }

    @Override // cc.q
    public void onError(Throwable th) {
        if (this.f16420d) {
            yc.a.q(th);
        } else {
            this.f16420d = true;
            this.f16417a.onError(th);
        }
    }

    public void b() {
    }
}
