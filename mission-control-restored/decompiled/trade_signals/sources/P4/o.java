package P4;

import b5.C1216n;
import b5.C1223u;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o implements p {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6439a;

        static {
            int[] iArr = new int[P4.a.values().length];
            f6439a = iArr;
            try {
                iArr[P4.a.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6439a[P4.a.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6439a[P4.a.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6439a[P4.a.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int f() {
        return f.b();
    }

    public static o h() {
        return AbstractC2283a.m(d5.d.f16903a);
    }

    public static o p(Iterable iterable) {
        X4.b.d(iterable, "source is null");
        return AbstractC2283a.m(new d5.i(iterable));
    }

    public static o q(Object obj) {
        X4.b.d(obj, "The item is null");
        return AbstractC2283a.m(new d5.j(obj));
    }

    @Override // P4.p
    public final void d(q qVar) {
        X4.b.d(qVar, "observer is null");
        try {
            q qVarV = AbstractC2283a.v(this, qVar);
            X4.b.d(qVarV, "Plugin returned null Observer");
            s(qVarV);
        } catch (NullPointerException e8) {
            throw e8;
        } catch (Throwable th) {
            T4.b.b(th);
            AbstractC2283a.q(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final s e(V4.g gVar) {
        X4.b.d(gVar, "predicate is null");
        return AbstractC2283a.n(new d5.c(this, gVar));
    }

    public final s g(Object obj) {
        X4.b.d(obj, "element is null");
        return e(X4.a.c(obj));
    }

    public final o i(V4.g gVar) {
        X4.b.d(gVar, "predicate is null");
        return AbstractC2283a.m(new d5.e(this, gVar));
    }

    public final o j(V4.e eVar) {
        return k(eVar, false);
    }

    public final o k(V4.e eVar, boolean z7) {
        return l(eVar, z7, Integer.MAX_VALUE);
    }

    public final o l(V4.e eVar, boolean z7, int i8) {
        return m(eVar, z7, i8, f());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final o m(V4.e eVar, boolean z7, int i8, int i9) {
        X4.b.d(eVar, "mapper is null");
        X4.b.e(i8, "maxConcurrency");
        X4.b.e(i9, "bufferSize");
        if (!(this instanceof Y4.h)) {
            return AbstractC2283a.m(new d5.f(this, eVar, z7, i8, i9));
        }
        Object objCall = ((Y4.h) this).call();
        return objCall == null ? h() : d5.l.a(objCall, eVar);
    }

    public final b n(V4.e eVar) {
        return o(eVar, false);
    }

    public final b o(V4.e eVar, boolean z7) {
        X4.b.d(eVar, "mapper is null");
        return AbstractC2283a.j(new d5.h(this, eVar, z7));
    }

    public final o r(V4.e eVar) {
        X4.b.d(eVar, "mapper is null");
        return AbstractC2283a.m(new d5.k(this, eVar));
    }

    public abstract void s(q qVar);

    public final o t(p pVar) {
        X4.b.d(pVar, "other is null");
        return AbstractC2283a.m(new d5.m(this, pVar));
    }

    public final f u(P4.a aVar) {
        C1216n c1216n = new C1216n(this);
        int i8 = a.f6439a[aVar.ordinal()];
        return i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? c1216n.y() : AbstractC2283a.k(new C1223u(c1216n)) : c1216n : c1216n.B() : c1216n.A();
    }
}
