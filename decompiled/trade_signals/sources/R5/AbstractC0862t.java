package R5;

import P6.l;
import R5.w0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import u6.AbstractC2794i;

/* JADX INFO: renamed from: R5.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0862t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0863u f7257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0863u f7258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbstractC0863u f7259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC0863u f7260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AbstractC0863u f7261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC0863u f7262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AbstractC0863u f7263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AbstractC0863u f7264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AbstractC0863u f7265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set f7266j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map f7267k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AbstractC0863u f7268l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C6.g f7269m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final C6.g f7270n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C6.g f7271o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final P6.l f7272p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Map f7273q;

    /* JADX INFO: renamed from: R5.t$a */
    public static class a implements C6.g {
        @Override // C6.g
        public I6.S getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* JADX INFO: renamed from: R5.t$b */
    public static class b implements C6.g {
        @Override // C6.g
        public I6.S getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* JADX INFO: renamed from: R5.t$c */
    public static class c implements C6.g {
        @Override // C6.g
        public I6.S getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* JADX INFO: renamed from: R5.t$d */
    public static class d extends r {
        public d(x0 x0Var) {
            super(x0Var);
        }

        public static /* synthetic */ void g(int i8) {
            Object[] objArr = new Object[3];
            if (i8 == 1) {
                objArr[0] = "what";
            } else if (i8 != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i8 == 1 || i8 == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // R5.AbstractC0863u
        public boolean e(C6.g gVar, InterfaceC0860q interfaceC0860q, InterfaceC0856m interfaceC0856m, boolean z7) {
            if (interfaceC0860q == 0) {
                g(1);
            }
            if (interfaceC0856m == null) {
                g(2);
            }
            if (AbstractC2794i.J(interfaceC0860q) && h(interfaceC0856m)) {
                return AbstractC0862t.f(interfaceC0860q, interfaceC0856m);
            }
            if (interfaceC0860q instanceof InterfaceC0855l) {
                InterfaceC0852i interfaceC0852iB = ((InterfaceC0855l) interfaceC0860q).b();
                if (z7 && AbstractC2794i.G(interfaceC0852iB) && AbstractC2794i.J(interfaceC0852iB) && (interfaceC0856m instanceof InterfaceC0855l) && AbstractC2794i.J(interfaceC0856m.b()) && AbstractC0862t.f(interfaceC0860q, interfaceC0856m)) {
                    return true;
                }
            }
            while (interfaceC0860q != 0) {
                interfaceC0860q = interfaceC0860q.b();
                if (((interfaceC0860q instanceof InterfaceC0848e) && !AbstractC2794i.x(interfaceC0860q)) || (interfaceC0860q instanceof N)) {
                    break;
                }
            }
            if (interfaceC0860q == 0) {
                return false;
            }
            while (interfaceC0856m != null) {
                if (interfaceC0860q == interfaceC0856m) {
                    return true;
                }
                if (interfaceC0856m instanceof N) {
                    return (interfaceC0860q instanceof N) && ((N) interfaceC0860q).e().equals(((N) interfaceC0856m).e()) && AbstractC2794i.b(interfaceC0856m, interfaceC0860q);
                }
                interfaceC0856m = interfaceC0856m.b();
            }
            return false;
        }

        public final boolean h(InterfaceC0856m interfaceC0856m) {
            if (interfaceC0856m == null) {
                g(0);
            }
            return AbstractC2794i.j(interfaceC0856m) != i0.f7250a;
        }
    }

    /* JADX INFO: renamed from: R5.t$e */
    public static class e extends r {
        public e(x0 x0Var) {
            super(x0Var);
        }

        private static /* synthetic */ void g(int i8) {
            Object[] objArr = new Object[3];
            if (i8 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // R5.AbstractC0863u
        public boolean e(C6.g gVar, InterfaceC0860q interfaceC0860q, InterfaceC0856m interfaceC0856m, boolean z7) {
            InterfaceC0856m interfaceC0856mQ;
            if (interfaceC0860q == null) {
                g(0);
            }
            if (interfaceC0856m == null) {
                g(1);
            }
            if (AbstractC0862t.f7257a.e(gVar, interfaceC0860q, interfaceC0856m, z7)) {
                if (gVar == AbstractC0862t.f7270n) {
                    return true;
                }
                if (gVar != AbstractC0862t.f7269m && (interfaceC0856mQ = AbstractC2794i.q(interfaceC0860q, InterfaceC0848e.class)) != null && (gVar instanceof C6.h)) {
                    return ((C6.h) gVar).s().a().equals(interfaceC0856mQ.a());
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: R5.t$f */
    public static class f extends r {
        public f(x0 x0Var) {
            super(x0Var);
        }

        private static /* synthetic */ void g(int i8) {
            Object[] objArr = new Object[3];
            if (i8 == 1) {
                objArr[0] = "from";
            } else if (i8 == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i8 != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i8 == 2 || i8 == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // R5.AbstractC0863u
        public boolean e(C6.g gVar, InterfaceC0860q interfaceC0860q, InterfaceC0856m interfaceC0856m, boolean z7) {
            InterfaceC0848e interfaceC0848e;
            if (interfaceC0860q == null) {
                g(0);
            }
            if (interfaceC0856m == null) {
                g(1);
            }
            InterfaceC0848e interfaceC0848e2 = (InterfaceC0848e) AbstractC2794i.q(interfaceC0860q, InterfaceC0848e.class);
            InterfaceC0848e interfaceC0848e3 = (InterfaceC0848e) AbstractC2794i.r(interfaceC0856m, InterfaceC0848e.class, false);
            if (interfaceC0848e3 == null) {
                return false;
            }
            if (interfaceC0848e2 != null && AbstractC2794i.x(interfaceC0848e2) && (interfaceC0848e = (InterfaceC0848e) AbstractC2794i.q(interfaceC0848e2, InterfaceC0848e.class)) != null && AbstractC2794i.H(interfaceC0848e3, interfaceC0848e)) {
                return true;
            }
            InterfaceC0860q interfaceC0860qM = AbstractC2794i.M(interfaceC0860q);
            InterfaceC0848e interfaceC0848e4 = (InterfaceC0848e) AbstractC2794i.q(interfaceC0860qM, InterfaceC0848e.class);
            if (interfaceC0848e4 == null) {
                return false;
            }
            if (AbstractC2794i.H(interfaceC0848e3, interfaceC0848e4) && h(gVar, interfaceC0860qM, interfaceC0848e3)) {
                return true;
            }
            return e(gVar, interfaceC0860q, interfaceC0848e3.b(), z7);
        }

        public final boolean h(C6.g gVar, InterfaceC0860q interfaceC0860q, InterfaceC0848e interfaceC0848e) {
            if (interfaceC0860q == null) {
                g(2);
            }
            if (interfaceC0848e == null) {
                g(3);
            }
            if (gVar == AbstractC0862t.f7271o) {
                return false;
            }
            if (!(interfaceC0860q instanceof InterfaceC0845b) || (interfaceC0860q instanceof InterfaceC0855l) || gVar == AbstractC0862t.f7270n) {
                return true;
            }
            if (gVar == AbstractC0862t.f7269m || gVar == null) {
                return false;
            }
            I6.S type = gVar.getType();
            return AbstractC2794i.I(type, interfaceC0848e) || I6.E.a(type);
        }
    }

    /* JADX INFO: renamed from: R5.t$g */
    public static class g extends r {
        public g(x0 x0Var) {
            super(x0Var);
        }

        private static /* synthetic */ void g(int i8) {
            Object[] objArr = new Object[3];
            if (i8 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // R5.AbstractC0863u
        public boolean e(C6.g gVar, InterfaceC0860q interfaceC0860q, InterfaceC0856m interfaceC0856m, boolean z7) {
            if (interfaceC0860q == null) {
                g(0);
            }
            if (interfaceC0856m == null) {
                g(1);
            }
            if (AbstractC2794i.g(interfaceC0856m).s0(AbstractC2794i.g(interfaceC0860q))) {
                return AbstractC0862t.f7272p.a(interfaceC0860q, interfaceC0856m);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: R5.t$h */
    public static class h extends r {
        public h(x0 x0Var) {
            super(x0Var);
        }

        private static /* synthetic */ void g(int i8) {
            Object[] objArr = new Object[3];
            if (i8 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // R5.AbstractC0863u
        public boolean e(C6.g gVar, InterfaceC0860q interfaceC0860q, InterfaceC0856m interfaceC0856m, boolean z7) {
            if (interfaceC0860q == null) {
                g(0);
            }
            if (interfaceC0856m == null) {
                g(1);
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: R5.t$i */
    public static class i extends r {
        public i(x0 x0Var) {
            super(x0Var);
        }

        private static /* synthetic */ void g(int i8) {
            Object[] objArr = new Object[3];
            if (i8 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // R5.AbstractC0863u
        public boolean e(C6.g gVar, InterfaceC0860q interfaceC0860q, InterfaceC0856m interfaceC0856m, boolean z7) {
            if (interfaceC0860q == null) {
                g(0);
            }
            if (interfaceC0856m == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    }

    /* JADX INFO: renamed from: R5.t$j */
    public static class j extends r {
        public j(x0 x0Var) {
            super(x0Var);
        }

        private static /* synthetic */ void g(int i8) {
            Object[] objArr = new Object[3];
            if (i8 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // R5.AbstractC0863u
        public boolean e(C6.g gVar, InterfaceC0860q interfaceC0860q, InterfaceC0856m interfaceC0856m, boolean z7) {
            if (interfaceC0860q == null) {
                g(0);
            }
            if (interfaceC0856m == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    }

    /* JADX INFO: renamed from: R5.t$k */
    public static class k extends r {
        public k(x0 x0Var) {
            super(x0Var);
        }

        private static /* synthetic */ void g(int i8) {
            Object[] objArr = new Object[3];
            if (i8 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // R5.AbstractC0863u
        public boolean e(C6.g gVar, InterfaceC0860q interfaceC0860q, InterfaceC0856m interfaceC0856m, boolean z7) {
            if (interfaceC0860q == null) {
                g(0);
            }
            if (interfaceC0856m == null) {
                g(1);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: R5.t$l */
    public static class l extends r {
        public l(x0 x0Var) {
            super(x0Var);
        }

        private static /* synthetic */ void g(int i8) {
            Object[] objArr = new Object[3];
            if (i8 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // R5.AbstractC0863u
        public boolean e(C6.g gVar, InterfaceC0860q interfaceC0860q, InterfaceC0856m interfaceC0856m, boolean z7) {
            if (interfaceC0860q == null) {
                g(0);
            }
            if (interfaceC0856m == null) {
                g(1);
            }
            return false;
        }
    }

    static {
        d dVar = new d(w0.e.f7282c);
        f7257a = dVar;
        e eVar = new e(w0.f.f7283c);
        f7258b = eVar;
        f fVar = new f(w0.g.f7284c);
        f7259c = fVar;
        g gVar = new g(w0.b.f7279c);
        f7260d = gVar;
        h hVar = new h(w0.h.f7285c);
        f7261e = hVar;
        i iVar = new i(w0.d.f7281c);
        f7262f = iVar;
        j jVar = new j(w0.a.f7278c);
        f7263g = jVar;
        k kVar = new k(w0.c.f7280c);
        f7264h = kVar;
        l lVar = new l(w0.i.f7286c);
        f7265i = lVar;
        f7266j = Collections.unmodifiableSet(p5.S.h(dVar, eVar, gVar, iVar));
        HashMap mapE = S6.a.e(4);
        mapE.put(eVar, 0);
        mapE.put(dVar, 0);
        mapE.put(gVar, 1);
        mapE.put(fVar, 1);
        mapE.put(hVar, 2);
        f7267k = Collections.unmodifiableMap(mapE);
        f7268l = hVar;
        f7269m = new a();
        f7270n = new b();
        f7271o = new c();
        Iterator it = ServiceLoader.load(P6.l.class, P6.l.class.getClassLoader()).iterator();
        f7272p = it.hasNext() ? (P6.l) it.next() : l.a.f6511a;
        f7273q = new HashMap();
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
        throw new UnsupportedOperationException("Method not decompiled: R5.AbstractC0862t.a(int):void");
    }

    public static Integer d(AbstractC0863u abstractC0863u, AbstractC0863u abstractC0863u2) {
        if (abstractC0863u == null) {
            a(12);
        }
        if (abstractC0863u2 == null) {
            a(13);
        }
        Integer numA = abstractC0863u.a(abstractC0863u2);
        if (numA != null) {
            return numA;
        }
        Integer numA2 = abstractC0863u2.a(abstractC0863u);
        if (numA2 != null) {
            return Integer.valueOf(-numA2.intValue());
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if ((r4 instanceof U5.Q) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r3 = e(r3, ((U5.Q) r4).o0(), r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        if (r3 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static R5.InterfaceC0860q e(C6.g r3, R5.InterfaceC0860q r4, R5.InterfaceC0856m r5, boolean r6) {
        /*
            if (r4 != 0) goto L7
            r0 = 8
            a(r0)
        L7:
            if (r5 != 0) goto Le
            r0 = 9
            a(r0)
        Le:
            R5.m r0 = r4.a()
        L12:
            R5.q r0 = (R5.InterfaceC0860q) r0
            if (r0 == 0) goto L30
            R5.u r1 = r0.getVisibility()
            R5.u r2 = R5.AbstractC0862t.f7262f
            if (r1 == r2) goto L30
            R5.u r1 = r0.getVisibility()
            boolean r1 = r1.e(r3, r0, r5, r6)
            if (r1 != 0) goto L29
            return r0
        L29:
            java.lang.Class<R5.q> r1 = R5.InterfaceC0860q.class
            R5.m r0 = u6.AbstractC2794i.q(r0, r1)
            goto L12
        L30:
            boolean r0 = r4 instanceof U5.Q
            if (r0 == 0) goto L41
            U5.Q r4 = (U5.Q) r4
            R5.d r4 = r4.o0()
            R5.q r3 = e(r3, r4, r5, r6)
            if (r3 == 0) goto L41
            return r3
        L41:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: R5.AbstractC0862t.e(C6.g, R5.q, R5.m, boolean):R5.q");
    }

    public static boolean f(InterfaceC0856m interfaceC0856m, InterfaceC0856m interfaceC0856m2) {
        if (interfaceC0856m == null) {
            a(6);
        }
        if (interfaceC0856m2 == null) {
            a(7);
        }
        i0 i0VarJ = AbstractC2794i.j(interfaceC0856m2);
        if (i0VarJ != i0.f7250a) {
            return i0VarJ.equals(AbstractC2794i.j(interfaceC0856m));
        }
        return false;
    }

    public static boolean g(AbstractC0863u abstractC0863u) {
        if (abstractC0863u == null) {
            a(14);
        }
        return abstractC0863u == f7257a || abstractC0863u == f7258b;
    }

    public static boolean h(InterfaceC0860q interfaceC0860q, InterfaceC0856m interfaceC0856m, boolean z7) {
        if (interfaceC0860q == null) {
            a(2);
        }
        if (interfaceC0856m == null) {
            a(3);
        }
        return e(f7270n, interfaceC0860q, interfaceC0856m, z7) == null;
    }

    public static void i(AbstractC0863u abstractC0863u) {
        f7273q.put(abstractC0863u.b(), abstractC0863u);
    }

    public static AbstractC0863u j(x0 x0Var) {
        if (x0Var == null) {
            a(15);
        }
        AbstractC0863u abstractC0863u = (AbstractC0863u) f7273q.get(x0Var);
        if (abstractC0863u != null) {
            return abstractC0863u;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + x0Var);
    }
}
