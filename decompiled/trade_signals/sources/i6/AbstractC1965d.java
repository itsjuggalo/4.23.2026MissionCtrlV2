package i6;

import a6.AbstractC1079b;
import a6.EnumC1080c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: renamed from: i6.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1965d {

    /* JADX INFO: renamed from: i6.d$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final M6.i f18860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a6.E f18861b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final M6.o f18862c;

        public a(M6.i iVar, a6.E e8, M6.o oVar) {
            this.f18860a = iVar;
            this.f18861b = e8;
            this.f18862c = oVar;
        }

        public final a6.E a() {
            return this.f18861b;
        }

        public final M6.i b() {
            return this.f18860a;
        }

        public final M6.o c() {
            return this.f18862c;
        }
    }

    public static final Iterable I(AbstractC1965d abstractC1965d, M6.p pVar, a it) {
        M6.i iVarB;
        M6.n nVarJ;
        List listZ;
        M6.i iVarB2;
        AbstractC2304t.f(it, "it");
        if ((abstractC1965d.z() && (iVarB2 = it.b()) != null && pVar.s0(iVarB2)) || (iVarB = it.b()) == null || (nVarJ = pVar.J(iVarB)) == null || (listZ = pVar.z(nVarJ)) == null) {
            return null;
        }
        List listY = pVar.Y(it.b());
        Iterator it2 = listZ.iterator();
        Iterator it3 = listY.iterator();
        ArrayList arrayList = new ArrayList(Math.min(p5.r.s(listZ, 10), p5.r.s(listY, 10)));
        while (it2.hasNext() && it3.hasNext()) {
            M6.o oVar = (M6.o) it2.next();
            M6.i iVarL = pVar.L((M6.m) it3.next());
            arrayList.add(iVarL == null ? new a(null, it.a(), oVar) : new a(iVarL, abstractC1965d.f(iVarL, it.a()), oVar));
        }
        return arrayList;
    }

    public static final C1973h e(C1994r0 c1994r0, C1973h[] c1973hArr, int i8) {
        Map mapB;
        C1973h c1973h;
        return (c1994r0 == null || (mapB = c1994r0.b()) == null || (c1973h = (C1973h) mapB.get(Integer.valueOf(i8))) == null) ? (i8 < 0 || i8 >= c1973hArr.length) ? C1973h.f18881e.a() : c1973hArr[i8] : c1973h;
    }

    public static final boolean i(AbstractC1965d abstractC1965d, a aVar, Object extractNullability) {
        AbstractC2304t.f(extractNullability, "$this$extractNullability");
        return abstractC1965d.l(extractNullability, aVar.b());
    }

    public abstract M6.p A();

    public abstract boolean B(M6.i iVar);

    public abstract boolean C();

    public abstract boolean D(M6.i iVar, M6.i iVar2);

    public abstract boolean E(M6.o oVar);

    public abstract boolean F(M6.i iVar);

    public final C1981l G(C1981l c1981l, C1981l c1981l2) {
        return c1981l == null ? c1981l2 : c1981l2 == null ? c1981l : (!c1981l.d() || c1981l2.d()) ? (c1981l.d() || !c1981l2.d()) ? (c1981l.c().compareTo(c1981l2.c()) >= 0 && c1981l.c().compareTo(c1981l2.c()) > 0) ? c1981l : c1981l2 : c1981l : c1981l2;
    }

    public final List H(M6.i iVar) {
        return j(new a(iVar, f(iVar, r()), null), new C1963c(this, A()));
    }

    public final B5.k d(M6.i iVar, Iterable overrides, C1994r0 c1994r0, boolean z7) {
        int size;
        M6.i iVarB;
        AbstractC2304t.f(iVar, "<this>");
        AbstractC2304t.f(overrides, "overrides");
        List listH = H(iVar);
        ArrayList arrayList = new ArrayList(p5.r.s(overrides, 10));
        Iterator it = overrides.iterator();
        while (it.hasNext()) {
            arrayList.add(H((M6.i) it.next()));
        }
        if (w()) {
            size = 1;
            break;
        }
        if (C() && (!(overrides instanceof Collection) || !((Collection) overrides).isEmpty())) {
            Iterator it2 = overrides.iterator();
            while (it2.hasNext()) {
                if (!D(iVar, (M6.i) it2.next())) {
                    size = 1;
                    break;
                }
            }
        }
        size = listH.size();
        C1973h[] c1973hArr = new C1973h[size];
        int i8 = 0;
        while (i8 < size) {
            C1973h c1973hH = h((a) listH.get(i8));
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                a aVar = (a) p5.z.b0((List) it3.next(), i8);
                C1973h c1973hG = (aVar == null || (iVarB = aVar.b()) == null) ? null : g(iVarB);
                if (c1973hG != null) {
                    arrayList2.add(c1973hG);
                }
            }
            c1973hArr[i8] = AbstractC1998t0.a(c1973hH, arrayList2, i8 == 0 && C(), i8 == 0 && s(), z7);
            i8++;
        }
        return new C1961b(c1994r0, c1973hArr);
    }

    public final a6.E f(M6.i iVar, a6.E e8) {
        return m().d(e8, n(iVar));
    }

    public final C1973h g(M6.i iVar) {
        EnumC1979k enumC1979kY;
        EnumC1979k enumC1979kY2 = y(iVar);
        EnumC1975i enumC1975i = null;
        if (enumC1979kY2 == null) {
            M6.i iVarV = v(iVar);
            enumC1979kY = iVarV != null ? y(iVarV) : null;
        } else {
            enumC1979kY = enumC1979kY2;
        }
        M6.p pVarA = A();
        Q5.c cVar = Q5.c.f6732a;
        if (cVar.l(x(pVarA.H0(iVar)))) {
            enumC1975i = EnumC1975i.f18888a;
        } else if (cVar.k(x(pVarA.w0(iVar)))) {
            enumC1975i = EnumC1975i.f18889b;
        }
        return new C1973h(enumC1979kY, enumC1975i, A().n(iVar) || F(iVar), enumC1979kY != enumC1979kY2);
    }

    public final C1973h h(a aVar) {
        Iterable iterableI;
        C1981l c1981lO;
        M6.i iVarB;
        M6.n nVarJ;
        if (aVar.b() == null) {
            M6.p pVarA = A();
            M6.o oVarC = aVar.c();
            if ((oVarC != null ? pVarA.Z(oVarC) : null) == M6.t.f5438b) {
                return C1973h.f18881e.a();
            }
        }
        boolean z7 = false;
        boolean z8 = aVar.c() == null;
        M6.i iVarB2 = aVar.b();
        if (iVarB2 == null || (iterableI = n(iVarB2)) == null) {
            iterableI = AbstractC2595q.i();
        }
        M6.p pVarA2 = A();
        M6.i iVarB3 = aVar.b();
        M6.o oVarC0 = (iVarB3 == null || (nVarJ = pVarA2.J(iVarB3)) == null) ? null : pVarA2.c0(nVarJ);
        boolean z9 = q() == EnumC1080c.f10132f;
        if (z8) {
            if (z9 || !u() || (iVarB = aVar.b()) == null || !B(iVarB)) {
                iterableI = p5.z.p0(p(), iterableI);
            } else {
                Iterable iterableP = p();
                ArrayList arrayList = new ArrayList();
                for (Object obj : iterableP) {
                    if (!m().p(obj)) {
                        arrayList.add(obj);
                    }
                }
                iterableI = p5.z.r0(arrayList, iterableI);
            }
        }
        EnumC1975i enumC1975iG = m().g(iterableI);
        C1981l c1981lH = m().h(iterableI, new C1959a(this, aVar));
        if (c1981lH != null) {
            EnumC1979k enumC1979kC = c1981lH.c();
            if (c1981lH.c() == EnumC1979k.f18897c && oVarC0 != null) {
                z7 = true;
            }
            return new C1973h(enumC1979kC, enumC1975iG, z7, c1981lH.d());
        }
        EnumC1080c enumC1080cQ = (z8 || z9) ? q() : EnumC1080c.f10131e;
        a6.E eA = aVar.a();
        a6.w wVarA = eA != null ? eA.a(enumC1080cQ) : null;
        C1981l c1981lO2 = oVarC0 != null ? o(oVarC0) : null;
        C1981l c1981lT = t(c1981lO2, wVarA);
        boolean z10 = (c1981lO2 != null ? c1981lO2.c() : null) == EnumC1979k.f18897c || !(oVarC0 == null || wVarA == null || !wVarA.c());
        M6.o oVarC2 = aVar.c();
        if (oVarC2 == null || (c1981lO = o(oVarC2)) == null) {
            c1981lO = null;
        } else if (c1981lO.c() == EnumC1979k.f18896b) {
            c1981lO = C1981l.b(c1981lO, EnumC1979k.f18895a, false, 2, null);
        }
        C1981l c1981lG = G(c1981lO, c1981lT);
        EnumC1979k enumC1979kC2 = c1981lG != null ? c1981lG.c() : null;
        if (c1981lG != null && c1981lG.d()) {
            z7 = true;
        }
        return new C1973h(enumC1979kC2, enumC1975iG, z10, z7);
    }

    public final List j(Object obj, B5.k kVar) {
        ArrayList arrayList = new ArrayList(1);
        k(obj, arrayList, kVar);
        return arrayList;
    }

    public final void k(Object obj, List list, B5.k kVar) {
        list.add(obj);
        Iterable iterable = (Iterable) kVar.invoke(obj);
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                k(it.next(), list, kVar);
            }
        }
    }

    public abstract boolean l(Object obj, M6.i iVar);

    public abstract AbstractC1079b m();

    public abstract Iterable n(M6.i iVar);

    /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final i6.C1981l o(M6.o r6) {
        /*
            r5 = this;
            M6.p r0 = r5.A()
            boolean r1 = r5.E(r6)
            r2 = 0
            if (r1 != 0) goto Lc
            return r2
        Lc:
            java.util.List r6 = r0.h0(r6)
            boolean r1 = r6 instanceof java.util.Collection
            if (r1 == 0) goto L1c
            boolean r3 = r6.isEmpty()
            if (r3 == 0) goto L1c
            goto Lc1
        L1c:
            java.util.Iterator r3 = r6.iterator()
        L20:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lc1
            java.lang.Object r4 = r3.next()
            M6.i r4 = (M6.i) r4
            boolean r4 = r0.G(r4)
            if (r4 != 0) goto L20
            if (r1 == 0) goto L3b
            boolean r3 = r6.isEmpty()
            if (r3 == 0) goto L3b
            goto L53
        L3b:
            java.util.Iterator r3 = r6.iterator()
        L3f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L53
            java.lang.Object r4 = r3.next()
            M6.i r4 = (M6.i) r4
            i6.k r4 = r5.y(r4)
            if (r4 == 0) goto L3f
            r1 = r6
            goto L91
        L53:
            if (r1 == 0) goto L5c
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L5c
            goto Lc1
        L5c:
            java.util.Iterator r1 = r6.iterator()
        L60:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Lc1
            java.lang.Object r3 = r1.next()
            M6.i r3 = (M6.i) r3
            M6.i r3 = r5.v(r3)
            if (r3 == 0) goto L60
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r6.iterator()
        L7b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L91
            java.lang.Object r3 = r2.next()
            M6.i r3 = (M6.i) r3
            M6.i r3 = r5.v(r3)
            if (r3 == 0) goto L7b
            r1.add(r3)
            goto L7b
        L91:
            boolean r2 = r1 instanceof java.util.Collection
            if (r2 == 0) goto L9c
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L9c
            goto Lb5
        L9c:
            java.util.Iterator r2 = r1.iterator()
        La0:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r2.next()
            M6.i r3 = (M6.i) r3
            boolean r3 = r0.l(r3)
            if (r3 != 0) goto La0
            i6.k r0 = i6.EnumC1979k.f18897c
            goto Lb7
        Lb5:
            i6.k r0 = i6.EnumC1979k.f18896b
        Lb7:
            i6.l r2 = new i6.l
            if (r1 == r6) goto Lbd
            r6 = 1
            goto Lbe
        Lbd:
            r6 = 0
        Lbe:
            r2.<init>(r0, r6)
        Lc1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.AbstractC1965d.o(M6.o):i6.l");
    }

    public abstract Iterable p();

    public abstract EnumC1080c q();

    public abstract a6.E r();

    public abstract boolean s();

    public abstract C1981l t(C1981l c1981l, a6.w wVar);

    public abstract boolean u();

    public abstract M6.i v(M6.i iVar);

    public boolean w() {
        return false;
    }

    public abstract q6.d x(M6.i iVar);

    public final EnumC1979k y(M6.i iVar) {
        M6.p pVarA = A();
        if (pVarA.a0(pVarA.H0(iVar))) {
            return EnumC1979k.f18896b;
        }
        if (pVarA.a0(pVarA.w0(iVar))) {
            return null;
        }
        return EnumC1979k.f18897c;
    }

    public abstract boolean z();
}
