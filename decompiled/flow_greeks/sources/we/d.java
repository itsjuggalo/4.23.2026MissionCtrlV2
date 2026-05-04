package we;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bg.i f23946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final oe.e0 f23947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final bg.o f23948c;

        public a(bg.i iVar, oe.e0 e0Var, bg.o oVar) {
            this.f23946a = iVar;
            this.f23947b = e0Var;
            this.f23948c = oVar;
        }

        public final oe.e0 a() {
            return this.f23947b;
        }

        public final bg.i b() {
            return this.f23946a;
        }

        public final bg.o c() {
            return this.f23948c;
        }
    }

    public static final Iterable I(d dVar, bg.p pVar, a it) {
        bg.i iVarB;
        bg.n nVarB;
        List listT;
        bg.i iVarB2;
        kotlin.jvm.internal.t.f(it, "it");
        if ((dVar.z() && (iVarB2 = it.b()) != null && pVar.Q(iVarB2)) || (iVarB = it.b()) == null || (nVarB = pVar.B(iVarB)) == null || (listT = pVar.t(nVarB)) == null) {
            return null;
        }
        List listR = pVar.R(it.b());
        Iterator it2 = listT.iterator();
        Iterator it3 = listR.iterator();
        ArrayList arrayList = new ArrayList(Math.min(dd.s.u(listT, 10), dd.s.u(listR, 10)));
        while (it2.hasNext() && it3.hasNext()) {
            bg.o oVar = (bg.o) it2.next();
            bg.i iVarH = pVar.H((bg.m) it3.next());
            arrayList.add(iVarH == null ? new a(null, it.a(), oVar) : new a(iVarH, dVar.f(iVarH, it.a()), oVar));
        }
        return arrayList;
    }

    public static final h e(q1 q1Var, h[] hVarArr, int i10) {
        Map mapB;
        h hVar;
        return (q1Var == null || (mapB = q1Var.b()) == null || (hVar = (h) mapB.get(Integer.valueOf(i10))) == null) ? (i10 < 0 || i10 >= hVarArr.length) ? h.f23975e.a() : hVarArr[i10] : hVar;
    }

    public static final boolean i(d dVar, a aVar, Object extractNullability) {
        kotlin.jvm.internal.t.f(extractNullability, "$this$extractNullability");
        return dVar.l(extractNullability, aVar.b());
    }

    public abstract bg.p A();

    public abstract boolean B(bg.i iVar);

    public abstract boolean C();

    public abstract boolean D(bg.i iVar, bg.i iVar2);

    public abstract boolean E(bg.o oVar);

    public abstract boolean F(bg.i iVar);

    public final l G(l lVar, l lVar2) {
        return lVar == null ? lVar2 : (lVar2 != null && ((lVar.d() && !lVar2.d()) || ((lVar.d() || !lVar2.d()) && (lVar.c().compareTo(lVar2.c()) < 0 || lVar.c().compareTo(lVar2.c()) <= 0)))) ? lVar2 : lVar;
    }

    public final List H(bg.i iVar) {
        return j(new a(iVar, f(iVar, r()), null), new c(this, A()));
    }

    public final pd.k d(bg.i iVar, Iterable overrides, q1 q1Var, boolean z10) {
        int size;
        bg.i iVarB;
        kotlin.jvm.internal.t.f(iVar, "<this>");
        kotlin.jvm.internal.t.f(overrides, "overrides");
        List listH = H(iVar);
        ArrayList arrayList = new ArrayList(dd.s.u(overrides, 10));
        Iterator it = overrides.iterator();
        while (it.hasNext()) {
            arrayList.add(H((bg.i) it.next()));
        }
        if (w()) {
            size = 1;
            break;
        }
        if (C() && (!(overrides instanceof Collection) || !((Collection) overrides).isEmpty())) {
            Iterator it2 = overrides.iterator();
            while (it2.hasNext()) {
                if (!D(iVar, (bg.i) it2.next())) {
                    size = 1;
                    break;
                }
            }
        }
        size = listH.size();
        h[] hVarArr = new h[size];
        int i10 = 0;
        while (i10 < size) {
            h hVarH = h((a) listH.get(i10));
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                a aVar = (a) dd.a0.c0((List) it3.next(), i10);
                h hVarG = (aVar == null || (iVarB = aVar.b()) == null) ? null : g(iVarB);
                if (hVarG != null) {
                    arrayList2.add(hVarG);
                }
            }
            hVarArr[i10] = s1.a(hVarH, arrayList2, i10 == 0 && C(), i10 == 0 && s(), z10);
            i10++;
        }
        return new b(q1Var, hVarArr);
    }

    public final oe.e0 f(bg.i iVar, oe.e0 e0Var) {
        return m().d(e0Var, n(iVar));
    }

    public final h g(bg.i iVar) {
        k kVarY;
        k kVarY2 = y(iVar);
        i iVar2 = null;
        if (kVarY2 == null) {
            bg.i iVarV = v(iVar);
            kVarY = iVarV != null ? y(iVarV) : null;
        } else {
            kVarY = kVarY2;
        }
        bg.p pVarA = A();
        ee.c cVar = ee.c.f8681a;
        if (cVar.l(x(pVarA.m(iVar)))) {
            iVar2 = i.f23983a;
        } else if (cVar.k(x(pVarA.z0(iVar)))) {
            iVar2 = i.f23984b;
        }
        return new h(kVarY, iVar2, A().Y(iVar) || F(iVar), kVarY != kVarY2);
    }

    public final h h(a aVar) {
        Iterable iterableK;
        l lVarO;
        bg.i iVarB;
        bg.n nVarB;
        if (aVar.b() == null) {
            bg.p pVarA = A();
            bg.o oVarC = aVar.c();
            if ((oVarC != null ? pVarA.A0(oVarC) : null) == bg.t.f3357b) {
                return h.f23975e.a();
            }
        }
        boolean z10 = false;
        boolean z11 = aVar.c() == null;
        bg.i iVarB2 = aVar.b();
        if (iVarB2 == null || (iterableK = n(iVarB2)) == null) {
            iterableK = dd.r.k();
        }
        bg.p pVarA2 = A();
        bg.i iVarB3 = aVar.b();
        bg.o oVarP0 = (iVarB3 == null || (nVarB = pVarA2.B(iVarB3)) == null) ? null : pVarA2.p0(nVarB);
        boolean z12 = q() == oe.c.f17948f;
        if (z11) {
            if (z12 || !u() || (iVarB = aVar.b()) == null || !B(iVarB)) {
                iterableK = dd.a0.q0(p(), iterableK);
            } else {
                Iterable iterableP = p();
                ArrayList arrayList = new ArrayList();
                for (Object obj : iterableP) {
                    if (!m().p(obj)) {
                        arrayList.add(obj);
                    }
                }
                iterableK = dd.a0.s0(arrayList, iterableK);
            }
        }
        i iVarG = m().g(iterableK);
        l lVarH = m().h(iterableK, new we.a(this, aVar));
        if (lVarH != null) {
            k kVarC = lVarH.c();
            if (lVarH.c() == k.f23994c && oVarP0 != null) {
                z10 = true;
            }
            return new h(kVarC, iVarG, z10, lVarH.d());
        }
        oe.c cVarQ = (z11 || z12) ? q() : oe.c.f17947e;
        oe.e0 e0VarA = aVar.a();
        oe.w wVarA = e0VarA != null ? e0VarA.a(cVarQ) : null;
        l lVarO2 = oVarP0 != null ? o(oVarP0) : null;
        l lVarT = t(lVarO2, wVarA);
        boolean z13 = (lVarO2 != null ? lVarO2.c() : null) == k.f23994c || !(oVarP0 == null || wVarA == null || !wVarA.c());
        bg.o oVarC2 = aVar.c();
        if (oVarC2 == null || (lVarO = o(oVarC2)) == null) {
            lVarO = null;
        } else if (lVarO.c() == k.f23993b) {
            lVarO = l.b(lVarO, k.f23992a, false, 2, null);
        }
        l lVarG = G(lVarO, lVarT);
        k kVarC2 = lVarG != null ? lVarG.c() : null;
        if (lVarG != null && lVarG.d()) {
            z10 = true;
        }
        return new h(kVarC2, iVarG, z13, z10);
    }

    public final List j(Object obj, pd.k kVar) {
        ArrayList arrayList = new ArrayList(1);
        k(obj, arrayList, kVar);
        return arrayList;
    }

    public final void k(Object obj, List list, pd.k kVar) {
        list.add(obj);
        Iterable iterable = (Iterable) kVar.invoke(obj);
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                k(it.next(), list, kVar);
            }
        }
    }

    public abstract boolean l(Object obj, bg.i iVar);

    public abstract oe.b m();

    public abstract Iterable n(bg.i iVar);

    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final we.l o(bg.o r5) {
        /*
            r4 = this;
            bg.p r0 = r4.A()
            boolean r1 = r4.E(r5)
            r2 = 0
            if (r1 != 0) goto Lc
            return r2
        Lc:
            java.util.List r5 = r0.r(r5)
            if (r5 == 0) goto L1a
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L1a
            goto Lbd
        L1a:
            java.util.Iterator r1 = r5.iterator()
        L1e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Lbd
            java.lang.Object r3 = r1.next()
            bg.i r3 = (bg.i) r3
            boolean r3 = r0.w0(r3)
            if (r3 != 0) goto L1e
            if (r5 == 0) goto L39
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L39
            goto L51
        L39:
            java.util.Iterator r1 = r5.iterator()
        L3d:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L51
            java.lang.Object r3 = r1.next()
            bg.i r3 = (bg.i) r3
            we.k r3 = r4.y(r3)
            if (r3 == 0) goto L3d
            r1 = r5
            goto L8f
        L51:
            if (r5 == 0) goto L5a
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L5a
            goto Lbd
        L5a:
            java.util.Iterator r1 = r5.iterator()
        L5e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Lbd
            java.lang.Object r3 = r1.next()
            bg.i r3 = (bg.i) r3
            bg.i r3 = r4.v(r3)
            if (r3 == 0) goto L5e
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r5.iterator()
        L79:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L8f
            java.lang.Object r3 = r2.next()
            bg.i r3 = (bg.i) r3
            bg.i r3 = r4.v(r3)
            if (r3 == 0) goto L79
            r1.add(r3)
            goto L79
        L8f:
            if (r1 == 0) goto L98
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L98
            goto Lb1
        L98:
            java.util.Iterator r2 = r1.iterator()
        L9c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Lb1
            java.lang.Object r3 = r2.next()
            bg.i r3 = (bg.i) r3
            boolean r3 = r0.D0(r3)
            if (r3 != 0) goto L9c
            we.k r0 = we.k.f23994c
            goto Lb3
        Lb1:
            we.k r0 = we.k.f23993b
        Lb3:
            we.l r2 = new we.l
            if (r1 == r5) goto Lb9
            r5 = 1
            goto Lba
        Lb9:
            r5 = 0
        Lba:
            r2.<init>(r0, r5)
        Lbd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: we.d.o(bg.o):we.l");
    }

    public abstract Iterable p();

    public abstract oe.c q();

    public abstract oe.e0 r();

    public abstract boolean s();

    public abstract l t(l lVar, oe.w wVar);

    public abstract boolean u();

    public abstract bg.i v(bg.i iVar);

    public boolean w() {
        return false;
    }

    public abstract ef.d x(bg.i iVar);

    public final k y(bg.i iVar) {
        bg.p pVarA = A();
        if (pVarA.n(pVarA.m(iVar))) {
            return k.f23993b;
        }
        if (pVarA.n(pVarA.z0(iVar))) {
            return null;
        }
        return k.f23994c;
    }

    public abstract boolean z();
}
