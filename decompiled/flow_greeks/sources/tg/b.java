package tg;

import cd.r;
import cd.s;
import gd.e;
import gd.i;
import hd.c;
import id.h;
import kotlin.jvm.internal.t0;
import ng.c0;
import ng.f2;
import ng.w2;
import pd.o;
import sg.k0;
import sg.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final void a(o oVar, Object obj, e eVar) {
        e eVarA = h.a(eVar);
        try {
            i context = eVarA.getContext();
            Object objI = k0.i(context, null);
            try {
                h.b(eVarA);
                Object objD = !(oVar instanceof id.a) ? hd.b.d(oVar, obj, eVarA) : ((o) t0.c(oVar, 2)).invoke(obj, eVarA);
                k0.f(context, objI);
                if (objD != c.f()) {
                    eVarA.resumeWith(r.b(objD));
                }
            } catch (Throwable th) {
                k0.f(context, objI);
                throw th;
            }
        } catch (Throwable th2) {
            r.a aVar = r.f3870b;
            eVarA.resumeWith(r.b(s.a(th2)));
        }
    }

    public static final Object b(z zVar, Object obj, o oVar) {
        Object c0Var;
        try {
            c0Var = !(oVar instanceof id.a) ? hd.b.d(oVar, obj, zVar) : ((o) t0.c(oVar, 2)).invoke(obj, zVar);
        } catch (Throwable th) {
            c0Var = new c0(th, false, 2, null);
        }
        if (c0Var == c.f()) {
            return c.f();
        }
        Object objL0 = zVar.l0(c0Var);
        if (objL0 == f2.f17125b) {
            return c.f();
        }
        if (objL0 instanceof c0) {
            throw ((c0) objL0).f17078a;
        }
        return f2.h(objL0);
    }

    public static final Object c(z zVar, Object obj, o oVar) throws Throwable {
        Object c0Var;
        try {
            c0Var = !(oVar instanceof id.a) ? hd.b.d(oVar, obj, zVar) : ((o) t0.c(oVar, 2)).invoke(obj, zVar);
        } catch (Throwable th) {
            c0Var = new c0(th, false, 2, null);
        }
        if (c0Var == c.f()) {
            return c.f();
        }
        Object objL0 = zVar.l0(c0Var);
        if (objL0 == f2.f17125b) {
            return c.f();
        }
        if (objL0 instanceof c0) {
            Throwable th2 = ((c0) objL0).f17078a;
            if (!(th2 instanceof w2) || ((w2) th2).f17194a != zVar) {
                throw th2;
            }
            if (c0Var instanceof c0) {
                throw ((c0) c0Var).f17078a;
            }
        } else {
            c0Var = f2.h(objL0);
        }
        return c0Var;
    }
}
