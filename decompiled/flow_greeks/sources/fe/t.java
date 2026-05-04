package fe;

import eg.l;
import fe.v1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f9507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f9508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f9509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f9510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u f9511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u f9512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u f9513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u f9514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u f9515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set f9516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map f9517k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final u f9518l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final rf.g f9519m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final rf.g f9520n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final rf.g f9521o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final eg.l f9522p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Map f9523q;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements rf.g {
        @Override // rf.g
        public xf.r0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements rf.g {
        @Override // rf.g
        public xf.r0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements rf.g {
        @Override // rf.g
        public xf.r0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d extends r {
        public d(w1 w1Var) {
            super(w1Var);
        }

        public static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "what";
            } else if (i10 != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // fe.u
        public boolean e(rf.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == 0) {
                g(1);
            }
            if (mVar == null) {
                g(2);
            }
            if (jf.i.J(qVar) && h(mVar)) {
                return t.f(qVar, mVar);
            }
            if (qVar instanceof fe.l) {
                fe.i iVarB = ((fe.l) qVar).b();
                if (z10 && jf.i.G(iVarB) && jf.i.J(iVarB) && (mVar instanceof fe.l) && jf.i.J(mVar.b()) && t.f(qVar, mVar)) {
                    return true;
                }
            }
            while (qVar != 0) {
                qVar = qVar.b();
                if (((qVar instanceof fe.e) && !jf.i.x(qVar)) || (qVar instanceof n0)) {
                    break;
                }
            }
            if (qVar == 0) {
                return false;
            }
            while (mVar != null) {
                if (qVar == mVar) {
                    return true;
                }
                if (mVar instanceof n0) {
                    return (qVar instanceof n0) && ((n0) qVar).e().equals(((n0) mVar).e()) && jf.i.b(mVar, qVar);
                }
                mVar = mVar.b();
            }
            return false;
        }

        public final boolean h(m mVar) {
            if (mVar == null) {
                g(0);
            }
            return jf.i.j(mVar) != h1.f9484a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e extends r {
        public e(w1 w1Var) {
            super(w1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // fe.u
        public boolean e(rf.g gVar, q qVar, m mVar, boolean z10) {
            m mVarQ;
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            if (t.f9507a.e(gVar, qVar, mVar, z10)) {
                if (gVar == t.f9520n) {
                    return true;
                }
                if (gVar != t.f9519m && (mVarQ = jf.i.q(qVar, fe.e.class)) != null && (gVar instanceof rf.h)) {
                    return ((rf.h) gVar).r().a().equals(mVarQ.a());
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class f extends r {
        public f(w1 w1Var) {
            super(w1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "from";
            } else if (i10 == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i10 != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i10 == 2 || i10 == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // fe.u
        public boolean e(rf.g gVar, q qVar, m mVar, boolean z10) {
            fe.e eVar;
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            fe.e eVar2 = (fe.e) jf.i.q(qVar, fe.e.class);
            fe.e eVar3 = (fe.e) jf.i.r(mVar, fe.e.class, false);
            if (eVar3 == null) {
                return false;
            }
            if (eVar2 != null && jf.i.x(eVar2) && (eVar = (fe.e) jf.i.q(eVar2, fe.e.class)) != null && jf.i.H(eVar3, eVar)) {
                return true;
            }
            q qVarM = jf.i.M(qVar);
            fe.e eVar4 = (fe.e) jf.i.q(qVarM, fe.e.class);
            if (eVar4 == null) {
                return false;
            }
            if (jf.i.H(eVar3, eVar4) && h(gVar, qVarM, eVar3)) {
                return true;
            }
            return e(gVar, qVar, eVar3.b(), z10);
        }

        public final boolean h(rf.g gVar, q qVar, fe.e eVar) {
            if (qVar == null) {
                g(2);
            }
            if (eVar == null) {
                g(3);
            }
            if (gVar == t.f9521o) {
                return false;
            }
            if (!(qVar instanceof fe.b) || (qVar instanceof fe.l) || gVar == t.f9520n) {
                return true;
            }
            if (gVar == t.f9519m || gVar == null) {
                return false;
            }
            xf.r0 type = gVar.getType();
            return jf.i.I(type, eVar) || xf.e0.a(type);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class g extends r {
        public g(w1 w1Var) {
            super(w1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // fe.u
        public boolean e(rf.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            if (jf.i.g(mVar).A0(jf.i.g(qVar))) {
                return t.f9522p.a(qVar, mVar);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class h extends r {
        public h(w1 w1Var) {
            super(w1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // fe.u
        public boolean e(rf.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class i extends r {
        public i(w1 w1Var) {
            super(w1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // fe.u
        public boolean e(rf.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class j extends r {
        public j(w1 w1Var) {
            super(w1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // fe.u
        public boolean e(rf.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class k extends r {
        public k(w1 w1Var) {
            super(w1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // fe.u
        public boolean e(rf.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class l extends r {
        public l(w1 w1Var) {
            super(w1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // fe.u
        public boolean e(rf.g gVar, q qVar, m mVar, boolean z10) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return false;
        }
    }

    static {
        d dVar = new d(v1.e.f9532c);
        f9507a = dVar;
        e eVar = new e(v1.f.f9533c);
        f9508b = eVar;
        f fVar = new f(v1.g.f9534c);
        f9509c = fVar;
        g gVar = new g(v1.b.f9529c);
        f9510d = gVar;
        h hVar = new h(v1.h.f9535c);
        f9511e = hVar;
        i iVar = new i(v1.d.f9531c);
        f9512f = iVar;
        j jVar = new j(v1.a.f9528c);
        f9513g = jVar;
        k kVar = new k(v1.c.f9530c);
        f9514h = kVar;
        l lVar = new l(v1.i.f9536c);
        f9515i = lVar;
        f9516j = Collections.unmodifiableSet(dd.u0.h(dVar, eVar, gVar, iVar));
        HashMap mapE = hg.a.e(4);
        mapE.put(eVar, 0);
        mapE.put(dVar, 0);
        mapE.put(gVar, 1);
        mapE.put(fVar, 1);
        mapE.put(hVar, 2);
        f9517k = Collections.unmodifiableMap(mapE);
        f9518l = hVar;
        f9519m = new a();
        f9520n = new b();
        f9521o = new c();
        Iterator it = ServiceLoader.load(eg.l.class, eg.l.class.getClassLoader()).iterator();
        f9522p = it.hasNext() ? (eg.l) it.next() : l.a.f8905a;
        f9523q = new HashMap();
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r8) {
        /*
            r0 = 16
            if (r8 == r0) goto L7
            java.lang.String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L9
        L7:
            java.lang.String r1 = "@NotNull method %s.%s must not return null"
        L9:
            r2 = 3
            r3 = 2
            if (r8 == r0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r3
        L10:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities"
            r6 = 1
            r7 = 0
            if (r8 == r6) goto L3a
            if (r8 == r2) goto L3a
            r2 = 5
            if (r8 == r2) goto L3a
            r2 = 7
            if (r8 == r2) goto L3a
            switch(r8) {
                case 9: goto L3a;
                case 10: goto L35;
                case 11: goto L30;
                case 12: goto L35;
                case 13: goto L30;
                case 14: goto L2b;
                case 15: goto L2b;
                case 16: goto L28;
                default: goto L23;
            }
        L23:
            java.lang.String r2 = "what"
            r4[r7] = r2
            goto L3e
        L28:
            r4[r7] = r5
            goto L3e
        L2b:
            java.lang.String r2 = "visibility"
            r4[r7] = r2
            goto L3e
        L30:
            java.lang.String r2 = "second"
            r4[r7] = r2
            goto L3e
        L35:
            java.lang.String r2 = "first"
            r4[r7] = r2
            goto L3e
        L3a:
            java.lang.String r2 = "from"
            r4[r7] = r2
        L3e:
            java.lang.String r2 = "toDescriptorVisibility"
            if (r8 == r0) goto L45
            r4[r6] = r5
            goto L47
        L45:
            r4[r6] = r2
        L47:
            switch(r8) {
                case 2: goto L70;
                case 3: goto L70;
                case 4: goto L6b;
                case 5: goto L6b;
                case 6: goto L66;
                case 7: goto L66;
                case 8: goto L61;
                case 9: goto L61;
                case 10: goto L5c;
                case 11: goto L5c;
                case 12: goto L57;
                case 13: goto L57;
                case 14: goto L52;
                case 15: goto L4f;
                case 16: goto L74;
                default: goto L4a;
            }
        L4a:
            java.lang.String r2 = "isVisible"
            r4[r3] = r2
            goto L74
        L4f:
            r4[r3] = r2
            goto L74
        L52:
            java.lang.String r2 = "isPrivate"
            r4[r3] = r2
            goto L74
        L57:
            java.lang.String r2 = "compare"
            r4[r3] = r2
            goto L74
        L5c:
            java.lang.String r2 = "compareLocal"
            r4[r3] = r2
            goto L74
        L61:
            java.lang.String r2 = "findInvisibleMember"
            r4[r3] = r2
            goto L74
        L66:
            java.lang.String r2 = "inSameFile"
            r4[r3] = r2
            goto L74
        L6b:
            java.lang.String r2 = "isVisibleWithAnyReceiver"
            r4[r3] = r2
            goto L74
        L70:
            java.lang.String r2 = "isVisibleIgnoringReceiver"
            r4[r3] = r2
        L74:
            java.lang.String r1 = java.lang.String.format(r1, r4)
            if (r8 == r0) goto L80
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r1)
            goto L85
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.t.a(int):void");
    }

    public static Integer d(u uVar, u uVar2) {
        if (uVar == null) {
            a(12);
        }
        if (uVar2 == null) {
            a(13);
        }
        Integer numA = uVar.a(uVar2);
        if (numA != null) {
            return numA;
        }
        Integer numA2 = uVar2.a(uVar);
        if (numA2 != null) {
            return Integer.valueOf(-numA2.intValue());
        }
        return null;
    }

    public static q e(rf.g gVar, q qVar, m mVar, boolean z10) {
        q qVarE;
        if (qVar == null) {
            a(8);
        }
        if (mVar == null) {
            a(9);
        }
        for (q qVar2 = (q) qVar.a(); qVar2 != null && qVar2.getVisibility() != f9512f; qVar2 = (q) jf.i.q(qVar2, q.class)) {
            if (!qVar2.getVisibility().e(gVar, qVar2, mVar, z10)) {
                return qVar2;
            }
        }
        if (!(qVar instanceof ie.q0) || (qVarE = e(gVar, ((ie.q0) qVar).n0(), mVar, z10)) == null) {
            return null;
        }
        return qVarE;
    }

    public static boolean f(m mVar, m mVar2) {
        if (mVar == null) {
            a(6);
        }
        if (mVar2 == null) {
            a(7);
        }
        h1 h1VarJ = jf.i.j(mVar2);
        if (h1VarJ != h1.f9484a) {
            return h1VarJ.equals(jf.i.j(mVar));
        }
        return false;
    }

    public static boolean g(u uVar) {
        if (uVar == null) {
            a(14);
        }
        return uVar == f9507a || uVar == f9508b;
    }

    public static boolean h(q qVar, m mVar, boolean z10) {
        if (qVar == null) {
            a(2);
        }
        if (mVar == null) {
            a(3);
        }
        return e(f9520n, qVar, mVar, z10) == null;
    }

    public static void i(u uVar) {
        f9523q.put(uVar.b(), uVar);
    }

    public static u j(w1 w1Var) {
        if (w1Var == null) {
            a(15);
        }
        u uVar = (u) f9523q.get(w1Var);
        if (uVar != null) {
            return uVar;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + w1Var);
    }
}
