package pc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends AtomicReference implements cc.l, fc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ic.d f18500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.d f18501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic.a f18502c;

    public b(ic.d dVar, ic.d dVar2, ic.a aVar) {
        this.f18500a = dVar;
        this.f18501b = dVar2;
        this.f18502c = aVar;
    }

    @Override // cc.l
    public void a(fc.b bVar) {
        jc.b.l(this, bVar);
    }

    @Override // fc.b
    public boolean c() {
        return jc.b.b((fc.b) get());
    }

    @Override // fc.b
    public void dispose() {
        jc.b.a(this);
    }

    @Override // cc.l
    public void onComplete() {
        lazySet(jc.b.DISPOSED);
        try {
            this.f18502c.run();
        } catch (Throwable th) {
            gc.b.b(th);
            yc.a.q(th);
        }
    }

    @Override // cc.l
    public void onError(Throwable th) {
        lazySet(jc.b.DISPOSED);
        try {
            this.f18501b.accept(th);
        } catch (Throwable th2) {
            gc.b.b(th2);
            yc.a.q(new gc.a(th, th2));
        }
    }

    @Override // cc.l
    public void onSuccess(Object obj) {
        lazySet(jc.b.DISPOSED);
        try {
            this.f18500a.accept(obj);
        } catch (Throwable th) {
            gc.b.b(th);
            yc.a.q(th);
        }
    }
}
