package ng;

import java.util.Iterator;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class c2 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a extends kotlin.jvm.internal.q implements pd.k {
        public a(Object obj) {
            super(1, obj, d2.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            o((Throwable) obj);
            return cd.h0.f3852a;
        }

        public final void o(Throwable th) {
            ((d2) this.receiver).v(th);
        }
    }

    public static final a0 a(y1 y1Var) {
        return new a2(y1Var);
    }

    public static /* synthetic */ a0 b(y1 y1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            y1Var = null;
        }
        return b2.a(y1Var);
    }

    public static final void c(gd.i iVar, CancellationException cancellationException) {
        y1 y1Var = (y1) iVar.get(y1.N);
        if (y1Var != null) {
            y1Var.cancel(cancellationException);
        }
    }

    public static final void d(gd.i iVar, CancellationException cancellationException) {
        jg.h children;
        y1 y1Var = (y1) iVar.get(y1.N);
        if (y1Var == null || (children = y1Var.getChildren()) == null) {
            return;
        }
        Iterator it = children.iterator();
        while (it.hasNext()) {
            ((y1) it.next()).cancel(cancellationException);
        }
    }

    public static /* synthetic */ void e(gd.i iVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        b2.d(iVar, cancellationException);
    }

    public static final e1 f(y1 y1Var, e1 e1Var) {
        return k(y1Var, false, new g1(e1Var), 1, null);
    }

    public static final void g(gd.i iVar) {
        y1 y1Var = (y1) iVar.get(y1.N);
        if (y1Var != null) {
            b2.h(y1Var);
        }
    }

    public static final void h(y1 y1Var) {
        if (!y1Var.isActive()) {
            throw y1Var.getCancellationException();
        }
    }

    public static final y1 i(gd.i iVar) {
        y1 y1Var = (y1) iVar.get(y1.N);
        if (y1Var != null) {
            return y1Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + iVar).toString());
    }

    public static final e1 j(y1 y1Var, boolean z10, d2 d2Var) {
        return y1Var instanceof e2 ? ((e2) y1Var).f0(z10, d2Var) : y1Var.invokeOnCompletion(d2Var.u(), z10, new a(d2Var));
    }

    public static /* synthetic */ e1 k(y1 y1Var, boolean z10, d2 d2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return b2.j(y1Var, z10, d2Var);
    }
}
