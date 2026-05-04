package cc;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements d {
    public static b c() {
        return yc.a.j(nc.b.f17004a);
    }

    public static b g(ic.a aVar) {
        kc.b.d(aVar, "run is null");
        return yc.a.j(new nc.c(aVar));
    }

    public static b h(Callable callable) {
        kc.b.d(callable, "callable is null");
        return yc.a.j(new nc.d(callable));
    }

    public static NullPointerException o(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @Override // cc.d
    public final void a(c cVar) {
        kc.b.d(cVar, "observer is null");
        try {
            c cVarT = yc.a.t(this, cVar);
            kc.b.d(cVarT, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            m(cVarT);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            gc.b.b(th);
            yc.a.q(th);
            throw o(th);
        }
    }

    public final b b(d dVar) {
        kc.b.d(dVar, "next is null");
        return yc.a.j(new nc.a(this, dVar));
    }

    public final b d(ic.a aVar) {
        ic.d dVarB = kc.a.b();
        ic.d dVarB2 = kc.a.b();
        ic.a aVar2 = kc.a.f14806c;
        return f(dVarB, dVarB2, aVar, aVar2, aVar2, aVar2);
    }

    public final b e(ic.d dVar) {
        ic.d dVarB = kc.a.b();
        ic.a aVar = kc.a.f14806c;
        return f(dVarB, dVar, aVar, aVar, aVar, aVar);
    }

    public final b f(ic.d dVar, ic.d dVar2, ic.a aVar, ic.a aVar2, ic.a aVar3, ic.a aVar4) {
        kc.b.d(dVar, "onSubscribe is null");
        kc.b.d(dVar2, "onError is null");
        kc.b.d(aVar, "onComplete is null");
        kc.b.d(aVar2, "onTerminate is null");
        kc.b.d(aVar3, "onAfterTerminate is null");
        kc.b.d(aVar4, "onDispose is null");
        return yc.a.j(new nc.f(this, dVar, dVar2, aVar, aVar2, aVar3, aVar4));
    }

    public final b i() {
        return j(kc.a.a());
    }

    public final b j(ic.g gVar) {
        kc.b.d(gVar, "predicate is null");
        return yc.a.j(new nc.e(this, gVar));
    }

    public final b k(ic.e eVar) {
        kc.b.d(eVar, "errorMapper is null");
        return yc.a.j(new nc.g(this, eVar));
    }

    public final fc.b l() {
        mc.c cVar = new mc.c();
        a(cVar);
        return cVar;
    }

    public abstract void m(c cVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final j n() {
        return this instanceof lc.c ? ((lc.c) this).a() : yc.a.l(new pc.j(this));
    }
}
