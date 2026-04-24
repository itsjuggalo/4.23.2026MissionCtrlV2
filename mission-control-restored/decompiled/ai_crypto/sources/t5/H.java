package t5;

import r5.AbstractC2595k;
import r5.C2587c;
import t5.InterfaceC2698s;

/* JADX INFO: loaded from: classes2.dex */
public class H implements InterfaceC2700t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r5.l0 f23464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2698s.a f23465b;

    public H(r5.l0 l0Var, InterfaceC2698s.a aVar) {
        H2.m.e(!l0Var.o(), "error must not be OK");
        this.f23464a = l0Var;
        this.f23465b = aVar;
    }

    @Override // t5.InterfaceC2700t
    public r f(r5.a0 a0Var, r5.Z z7, C2587c c2587c, AbstractC2595k[] abstractC2595kArr) {
        return new G(this.f23464a, this.f23465b, abstractC2595kArr);
    }

    @Override // r5.P
    public r5.K h() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
