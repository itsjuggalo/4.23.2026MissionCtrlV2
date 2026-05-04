package ng;

import cd.r;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z0 extends ug.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17199c;

    public z0(int i10) {
        this.f17199c = i10;
    }

    public abstract gd.e d();

    public Throwable e(Object obj) {
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        if (c0Var != null) {
            return c0Var.f17078a;
        }
        return null;
    }

    public final void i(Throwable th) {
        m0.a(d().getContext(), new q0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object l();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            gd.e eVarD = d();
            kotlin.jvm.internal.t.d(eVarD, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            sg.h hVar = (sg.h) eVarD;
            gd.e eVar = hVar.f20391e;
            Object obj = hVar.f20393g;
            gd.i context = eVar.getContext();
            Object objI = sg.k0.i(context, obj);
            y1 y1Var = null;
            a3 a3VarM = objI != sg.k0.f20405a ? i0.m(eVar, context, objI) : null;
            try {
                gd.i context2 = eVar.getContext();
                Object objL = l();
                Throwable thE = e(objL);
                if (thE == null && a1.b(this.f17199c)) {
                    y1Var = (y1) context2.get(y1.N);
                }
                if (y1Var != null && !y1Var.isActive()) {
                    CancellationException cancellationException = y1Var.getCancellationException();
                    a(objL, cancellationException);
                    r.a aVar = cd.r.f3870b;
                    eVar.resumeWith(cd.r.b(cd.s.a(cancellationException)));
                } else if (thE != null) {
                    r.a aVar2 = cd.r.f3870b;
                    eVar.resumeWith(cd.r.b(cd.s.a(thE)));
                } else {
                    r.a aVar3 = cd.r.f3870b;
                    eVar.resumeWith(cd.r.b(g(objL)));
                }
                cd.h0 h0Var = cd.h0.f3852a;
                if (a3VarM != null && !a3VarM.O0()) {
                    return;
                }
                sg.k0.f(context, objI);
            } catch (Throwable th) {
                if (a3VarM == null || a3VarM.O0()) {
                    sg.k0.f(context, objI);
                }
                throw th;
            }
        } catch (Throwable th2) {
            i(th2);
        }
    }

    public Object g(Object obj) {
        return obj;
    }

    public void a(Object obj, Throwable th) {
    }
}
