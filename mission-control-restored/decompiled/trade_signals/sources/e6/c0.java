package e6;

import I6.AbstractC0613d0;
import I6.I0;
import I6.N0;
import R5.InterfaceC0856m;
import R5.h0;
import U5.AbstractC0945b;
import f6.AbstractC1761b;
import h6.InterfaceC1901j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2594p;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends AbstractC0945b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d6.k f17276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h6.y f17277l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(d6.k c8, h6.y javaTypeParameter, int i8, InterfaceC0856m containingDeclaration) {
        super(c8.e(), containingDeclaration, new d6.g(c8, javaTypeParameter, false, 4, null), javaTypeParameter.getName(), N0.f4370e, false, i8, h0.f7249a, c8.a().v());
        AbstractC2304t.f(c8, "c");
        AbstractC2304t.f(javaTypeParameter, "javaTypeParameter");
        AbstractC2304t.f(containingDeclaration, "containingDeclaration");
        this.f17276k = c8;
        this.f17277l = javaTypeParameter;
    }

    @Override // U5.AbstractC0951h
    public List H0(List bounds) {
        AbstractC2304t.f(bounds, "bounds");
        return this.f17276k.a().r().r(this, bounds, this.f17276k);
    }

    @Override // U5.AbstractC0951h
    public void L0(I6.S type) {
        AbstractC2304t.f(type, "type");
    }

    @Override // U5.AbstractC0951h
    public List M0() {
        return N0();
    }

    public final List N0() {
        Collection upperBounds = this.f17277l.getUpperBounds();
        if (upperBounds.isEmpty()) {
            AbstractC0613d0 abstractC0613d0I = this.f17276k.d().q().i();
            AbstractC2304t.e(abstractC0613d0I, "getAnyType(...)");
            AbstractC0613d0 abstractC0613d0J = this.f17276k.d().q().J();
            AbstractC2304t.e(abstractC0613d0J, "getNullableAnyType(...)");
            return AbstractC2594p.e(I6.V.e(abstractC0613d0I, abstractC0613d0J));
        }
        ArrayList arrayList = new ArrayList(p5.r.s(upperBounds, 10));
        Iterator it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f17276k.g().p((InterfaceC1901j) it.next(), AbstractC1761b.b(I0.f4353b, false, false, this, 3, null)));
        }
        return arrayList;
    }
}
