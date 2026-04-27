package P4;

import e5.C1670a;
import e5.C1671b;
import e5.C1672c;
import e5.C1673d;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s implements u {
    public static s h(Object obj) {
        X4.b.d(obj, "value is null");
        return AbstractC2283a.n(new C1672c(obj));
    }

    @Override // P4.u
    public final void d(t tVar) {
        X4.b.d(tVar, "subscriber is null");
        t tVarW = AbstractC2283a.w(this, tVar);
        X4.b.d(tVarW, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            k(tVarW);
        } catch (NullPointerException e8) {
            throw e8;
        } catch (Throwable th) {
            T4.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final s e(V4.d dVar) {
        X4.b.d(dVar, "onError is null");
        return AbstractC2283a.n(new C1670a(this, dVar));
    }

    public final s f(V4.d dVar) {
        X4.b.d(dVar, "onSuccess is null");
        return AbstractC2283a.n(new C1671b(this, dVar));
    }

    public final j g(V4.g gVar) {
        X4.b.d(gVar, "predicate is null");
        return AbstractC2283a.l(new c5.f(this, gVar));
    }

    public final s i(s sVar) {
        X4.b.d(sVar, "resumeSingleInCaseOfError is null");
        return j(X4.a.e(sVar));
    }

    public final s j(V4.e eVar) {
        X4.b.d(eVar, "resumeFunctionInCaseOfError is null");
        return AbstractC2283a.n(new C1673d(this, eVar));
    }

    public abstract void k(t tVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final f l() {
        return this instanceof Y4.b ? ((Y4.b) this).c() : AbstractC2283a.k(new e5.e(this));
    }
}
