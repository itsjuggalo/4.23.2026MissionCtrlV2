package G6;

import E6.C0477p;
import E6.X;
import R5.InterfaceC0856m;
import R5.h0;
import R5.k0;
import U5.AbstractC0945b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import l6.s;
import p5.AbstractC2594p;
import y6.AbstractC2996e;

/* JADX INFO: loaded from: classes2.dex */
public final class S extends AbstractC0945b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0477p f3296k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l6.s f3297l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final C0564a f3298m;

    /* JADX WARN: Illegal instructions before constructor call */
    public S(C0477p c8, l6.s proto, int i8) {
        AbstractC2304t.f(c8, "c");
        AbstractC2304t.f(proto, "proto");
        H6.n nVarH = c8.h();
        InterfaceC0856m interfaceC0856mE = c8.e();
        S5.h hVarB = S5.h.f7663J.b();
        q6.f fVarB = E6.L.b(c8.g(), proto.O());
        E6.O o8 = E6.O.f941a;
        s.c cVarU = proto.U();
        AbstractC2304t.e(cVarU, "getVariance(...)");
        super(nVarH, interfaceC0856mE, hVarB, fVarB, o8.d(cVarU), proto.P(), i8, h0.f7249a, k0.a.f7252a);
        this.f3296k = c8;
        this.f3297l = proto;
        this.f3298m = new C0564a(c8.h(), new Q(this));
    }

    public static final List O0(S s8) {
        return p5.z.G0(s8.f3296k.c().d().c(s8.f3297l, s8.f3296k.g()));
    }

    @Override // U5.AbstractC0951h
    public List M0() {
        List listS = n6.f.s(this.f3297l, this.f3296k.j());
        if (listS.isEmpty()) {
            return AbstractC2594p.e(AbstractC2996e.m(this).z());
        }
        X xI = this.f3296k.i();
        ArrayList arrayList = new ArrayList(p5.r.s(listS, 10));
        Iterator it = listS.iterator();
        while (it.hasNext()) {
            arrayList.add(xI.u((l6.q) it.next()));
        }
        return arrayList;
    }

    @Override // S5.b, S5.a
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public C0564a getAnnotations() {
        return this.f3298m;
    }

    @Override // U5.AbstractC0951h
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public Void L0(I6.S type) {
        AbstractC2304t.f(type, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }
}
