package b6;

import H5.g;
import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: b6.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC1101w0 extends g.b {

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final b f9097L = b.f9098a;

    /* JADX INFO: renamed from: b6.w0$b */
    public static final class b implements g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f9098a = new b();
    }

    InterfaceC1096u attachChild(InterfaceC1100w interfaceC1100w);

    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    CancellationException getCancellationException();

    Y5.f getChildren();

    j6.a getOnJoin();

    InterfaceC1101w0 getParent();

    InterfaceC1062c0 invokeOnCompletion(Q5.k kVar);

    InterfaceC1062c0 invokeOnCompletion(boolean z7, boolean z8, Q5.k kVar);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(H5.d dVar);

    InterfaceC1101w0 plus(InterfaceC1101w0 interfaceC1101w0);

    boolean start();

    /* JADX INFO: renamed from: b6.w0$a */
    public static final class a {
        public static /* synthetic */ void b(InterfaceC1101w0 interfaceC1101w0, CancellationException cancellationException, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i7 & 1) != 0) {
                cancellationException = null;
            }
            interfaceC1101w0.cancel(cancellationException);
        }

        public static Object c(InterfaceC1101w0 interfaceC1101w0, Object obj, Q5.o oVar) {
            return g.b.a.a(interfaceC1101w0, obj, oVar);
        }

        public static g.b d(InterfaceC1101w0 interfaceC1101w0, g.c cVar) {
            return g.b.a.b(interfaceC1101w0, cVar);
        }

        public static /* synthetic */ InterfaceC1062c0 e(InterfaceC1101w0 interfaceC1101w0, boolean z7, boolean z8, Q5.k kVar, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i7 & 1) != 0) {
                z7 = false;
            }
            if ((i7 & 2) != 0) {
                z8 = true;
            }
            return interfaceC1101w0.invokeOnCompletion(z7, z8, kVar);
        }

        public static H5.g f(InterfaceC1101w0 interfaceC1101w0, g.c cVar) {
            return g.b.a.c(interfaceC1101w0, cVar);
        }

        public static H5.g g(InterfaceC1101w0 interfaceC1101w0, H5.g gVar) {
            return g.b.a.d(interfaceC1101w0, gVar);
        }

        public static InterfaceC1101w0 h(InterfaceC1101w0 interfaceC1101w0, InterfaceC1101w0 interfaceC1101w02) {
            return interfaceC1101w02;
        }
    }
}
