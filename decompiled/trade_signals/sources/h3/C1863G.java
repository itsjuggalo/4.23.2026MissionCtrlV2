package h3;

import java.util.Collections;
import java.util.List;
import m3.C2374a;
import p3.AbstractC2554h;
import p3.C2548b;
import p3.C2559m;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: h3.G, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1863G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1875k f18411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1862F f18412b;

    public C1863G(C1875k c1875k, C1862F c1862f) {
        this.f18411a = c1875k;
        this.f18412b = c1862f;
    }

    public InterfaceC2560n a(C2548b c2548b, C2374a c2374a) {
        return this.f18412b.c(this.f18411a, c2548b, c2374a);
    }

    public InterfaceC2560n b(InterfaceC2560n interfaceC2560n) {
        return c(interfaceC2560n, Collections.emptyList());
    }

    public InterfaceC2560n c(InterfaceC2560n interfaceC2560n, List list) {
        return d(interfaceC2560n, list, false);
    }

    public InterfaceC2560n d(InterfaceC2560n interfaceC2560n, List list, boolean z7) {
        return this.f18412b.d(this.f18411a, interfaceC2560n, list, z7);
    }

    public InterfaceC2560n e(InterfaceC2560n interfaceC2560n) {
        return this.f18412b.e(this.f18411a, interfaceC2560n);
    }

    public InterfaceC2560n f(C1875k c1875k, InterfaceC2560n interfaceC2560n, InterfaceC2560n interfaceC2560n2) {
        return this.f18412b.f(this.f18411a, c1875k, interfaceC2560n, interfaceC2560n2);
    }

    public C2559m g(InterfaceC2560n interfaceC2560n, C2559m c2559m, boolean z7, AbstractC2554h abstractC2554h) {
        return this.f18412b.g(this.f18411a, interfaceC2560n, c2559m, z7, abstractC2554h);
    }

    public C1863G h(C2548b c2548b) {
        return new C1863G(this.f18411a.K(c2548b), this.f18412b);
    }

    public InterfaceC2560n i(C1875k c1875k) {
        return this.f18412b.o(this.f18411a.J(c1875k));
    }
}
