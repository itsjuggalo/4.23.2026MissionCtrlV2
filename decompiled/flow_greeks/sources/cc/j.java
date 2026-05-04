package cc;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j implements n {
    public static j A(ic.e eVar, n... nVarArr) {
        kc.b.d(nVarArr, "sources is null");
        if (nVarArr.length == 0) {
            return g();
        }
        kc.b.d(eVar, "zipper is null");
        return yc.a.l(new pc.u(nVarArr, eVar));
    }

    public static j b(m mVar) {
        kc.b.d(mVar, "onSubscribe is null");
        return yc.a.l(new pc.c(mVar));
    }

    public static j g() {
        return yc.a.l(pc.d.f18505a);
    }

    public static j l(Callable callable) {
        kc.b.d(callable, "callable is null");
        return yc.a.l(new pc.i(callable));
    }

    public static j n(Object obj) {
        kc.b.d(obj, "item is null");
        return yc.a.l(new pc.m(obj));
    }

    public static j z(n nVar, n nVar2, ic.b bVar) {
        kc.b.d(nVar, "source1 is null");
        kc.b.d(nVar2, "source2 is null");
        return A(kc.a.g(bVar), nVar, nVar2);
    }

    @Override // cc.n
    public final void a(l lVar) {
        kc.b.d(lVar, "observer is null");
        l lVarU = yc.a.u(this, lVar);
        kc.b.d(lVarU, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            u(lVarU);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            gc.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final j d(Object obj) {
        kc.b.d(obj, "defaultItem is null");
        return x(n(obj));
    }

    public final j e(ic.d dVar) {
        ic.d dVarB = kc.a.b();
        ic.d dVarB2 = kc.a.b();
        ic.d dVar2 = (ic.d) kc.b.d(dVar, "onError is null");
        ic.a aVar = kc.a.f14806c;
        return yc.a.l(new pc.q(this, dVarB, dVarB2, dVar2, aVar, aVar, aVar));
    }

    public final j f(ic.d dVar) {
        ic.d dVarB = kc.a.b();
        ic.d dVar2 = (ic.d) kc.b.d(dVar, "onSuccess is null");
        ic.d dVarB2 = kc.a.b();
        ic.a aVar = kc.a.f14806c;
        return yc.a.l(new pc.q(this, dVarB, dVar2, dVarB2, aVar, aVar, aVar));
    }

    public final j h(ic.g gVar) {
        kc.b.d(gVar, "predicate is null");
        return yc.a.l(new pc.e(this, gVar));
    }

    public final j i(ic.e eVar) {
        kc.b.d(eVar, "mapper is null");
        return yc.a.l(new pc.h(this, eVar));
    }

    public final b j(ic.e eVar) {
        kc.b.d(eVar, "mapper is null");
        return yc.a.j(new pc.g(this, eVar));
    }

    public final o k(ic.e eVar) {
        kc.b.d(eVar, "mapper is null");
        return yc.a.m(new qc.a(this, eVar));
    }

    public final s m() {
        return yc.a.n(new pc.l(this));
    }

    public final j o(ic.e eVar) {
        kc.b.d(eVar, "mapper is null");
        return yc.a.l(new pc.n(this, eVar));
    }

    public final j p(r rVar) {
        kc.b.d(rVar, "scheduler is null");
        return yc.a.l(new pc.o(this, rVar));
    }

    public final j q(n nVar) {
        kc.b.d(nVar, "next is null");
        return r(kc.a.e(nVar));
    }

    public final j r(ic.e eVar) {
        kc.b.d(eVar, "resumeFunction is null");
        return yc.a.l(new pc.p(this, eVar, true));
    }

    public final fc.b s() {
        return t(kc.a.b(), kc.a.f14809f, kc.a.f14806c);
    }

    public final fc.b t(ic.d dVar, ic.d dVar2, ic.a aVar) {
        kc.b.d(dVar, "onSuccess is null");
        kc.b.d(dVar2, "onError is null");
        kc.b.d(aVar, "onComplete is null");
        return (fc.b) w(new pc.b(dVar, dVar2, aVar));
    }

    public abstract void u(l lVar);

    public final j v(r rVar) {
        kc.b.d(rVar, "scheduler is null");
        return yc.a.l(new pc.r(this, rVar));
    }

    public final l w(l lVar) {
        a(lVar);
        return lVar;
    }

    public final j x(n nVar) {
        kc.b.d(nVar, "other is null");
        return yc.a.l(new pc.s(this, nVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f y() {
        return this instanceof lc.b ? ((lc.b) this).c() : yc.a.k(new pc.t(this));
    }
}
