package t3;

import Z2.i;
import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: t3.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC1846w0 extends i.b {

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final b f15039M = b.f15040a;

    /* JADX INFO: renamed from: t3.w0$b */
    public static final class b implements i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f15040a = new b();
    }

    InterfaceC1841u attachChild(InterfaceC1845w interfaceC1845w);

    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    CancellationException getCancellationException();

    q3.e getChildren();

    B3.a getOnJoin();

    InterfaceC1846w0 getParent();

    InterfaceC1807c0 invokeOnCompletion(i3.k kVar);

    InterfaceC1807c0 invokeOnCompletion(boolean z4, boolean z5, i3.k kVar);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(Z2.e eVar);

    InterfaceC1846w0 plus(InterfaceC1846w0 interfaceC1846w0);

    boolean start();

    /* JADX INFO: renamed from: t3.w0$a */
    public static final class a {
        public static /* synthetic */ void b(InterfaceC1846w0 interfaceC1846w0, CancellationException cancellationException, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i4 & 1) != 0) {
                cancellationException = null;
            }
            interfaceC1846w0.cancel(cancellationException);
        }

        public static Object c(InterfaceC1846w0 interfaceC1846w0, Object obj, i3.o oVar) {
            return i.b.a.a(interfaceC1846w0, obj, oVar);
        }

        public static i.b d(InterfaceC1846w0 interfaceC1846w0, i.c cVar) {
            return i.b.a.b(interfaceC1846w0, cVar);
        }

        public static /* synthetic */ InterfaceC1807c0 e(InterfaceC1846w0 interfaceC1846w0, boolean z4, boolean z5, i3.k kVar, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i4 & 1) != 0) {
                z4 = false;
            }
            if ((i4 & 2) != 0) {
                z5 = true;
            }
            return interfaceC1846w0.invokeOnCompletion(z4, z5, kVar);
        }

        public static Z2.i f(InterfaceC1846w0 interfaceC1846w0, i.c cVar) {
            return i.b.a.c(interfaceC1846w0, cVar);
        }

        public static Z2.i g(InterfaceC1846w0 interfaceC1846w0, Z2.i iVar) {
            return i.b.a.d(interfaceC1846w0, iVar);
        }

        public static InterfaceC1846w0 h(InterfaceC1846w0 interfaceC1846w0, InterfaceC1846w0 interfaceC1846w02) {
            return interfaceC1846w02;
        }
    }
}
