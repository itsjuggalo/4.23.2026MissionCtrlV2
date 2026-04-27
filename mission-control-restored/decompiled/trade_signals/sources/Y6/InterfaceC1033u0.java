package Y6;

import java.util.concurrent.CancellationException;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: Y6.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC1033u0 extends InterfaceC2711i.b {

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final b f9694L = b.f9695a;

    /* JADX INFO: renamed from: Y6.u0$a */
    public static final class a {
        public static /* synthetic */ void a(InterfaceC1033u0 interfaceC1033u0, CancellationException cancellationException, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i8 & 1) != 0) {
                cancellationException = null;
            }
            interfaceC1033u0.e(cancellationException);
        }

        public static Object b(InterfaceC1033u0 interfaceC1033u0, Object obj, B5.o oVar) {
            return InterfaceC2711i.b.a.a(interfaceC1033u0, obj, oVar);
        }

        public static InterfaceC2711i.b c(InterfaceC1033u0 interfaceC1033u0, InterfaceC2711i.c cVar) {
            return InterfaceC2711i.b.a.b(interfaceC1033u0, cVar);
        }

        public static InterfaceC2711i d(InterfaceC1033u0 interfaceC1033u0, InterfaceC2711i.c cVar) {
            return InterfaceC2711i.b.a.c(interfaceC1033u0, cVar);
        }

        public static InterfaceC2711i e(InterfaceC1033u0 interfaceC1033u0, InterfaceC2711i interfaceC2711i) {
            return InterfaceC2711i.b.a.d(interfaceC1033u0, interfaceC2711i);
        }
    }

    /* JADX INFO: renamed from: Y6.u0$b */
    public static final class b implements InterfaceC2711i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f9695a = new b();
    }

    CancellationException B();

    InterfaceC0996b0 E(B5.k kVar);

    InterfaceC1028s N(InterfaceC1032u interfaceC1032u);

    boolean c();

    void e(CancellationException cancellationException);

    boolean i0();

    boolean isCancelled();

    InterfaceC0996b0 r(boolean z7, boolean z8, B5.k kVar);

    boolean start();
}
