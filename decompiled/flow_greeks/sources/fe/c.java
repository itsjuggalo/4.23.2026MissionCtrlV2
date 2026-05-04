package fe;

import java.util.List;
import xf.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1 f9453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f9454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9455c;

    public c(l1 originalDescriptor, m declarationDescriptor, int i10) {
        kotlin.jvm.internal.t.f(originalDescriptor, "originalDescriptor");
        kotlin.jvm.internal.t.f(declarationDescriptor, "declarationDescriptor");
        this.f9453a = originalDescriptor;
        this.f9454b = declarationDescriptor;
        this.f9455c = i10;
    }

    @Override // fe.l1
    public boolean G() {
        return this.f9453a.G();
    }

    @Override // fe.n, fe.m
    public m b() {
        return this.f9454b;
    }

    @Override // fe.l1
    public wf.n g0() {
        wf.n nVarG0 = this.f9453a.g0();
        kotlin.jvm.internal.t.e(nVarG0, "getStorageManager(...)");
        return nVarG0;
    }

    @Override // ge.a
    public ge.h getAnnotations() {
        return this.f9453a.getAnnotations();
    }

    @Override // fe.l1
    public int getIndex() {
        return this.f9455c + this.f9453a.getIndex();
    }

    @Override // fe.j0
    public ef.f getName() {
        ef.f name = this.f9453a.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        return name;
    }

    @Override // fe.l1
    public List getUpperBounds() {
        List upperBounds = this.f9453a.getUpperBounds();
        kotlin.jvm.internal.t.e(upperBounds, "getUpperBounds(...)");
        return upperBounds;
    }

    @Override // fe.p
    public g1 j() {
        g1 g1VarJ = this.f9453a.j();
        kotlin.jvm.internal.t.e(g1VarJ, "getSource(...)");
        return g1VarJ;
    }

    @Override // fe.l1, fe.h
    public xf.u1 k() {
        xf.u1 u1VarK = this.f9453a.k();
        kotlin.jvm.internal.t.e(u1VarK, "getTypeConstructor(...)");
        return u1VarK;
    }

    @Override // fe.l1
    public boolean m0() {
        return true;
    }

    @Override // fe.l1
    public m2 o() {
        m2 m2VarO = this.f9453a.o();
        kotlin.jvm.internal.t.e(m2VarO, "getVariance(...)");
        return m2VarO;
    }

    @Override // fe.h
    public xf.c1 s() {
        xf.c1 c1VarS = this.f9453a.s();
        kotlin.jvm.internal.t.e(c1VarS, "getDefaultType(...)");
        return c1VarS;
    }

    @Override // fe.m
    public Object t0(o oVar, Object obj) {
        return this.f9453a.t0(oVar, obj);
    }

    public String toString() {
        return this.f9453a + "[inner-copy]";
    }

    @Override // fe.m
    public l1 a() {
        l1 l1VarA = this.f9453a.a();
        kotlin.jvm.internal.t.e(l1VarA, "getOriginal(...)");
        return l1VarA;
    }
}
