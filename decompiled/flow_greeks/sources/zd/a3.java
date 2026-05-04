package zd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class a3 extends kotlin.jvm.internal.o0 {
    public static c1 k(kotlin.jvm.internal.f fVar) {
        wd.g owner = fVar.getOwner();
        return owner instanceof c1 ? (c1) owner : k.f25771d;
    }

    @Override // kotlin.jvm.internal.o0
    public wd.h a(kotlin.jvm.internal.p pVar) {
        return new h1(k(pVar), pVar.getName(), pVar.getSignature(), pVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.o0
    public wd.d b(Class cls) {
        return h.k(cls);
    }

    @Override // kotlin.jvm.internal.o0
    public wd.g c(Class cls, String str) {
        return h.l(cls);
    }

    @Override // kotlin.jvm.internal.o0
    public wd.j d(kotlin.jvm.internal.x xVar) {
        return new j1(k(xVar), xVar.getName(), xVar.getSignature(), xVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.o0
    public wd.k e(kotlin.jvm.internal.z zVar) {
        return new l1(k(zVar), zVar.getName(), zVar.getSignature(), zVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.o0
    public wd.n f(kotlin.jvm.internal.d0 d0Var) {
        return new a2(k(d0Var), d0Var.getName(), d0Var.getSignature(), d0Var.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.o0
    public wd.o g(kotlin.jvm.internal.f0 f0Var) {
        return new d2(k(f0Var), f0Var.getName(), f0Var.getSignature(), f0Var.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.o0
    public wd.p h(kotlin.jvm.internal.h0 h0Var) {
        return new g2(k(h0Var), h0Var.getName(), h0Var.getSignature());
    }

    @Override // kotlin.jvm.internal.o0
    public String i(kotlin.jvm.internal.o oVar) {
        h1 h1VarC;
        wd.h hVarA = yd.d.a(oVar);
        return (hVarA == null || (h1VarC = i3.c(hVarA)) == null) ? super.i(oVar) : d3.f25708a.h(h1VarC.W());
    }

    @Override // kotlin.jvm.internal.o0
    public String j(kotlin.jvm.internal.v vVar) {
        return i(vVar);
    }
}
