package v3;

import W2.AbstractC0737e;
import W2.E;
import kotlin.jvm.internal.G;
import t3.b1;
import v3.h;
import y3.O;
import y3.x;

/* JADX INFO: loaded from: classes3.dex */
public class p extends b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f15374m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f15375n;

    public p(int i4, a aVar, i3.k kVar) {
        super(i4, kVar);
        this.f15374m = i4;
        this.f15375n = aVar;
        if (aVar == a.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + G.b(b.class).b() + " instead").toString());
        }
        if (i4 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i4 + " was specified").toString());
    }

    public static /* synthetic */ Object G0(p pVar, Object obj, Z2.e eVar) throws Throwable {
        O oD;
        Object objJ0 = pVar.J0(obj, true);
        if (!(objJ0 instanceof h.a)) {
            return E.f5463a;
        }
        h.e(objJ0);
        i3.k kVar = pVar.f15332b;
        if (kVar == null || (oD = x.d(kVar, obj, null, 2, null)) == null) {
            throw pVar.M();
        }
        AbstractC0737e.a(oD, pVar.M());
        throw oD;
    }

    public final Object H0(Object obj, boolean z4) {
        i3.k kVar;
        O oD;
        Object objM = super.m(obj);
        if (h.i(objM) || h.h(objM)) {
            return objM;
        }
        if (!z4 || (kVar = this.f15332b) == null || (oD = x.d(kVar, obj, null, 2, null)) == null) {
            return h.f15364b.c(E.f5463a);
        }
        throw oD;
    }

    public final Object I0(Object obj) {
        j jVarH;
        int i4;
        p pVar;
        Object obj2 = c.f15343d;
        j jVar = (j) b.f15326h.get(this);
        while (true) {
            long andIncrement = b.f15322d.getAndIncrement(this);
            long j4 = andIncrement & 1152921504606846975L;
            boolean zW = W(andIncrement);
            int i5 = c.f15341b;
            long j5 = j4 / ((long) i5);
            int i6 = (int) (j4 % ((long) i5));
            if (jVar.f15955c != j5) {
                jVarH = H(j5, jVar);
                if (jVarH != null) {
                    pVar = this;
                    i4 = i6;
                } else if (zW) {
                    return h.f15364b.a(M());
                }
            } else {
                jVarH = jVar;
                i4 = i6;
                pVar = this;
            }
            Object obj3 = obj;
            int iB0 = pVar.B0(jVarH, i4, obj3, j4, obj2, zW);
            jVar = jVarH;
            if (iB0 == 0) {
                jVar.b();
                return h.f15364b.c(E.f5463a);
            }
            if (iB0 == 1) {
                return h.f15364b.c(E.f5463a);
            }
            if (iB0 == 2) {
                if (zW) {
                    jVar.p();
                    return h.f15364b.a(M());
                }
                b1 b1Var = obj2 instanceof b1 ? (b1) obj2 : null;
                if (b1Var != null) {
                    l0(b1Var, jVar, i4);
                }
                D((jVar.f15955c * ((long) i5)) + ((long) i4));
                return h.f15364b.c(E.f5463a);
            }
            if (iB0 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iB0 == 4) {
                if (j4 < L()) {
                    jVar.b();
                }
                return h.f15364b.a(M());
            }
            if (iB0 == 5) {
                jVar.b();
            }
            obj = obj3;
        }
    }

    public final Object J0(Object obj, boolean z4) {
        return this.f15375n == a.DROP_LATEST ? H0(obj, z4) : I0(obj);
    }

    @Override // v3.b
    public boolean X() {
        return this.f15375n == a.DROP_OLDEST;
    }

    @Override // v3.b, v3.u
    public Object a(Object obj, Z2.e eVar) {
        return G0(this, obj, eVar);
    }

    @Override // v3.b, v3.u
    public Object m(Object obj) {
        return J0(obj, false);
    }
}
