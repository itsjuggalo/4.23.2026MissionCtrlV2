package G4;

import F4.AbstractC0497k;
import G4.InterfaceC0551s;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public final class G extends C0547p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final F4.j0 f2497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0551s.a f2498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AbstractC0497k[] f2499e;

    public G(F4.j0 j0Var, InterfaceC0551s.a aVar, AbstractC0497k[] abstractC0497kArr) {
        AbstractC2848n.e(!j0Var.p(), "error must not be OK");
        this.f2497c = j0Var;
        this.f2498d = aVar;
        this.f2499e = abstractC0497kArr;
    }

    @Override // G4.C0547p0, G4.r
    public void i(InterfaceC0551s interfaceC0551s) {
        AbstractC2848n.u(!this.f2496b, "already started");
        this.f2496b = true;
        for (AbstractC0497k abstractC0497k : this.f2499e) {
            abstractC0497k.i(this.f2497c);
        }
        interfaceC0551s.c(this.f2497c, this.f2498d, new F4.X());
    }

    @Override // G4.C0547p0, G4.r
    public void m(Y y7) {
        y7.b("error", this.f2497c).b("progress", this.f2498d);
    }

    public G(F4.j0 j0Var, AbstractC0497k[] abstractC0497kArr) {
        this(j0Var, InterfaceC0551s.a.PROCESSED, abstractC0497kArr);
    }
}
