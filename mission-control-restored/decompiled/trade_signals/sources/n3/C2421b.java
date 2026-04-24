package n3;

import h3.C1875k;
import k3.AbstractC2279m;
import m3.C2376c;
import n3.InterfaceC2423d;
import p3.AbstractC2554h;
import p3.C2548b;
import p3.C2555i;
import p3.C2559m;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: n3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2421b implements InterfaceC2423d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2554h f21606a;

    public C2421b(AbstractC2554h abstractC2554h) {
        this.f21606a = abstractC2554h;
    }

    @Override // n3.InterfaceC2423d
    public C2555i a(C2555i c2555i, C2548b c2548b, InterfaceC2560n interfaceC2560n, C1875k c1875k, InterfaceC2423d.a aVar, C2420a c2420a) {
        C2376c c2376cC;
        AbstractC2279m.g(c2555i.F(this.f21606a), "The index must match the filter");
        InterfaceC2560n interfaceC2560nN = c2555i.n();
        InterfaceC2560n interfaceC2560nZ = interfaceC2560nN.z(c2548b);
        if (interfaceC2560nZ.s(c1875k).equals(interfaceC2560n.s(c1875k)) && interfaceC2560nZ.isEmpty() == interfaceC2560n.isEmpty()) {
            return c2555i;
        }
        if (c2420a != null) {
            if (!interfaceC2560n.isEmpty()) {
                c2376cC = interfaceC2560nZ.isEmpty() ? C2376c.c(c2548b, interfaceC2560n) : C2376c.e(c2548b, interfaceC2560n, interfaceC2560nZ);
            } else if (interfaceC2560nN.u(c2548b)) {
                c2376cC = C2376c.h(c2548b, interfaceC2560nZ);
            } else {
                AbstractC2279m.g(interfaceC2560nN.x(), "A child remove without an old child only makes sense on a leaf node");
            }
            c2420a.b(c2376cC);
        }
        return (interfaceC2560nN.x() && interfaceC2560n.isEmpty()) ? c2555i : c2555i.H(c2548b, interfaceC2560n);
    }

    @Override // n3.InterfaceC2423d
    public boolean c() {
        return false;
    }

    @Override // n3.InterfaceC2423d
    public C2555i d(C2555i c2555i, InterfaceC2560n interfaceC2560n) {
        return c2555i.n().isEmpty() ? c2555i : c2555i.I(interfaceC2560n);
    }

    @Override // n3.InterfaceC2423d
    public C2555i e(C2555i c2555i, C2555i c2555i2, C2420a c2420a) {
        C2376c c2376cC;
        AbstractC2279m.g(c2555i2.F(this.f21606a), "Can't use IndexedNode that doesn't have filter's index");
        if (c2420a != null) {
            for (C2559m c2559m : c2555i.n()) {
                if (!c2555i2.n().u(c2559m.c())) {
                    c2420a.b(C2376c.h(c2559m.c(), c2559m.d()));
                }
            }
            if (!c2555i2.n().x()) {
                for (C2559m c2559m2 : c2555i2.n()) {
                    if (c2555i.n().u(c2559m2.c())) {
                        InterfaceC2560n interfaceC2560nZ = c2555i.n().z(c2559m2.c());
                        if (!interfaceC2560nZ.equals(c2559m2.d())) {
                            c2376cC = C2376c.e(c2559m2.c(), c2559m2.d(), interfaceC2560nZ);
                        }
                    } else {
                        c2376cC = C2376c.c(c2559m2.c(), c2559m2.d());
                    }
                    c2420a.b(c2376cC);
                }
            }
        }
        return c2555i2;
    }

    @Override // n3.InterfaceC2423d
    public AbstractC2554h g() {
        return this.f21606a;
    }

    @Override // n3.InterfaceC2423d
    public InterfaceC2423d b() {
        return this;
    }
}
