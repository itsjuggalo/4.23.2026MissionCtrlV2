package b6;

import java.util.Iterator;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class C0 {
    public static final InterfaceC1054A a(InterfaceC1101w0 interfaceC1101w0) {
        return new C1107z0(interfaceC1101w0);
    }

    public static /* synthetic */ InterfaceC1054A b(InterfaceC1101w0 interfaceC1101w0, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            interfaceC1101w0 = null;
        }
        return A0.a(interfaceC1101w0);
    }

    public static final void c(H5.g gVar, CancellationException cancellationException) {
        InterfaceC1101w0 interfaceC1101w0 = (InterfaceC1101w0) gVar.get(InterfaceC1101w0.f9097L);
        if (interfaceC1101w0 != null) {
            interfaceC1101w0.cancel(cancellationException);
        }
    }

    public static final void d(H5.g gVar, CancellationException cancellationException) {
        Y5.f children;
        InterfaceC1101w0 interfaceC1101w0 = (InterfaceC1101w0) gVar.get(InterfaceC1101w0.f9097L);
        if (interfaceC1101w0 == null || (children = interfaceC1101w0.getChildren()) == null) {
            return;
        }
        Iterator it = children.iterator();
        while (it.hasNext()) {
            ((InterfaceC1101w0) it.next()).cancel(cancellationException);
        }
    }

    public static /* synthetic */ void e(H5.g gVar, CancellationException cancellationException, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            cancellationException = null;
        }
        A0.d(gVar, cancellationException);
    }

    public static final InterfaceC1062c0 f(InterfaceC1101w0 interfaceC1101w0, InterfaceC1062c0 interfaceC1062c0) {
        return interfaceC1101w0.invokeOnCompletion(new C1066e0(interfaceC1062c0));
    }

    public static final void g(H5.g gVar) {
        InterfaceC1101w0 interfaceC1101w0 = (InterfaceC1101w0) gVar.get(InterfaceC1101w0.f9097L);
        if (interfaceC1101w0 != null) {
            A0.i(interfaceC1101w0);
        }
    }

    public static final void h(InterfaceC1101w0 interfaceC1101w0) {
        if (!interfaceC1101w0.isActive()) {
            throw interfaceC1101w0.getCancellationException();
        }
    }

    public static final InterfaceC1101w0 i(H5.g gVar) {
        InterfaceC1101w0 interfaceC1101w0 = (InterfaceC1101w0) gVar.get(InterfaceC1101w0.f9097L);
        if (interfaceC1101w0 != null) {
            return interfaceC1101w0;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + gVar).toString());
    }
}
