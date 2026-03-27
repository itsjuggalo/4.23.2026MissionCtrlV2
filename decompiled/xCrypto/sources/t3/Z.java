package t3;

import W2.p;
import y3.C1956j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Z {
    public static final void a(Y y4, int i4) {
        Z2.e eVarC = y4.c();
        boolean z4 = i4 == 4;
        if (z4 || !(eVarC instanceof C1956j) || b(i4) != b(y4.f14971c)) {
            d(y4, eVarC, z4);
            return;
        }
        I i5 = ((C1956j) eVarC).f15984d;
        Z2.i context = eVarC.getContext();
        if (i5.e0(context)) {
            i5.d0(context, y4);
        } else {
            e(y4);
        }
    }

    public static final boolean b(int i4) {
        return i4 == 1 || i4 == 2;
    }

    public static final boolean c(int i4) {
        return i4 == 2;
    }

    public static final void d(Y y4, Z2.e eVar, boolean z4) {
        Object objE;
        Object objK = y4.k();
        Throwable thD = y4.d(objK);
        if (thD != null) {
            p.a aVar = W2.p.f5487b;
            objE = W2.q.a(thD);
        } else {
            p.a aVar2 = W2.p.f5487b;
            objE = y4.e(objK);
        }
        Object objB = W2.p.b(objE);
        if (!z4) {
            eVar.resumeWith(objB);
            return;
        }
        kotlin.jvm.internal.r.d(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        C1956j c1956j = (C1956j) eVar;
        Z2.e eVar2 = c1956j.f15985e;
        Object obj = c1956j.f15987g;
        Z2.i context = eVar2.getContext();
        Object objC = y3.J.c(context, obj);
        Z0 z0G = objC != y3.J.f15961a ? H.g(eVar2, context, objC) : null;
        try {
            c1956j.f15985e.resumeWith(objB);
            W2.E e4 = W2.E.f5463a;
            if (z0G == null || z0G.O0()) {
                y3.J.a(context, objC);
            }
        } catch (Throwable th) {
            if (z0G == null || z0G.O0()) {
                y3.J.a(context, objC);
            }
            throw th;
        }
    }

    public static final void e(Y y4) {
        AbstractC1815g0 abstractC1815g0B = U0.f14966a.b();
        if (abstractC1815g0B.n0()) {
            abstractC1815g0B.j0(y4);
            return;
        }
        abstractC1815g0B.l0(true);
        try {
            d(y4, y4.c(), true);
            do {
            } while (abstractC1815g0B.q0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
