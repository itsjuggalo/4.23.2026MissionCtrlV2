package cc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o implements p {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3825a;

        static {
            int[] iArr = new int[cc.a.values().length];
            f3825a = iArr;
            try {
                iArr[cc.a.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3825a[cc.a.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3825a[cc.a.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3825a[cc.a.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static o h(Iterable iterable) {
        kc.b.d(iterable, "source is null");
        return yc.a.m(new rc.e(iterable));
    }

    public static o i(Object obj) {
        kc.b.d(obj, "item is null");
        return yc.a.m(new rc.f(obj));
    }

    @Override // cc.p
    public final void b(q qVar) {
        kc.b.d(qVar, "observer is null");
        try {
            q qVarV = yc.a.v(this, qVar);
            kc.b.d(qVarV, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            k(qVarV);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            gc.b.b(th);
            yc.a.q(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final s c(ic.g gVar) {
        kc.b.d(gVar, "predicate is null");
        return yc.a.n(new rc.b(this, gVar));
    }

    public final s d(Object obj) {
        kc.b.d(obj, "element is null");
        return c(kc.a.c(obj));
    }

    public final o e(ic.g gVar) {
        kc.b.d(gVar, "predicate is null");
        return yc.a.m(new rc.c(this, gVar));
    }

    public final b f(ic.e eVar) {
        return g(eVar, false);
    }

    public final b g(ic.e eVar, boolean z10) {
        kc.b.d(eVar, "mapper is null");
        return yc.a.j(new rc.d(this, eVar, z10));
    }

    public final o j(ic.e eVar) {
        kc.b.d(eVar, "mapper is null");
        return yc.a.m(new rc.g(this, eVar));
    }

    public abstract void k(q qVar);

    public final o l(p pVar) {
        kc.b.d(pVar, "other is null");
        return yc.a.m(new rc.i(this, pVar));
    }

    public final f m(cc.a aVar) {
        oc.n nVar = new oc.n(this);
        int i10 = a.f3825a[aVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? nVar.y() : yc.a.k(new oc.u(nVar)) : nVar : nVar.B() : nVar.A();
    }
}
