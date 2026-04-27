package z3;

import W2.p;
import W2.q;
import Z2.e;
import Z2.i;
import a3.AbstractC0787c;
import b3.h;
import i3.o;
import kotlin.jvm.internal.K;
import t3.C;
import t3.F0;
import t3.V0;
import y3.B;
import y3.J;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final void a(o oVar, Object obj, e eVar) {
        e eVarA = h.a(eVar);
        try {
            i context = eVar.getContext();
            Object objC = J.c(context, null);
            try {
                Object objInvoke = ((o) K.b(oVar, 2)).invoke(obj, eVarA);
                if (objInvoke != AbstractC0787c.e()) {
                    eVarA.resumeWith(p.b(objInvoke));
                }
            } finally {
                J.a(context, objC);
            }
        } catch (Throwable th) {
            p.a aVar = p.f5487b;
            eVarA.resumeWith(p.b(q.a(th)));
        }
    }

    public static final Object b(B b4, Object obj, o oVar) {
        Object c4;
        try {
            c4 = ((o) K.b(oVar, 2)).invoke(obj, b4);
        } catch (Throwable th) {
            c4 = new C(th, false, 2, null);
        }
        if (c4 == AbstractC0787c.e()) {
            return AbstractC0787c.e();
        }
        Object objK0 = b4.k0(c4);
        if (objK0 == F0.f14935b) {
            return AbstractC0787c.e();
        }
        if (objK0 instanceof C) {
            throw ((C) objK0).f14907a;
        }
        return F0.h(objK0);
    }

    public static final Object c(B b4, Object obj, o oVar) throws Throwable {
        Object c4;
        try {
            c4 = ((o) K.b(oVar, 2)).invoke(obj, b4);
        } catch (Throwable th) {
            c4 = new C(th, false, 2, null);
        }
        if (c4 == AbstractC0787c.e()) {
            return AbstractC0787c.e();
        }
        Object objK0 = b4.k0(c4);
        if (objK0 == F0.f14935b) {
            return AbstractC0787c.e();
        }
        if (objK0 instanceof C) {
            Throwable th2 = ((C) objK0).f14907a;
            if (!(th2 instanceof V0) || ((V0) th2).f14968a != b4) {
                throw th2;
            }
            if (c4 instanceof C) {
                throw ((C) c4).f14907a;
            }
        } else {
            c4 = F0.h(objK0);
        }
        return c4;
    }
}
