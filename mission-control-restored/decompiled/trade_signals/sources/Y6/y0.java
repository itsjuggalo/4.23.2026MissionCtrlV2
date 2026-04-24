package Y6;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.AbstractC2302q;
import o5.C2470H;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class y0 {

    public /* synthetic */ class a extends AbstractC2302q implements B5.k {
        public a(Object obj) {
            super(1, obj, z0.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m((Throwable) obj);
            return C2470H.f21956a;
        }

        public final void m(Throwable th) {
            ((z0) this.receiver).w(th);
        }
    }

    public static final InterfaceC1037y a(InterfaceC1033u0 interfaceC1033u0) {
        return new w0(interfaceC1033u0);
    }

    public static /* synthetic */ InterfaceC1037y b(InterfaceC1033u0 interfaceC1033u0, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            interfaceC1033u0 = null;
        }
        return x0.a(interfaceC1033u0);
    }

    public static final void c(InterfaceC2711i interfaceC2711i, CancellationException cancellationException) {
        InterfaceC1033u0 interfaceC1033u0 = (InterfaceC1033u0) interfaceC2711i.a(InterfaceC1033u0.f9694L);
        if (interfaceC1033u0 != null) {
            interfaceC1033u0.e(cancellationException);
        }
    }

    public static final void d(InterfaceC1033u0 interfaceC1033u0) {
        if (!interfaceC1033u0.c()) {
            throw interfaceC1033u0.B();
        }
    }

    public static final void e(InterfaceC2711i interfaceC2711i) {
        InterfaceC1033u0 interfaceC1033u0 = (InterfaceC1033u0) interfaceC2711i.a(InterfaceC1033u0.f9694L);
        if (interfaceC1033u0 != null) {
            x0.d(interfaceC1033u0);
        }
    }

    public static final InterfaceC0996b0 f(InterfaceC1033u0 interfaceC1033u0, boolean z7, z0 z0Var) {
        return interfaceC1033u0 instanceof A0 ? ((A0) interfaceC1033u0).n0(z7, z0Var) : interfaceC1033u0.r(z0Var.v(), z7, new a(z0Var));
    }

    public static /* synthetic */ InterfaceC0996b0 g(InterfaceC1033u0 interfaceC1033u0, boolean z7, z0 z0Var, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = true;
        }
        return x0.f(interfaceC1033u0, z7, z0Var);
    }
}
