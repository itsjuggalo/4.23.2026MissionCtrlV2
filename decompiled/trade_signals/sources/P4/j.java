package P4;

import c5.C1255b;
import c5.C1256c;
import c5.v;
import java.util.concurrent.Callable;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j implements n {
    public static j A(n nVar, n nVar2, V4.b bVar) {
        X4.b.d(nVar, "source1 is null");
        X4.b.d(nVar2, "source2 is null");
        return B(X4.a.g(bVar), nVar, nVar2);
    }

    public static j B(V4.e eVar, n... nVarArr) {
        X4.b.d(nVarArr, "sources is null");
        if (nVarArr.length == 0) {
            return g();
        }
        X4.b.d(eVar, "zipper is null");
        return AbstractC2283a.l(new v(nVarArr, eVar));
    }

    public static j b(m mVar) {
        X4.b.d(mVar, "onSubscribe is null");
        return AbstractC2283a.l(new C1256c(mVar));
    }

    public static j g() {
        return AbstractC2283a.l(c5.d.f13480a);
    }

    public static j l(Callable callable) {
        X4.b.d(callable, "callable is null");
        return AbstractC2283a.l(new c5.i(callable));
    }

    public static j n(Object obj) {
        X4.b.d(obj, "item is null");
        return AbstractC2283a.l(new c5.m(obj));
    }

    @Override // P4.n
    public final void a(l lVar) {
        X4.b.d(lVar, "observer is null");
        l lVarU = AbstractC2283a.u(this, lVar);
        X4.b.d(lVarU, "observer returned by the RxJavaPlugins hook is null");
        try {
            u(lVarU);
        } catch (NullPointerException e8) {
            throw e8;
        } catch (Throwable th) {
            T4.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final j d(Object obj) {
        X4.b.d(obj, "item is null");
        return x(n(obj));
    }

    public final j e(V4.d dVar) {
        V4.d dVarB = X4.a.b();
        V4.d dVarB2 = X4.a.b();
        V4.d dVar2 = (V4.d) X4.b.d(dVar, "onError is null");
        V4.a aVar = X4.a.f9377c;
        return AbstractC2283a.l(new c5.q(this, dVarB, dVarB2, dVar2, aVar, aVar, aVar));
    }

    public final j f(V4.d dVar) {
        V4.d dVarB = X4.a.b();
        V4.d dVar2 = (V4.d) X4.b.d(dVar, "onSubscribe is null");
        V4.d dVarB2 = X4.a.b();
        V4.a aVar = X4.a.f9377c;
        return AbstractC2283a.l(new c5.q(this, dVarB, dVar2, dVarB2, aVar, aVar, aVar));
    }

    public final j h(V4.g gVar) {
        X4.b.d(gVar, "predicate is null");
        return AbstractC2283a.l(new c5.e(this, gVar));
    }

    public final j i(V4.e eVar) {
        X4.b.d(eVar, "mapper is null");
        return AbstractC2283a.l(new c5.h(this, eVar));
    }

    public final b j(V4.e eVar) {
        X4.b.d(eVar, "mapper is null");
        return AbstractC2283a.j(new c5.g(this, eVar));
    }

    public final o k(V4.e eVar) {
        return z().j(eVar);
    }

    public final s m() {
        return AbstractC2283a.n(new c5.l(this));
    }

    public final j o(V4.e eVar) {
        X4.b.d(eVar, "mapper is null");
        return AbstractC2283a.l(new c5.n(this, eVar));
    }

    public final j p(r rVar) {
        X4.b.d(rVar, "scheduler is null");
        return AbstractC2283a.l(new c5.o(this, rVar));
    }

    public final j q(n nVar) {
        X4.b.d(nVar, "next is null");
        return r(X4.a.e(nVar));
    }

    public final j r(V4.e eVar) {
        X4.b.d(eVar, "resumeFunction is null");
        return AbstractC2283a.l(new c5.p(this, eVar, true));
    }

    public final S4.b s() {
        return t(X4.a.b(), X4.a.f9380f, X4.a.f9377c);
    }

    public final S4.b t(V4.d dVar, V4.d dVar2, V4.a aVar) {
        X4.b.d(dVar, "onSuccess is null");
        X4.b.d(dVar2, "onError is null");
        X4.b.d(aVar, "onComplete is null");
        return (S4.b) w(new C1255b(dVar, dVar2, aVar));
    }

    public abstract void u(l lVar);

    public final j v(r rVar) {
        X4.b.d(rVar, "scheduler is null");
        return AbstractC2283a.l(new c5.r(this, rVar));
    }

    public final l w(l lVar) {
        a(lVar);
        return lVar;
    }

    public final j x(n nVar) {
        X4.b.d(nVar, "other is null");
        return AbstractC2283a.l(new c5.s(this, nVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f y() {
        return this instanceof Y4.b ? ((Y4.b) this).c() : AbstractC2283a.k(new c5.t(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final o z() {
        return this instanceof Y4.d ? ((Y4.d) this).a() : AbstractC2283a.m(new c5.u(this));
    }
}
