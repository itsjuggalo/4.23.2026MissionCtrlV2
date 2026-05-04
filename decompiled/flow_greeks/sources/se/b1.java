package se;

import fe.g1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import xf.c1;
import xf.h2;
import xf.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b1 extends ie.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final re.k f20222k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ve.y f20223l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(re.k c10, ve.y javaTypeParameter, int i10, fe.m containingDeclaration) {
        super(c10.e(), containingDeclaration, new re.g(c10, javaTypeParameter, false, 4, null), javaTypeParameter.getName(), m2.f25015e, false, i10, g1.f9483a, c10.a().v());
        kotlin.jvm.internal.t.f(c10, "c");
        kotlin.jvm.internal.t.f(javaTypeParameter, "javaTypeParameter");
        kotlin.jvm.internal.t.f(containingDeclaration, "containingDeclaration");
        this.f20222k = c10;
        this.f20223l = javaTypeParameter;
    }

    @Override // ie.h
    public List F0(List bounds) {
        kotlin.jvm.internal.t.f(bounds, "bounds");
        return this.f20222k.a().r().r(this, bounds, this.f20222k);
    }

    @Override // ie.h
    public void K0(xf.r0 type) {
        kotlin.jvm.internal.t.f(type, "type");
    }

    @Override // ie.h
    public List L0() {
        return M0();
    }

    public final List M0() {
        Collection upperBounds = this.f20223l.getUpperBounds();
        if (upperBounds.isEmpty()) {
            c1 c1VarI = this.f20222k.d().p().i();
            kotlin.jvm.internal.t.e(c1VarI, "getAnyType(...)");
            c1 c1VarJ = this.f20222k.d().p().J();
            kotlin.jvm.internal.t.e(c1VarJ, "getNullableAnyType(...)");
            return dd.q.e(xf.u0.e(c1VarI, c1VarJ));
        }
        ArrayList arrayList = new ArrayList(dd.s.u(upperBounds, 10));
        Iterator it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f20222k.g().p((ve.j) it.next(), te.b.b(h2.f24979b, false, false, this, 3, null)));
        }
        return arrayList;
    }
}
