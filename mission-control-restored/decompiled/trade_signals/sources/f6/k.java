package f6;

import I6.A0;
import I6.AbstractC0613d0;
import I6.B0;
import I6.I;
import I6.InterfaceC0611c0;
import I6.S;
import I6.r0;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import V6.C;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import p5.r;
import p5.z;
import t6.n;
import t6.w;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends I implements InterfaceC0611c0 {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(AbstractC0613d0 lowerBound, AbstractC0613d0 upperBound) {
        this(lowerBound, upperBound, false);
        AbstractC2304t.f(lowerBound, "lowerBound");
        AbstractC2304t.f(upperBound, "upperBound");
    }

    public static final CharSequence c1(String it) {
        AbstractC2304t.f(it, "it");
        return "(raw) " + it;
    }

    public static final boolean d1(String str, String str2) {
        return AbstractC2304t.b(str, C.o0(str2, "out ")) || AbstractC2304t.b(str2, "*");
    }

    public static final List e1(n nVar, S s8) {
        List listM0 = s8.M0();
        ArrayList arrayList = new ArrayList(r.s(listM0, 10));
        Iterator it = listM0.iterator();
        while (it.hasNext()) {
            arrayList.add(nVar.T((B0) it.next()));
        }
        return arrayList;
    }

    public static final String f1(String str, String str2) {
        if (!C.K(str, '<', false, 2, null)) {
            return str;
        }
        return C.J0(str, '<', null, 2, null) + '<' + str2 + '>' + C.F0(str, '>', null, 2, null);
    }

    @Override // I6.I
    public AbstractC0613d0 V0() {
        return W0();
    }

    @Override // I6.I
    public String Y0(n renderer, w options) {
        AbstractC2304t.f(renderer, "renderer");
        AbstractC2304t.f(options, "options");
        String strS = renderer.S(W0());
        String strS2 = renderer.S(X0());
        if (options.n()) {
            return "raw (" + strS + ".." + strS2 + ')';
        }
        if (X0().M0().isEmpty()) {
            return renderer.P(strS, strS2, N6.d.n(this));
        }
        List listE1 = e1(renderer, W0());
        List listE12 = e1(renderer, X0());
        String strH0 = z.h0(listE1, ", ", null, null, 0, null, j.f17596a, 30, null);
        List<C2489q> listO0 = z.O0(listE1, listE12);
        if ((listO0 instanceof Collection) && listO0.isEmpty()) {
            strS2 = f1(strS2, strH0);
        } else {
            for (C2489q c2489q : listO0) {
                if (!d1((String) c2489q.c(), (String) c2489q.d())) {
                    break;
                }
            }
            strS2 = f1(strS2, strH0);
        }
        String strF1 = f1(strS, strH0);
        return AbstractC2304t.b(strF1, strS2) ? strF1 : renderer.P(strF1, strS2, N6.d.n(this));
    }

    @Override // I6.M0
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public k S0(boolean z7) {
        return new k(W0().S0(z7), X0().S0(z7));
    }

    @Override // I6.M0
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public I Y0(J6.g kotlinTypeRefiner) {
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        S sA = kotlinTypeRefiner.a(W0());
        AbstractC2304t.d(sA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        S sA2 = kotlinTypeRefiner.a(X0());
        AbstractC2304t.d(sA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new k((AbstractC0613d0) sA, (AbstractC0613d0) sA2, true);
    }

    @Override // I6.M0
    /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
    public k U0(r0 newAttributes) {
        AbstractC2304t.f(newAttributes, "newAttributes");
        return new k(W0().U0(newAttributes), X0().U0(newAttributes));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // I6.I, I6.S
    public B6.k r() {
        InterfaceC0851h interfaceC0851hS = O0().s();
        A0 a02 = null;
        Object[] objArr = 0;
        InterfaceC0848e interfaceC0848e = interfaceC0851hS instanceof InterfaceC0848e ? (InterfaceC0848e) interfaceC0851hS : null;
        if (interfaceC0848e != null) {
            B6.k kVarR0 = interfaceC0848e.r0(new i(a02, 1, objArr == true ? 1 : 0));
            AbstractC2304t.e(kVarR0, "getMemberScope(...)");
            return kVarR0;
        }
        throw new IllegalStateException(("Incorrect classifier: " + O0().s()).toString());
    }

    public k(AbstractC0613d0 abstractC0613d0, AbstractC0613d0 abstractC0613d02, boolean z7) {
        super(abstractC0613d0, abstractC0613d02);
        if (z7) {
            return;
        }
        J6.e.f4643a.b(abstractC0613d0, abstractC0613d02);
    }
}
