package h6;

import E5.p;
import E5.q;
import H5.d;
import H5.g;
import I5.c;
import J5.h;
import Q5.o;
import b6.C1056C;
import b6.F0;
import b6.V0;
import g6.B;
import g6.J;
import kotlin.jvm.internal.L;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static final void a(o oVar, Object obj, d dVar) {
        d dVarA = h.a(dVar);
        try {
            g context = dVar.getContext();
            Object objC = J.c(context, null);
            try {
                Object objInvoke = ((o) L.b(oVar, 2)).invoke(obj, dVarA);
                if (objInvoke != c.e()) {
                    dVarA.resumeWith(p.b(objInvoke));
                }
            } finally {
                J.a(context, objC);
            }
        } catch (Throwable th) {
            p.a aVar = p.f1681b;
            dVarA.resumeWith(p.b(q.a(th)));
        }
    }

    public static final Object b(B b7, Object obj, o oVar) {
        Object c1056c;
        try {
            c1056c = ((o) L.b(oVar, 2)).invoke(obj, b7);
        } catch (Throwable th) {
            c1056c = new C1056C(th, false, 2, null);
        }
        if (c1056c == c.e()) {
            return c.e();
        }
        Object objK0 = b7.k0(c1056c);
        if (objK0 == F0.f8993b) {
            return c.e();
        }
        if (objK0 instanceof C1056C) {
            throw ((C1056C) objK0).f8965a;
        }
        return F0.h(objK0);
    }

    public static final Object c(B b7, Object obj, o oVar) throws Throwable {
        Object c1056c;
        try {
            c1056c = ((o) L.b(oVar, 2)).invoke(obj, b7);
        } catch (Throwable th) {
            c1056c = new C1056C(th, false, 2, null);
        }
        if (c1056c == c.e()) {
            return c.e();
        }
        Object objK0 = b7.k0(c1056c);
        if (objK0 == F0.f8993b) {
            return c.e();
        }
        if (objK0 instanceof C1056C) {
            Throwable th2 = ((C1056C) objK0).f8965a;
            if (!(th2 instanceof V0) || ((V0) th2).f9026a != b7) {
                throw th2;
            }
            if (c1056c instanceof C1056C) {
                throw ((C1056C) c1056c).f8965a;
            }
        } else {
            c1056c = F0.h(objK0);
        }
        return c1056c;
    }
}
