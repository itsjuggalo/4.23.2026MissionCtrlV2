package P4;

import a5.C1074a;
import a5.C1075b;
import java.util.concurrent.Callable;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements d {
    public static b d() {
        return AbstractC2283a.j(C1075b.f9970a);
    }

    public static b e(d... dVarArr) {
        X4.b.d(dVarArr, "sources is null");
        return dVarArr.length == 0 ? d() : dVarArr.length == 1 ? s(dVarArr[0]) : AbstractC2283a.j(new C1074a(dVarArr));
    }

    public static b j(V4.a aVar) {
        X4.b.d(aVar, "run is null");
        return AbstractC2283a.j(new a5.c(aVar));
    }

    public static b k(Callable callable) {
        X4.b.d(callable, "callable is null");
        return AbstractC2283a.j(new a5.d(callable));
    }

    public static NullPointerException r(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static b s(d dVar) {
        X4.b.d(dVar, "source is null");
        return dVar instanceof b ? AbstractC2283a.j((b) dVar) : AbstractC2283a.j(new a5.e(dVar));
    }

    @Override // P4.d
    public final void b(c cVar) {
        X4.b.d(cVar, "s is null");
        try {
            p(AbstractC2283a.t(this, cVar));
        } catch (NullPointerException e8) {
            throw e8;
        } catch (Throwable th) {
            T4.b.b(th);
            AbstractC2283a.q(th);
            throw r(th);
        }
    }

    public final b c(d dVar) {
        return f(dVar);
    }

    public final b f(d dVar) {
        X4.b.d(dVar, "other is null");
        return e(this, dVar);
    }

    public final b g(V4.a aVar) {
        V4.d dVarB = X4.a.b();
        V4.d dVarB2 = X4.a.b();
        V4.a aVar2 = X4.a.f9377c;
        return i(dVarB, dVarB2, aVar, aVar2, aVar2, aVar2);
    }

    public final b h(V4.d dVar) {
        V4.d dVarB = X4.a.b();
        V4.a aVar = X4.a.f9377c;
        return i(dVarB, dVar, aVar, aVar, aVar, aVar);
    }

    public final b i(V4.d dVar, V4.d dVar2, V4.a aVar, V4.a aVar2, V4.a aVar3, V4.a aVar4) {
        X4.b.d(dVar, "onSubscribe is null");
        X4.b.d(dVar2, "onError is null");
        X4.b.d(aVar, "onComplete is null");
        X4.b.d(aVar2, "onTerminate is null");
        X4.b.d(aVar3, "onAfterTerminate is null");
        X4.b.d(aVar4, "onDispose is null");
        return AbstractC2283a.j(new a5.g(this, dVar, dVar2, aVar, aVar2, aVar3, aVar4));
    }

    public final b l() {
        return m(X4.a.a());
    }

    public final b m(V4.g gVar) {
        X4.b.d(gVar, "predicate is null");
        return AbstractC2283a.j(new a5.f(this, gVar));
    }

    public final b n(V4.e eVar) {
        X4.b.d(eVar, "errorMapper is null");
        return AbstractC2283a.j(new a5.h(this, eVar));
    }

    public final S4.b o() {
        Z4.e eVar = new Z4.e();
        b(eVar);
        return eVar;
    }

    public abstract void p(c cVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final j q() {
        return this instanceof Y4.c ? ((Y4.c) this).b() : AbstractC2283a.l(new c5.j(this));
    }
}
