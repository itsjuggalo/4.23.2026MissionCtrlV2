package t3;

import java.util.Iterator;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class C0 {
    public static final A a(InterfaceC1846w0 interfaceC1846w0) {
        return new C1852z0(interfaceC1846w0);
    }

    public static /* synthetic */ A b(InterfaceC1846w0 interfaceC1846w0, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            interfaceC1846w0 = null;
        }
        return A0.a(interfaceC1846w0);
    }

    public static final void c(Z2.i iVar, CancellationException cancellationException) {
        InterfaceC1846w0 interfaceC1846w0 = (InterfaceC1846w0) iVar.get(InterfaceC1846w0.f15039M);
        if (interfaceC1846w0 != null) {
            interfaceC1846w0.cancel(cancellationException);
        }
    }

    public static final void d(Z2.i iVar, CancellationException cancellationException) {
        q3.e children;
        InterfaceC1846w0 interfaceC1846w0 = (InterfaceC1846w0) iVar.get(InterfaceC1846w0.f15039M);
        if (interfaceC1846w0 == null || (children = interfaceC1846w0.getChildren()) == null) {
            return;
        }
        Iterator it = children.iterator();
        while (it.hasNext()) {
            ((InterfaceC1846w0) it.next()).cancel(cancellationException);
        }
    }

    public static /* synthetic */ void e(Z2.i iVar, CancellationException cancellationException, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            cancellationException = null;
        }
        A0.d(iVar, cancellationException);
    }

    public static final InterfaceC1807c0 f(InterfaceC1846w0 interfaceC1846w0, InterfaceC1807c0 interfaceC1807c0) {
        return interfaceC1846w0.invokeOnCompletion(new C1811e0(interfaceC1807c0));
    }

    public static final void g(Z2.i iVar) {
        InterfaceC1846w0 interfaceC1846w0 = (InterfaceC1846w0) iVar.get(InterfaceC1846w0.f15039M);
        if (interfaceC1846w0 != null) {
            A0.i(interfaceC1846w0);
        }
    }

    public static final void h(InterfaceC1846w0 interfaceC1846w0) {
        if (!interfaceC1846w0.isActive()) {
            throw interfaceC1846w0.getCancellationException();
        }
    }

    public static final InterfaceC1846w0 i(Z2.i iVar) {
        InterfaceC1846w0 interfaceC1846w0 = (InterfaceC1846w0) iVar.get(InterfaceC1846w0.f15039M);
        if (interfaceC1846w0 != null) {
            return interfaceC1846w0;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + iVar).toString());
    }
}
