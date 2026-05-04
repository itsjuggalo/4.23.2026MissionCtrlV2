package ng;

import gd.i;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface y1 extends i.b {
    public static final b N = b.f17198a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f17198a = new b();
    }

    u attachChild(w wVar);

    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    CancellationException getCancellationException();

    jg.h getChildren();

    vg.a getOnJoin();

    y1 getParent();

    e1 invokeOnCompletion(pd.k kVar);

    e1 invokeOnCompletion(boolean z10, boolean z11, pd.k kVar);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(gd.e eVar);

    y1 plus(y1 y1Var);

    boolean start();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static /* synthetic */ void b(y1 y1Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            y1Var.cancel(cancellationException);
        }

        public static Object c(y1 y1Var, Object obj, pd.o oVar) {
            return i.b.a.a(y1Var, obj, oVar);
        }

        public static i.b d(y1 y1Var, i.c cVar) {
            return i.b.a.b(y1Var, cVar);
        }

        public static gd.i e(y1 y1Var, i.c cVar) {
            return i.b.a.c(y1Var, cVar);
        }

        public static gd.i f(y1 y1Var, gd.i iVar) {
            return i.b.a.d(y1Var, iVar);
        }

        public static y1 g(y1 y1Var, y1 y1Var2) {
            return y1Var2;
        }
    }
}
