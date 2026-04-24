package M2;

import K2.AbstractC0363k;
import K2.C0355c;
import M2.InterfaceC0443s;

/* JADX INFO: loaded from: classes3.dex */
public class H implements InterfaceC0445t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.l0 f1913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0443s.a f1914b;

    public H(K2.l0 l0Var, InterfaceC0443s.a aVar) {
        Z1.m.e(!l0Var.o(), "error must not be OK");
        this.f1913a = l0Var;
        this.f1914b = aVar;
    }

    @Override // M2.InterfaceC0445t
    public r c(K2.a0 a0Var, K2.Z z4, C0355c c0355c, AbstractC0363k[] abstractC0363kArr) {
        return new G(this.f1913a, this.f1914b, abstractC0363kArr);
    }

    @Override // K2.P
    public K2.K h() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
