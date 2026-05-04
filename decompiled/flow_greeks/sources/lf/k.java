package lf;

import fe.h0;
import xf.c1;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ef.b f15657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ef.f f15658c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(ef.b enumClassId, ef.f enumEntryName) {
        super(cd.w.a(enumClassId, enumEntryName));
        kotlin.jvm.internal.t.f(enumClassId, "enumClassId");
        kotlin.jvm.internal.t.f(enumEntryName, "enumEntryName");
        this.f15657b = enumClassId;
        this.f15658c = enumEntryName;
    }

    @Override // lf.g
    public r0 a(h0 module) {
        c1 c1VarS;
        kotlin.jvm.internal.t.f(module, "module");
        fe.e eVarB = fe.y.b(module, this.f15657b);
        if (eVarB != null) {
            if (!jf.i.A(eVarB)) {
                eVarB = null;
            }
            if (eVarB != null && (c1VarS = eVarB.s()) != null) {
                return c1VarS;
            }
        }
        return zf.l.d(zf.k.F0, this.f15657b.toString(), this.f15658c.toString());
    }

    public final ef.f c() {
        return this.f15658c;
    }

    @Override // lf.g
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f15657b.h());
        sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
        sb2.append(this.f15658c);
        return sb2.toString();
    }
}
