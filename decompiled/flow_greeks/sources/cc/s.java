package cc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s implements u {
    public static s g(Object obj) {
        kc.b.d(obj, "item is null");
        return yc.a.n(new sc.c(obj));
    }

    @Override // cc.u
    public final void b(t tVar) {
        kc.b.d(tVar, "observer is null");
        t tVarW = yc.a.w(this, tVar);
        kc.b.d(tVarW, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            j(tVarW);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            gc.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final s d(ic.d dVar) {
        kc.b.d(dVar, "onError is null");
        return yc.a.n(new sc.a(this, dVar));
    }

    public final s e(ic.d dVar) {
        kc.b.d(dVar, "onSuccess is null");
        return yc.a.n(new sc.b(this, dVar));
    }

    public final j f(ic.g gVar) {
        kc.b.d(gVar, "predicate is null");
        return yc.a.l(new pc.f(this, gVar));
    }

    public final s h(s sVar) {
        kc.b.d(sVar, "resumeSingleInCaseOfError is null");
        return i(kc.a.e(sVar));
    }

    public final s i(ic.e eVar) {
        kc.b.d(eVar, "resumeFunctionInCaseOfError is null");
        return yc.a.n(new sc.d(this, eVar));
    }

    public abstract void j(t tVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final f k() {
        return this instanceof lc.b ? ((lc.b) this).c() : yc.a.k(new sc.e(this));
    }
}
